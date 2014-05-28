package com.buy_from_us.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_user")
public class Account {
	private String username;
	private String password;
	private int keyRole;
	private Long id;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "key_user")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "fld_username")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name = "fld_password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "key_role")
	public int getKeyRole() {
		return keyRole;
	}
	public void setKeyRole(int keyRole) {
		this.keyRole = keyRole;
	}
	
	@Override
	public String toString(){
		return "userName: " +username + " password: " + password; 
	}
		
}
