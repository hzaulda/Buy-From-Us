package com.buy_from_us.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.buy_from_us.model.Category;
import com.buy_from_us.model.Order;
import com.buy_from_us.model.OrderDetail;
import com.buy_from_us.service.OrderService;
import com.buy_from_us.service.ProductService;
import com.buy_from_us.service.ShoppingCartService;


@Controller
public class ShoppingCartController {
	private static final String NO_CART_ITEMS = "Shopping cart is empty!";
	
	@Autowired
	private ShoppingCartService shopCartService;
	@Autowired
	private ProductService productService;
	@Autowired
	private OrderService orderService;
	private String user; 
	
	@RequestMapping(value="/add-to-cart",method=RequestMethod.POST)
	public String getProductsByCategory(
			@RequestParam("productName") String productName,
			@RequestParam("quantity") String quantity,
			HttpServletRequest request,
			Model model){
			
		HttpSession session = request.getSession();
		user = (String) session.getAttribute("user");
		Order order = orderService.searchByUserName(user);
		
		List<OrderDetail> cartItems = orderService.searchByOrderId(order.getOrderId());
		
		String result = 
				shopCartService.addToCart(productName, getIntVal(quantity), 
						user, order);
		//shopCartService.addToCart(productName, getIntVal(quantity), 
		//		user, order, cartItems);
		
		model.addAttribute("addToCartResult",result);	
		
		List<Category> categoryList = productService.getAllCategoies();
		model.addAttribute("categoryList", categoryList);
		
		 return "view-products";
	}
	
	@RequestMapping(value="/view-cart",method=RequestMethod.GET)
	public String viewCart(HttpServletRequest request,
			Model model){
		HttpSession session = request.getSession();
		user = (String) session.getAttribute("user");
		
		Order order = orderService.searchByUserName(user);
		int orderId = order.getOrderId();
		List<OrderDetail> cartItems = null;
		
		if (orderId!=0) {
			cartItems = orderService.searchByOrderId(order.getOrderId());
			
			model.addAttribute("cartItems", cartItems);
		} else {
			model.addAttribute("shopCartMsg", NO_CART_ITEMS);
		}
		
		
		 return "shopping-cart";
	}
	
	private int getIntVal(String str){
		int intVal = 0;
		try {
			intVal = Integer.parseInt(str);
		}catch(Exception e){
			e.printStackTrace();
		}
		return intVal;
	}
	
}
