package com.entity;

import java.util.List;
import java.util.Scanner;

public class Application {
	
	
	public static int marks=0;
	public static int Warning=0;
	public static boolean con=true;
	public static char option='a';

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		Questions_collection qs=new Questions_collection();
		List<Question> questions=new Services().QuestionLoader().getCollection();
		System.out.println("Welcome To Quiz App");
		for(Question q:questions) {
			System.out.println(q.getQuestion());
			for(String opt:q.getOptions()) {
				System.out.println(opt);
				
			}
			while(con) {
				con=true;
				System.out.println("Enter the option as 'a' or 'b' or 'c' or 'd':");
				option=sc.next().charAt(0);
				if(!(option=='a'||option=='b'||option=='c'||option=='d')) {
					Warning++;
					System.err.println("Invalid input");
					System.out.println("Warning no "+Warning+" if it exceeds exam will close automatically");
					if(Warning>=3) {
						System.out.println("Exam submited automatically");
						System.exit(0);
					}
				}else {
					con=false;
				}
				
			}
			con=true;
			
			if(q.isCorrect(option)) {
				marks++;
			}
			System.out.println("#########################");
		}
		System.out.println("You scored:"+marks+" out of "+questions.size());
		
		
		
		
		
	}

}
