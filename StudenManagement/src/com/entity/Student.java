package com.entity;

public class Student {
	private String Name;
	private Course course;
	private int Grade;
	public Student(String name, Course course, int grade) {
		super();
		Name = name;
		this.course = course;
		Grade = grade;
		course.addIntoCourse(this);
		
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Course getCourse() {
		return course;
	}
	public String getCourseName() {
		return course.getCourseName();
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public int getGrade() {
		return Grade;
	}
	public void setGrade(int grade) {
		Grade = grade;
	}
	
	//
	
	
	

}
