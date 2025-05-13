package com.management.entity;

public class Admin {
	private static final int id=100;
	private static String userName="Admin";
	private static String password="Admin123";
	public static String getUserName() {
		return userName;
	}
	public static void setUserName(String userName) {
		Admin.userName = userName;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		Admin.password = password;
	}
	public static int getId() {
		return id;
	}
	
	
	
}
