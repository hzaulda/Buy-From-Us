package com.buy_from_us.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buy_from_us.dao.AccountDao;
import com.buy_from_us.form.Authentication;
import com.buy_from_us.model.Account;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	private static final String AUTH_SUCCESS = "Welcome to Buy From Us!";
	private static final String AUTH_FAILED = "Incorrect username or password!";
	
	@Autowired
	private AccountDao accountDao;
	
	public AccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}


	public Authentication isUserAuthenticated(String formUserName, String formPassword) {
		List<Account> accounts = accountDao.getAllUsers();
		Authentication auth = getAuth(false, 0);
		
		for (Account account : accounts) {
			String dbUserName = account.getUsername();
			String dbPassword = account.getPassword();
			int dbRole = account.getKeyRole();
			
			boolean match = credentialMatch(formUserName, formPassword, 
					dbUserName, dbPassword);
			
			if (match) {
				auth = getAuth(match, dbRole);
				break;
			}
		}
		return auth;
	}
	
	public boolean credentialMatch(String formUserName, String formPassword, 
			String dbUserName, String dbPassword) {
		return formUserName.equals(dbUserName) &&
				formPassword.equals(dbPassword);
	}
	
	
	private Authentication getAuth(boolean isAuth, int role) {
		if (isAuth) {
			String landingPage = (role==1) ? "admin-page" : "view-products";
			return new Authentication(AUTH_SUCCESS, landingPage, role, true);
		} else {
			return new Authentication(AUTH_FAILED, "log-in", role, false);
		}
	}
	

}
