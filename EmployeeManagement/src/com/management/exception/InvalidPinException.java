package com.management.exception;

public class InvalidPinException extends Exception {
	
	private String message;
	
	public InvalidPinException() {
		super();
		System.out.println("Invalid Pin");
	}

	public InvalidPinException(String message) {
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
