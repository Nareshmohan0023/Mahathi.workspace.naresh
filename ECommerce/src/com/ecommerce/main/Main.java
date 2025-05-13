package com.ecommerce.main;

<<<<<<< HEAD
import java.util.Scanner;

import com.ecommerce.controller.AdminController;
import com.ecommerce.controller.CustomerController;
import com.ecommerce.controller.UserController;
=======
import com.ecommerce.controller.AdminController;
import com.ecommerce.controller.CustomerController;
import com.ecommerce.controller.UserController;
import com.ecommerce.utils.InputUtil;
>>>>>>> a97894743a21f02033980070e6f46041a42c25cb

public class Main {

	public static void main(String[] args) {
		UserController ucntrl = new UserController();
		AdminController acntrl = new AdminController();
		CustomerController ccontrl = new CustomerController();
<<<<<<< HEAD
		ccontrl.loaderForCustomer();
//		System.out.println(DataBase.getCustomerList().size());
		ccontrl.displayCustomer();
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("Are you a 1. User or 2. Admin?");
			int choice = sc.nextInt();

			if (choice == 1) {
			    UserController userController = new UserController();
			    userController.start();
			} else if (choice == 2) {
			    AdminController adminController = new AdminController();
			    adminController.start();
			} else {
			    System.out.println("Invalid choice.");
			}
			
			
			
			if (ccontrl.isCustomer()) {
				System.out.println("");
			}
		} while (false);
=======

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
	
>>>>>>> a97894743a21f02033980070e6f46041a42c25cb

	}

}
