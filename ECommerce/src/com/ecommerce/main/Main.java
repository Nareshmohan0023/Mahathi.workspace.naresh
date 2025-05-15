package com.ecommerce.main;
import java.util.Scanner;
import com.ecommerce.controller.AdminController;
import com.ecommerce.controller.CustomerController;
import com.ecommerce.controller.UserController;
import com.ecommerce.utils.InputUtil;

public class Main {

	public static void main(String[] args) {
		UserController ucntrl = new UserController();
		AdminController acntrl = new AdminController();
		CustomerController ccontrl = new CustomerController();
		acntrl.loadInitialData();
		ccontrl.loaderForCustomer();
//		System.out.println(DataBase.getCustomerList().size());
		ccontrl.displayCustomer();
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("Are you a 1. User or 2. Admin?");
			int choice = sc.nextInt();

			if (choice == 1) {
			    UserController userController = new UserController();
			    ccontrl.displayCustomer();
			    userController.start(ccontrl.isCustomer());
			} else if (choice == 2) {
			    AdminController adminController = new AdminController();
			    adminController.start();
			} else {
			    System.out.println("Invalid choice.");
			}

		} while (false);


	}

}
