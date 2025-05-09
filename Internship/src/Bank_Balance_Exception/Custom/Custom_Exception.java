package Bank_Balance_Exception.Custom;

public class Custom_Exception extends Exception{
	
	private String message;

	public Custom_Exception(String message) {
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
