package com.product.test.model;

import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;

//@Documen
public class Stock {
	 @Id
	 public int id;
	 public int stockId;
	 public int productId;
	 public long quantity;
	 
	public Stock(int stockId, int productId, long quantity) {
		this.stockId = stockId;
		this.productId = productId;
		this.quantity = quantity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int producId) {
		this.productId = producId;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Stock [id=" + id + ", productId=" + productId + ", quantity=" + quantity + "]";
	}
}
