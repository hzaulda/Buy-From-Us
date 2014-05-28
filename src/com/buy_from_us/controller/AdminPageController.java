package com.buy_from_us.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.buy_from_us.form.CategoryFormBacker;
import com.buy_from_us.form.ProductFormBacker;
import com.buy_from_us.model.Category;
import com.buy_from_us.model.Product;
import com.buy_from_us.service.ProductService;

@Controller
public class AdminPageController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value="/add-product",method=RequestMethod.POST)
	public String addProduct(ProductFormBacker productForm,
			Model model) {
		String categoryName = productForm.getCategory();
		//Category category = getCategory(categoryName);
		
		//search category first
		
		Product product = getProduct(productForm);
		
		String result = productService.addProduct(product,categoryName);
		model.addAttribute("result", result);
		
		List<Category> categoryList = productService.getAllCategoies();
		model.addAttribute("categoryList", categoryList);
		
		return "admin-page";
	}
	
	@RequestMapping(value="/add-category",method=RequestMethod.POST)
	public String addCategory(CategoryFormBacker categoryForm,
			Model model) {
		Category category = getCategory(categoryForm.getCategory());
		String result = productService.addCategory(category);
		model.addAttribute("result", result);
		
		List<Category> categoryList = productService.getAllCategoies();
		model.addAttribute("categoryList", categoryList);
		
		return "admin-page";
	}
	
	public Category getCategory(String categoryName) {
		Category category = new Category(categoryName);
		return category;
	}
	
	public Product getProduct(ProductFormBacker form){
		String name = form.getName();
		BigDecimal price = form.getPrice();
		int quantity = form.getQuantity();
		String productImage = form.getProductImage();
		
		Product product = new Product(null, name, quantity, 
				price, productImage);
		return product;
	}

	
	
}
