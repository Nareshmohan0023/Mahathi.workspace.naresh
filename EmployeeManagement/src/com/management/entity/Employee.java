package com.management.entity;

public class Employee {
	private int empId;
	private String Name;
	private String Gender;
	private Address address;
	private JobProfile jobProfile;
	private User user;
	
	
	
	

	public Employee(int empId, String name, String gender, Address address, User user) {
		super();
		this.empId = empId;
		Name = name;
		Gender = gender;
		this.address = address;
		this.jobProfile =new JobProfile();
		this.user = user;
	}
	public Employee(int empId, String name, String gender, Address address, User user,JobProfile jobProfile) {
		super();
		this.empId = empId;
		Name = name;
		Gender = gender;
		this.address = address;
		this.jobProfile = jobProfile;
		this.user = user;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public JobProfile getJobProfile() {
		return jobProfile;
	}

	public void setJobProfile(JobProfile jobProfile) {
		this.jobProfile = jobProfile;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", Name=" + Name + ", Gender=" + Gender + ", address=" + address
				+ ", jobProfile=" + jobProfile + ", user=" + user + "]";
	}

}
