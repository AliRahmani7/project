package com.product.test.model;

import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;

//@Document
public class Product {
    @Id
    public int id;
    public int productId;
    public String productName;
    public String productDescription;
    public String category;
    
    public Product()
    {}
    
	public Product(int productId,String productName, String productDescription, String category) {
		//this.id = id;
		this.productId=productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productId=" + productId + ", productName=" + productName
				+ ", productDescription=" + productDescription + ", category=" + category + "]";
	}
}

