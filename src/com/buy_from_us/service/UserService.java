package com.buy_from_us.service;

import com.buy_from_us.form.Authentication;

public interface UserService {
	public Authentication isUserAuthenticated(String username, String password);

}
