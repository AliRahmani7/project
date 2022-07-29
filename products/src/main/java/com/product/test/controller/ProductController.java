package com.product.test.controller;

import com.product.test.model.Inventory;
import com.product.test.model.Product;
import com.product.test.repository.InventoryRepository;
import com.product.test.repository.ProductRepository;
import com.product.test.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.retry.Repeat;

@RestController
public class ProductController
{
    @Autowired
    ProductRepository productRepository;
    @Autowired
	StockRepository stockRepository;
    @Autowired
	InventoryRepository inventoryRepository;

	@GetMapping("/")					
	String testServer() {
		StringBuilder link = new StringBuilder("Server Running !");link.append("<br>");
		link.append("<a href=\"/products\">http://localhost:8080/products</a>\n");link.append("<br>");
		link.append( "<a href=\"/products/101\">http://localhost:8080/products/101</a>");link.append("<br>");
		link.append( "<a href=\"/productname/laptop\">http://localhost:8080/productname/laptop</a>");link.append("<br>");
		link.append( "<a href=\"/inventory\">http://localhost:8080/inventory</a>");link.append("<br>");
		link.append( "<a href=\"/inventory/101\">http://localhost:8080/inventory/101</a>");link.append("<br>");
		link.append( "<a href=\"/quantity/64\">http://localhost:8080/quantity/64</a>");link.append("<br>");
	    return link.toString();
	}

    @GetMapping(path = "/products")
    public Flux<Product> getAllProducts()
    {
        return productRepository.findAll();
    }

    @GetMapping(path = "/products/{productId}")
    public Mono<ResponseEntity<Product>> getProduct(@PathVariable Integer productId)
    {
        Mono<ResponseEntity<Product>> responseEntityMono;
        responseEntityMono = productRepository.findProductById(productId)
                .map(x -> new ResponseEntity<Product>(x, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        return responseEntityMono;
    }
    
    @GetMapping(path = "/productname/{productName}")
    public Mono<ResponseEntity<Product>> getProduct(@PathVariable String productName)
    {
        Mono<ResponseEntity<Product>> responseEntityMono;
        responseEntityMono = productRepository.findProductByName(productName)
                .map(x -> new ResponseEntity<Product>(x, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        return responseEntityMono;
    }
///////////////////////////////   Inventory    //////////////////////////////////
    @GetMapping(path = "/inventory/{productId}")
    public Mono<ResponseEntity<Inventory>> GetProductId(@PathVariable int productId)
    {
        Mono<ResponseEntity<Inventory>> responseEntityMono;
        responseEntityMono = inventoryRepository.findStockByProductId(productId)
                .map(x -> new ResponseEntity<Inventory>(x, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        return responseEntityMono;
    }
    
    @GetMapping(path = "/quantity/{quantity}")
    public Flux<Inventory> GetProductByQuantity(@PathVariable long quantity)
    {
        return inventoryRepository.findStockByQuantity(quantity);
    }
    @GetMapping(path = "/inventory")
    public Flux<Inventory> GetInventory()
    {
        return inventoryRepository.findAllStocks();
    }

    private boolean validateProduct(Product x)
    {
        return x.getProductName() != null;
    }
}
