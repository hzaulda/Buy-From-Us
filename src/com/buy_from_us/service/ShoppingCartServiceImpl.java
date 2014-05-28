package com.buy_from_us.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buy_from_us.dao.AccountDao;
import com.buy_from_us.dao.OrderDao;
import com.buy_from_us.dao.ProductDao;
import com.buy_from_us.dao.ShoppingCartDao;
import com.buy_from_us.model.Account;
import com.buy_from_us.model.Order;
import com.buy_from_us.model.OrderDetail;
import com.buy_from_us.model.Product;

//@Transactional
@Service("shopCartService")
public class ShoppingCartServiceImpl implements ShoppingCartService {
	
	@Autowired
	private ShoppingCartDao shopCartDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private OrderDao orderDao;
	
	public String addToCart(String productName, int qty, 
			String username, Order order) {
	
		Product product =  productDao.searchByProductName(productName);
		Account account = accountDao.searchByUsername(username);
		String result = shopCartDao.addToCart(product, qty, account, order);
		
		return result;
	}

	public void getCartContents(List<OrderDetail> orderDetails) {
		// TODO Auto-generated method stub
		
	}

	public String addToCart(String productName, int intVal, String user,
			Order order, List<OrderDetail> orderDetails) {
		// TODO Auto-generated method stub
		return null;
	}

}
