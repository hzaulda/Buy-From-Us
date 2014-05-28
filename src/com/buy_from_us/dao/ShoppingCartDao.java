package com.buy_from_us.dao;

import java.util.List;

import com.buy_from_us.model.Account;
import com.buy_from_us.model.Order;
import com.buy_from_us.model.OrderDetail;
import com.buy_from_us.model.Product;

public interface ShoppingCartDao {
	public String addToCart(Product product, int qty, Account account,Order order);
	public String addToCart(Product product, int qty, Account account,
			Order order, List<OrderDetail> orderDetails);
	public String removeFromCart(Product product);
	public String updateQty(Product product, int qty);

}
