package com.management.utils;

public class Validator {
	
	

	   	public static boolean isValidPincode(String pincode) {
	        return pincode != null && pincode.matches("\\d{6}");
	    }
	


}
