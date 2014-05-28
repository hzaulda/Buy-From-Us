package com.buy_from_us.service;

import java.util.List;

import com.buy_from_us.model.Order;
import com.buy_from_us.model.OrderDetail;

public interface OrderService {
	public Order searchByUserName(String username);
	public List<OrderDetail> searchByOrderId(int orderId);

}
