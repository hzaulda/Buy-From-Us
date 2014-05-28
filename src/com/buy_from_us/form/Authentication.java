package com.buy_from_us.form;

public class Authentication {
	private String message;
	private String landingPage;
	private int role;
	private boolean isSuccessful;
	

	public boolean isSuccessful() {
		return isSuccessful;
	}

	public void setSuccessful(boolean isSuccessful) {
		this.isSuccessful = isSuccessful;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public Authentication(String message, String landingPage,
			int role, boolean isSuccessful){
		this.message = message;
		this.landingPage = landingPage;
		this.role = role;
		this.isSuccessful = isSuccessful;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getLandingPage() {
		return landingPage;
	}
	public void setLandingPage(String landingPage) {
		this.landingPage = landingPage;
	}
	
	
}
