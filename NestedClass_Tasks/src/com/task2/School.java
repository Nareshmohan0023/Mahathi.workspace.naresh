package com.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class School {
	private static int Total;
	List<Student> students=new ArrayList<>();

	public School() {
		super();
	}

	public static int getTotal() {
		return Total;
	}

	public static void setTotal(int total) {
		Total = total;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public class Student {

		private String Name;

		public Student(String name) {
			super();
			Name = name;
			Total++;
			System.out.println("Student added sucessfully!");
			System.out.println("The number of students in the schhol are: "+Total);
			students.add(this);
			System.out.println("The size of the students list is:"+students.size());
			
		}

		public String getName() {
			return Name;
		}

		public void setName(String name) {
			Name = name;
		}
		
		

	}
	
	public static void main(String[] args) {
		char exit='y';
		
		School school=new School();
		Scanner sc=new Scanner(System.in);
		System.out.println("Hi,Need To add the student into the school?");
		do {
			System.out.println("Enter the Name of the Student:");
			String Name =sc.next();
			school.new Student(Name);
			
			System.out.println("Do you want to continue:'y' or 'n'");
			exit=sc.next().charAt(0);
			
		}while(exit=='y');
		
	}

}
