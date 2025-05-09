package com.task1;

public class Employee {

	Address address;

	public Employee(String pincode) {
		super();
		this.address = new Address(pincode);
	}

	public static boolean pincodeValidation(String pincode) {
		String regex = "^[1-9][0-9]{5}";
		return pincode.matches(regex);
	}

	static class Address {
		private String PinCode;

		public Address(String pincode) {
			super();
			if(Employee.pincodeValidation(pincode)) {
				PinCode = pincode;
			}else{
				System.err.println("Failed to craete due to invalid  pincode4");
			}
			
		}

		public String getPinCode() {
			return PinCode;
		}

		public void setPinCode(String pinCode) {
			PinCode = pinCode;
		}

	}

}
