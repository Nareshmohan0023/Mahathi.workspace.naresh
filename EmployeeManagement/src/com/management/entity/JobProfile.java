package com.management.entity;

public class JobProfile {
	private int totalWorkExperience;
	private double salary;
	private int leadId;
	private String role;
	
	
	
	public JobProfile(int leadId,String role,int totalWorkExperience, double salary ) {
		super();
		this.totalWorkExperience = totalWorkExperience;
		this.salary = salary;
		this.leadId = leadId;
		this.role=role;
	}
	public JobProfile() {
		// TODO Auto-generated constructor stub
	}
	public int getTotalWorkExperience() {
		return totalWorkExperience;
	}
	public void setTotalWorkExperience(int totalWorkExperience) {
		this.totalWorkExperience = totalWorkExperience;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getLeadId() {
		return leadId;
	}
	public void setLeadId(int leadId) {
		this.leadId = leadId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	
	

}
