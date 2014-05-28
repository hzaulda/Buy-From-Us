package com.buy_from_us.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.buy_from_us.model.Account;
import com.buy_from_us.model.Product;

@Repository("accountDao")
@Transactional
public class AccountDaoImpl implements AccountDao {
	private static final String SELECT_FROM_ACCOUNT = "from Account";
	private static final String SEARCH_BY_USERNAME= "from Account where username= :userName";
	
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public List<Account> getAllUsers() {
		Session session = sessionFactory.getCurrentSession();//getSession();
		session.beginTransaction();
		List<Account> users = (List<Account>) session.createQuery(SELECT_FROM_ACCOUNT).list();
		return users;
	}

	public Account searchByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(SEARCH_BY_USERNAME);
		query.setParameter("userName", username);
		
		//Account account = (Account) query.list();
		List<Account> accountList = (List<Account>) query.list();
		Account account = new Account();
		
		if (accountList!=null) {
			account = accountList.get(0);
		}
		
		return account;
	}

}
