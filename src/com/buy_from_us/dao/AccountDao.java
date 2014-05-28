package com.buy_from_us.dao;

import java.util.List;

import com.buy_from_us.model.Account;


public interface AccountDao{
	public List<Account> getAllUsers();
	public Account searchByUsername(String username);
	
	/*
    private SessionFactory sessionFactory;
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public void testConnection(){
		Session session = sessionFactory.getCurrentSession();//getSession();
		session.beginTransaction();
		
		List<Account> users = (List<Account>) session.createQuery("from tbl_user").list();
		System.out.println(users);
	}
	
	public List<Account> getAllUsers(){
		Session session = sessionFactory.getCurrentSession();//getSession();
		session.beginTransaction();
		List<Account> users = (List<Account>) session.createQuery("from tbl_user").list();
		
		return users;
	}
*/	
}
