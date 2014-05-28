package com.buy_from_us.form;

import java.math.BigDecimal;

public class ProductFormBacker {
	
	private String name;
	private BigDecimal price;
	private String category;
	private int quantity;
	private String productImage;
	
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override 
	public String toString(){
		return "name: " + name + "price: "+price+
				" category: "+ category +
				" quantity: " + quantity;
	}

}
