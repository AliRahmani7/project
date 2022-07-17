package com.product.test.model;

public class Inventory {
    public String productName;
    public String productDescription;
    public String category;
    public long quantity;
    
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
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Inventory [productName=" + productName + ", productDescription=" + productDescription + ", category="
				+ category + ", quantity=" + quantity + "]";
	}
    
}
