package com.buy_from_us.service;

import java.util.List;

import com.buy_from_us.model.Order;
import com.buy_from_us.model.OrderDetail;

public interface ShoppingCartService {
	//public String addToCart(String productName, int qty);
	public String addToCart(String productName, int intVal, String user,
			Order order, List<OrderDetail> orderDetails);
	public String addToCart(String productName, int intVal, String user,Order order);
	public void getCartContents(List<OrderDetail> orderDetails);
}
