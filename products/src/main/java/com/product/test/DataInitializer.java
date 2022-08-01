package com.product.test;

import com.product.test.model.Stock;
import com.product.test.model.Product;
import com.product.test.repository.ProductRepository;
import com.product.test.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class DataInitializer implements CommandLineRunner
{
    @Autowired
    ProductRepository productRepository;
    @Autowired
    StockRepository stockRepository;

    public List<Product> productData()
    {
        return Arrays.asList(
        		new Product(101, "laptop", "Ultra-light weight body with Ultra portability Laptop", "Electronics"),
                new Product(102, "shoe", "Comfortable fabric lining and lightly-padded tongue for added support", "Clothing"),
                new Product(103, "iPhon", "The silky, soft-touch finish of the silicone exterior feels great in your hand", "Electronics"),
                new Product(104, "pillow", "The poly fiber filling and the top quality materia", "Bedding"),
                new Product(105, "fridge", "Energy saving and environmentally friendly", "Home Appliances"),
                new Product(106, "desk", "Table with 2 open shelves ideal for study, bedroom, living room", "Furnitue"),
                new Product(107, "fax", "The best fax machine", "Electronics"),
        		new Product(108, "guitar", "The electronic guitar", "Electronics"));
    }
    public List<Stock> stockData()
    {
        return Arrays.asList(
        		new Stock(801, 101, 45),
                new Stock(802, 102, 176),
                new Stock(803, 103, 676),
                new Stock(804, 104, 96),
                new Stock(805, 105, 36),
                new Stock(806, 106, 88),
                new Stock(807, 107, 0), //out of stock
        		new Stock(808, 108, 0)); //out of stock
    }
    @Override
    public void run(String... args) throws Exception
    {
        List<Product> productList = productData();
        productRepository
                .deleteAll()
                .thenMany(Flux.fromIterable(productList))
                .flatMap(x -> {
                    Mono<Product> newlyAddedProduct = productRepository.save(x);
                    return newlyAddedProduct;
                })
                .thenMany(productRepository.findAll())
                .subscribe(x -> {
                    System.out.println(x);
                });
        stockRepository
        		.deleteAll()
        		.thenMany(Flux.fromIterable(stockData()))
        		.flatMap(x -> {
        			Mono<Stock> newlyInsertedStock = stockRepository.save(x);
        			return newlyInsertedStock;
        		})
        		.thenMany(stockRepository.findAll())
        		.subscribe(x -> {
        			System.out.println(x);
        		});
    }
}
