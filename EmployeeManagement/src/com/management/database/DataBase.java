package com.management.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.management.entity.Employee;

public class DataBase {
	private static List<Employee> listOfEmp=new ArrayList<>();
	
	private static Map<Integer, String> roles = new HashMap<>();

	static {
		roles.put(1, "Manager");
		roles.put(2, "Supervisor");
		roles.put(3, "Technician");
		roles.put(4, "Intern");
	}

	private static Map<Integer, String> gender = new HashMap<>();

	static {
		gender.put(1, "Male");
		gender.put(2, "Female");
		gender.put(3, "Other");
	}

	public static Map<Integer, String> getRoles() {
		return roles;
	}

	public static String setRole(int id) {
//		displayRoles();

		return roles.get(id);
	}

	public static Map<Integer, String> getGender() {
		return roles;
	}

	public static String setGender(int id) {
		return roles.get(id);
	}

	public static void displayRoles() {
		for (Map.Entry<Integer, String> e : roles.entrySet()) {
			System.out.println("Id:" + e.getKey() + " Role:" + e.getValue());
		}
	}

	public static void displayGender() {
		for (Map.Entry<Integer, String> e : gender.entrySet()) {
			System.out.println("Id:" + e.getKey() + " Role:" + e.getValue());
		}
	}

	public static List<Employee> getListOfEmp() {
		return listOfEmp;
	}

	public static void setListOfEmp(List<Employee> listOfEmp) {
		DataBase.listOfEmp = listOfEmp;
	}
	
	
	
	

}
