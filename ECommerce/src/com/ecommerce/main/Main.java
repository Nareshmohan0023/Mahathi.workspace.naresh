package com.ecommerce.main;

import com.ecommerce.controller.AdminController;
import com.ecommerce.controller.CustomerController;
import com.ecommerce.controller.UserController;
import com.ecommerce.utils.InputUtil;

public class Main {

	public static void main(String[] args) {
		UserController ucntrl = new UserController();
		AdminController acntrl = new AdminController();
		CustomerController ccontrl = new CustomerController();

//		UserController ucntrl=new UserController()
		int choice = 0;
		choice = InputUtil.getIntegerInput("Enter the choice:/n1.admin /2.user");
		switch (choice) {
		case 1:
			acntrl.start();
			break;
		case 2:
			ccontrl.displayCustomer();
			ucntrl.start(ccontrl.isCustomer());
			break;

		}
	

	}

}
