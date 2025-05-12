package com.ecommerce.entity;

import com.ecommerce.utils.IdGenerator;

public class Customer {
	private int customerId;
	private String name;
	private Cart cart;
	
	

	public Customer( String name) {
		super();
		this.customerId = IdGenerator.customerIdGenerator();
		this.name = name;
		this.cart=new Cart();
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

}
