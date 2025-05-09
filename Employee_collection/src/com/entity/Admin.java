package com.entity;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.services.ServiceImpl;
import com.services.Services;

public class Admin {
	private static Map<Integer,Department> DeptCollection=new HashMap<>();
	
	public void AddDept(Department d) {
		DeptCollection.put(d.getId(), d);
	}
	
	public Map<Integer,Department> getDeptCollection(){
		return DeptCollection;	
	}
	public Department selectDepartmentById(int i) {
		if(!DeptCollection.containsKey(i)) {
			return null;
		}else {
			return DeptCollection.get(i);
		}
	}
	
	
	public static void main(String[] args) {
		
		Admin admin=new Admin();
		Scanner sc=new Scanner(System.in);
		Services serv=new ServiceImpl();
		serv.CustomLoader(admin);
		
		System.out.println("Welcome To Employee Management");
		char exit='y';
		do {
			System.out.println("1.Add department 2.Add Employee 3.Fetch Number of Employees in the Department 4.No.of Dept");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
					System.out.println("Enter the name of the Department:");
					String deptName=sc.next();
					serv.AddDept(deptName, admin);
					System.out.println("Department Added sucessfully");
				//
					break;
			case 2:
				System.out.println("Enter Which Department to add employee by id displayed:");
				serv.displayDepartments(DeptCollection);
				System.out.println("Choose the id as displayed:");
				int dept=sc.nextInt();
				Department fetchDept=admin.selectDepartmentById(dept);
				int noEmp=fetchDept.getList_Emp().size();
				if(fetchDept==null){
					System.out.println("Department not found");
					break;
				}
				System.out.println("Enter the Name of the Employee:");
				String empName=sc.next();
				fetchDept.add_Emp(new Employee((noEmp+1),fetchDept,empName));
				System.out.println("Employee Added sucessfully");
				
				//
				break;
			case 3:
				System.out.println("Select Department as Id to fetch details:");
				serv.displayDepartments(DeptCollection);
				System.out.println("Choose the id as displayed:");
				int department=sc.nextInt();
				Department fetchDept1=admin.selectDepartmentById(department);
				System.out.println("Nymber of Employees are: "+fetchDept1.getList_Emp().size());
//				serv.listOfEmployees(fetchDepartment1);
				Collections.sort(fetchDept1.getList_Emp(),Comparator.comparing(Employee::getEmpName));
				for(Employee e:fetchDept1.getList_Emp()) {
					System.out.println("Id:"+e.getEmpID()+",Name:"+e.getEmpName());

				}
				

				
				break;
//				
			case 4:
				System.out.println("Departments Details:");
				System.out.println("No of Departments :"+admin.getDeptCollection().size());
				serv.displayDepartments(DeptCollection);
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
