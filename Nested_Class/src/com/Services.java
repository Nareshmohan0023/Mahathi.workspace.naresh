package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.Department.Employee;

public interface Services {
	
	void customLoader(Services serv);
	
	List<Department> CollectionOfDepartment=new ArrayList<>();
	
	void departmentLoader(Department dept);
	
	List<Department> getDepartments();
	
	void addEmployee(Employee e);
	
	int numberOfEmployees(Department dept);
	
	void listOfEmployees(Department dept);
	
	Department selectDepartmentById(int id,List<Department> Departments);
	
	void displayDepartments(List<Department> departments);
	
	
	

}
