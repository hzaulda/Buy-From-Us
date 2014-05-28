package com.buy_from_us.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.buy_from_us.helper.Payment;
import com.buy_from_us.model.Account;
import com.buy_from_us.model.Order;
import com.buy_from_us.model.OrderDetail;
import com.buy_from_us.model.Product;

@Repository("shopcartDao")
@Transactional
public class ShoppingCartDaoImpl implements ShoppingCartDao{
	private static final String ADD_TO_CART_SUCCESS = "Add to Cart is successful!";
	private static final String ADD_TO_CART_FAILED = "Error encountered upon adding to cart!";
	
	@Autowired
	private SessionFactory sessionFactory;

	public String removeFromCart(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	public String updateQty(Product product, int qty) {
		// TODO Auto-generated method stub
		return null;
	}

	public String addToCart(Product product, int qty, Account account,
			Order order) {
		String result = ADD_TO_CART_SUCCESS;
		Session session = sessionFactory.openSession();
		try{
	        session.beginTransaction();
	        BigDecimal unitPrice = product.getUnitPrice();
	        BigDecimal amount = calculateAmount(unitPrice, qty);
	        
	        if(order == null || order.getOrderId()== 0) {
	        	order = new Order();
		        order.setAccount(account);
		        order.setAmount(amount);
		        session.save(order);
	        }
	        
	        OrderDetail orderDetail = new OrderDetail();
	        orderDetail.setOrder(order);
	        orderDetail.setProduct(product);
	        orderDetail.setQuantity(qty);
	        orderDetail.setUnitPrice(unitPrice);
	        
	        session.save(orderDetail);
	        
	        session.getTransaction().commit();
	        
		}catch(Exception e){
			result = ADD_TO_CART_FAILED;
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return result;
	}
	
	private BigDecimal calculateAmount(BigDecimal price, int qty) {
		BigDecimal itemCost  = BigDecimal.ZERO;
	    BigDecimal totalCost = BigDecimal.ZERO;
	    
	    itemCost  = price.multiply(new BigDecimal(qty));
        totalCost = totalCost.add(itemCost);
        return totalCost;
	    
	}

	public String addToCart(Product product, int qty, Account account,
			Order order, List<OrderDetail> orderDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	public String addToCart(Product product, int qty, Account account,
			Order order, List<OrderDetail> orderDetails) {
		String result = ADD_TO_CART_SUCCESS;
		Session session = sessionFactory.openSession();
		Payment payment = new Payment();
		BigDecimal totalPayment = BigDecimal.ZERO;
		
		try{
		    session.beginTransaction();
		    
		    BigDecimal productToAddPrice = product.getUnitPrice();
		    totalPayment = payment.calculateCost(qty, productToAddPrice);
		    
		    //BigDecimal unitPrice = product.getUnitPrice();
		    //BigDecimal amount = calculateAmount(unitPrice, qty);
		    
			if (orderDetails!= null && orderDetails.isEmpty()) {
				for (OrderDetail orderDetail : orderDetails) {
					Product ordProduct = orderDetail.getProduct();
					BigDecimal productPrice = ordProduct.getUnitPrice();
					int quantity = orderDetail.getQuantity();
					totalPayment =totalPayment.add(payment.calculateCost(quantity, productPrice));
				}
				order.setAmount(totalPayment);
			} else {
				order = new Order();
		        order.setAccount(account);
		        order.setAmount(totalPayment);
		        session.save(order);
			}

		    
//		    if(order == null || order.getOrderId()== 0) {
//		    	order = new Order();
//		        order.setAccount(account);
//		        order.setAmount(amount);
//		        session.save(order);
//		    }
	    
		    OrderDetail orderDetail = new OrderDetail();
		    orderDetail.setOrder(order);
		    orderDetail.setProduct(product);
		    orderDetail.setQuantity(qty);
		    orderDetail.setUnitPrice(productToAddPrice);
		    
		    session.save(orderDetail);
	    
	    session.getTransaction().commit();
	    
		}catch(Exception e){
			result = ADD_TO_CART_FAILED;
			e.printStackTrace();
		}finally{
			session.close();
		}
	
		return result;
	}
	*/
	
	
//	public String addToCart(Product product, int qty, Account account,
//			Order order, List<OrderDetail> orderDetails) {
//		
//		Payment payment = new Payment();
//		BigDecimal totalPayment = BigDecimal.ZERO;
//		
//		if (orderDetails!= null && orderDetails.isEmpty()) {
//			for (OrderDetail orderDetail : orderDetails) {
//				Product ordProduct = orderDetail.getProduct();
//				BigDecimal productPrice = ordProduct.getUnitPrice();
//				int quantity = orderDetail.getQuantity();
//				totalPayment =totalPayment.add(payment.calculateCost(quantity, productPrice));
//			}
//		}
//		
//		return null;
//	}

}
