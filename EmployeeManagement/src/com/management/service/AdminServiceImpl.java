package com.management.service;

import com.management.database.DataBase;
import com.management.entity.Employee;

public class AdminServiceImpl implements AdminService {
	@Override
	public void addEmployee(Employee e) {
		DataBase.getListOfEmp().add(e);
		System.out.println("Employee "+e.getName()+" added Successfully");
	}
}
