package Celsius_Farenheit;

public class Custom_Exception extends Exception {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Custom_Exception(String message) {
		super();
		this.message = message;
	}
	
	
	
}
