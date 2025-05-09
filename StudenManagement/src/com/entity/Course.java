package com.entity;

import java.util.ArrayList;
import java.util.List;

public class Course {
	private String CourseName;
	private int CourseId;
	List<Student> List_Students=new ArrayList<>();
	public Course(String courseName, int courseId) {
		super();
		CourseName = courseName;
		CourseId = courseId;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	public int getCourseId() {
		return CourseId;
	}
	public void setCourseId(int courseId) {
		CourseId = courseId;
	}
	public List<Student> getList_Students() {
		return List_Students;
	}
	public void setList_Students(List<Student> list_Students) {
		List_Students = list_Students;
	}
	
	// 
	
	public void addStudent(School s,Student stud) {
		s.by_School.add(stud);
	}
	
	public void addIntoCourse(Student stud) {
		List_Students.add(stud);
	}
	

}
