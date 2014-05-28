package com.buy_from_us.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buy_from_us.dao.OrderDao;
import com.buy_from_us.model.Order;
import com.buy_from_us.model.OrderDetail;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDao orderDao;	
	

	public Order searchByUserName(String username) {
		Order order = orderDao.searchByUserId(username);
		return order;
	}


	public List<OrderDetail> searchByOrderId(int orderId) {
		List<OrderDetail>orderDetailList = orderDao.searchByOrderId(orderId);
		return orderDetailList;
	}

}
