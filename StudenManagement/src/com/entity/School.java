package com.entity;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class School {
	
	public Map<Integer,Course> by_Course=new HashMap<>();
	public Set<Student> by_School=new LinkedHashSet<>();
	public Map<Integer, Course> getBy_Course() {
		return by_Course;
	}
	public void setBy_Course(Map<Integer, Course> by_Course) {
		this.by_Course = by_Course;
	}
	public Set<Student> getBy_School() {
		return by_School;
	}
	public void setBy_School(Set<Student> by_School) {
		this.by_School = by_School;
	}
	
	public void putCourse(Course c) {
		this.by_Course.put(c.getCourseId(), c);
	}
	
	//select course by id
	
	public Course CourseById(int id) {
		for(Map.Entry<Integer, Course> entry:by_Course.entrySet()) {
			if(entry.getKey()==id) {
				return  entry.getValue();
			}
		}
		return null;
	}
	
	public void loadStudents() {
		for(Map.Entry<Integer, Course> e:this.getBy_Course().entrySet()) {
			for(Student s:e.getValue().List_Students) {
				this.by_School.add(s);
			}
		}
	}
	
	
	public void DisplayCourses() {
		for(Map.Entry<Integer, Course> entry:by_Course.entrySet()) {
			System.out.println("ID:"+entry.getKey()+",CourseName :"+entry.getValue().getCourseName());
		}
		
	}
	

}
