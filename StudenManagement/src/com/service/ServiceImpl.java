package com.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.entity.Course;
import com.entity.School;
import com.entity.Student;

public class ServiceImpl implements Services {
	
	

	@Override
	public void customLoader(School s) {
		
		Course Cse= new Course("CSE", 1);
		Course IT= new Course("IT", 2);
		
		Student s1=new Student("Naresh", IT, 80);
		Student s2=new Student("Vinoth", IT, 55);
		Student s3=new Student("ShanmugaPriyan", IT, 56);
		Student s4=new Student("RathiDevi", IT, 70);
		Student s5=new Student("Kansihka", IT, 70);
		
		Student c1=new Student("Swarna", Cse, 100);
		Student c2=new Student("Keerthana", Cse, 35);
		Student c3=new Student("Dharaneesh", Cse, 70);
		Student c4=new Student("Sundhar", Cse, 80);
		Student c5=new Student("Shanmugaraj", Cse, 75);
		
		s.putCourse(Cse);
		s.putCourse(IT);
		s.loadStudents();
		
		System.out.println(s.by_Course.size()+" Courses Added and "+s.by_School.size()+" Students added customly");
	}

	@Override
	public void DisplayCase3(Scanner sc,School sch) {
		System.out.println("1.ByName 2.ByGrade_Descending 3.ByCourse");
		int choice=sc.nextInt();
		switch(choice){
			case 1:
				List<Student> students=new ArrayList<>(sch.by_School);
				students.sort(Comparator.comparing(Student::getName));
				for(Student s:students) {
					System.out.println("Name:"+s.getName()+"\n Grade:"+s.getGrade()+" \n Course:"+s.getCourse().getCourseName());
					System.out.println();
					System.out.println("#######");
				}
				
				break;
			case 2:
				List<Student> students_byGrade=new ArrayList<>(sch.by_School);
				students_byGrade.sort(Comparator.comparing(Student::getGrade).reversed());
				for(Student s:students_byGrade) {
					System.out.println("Name:"+s.getName()+"\n Grade:"+s.getGrade()+" \n Course:"+s.getCourse().getCourseName());
					System.out.println();
					System.out.println("#######");
				}
				break;
			case 3:
				List<Student> students_byCourse=new ArrayList<>(sch.by_School);
				students_byCourse.sort(Comparator.comparing(Student::getCourseName));
				for(Student s:students_byCourse) {
//					String c=s.getCourseName();
					System.out.println("Name:"+s.getName()+"\n Grade:"+s.getGrade()+" \n Course:"+s.getCourse().getCourseName());
					System.out.println();
					System.out.println("#######");
				}
				break;
			default:
				break;
				
		}
		
	}
}
