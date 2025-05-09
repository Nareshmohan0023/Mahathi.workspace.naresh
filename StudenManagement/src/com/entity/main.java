package com.entity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.service.ServiceImpl;
import com.service.Services;

public class main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char exit = 'y';
		Services serv = new ServiceImpl();

		School sch = new School();
		serv.customLoader(sch);

		do {
			System.out.println("1.AddCourse  2.AddStudent 3.DisplayStudent 4.TopScorers 5.Failed_By_Course  6.Display_StudentsBy_Course  7.SarchByName");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter the Name Of the course:");
				String Name=sc.next();
				sch.putCourse(new Course(Name, sch.by_Course.size()+1));
				System.out.println("Course Added Successfully");
				break;

			case 2:
				System.out.println("Select the Department By Id As displayed to add Student");
				sch.DisplayCourses();
				int id=sc.nextInt();
				Course fetchCourse=sch.CourseById(id);
				if(fetchCourse==null) {
					System.out.println("Department not found");
					break;
				}
				System.out.println("Enter The Name:");
				String stdName=sc.next();
				System.out.println("Enter The grade below as or within 100");
				int grade=sc.nextInt();
				if(grade>100&&grade<0) {
					System.out.println("Inavlid Mark");
					break;
				}
				fetchCourse.addIntoCourse(new Student(stdName, fetchCourse, grade));
				System.out.println("Student Added sucessfully");
				
				
				break;

			case 3:
				sch.loadStudents();
				serv.DisplayCase3(sc,sch);
				
				break;
			case 4:
				System.out.println("The Top Scorers are:");
				for(Map.Entry<Integer,Course> e :sch.getBy_Course().entrySet()) {
					System.out.println("The Top scorer of"+e.getValue().getCourseName());
					int max=0;
					Student std=null;
					for(Student s:e.getValue().List_Students) {
						if(s.getGrade()>max) {
							max=s.getGrade();
							std=s;
						}
						
					}
					System.out.println(std.getName()+" Scorde Maximum marks of "+std.getGrade());
					System.out.println();
					System.out.println("*******************************");
				}
				break;
			case 5:
				System.out.println("Failed_By_Course students are");
				System.out.println("---------------------------------");

				for(Map.Entry<Integer,Course> e :sch.getBy_Course().entrySet()) {
					System.out.println("The Failed member of "+e.getValue().getCourseName()+"are:");
					System.out.println();
	
					for(Student s:e.getValue().List_Students) {
						if(s.getGrade()<65) {
							System.out.println(s.getName()+" Scorde marks of "+s.getGrade());
						}
						
					}
					
					System.out.println();
					System.out.println("*******************************");
				}
				break;
				
			case 6:
				System.out.println("Select the Department By Id As displayed to fetch students in the course");
				sch.DisplayCourses();
				int Courseid=sc.nextInt();
				Course fetchCourse_st=sch.CourseById(Courseid);
				if(fetchCourse_st==null) {
					System.out.println("Department not found");
					break;
				}
				for(Student st:fetchCourse_st.List_Students) {
					System.out.println("Name:"+st.getName()+"\n Grade:"+st.getGrade()+"\n Course:"+st.getCourseName());
					System.out.println("******");
				}
				break;
				
			case 7:
				List<Student> students=new ArrayList<>(sch.by_School);
				students.sort(Comparator.comparing(Student::getName));
				System.out.println("Enter the Name To Search:");
				String Name_St=sc.next();
				Student stu=null;
				for(Student s:students) {
					if(s.getName().equals(Name_St)) {
						stu=s;
						System.out.println("Name:"+s.getName()+"\n Grade:"+s.getGrade()+"\n Course:"+s.getCourseName());
						break;
					}
					
				}
				if(stu==null) {
					System.out.println("Student not found");
				}
				break;
			
			default:
				System.out.println("Inavalid choice ");
				break;
			}

			System.out.println("Do you Wnat To Continue:'y' or 'n'");
			exit = sc.next().charAt(0);

		} while (exit == 'y');

	}

}
