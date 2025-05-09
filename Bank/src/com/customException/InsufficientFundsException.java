package com.customException;

public class InsufficientFundsException extends Exception {
	
	private String Message;
	
	

	public String getMessage() {
		return Message;
	}



	public void setMessage(String message) {
		Message = message;
	}



	public InsufficientFundsException(String Message) {
		super();
		this.Message=Message;
	}
	
	

}
