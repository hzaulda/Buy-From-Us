package com.buy_from_us.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "tbl_product")
public class Product {
	
	private int keyProduct;
	private Category category;
	private String productName;
	private int inventory;
	private BigDecimal unitPrice;
	private String productImage;
	
	public Product(){
		
	}
	
	public Product(Category category, String productName,
			int inventory, BigDecimal unitPrice,
			String productImage) {
		this.category = category;
		this.productName = productName;
		this.inventory = inventory;
		this.unitPrice = unitPrice;
		this.productImage = productImage;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "key_product")
	public int getKeyProduct() {
		return keyProduct;
	}
	public void setKeyProduct(int keyProduct) {
		this.keyProduct = keyProduct;
	}
	
	
	@ManyToOne
	 @JoinColumn(name="key_category")
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	@Column(name = "fld_product_name")
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	@Column(name = "fld_inventory_qty")
	public int getInventory() {
		return inventory;
	}
	
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	
	@Column(name = "fld_unit_price")
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	@Column(name = "fld_product_image")
	public String getProductImage() {
		return productImage;
	}
	
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	
	
	
	
}
