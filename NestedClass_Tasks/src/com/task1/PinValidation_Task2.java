package com.task1;

import java.util.Scanner;

public class PinValidation_Task2 {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("eg:636401 \n rules:pincode should be 6 digits \n first digit canot be zero");
		System.out.println("Enter The pincode:");
		String pin=sc.next();
		Employee e1=new Employee(pin);
	}

}
