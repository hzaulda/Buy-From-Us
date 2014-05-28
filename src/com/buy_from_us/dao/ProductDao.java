package com.buy_from_us.dao;

import java.util.List;

import com.buy_from_us.model.Category;
import com.buy_from_us.model.Product;

public interface ProductDao {
	public String addProduct(Product product, String categoryName);
	public List<Product> viewProducts();
	public String addCategory(Category category);
	public Category searchByCategoryName(String categoryName);
	public List<Category> getAllCategories();
	public List<Product> getProductsByCategory(String category);
	public Product searchByProductName(String productName);

}
