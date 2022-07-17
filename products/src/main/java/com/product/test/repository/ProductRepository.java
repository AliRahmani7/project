package com.product.test.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import com.product.test.model.Product;
//import org.springframework.data.repository.reactive.ReactiveCrudRepository;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
//public interface ProductRepository extends ReactiveMongoRepository<Product, String>{
public interface ProductRepository extends ReactiveCrudRepository<Product, Integer>{
    @Query("SELECT * FROM Product WHERE product_name = :name") 
    Mono<Product> findProductByName(String name);  
    @Query("SELECT * FROM Product WHERE product_id = $1")
    Mono<Product> findProductById(Integer productId);
}