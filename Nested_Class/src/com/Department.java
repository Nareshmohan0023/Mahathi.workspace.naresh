package com;

import java.util.ArrayList;
import java.util.List;

public class Department {
	private int id;
	private String depatmentName;
	private List<Employee> Employees=new ArrayList();
	//

	public Department(int id, String depatmentName) {
		super();
		this.id = id;
		this.depatmentName = depatmentName;
	}

	public List<Employee> getEmployees() {
		return Employees;
	}

	public void setEmployees(List<Employee> employees) {
		Employees = employees;
	}
	
	public void addIntoEmployees(Employee e) {
		Employees.add(e);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepatmentName() {
		return depatmentName;
	}

	public void setDepatmentName(String depatmentName) {
		this.depatmentName = depatmentName;
	}

	public class Employee {
		
		private int empId;
		private String empName;
		private Department departmentName;
		
		
		public Department getDepartmentName() {
			return departmentName;
		}
		public void setDepartmentName(Department departmentName) {
			this.departmentName = departmentName;
		}
		public Employee(int empId, String empName,Department departmentName) {
			super();
			this.empId = empId;
			this.empName = empName;
			this.departmentName=departmentName;
			
		}
		public int getEmpId() {
			return empId;
		}
		public void setEmpId(int empId) {
			this.empId = empId;
		}
		public String getEmpName() {
			return empName;
		}
		public void setEmpName(String empName) {
			this.empName = empName;
		}

		
		

	}

}
