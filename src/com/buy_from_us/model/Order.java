package com.buy_from_us.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_order")
public class Order {
	
	private int orderId;
	private Account account;
	
	@OneToOne
	@JoinColumn(name = "key_user")
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	//private int userId;
	private BigDecimal amount;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "key_order")
	public int getOrderId() {
		return orderId;
	}
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
//	@OneToOne
//	@JoinColumn(name = "key_user")
//	public int getUserId() {
//		return userId;
//	}
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
	
	@Column(name = "fld_amount")
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
}
