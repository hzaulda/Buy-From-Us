package com.buy_from_us.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.buy_from_us.model.Category;
import com.buy_from_us.model.Product;
import com.buy_from_us.service.ProductService;


@Controller
public class CustomerPageController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/get-products-by-cat",method=RequestMethod.GET)
	public String getProductsByCategory(
			@RequestParam("categoryName") String categoryName,
			Model model){
		
			 List<Product> products = productService.
						getProductsByCategory(categoryName);
				model.addAttribute("productList", products);
		 
		
		List<Category> categoryList = productService.getAllCategoies();
		model.addAttribute("categoryList", categoryList);
		
		return "view-products";
	}
	
	@RequestMapping(value="/get-all-products",method=RequestMethod.GET)
	public String getProductsByCategory(Model model){
		List<Category> categoryList = productService.getAllCategoies();
		model.addAttribute("categoryList", categoryList);
		
		return "view-products";
	}

}
