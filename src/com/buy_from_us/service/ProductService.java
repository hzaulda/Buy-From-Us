package com.buy_from_us.service;

import java.util.List;

import com.buy_from_us.model.Category;
import com.buy_from_us.model.Product;

public interface ProductService {
	
	public String addCategory(Category category);
	public String addProduct(Product product, String category);
	public List<Category> getAllCategoies();
	public List<Product> getProductsByCategory(String category);

}
