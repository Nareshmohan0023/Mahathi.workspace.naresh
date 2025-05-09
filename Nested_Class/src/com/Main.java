package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static List<Department> Departments=new ArrayList<>();
	static char exit='y';

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Services serv=new Services_Impl();
		serv.customLoader(serv);
		Departments=serv.getDepartments();
//		serv.listOfEmployees(Departments.get(0));
		
		System.out.println("Welcome To Employee Management");
		do {
			System.out.println("1.Add department 2.Add Employee 3.Fetch Number of Employees in the Department 4.No.of Dept");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
					System.out.println("Enter the name of the Department:");
					String deptName=sc.next();
					Departments.add(new Department((Departments.size()+1),deptName));
					System.out.println("Department Added sucessfully");
				//
					break;
			case 2:
				System.out.println("Enter Which Department to add employee by id displayed:");
				serv.displayDepartments(Departments);
				System.out.println("Choose the id as displayed:");
				int dept=sc.nextInt();
				Department fetchDept=serv.selectDepartmentById(dept, Departments);
				if(fetchDept==null){
					System.out.println("Department not found");
					break;
				}
				System.out.println("Enter the Name of the Employee:");
				String empName=sc.next();
				int empId=fetchDept.getEmployees().size()+1;
				serv.addEmployee(fetchDept.new Employee(empId,empName,fetchDept));
				System.out.println("Employee Added sucessfully");
				
				//
				break;
			case 3:
				System.out.println("Select Department as Id to fetch details:");
				serv.displayDepartments(Departments);
				System.out.println("Choose the id as displayed:");
				int department=sc.nextInt();
				Department fetchDepartment=serv.selectDepartmentById(department, Departments);
				System.out.println("Nymber of Employees are: "+serv.numberOfEmployees(fetchDepartment));
				serv.listOfEmployees(fetchDepartment);
				

				//
				break;
				
			case 4:
				System.out.println("Departments Details:");
				System.out.println("No of Departments :"+Departments.size());
				for(Department d:Departments) {
					System.out.println("ID:"+d.getId()+",Name:"+d.getDepatmentName());
				}
				//
				break;
			default:
				break;
			}

			
			System.out.println("do you want to continue :'y' or 'n'");
			exit=sc.next().charAt(0);
		}while((exit=='y'));
		
		
	}



}
