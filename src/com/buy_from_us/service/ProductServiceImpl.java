package com.buy_from_us.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buy_from_us.dao.ProductDao;
import com.buy_from_us.model.Category;
import com.buy_from_us.model.Product;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;

	public String addProduct(Product product, String category) {
		String result = productDao.addProduct(product, category);
		return result;
	}

	public String addCategory(Category category) {
		String result = productDao.addCategory(category);
		return result;
	}

	public List<Category> getAllCategoies() {
		return productDao.getAllCategories();
	}

	public List<Product> getProductsByCategory(String category) {
		return productDao.getProductsByCategory(category);
	}

	


}
