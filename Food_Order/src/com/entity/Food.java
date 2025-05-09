package com.entity;

public class Food {
	
	private int id;
	private double price;
	private String Name;
	public Food(int id, double price, String name) {
		super();
		this.id = id;
		this.price = price;
		Name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	
	
	
	
	

}
