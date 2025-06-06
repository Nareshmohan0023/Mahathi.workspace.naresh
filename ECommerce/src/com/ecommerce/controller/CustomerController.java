package com.ecommerce.controller;

import com.ecommerce.db.DataBase;
import com.ecommerce.entity.Customer;
import com.ecommerce.service.CustomerService;
import com.ecommerce.service.CustomerServiceImpl;
import com.ecommerce.utils.InputUtil;

public class CustomerController {
	CustomerService cserv = new CustomerServiceImpl();

	public void createCustomer() {
		String Name = InputUtil.getStringInput("Enter The Name Of the Customer:");
		cserv.addCustomer(new Customer(Name));
	}

	public void loaderForCustomer() {
		int no = InputUtil.getIntegerInput("Enter no of customers To create");
		for (int i = 1; i <= no; i++) {
			System.out.println("Customer "+i);
			createCustomer();
		}
	}
	
	public void displayCustomer() {
		System.out.println("The number of Customers inthe DB are:"+DataBase.getCustomerList().size());
		cserv.displayCustomer();
	}
	
	public Customer isCustomer() {
		String name=InputUtil.getStringInput("Enter the Name of the Customer to get into Account:");
		Customer customer=returnCustomer(name);

		if(cserv.customerValidation(name)) {
			System.out.println("Welcome ,"+name);
			return customer;
		}
		System.out.println("User, Not Found !");
		return null;
	}
	
	public Customer returnCustomer(String Name) {
		return cserv.returnCustomer(Name);
	}
}
