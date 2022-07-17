package com.product.test.controller;

import com.product.test.model.Stock;
import com.product.test.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.retry.Repeat;

@RestController
public class StockController {
	 @Autowired
	 StockRepository stockRepository;

	    @GetMapping(path = "/stocks")
	    public Flux<Stock> getAllStocks()
	    {
	        return stockRepository.findAll();
	    }
	    @GetMapping(path = "/stocks/{stockId}")
	    public Mono<ResponseEntity<Stock>> getStock(@PathVariable Integer stockId)
	    {
	        Mono<ResponseEntity<Stock>> responseEntityMono;
	        responseEntityMono = stockRepository.findStocktById(stockId)
	                .map(x -> new ResponseEntity<Stock>(x, HttpStatus.OK))
	                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	        return responseEntityMono;
	    }
	    
	    private boolean validateStock(Stock x)
	    {
	        return x.getStockId() != 0;
	    }
}

