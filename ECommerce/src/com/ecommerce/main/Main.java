package com.ecommerce.main;

import java.util.Scanner;

import com.ecommerce.controller.AdminController;
import com.ecommerce.controller.CustomerController;
import com.ecommerce.controller.UserController;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello, Welcome to Personal-Kart");
		CustomerController ccontrl = new CustomerController();
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

	}

}
