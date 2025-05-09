package com.services;

import java.util.Map;

import com.entity.Admin;
import com.entity.Department;

public interface Services {
	
	void CustomLoader(Admin admin);
	void AddDept(String deptName,Admin admin);
	
	void displayDepartments(Map<Integer, Department> deptCollection);

}
