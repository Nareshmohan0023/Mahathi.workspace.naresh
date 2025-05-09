package com.customException;

public class FoodNotFoundException extends Exception{
	String message;
	
	

	public FoodNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
