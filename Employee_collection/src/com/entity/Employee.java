package com.entity;

public class Employee {
	private int EmpID;
	private Department Department;
	private  String EmpName;
	public Employee(int empID, com.entity.Department department, String empName) {
		super();
		EmpID = empID;
		Department = department;
		EmpName = empName;
	}
	public int getEmpID() {
		return EmpID;
	}
	public void setEmpID(int empID) {
		EmpID = empID;
	}
	public Department getDepartment() {
		return Department;
	}
	public void setDepartment(Department department) {
		Department = department;
	}
	public String getEmpName() {
		return EmpName;
	}
	public void setEmpName(String empName) {
		EmpName = empName;
	}
	
	
	
	

}
