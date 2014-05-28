package com.buy_from_us.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.buy_from_us.model.Category;
import com.buy_from_us.model.Order;
import com.buy_from_us.model.OrderDetail;

@Repository("orderDao")
@Transactional
public class OrderDaoImpl implements OrderDao {
	private static final String SEARCH_ORDER_BY_USER_ID = "From Order where account.username= :userName";
	private static final String SEARCH_ORD_DETAIL_BY_ORD_ID = "From OrderDetail where order.orderId= :orderId";
	
	@Autowired
	private SessionFactory sessionFactory;

	public Order searchByUserId(String userName) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(SEARCH_ORDER_BY_USER_ID);
		query.setParameter("userName", userName);
		List<Order> orderList = (List<Order>) query.list();
		Order order = null;
		
		if (orderList!=null && !orderList.isEmpty()) {
			order = orderList.get(0);
		}
		
		return order;
	}

	public List<OrderDetail> searchByOrderId(int orderId) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(SEARCH_ORD_DETAIL_BY_ORD_ID);
		query.setParameter("orderId", orderId);
		List<OrderDetail> ordDetailList = (List<OrderDetail>) query.list();
		
		return ordDetailList;
	}

}
