package com.management.main;

import com.management.controller.AdminController;
import com.management.controller.EmployeeController;
import com.management.database.DataBase;
import com.management.entity.Admin;
import com.management.entity.Employee;
import com.management.utils.ConfigLoader;
import com.management.utils.InputUtil;

public class Main {
	public static void main(String[] args) {
		
		AdminController acontrl = new AdminController();
		EmployeeController econtrl=new EmployeeController();
		acontrl.loadDefaultEmployees();
		
//		System.out.println(ConfigLoader.getAdminUsername());
		char ex = 'y';
		do {
			Employee emp;
//			boolean isAdmin = false;
			String userName = InputUtil.getStringInput("Enter the username:");
			for (Employee e : DataBase.getListOfEmp()) {
				if (userName.equals(ConfigLoader.getAdminUsername())) {
					System.out.println("Admin exists");
//					isAdmin = true;
					String passCode = InputUtil.getStringInput("Enter the Password");
					if (passCode.equals(ConfigLoader.getAdminPassword())) {
						acontrl.start();
						break;
					}

				} else if (userName.equals(e.getUser().getUserName())) {
					System.out.println("Employee exists");
					emp = e;
					String passCode = InputUtil.getStringInput("Enter the Password");
					if (passCode.equals(e.getUser().getPassword())) {
						econtrl.start(emp);
						break;
					}

				} 

			}
			System.out.println("No user or admin found");
			System.out.println("Do you want to go to loginPage");
			ex = InputUtil.getStringInput("Enter 'y' or 'n' to Continue").toLowerCase().charAt(0);
		} while (ex == 'y');

	}

}
