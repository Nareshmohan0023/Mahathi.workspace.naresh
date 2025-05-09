package com.services;

import java.util.Map;

import com.entity.Admin;
import com.entity.Department;
import com.entity.Employee;

public class ServiceImpl implements Services{

	@Override
	public void CustomLoader(Admin admin) {
//		Admin admin=new Admin();
		
		Department python=new Department(1, "python");
		Employee p1=new Employee(1, python, "Naresh");
		Employee p2=new Employee(2, python, "Vinoth");
		Employee p3=new Employee(3, python, "Prathap");
		
		python.add_Emp(p3);
		python.add_Emp(p2);
		python.add_Emp(p1);
		
		Department java=new Department(2, "java");
		Employee j1=new Employee(1, java, "Naresh");
		Employee j2=new Employee(2, java, "Vinoth");
		Employee j3=new Employee(3, java, "Prathap");
		
		java.add_Emp(j3);
		java.add_Emp(j2);
		java.add_Emp(j1);
		
		admin.AddDept(python);
		admin.AddDept(java);
		System.out.println(admin.getDeptCollection().size());
		
		System.out.println("Default Values Added");
		
		
	}

	@Override
	public void AddDept(String Name,Admin admin) {
		admin.AddDept(new Department(admin.getDeptCollection().size()+1,Name));
		System.out.println("Dept added sucessfully");
	}

	@Override
	public void displayDepartments(Map<Integer, Department> deptCollection) {
		for(Map.Entry<Integer, Department> e:deptCollection.entrySet()) {
			System.out.println("ID:"+e.getKey()+",Department:"+e.getValue().getDeptName());
		}
		
	}
	
	

	
	
	

}
