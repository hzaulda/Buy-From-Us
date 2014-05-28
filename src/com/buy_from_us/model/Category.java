package com.buy_from_us.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_category")
public class Category {
	
	private int categoryKey;
	private String categoryName;
	private List<Product> productList;
	
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
	public List<Product> getProductList() {
		return productList;
	}
	
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	
	public Category() {
		
	}
	
	public Category(String categoryName) {
		this.categoryName = categoryName;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "key_category", unique= true, nullable= false, updatable = false)
	public int getCategoryKey() {
		return categoryKey;
	}
	
	public void setCategoryKey(int categoryKey) {
		this.categoryKey = categoryKey;
	}
	
	@Column(name = "fld_category_name")
	public String getCategoryName() {
		return categoryName;
	}
	
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}
