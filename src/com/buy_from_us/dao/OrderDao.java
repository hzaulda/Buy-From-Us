package com.buy_from_us.dao;

import java.util.List;

import com.buy_from_us.model.Order;
import com.buy_from_us.model.OrderDetail;

public interface OrderDao {
	
	public Order searchByUserId(String userId);
	public List<OrderDetail> searchByOrderId(int orderId);

}
