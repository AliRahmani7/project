package com.product.test.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.product.test.model.Inventory;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface InventoryRepository extends ReactiveCrudRepository<Inventory, Object>{
    @Query("SELECT p.product_name,s.quantity FROM product p INNER JOIN stock s ON p.product_id = s.product_id WHERE p.product_id = $1")
    Mono<Inventory> findStockByProductId(Integer productId);
    @Query("SELECT p.product_name,p.product_description,p.category,s.quantity FROM product p INNER JOIN stock s ON p.product_id = s.product_id WHERE s.quantity > $1")
    Flux<Inventory> findStockByQuantity(Long quantity);
    @Query("SELECT p.product_name,s.quantity FROM product p INNER JOIN stock s ON p.product_id = s.product_id WHERE s.quantity > 0")
    Flux<Inventory> findAllStocks();
   // @Query("SELECT p.product_name FROM product p WHERE p.product_id =(SELECT s.product_id from stock s WHERE s.quantity = 0)")//Scalar subquery contains only one row
    @Query("SELECT p.product_name FROM product p WHERE p.product_id in(SELECT s.product_id from stock s WHERE s.quantity = 0)")//subquery contains multiple rows 
    Flux<Inventory> outOfStock();
}
