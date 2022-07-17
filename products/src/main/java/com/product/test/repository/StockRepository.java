package com.product.test.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.product.test.model.Product;
import com.product.test.model.Stock;
//import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Mono;

@Repository
//public interface StockRepository extends ReactiveMongoRepository<Stock, String>{
public interface StockRepository extends ReactiveCrudRepository<Stock, Integer>{
    @Query("SELECT * FROM Stock WHERE stock_id = $1")
    Mono<Stock> findStocktById(Integer stockId);
}
