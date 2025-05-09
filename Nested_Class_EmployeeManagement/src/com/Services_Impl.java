package com;

import java.util.List;

import com.Department.Employee;

public class Services_Impl implements Services {

	@Override
	public void departmentLoader(Department dept) {
		CollectionOfDepartment.add(dept);

	}

	@Override
	public List<Department> getDepartments() {
		return CollectionOfDepartment;
	}

	@Override
	public void addEmployee(Employee e) {
		e.getDepartmentName().addIntoEmployees(e);
//		System.out.println("Employee added successfully");
	}

	@Override
	public int numberOfEmployees(Department dept) {
		return dept.getEmployees().size();
	}

	@Override
	public void listOfEmployees(Department dept) {
		System.out.println("The Employess in the "+dept.getDepatmentName()+" are:");
//		List<Employee> emps=new ArrayList<>();
		for (Employee e : (dept.getEmployees())) {
			System.out.println(e.getEmpName() + "," + e.getEmpId());
		}
	}

	@Override
	public void customLoader(Services serv) {
		Department Testing = new Department(1, "Testing");

		Department.Employee t1 = Testing.new Employee(1, "Naresh", Testing);
		Department.Employee t2 = Testing.new Employee(2, "Vinoth", Testing);
		Department.Employee t3 = Testing.new Employee(3, "Prathap", Testing);
		serv.addEmployee(t1);
		serv.addEmployee(t2);
		serv.addEmployee(t3);
		
		Department Developer = new Department(2, "Developer");

		Department.Employee d1 = Testing.new Employee(1, "Naresh", Developer);
		Department.Employee d2 = Testing.new Employee(2, "Vinoth", Developer);
		Department.Employee d3 = Testing.new Employee(3, "Prathap", Developer);
		Department.Employee d4 = Testing.new Employee(4, "Kanishka", Developer);
		serv.addEmployee(d1);
		serv.addEmployee(d2);
		serv.addEmployee(d3);
		serv.addEmployee(d4);
		
		serv.departmentLoader(Developer);
		serv.departmentLoader(Testing);

	}

	@Override
	public Department selectDepartmentById(int id,List<Department> departments) {
		for(Department d:departments) {
			if(d.getId()==id) {
				return d;
			}
		}
		return null;
	}

	@Override
	public void displayDepartments(List<Department> departments) {
		for(Department d:departments) {
			System.out.println("ID:"+d.getId()+",Name:"+d.getDepatmentName());
		}
		
	}

}
