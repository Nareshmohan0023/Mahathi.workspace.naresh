package com.entity;

import java.util.ArrayList;
import java.util.List;

public class Department {
	private int id;
	public String DeptName;
	
	private List<Employee> list_Emp=new ArrayList<>();
	
	public Department(int id, String deptName) {
		super();
		this.id = id;
		DeptName = deptName;
		
	}
	
	


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDeptName() {
		return DeptName;
	}
	public void setDeptName(String deptName) {
		DeptName = deptName;
	}
	public List<Employee> getList_Emp() {
		return list_Emp;
	}
	
	public void add_Emp(Employee e) {
		this.list_Emp.add(e);
	}
	
	
	public void setList_Emp(List<Employee> list_Emp) {
		this.list_Emp = list_Emp;
	}
	
	

}
