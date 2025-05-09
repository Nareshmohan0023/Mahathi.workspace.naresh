package com.entity;

import java.util.List;

public class Services {
	
	public Questions_collection QuestionLoader() {
		
		Questions_collection qs=new Questions_collection();
		Question q1 = new Question(1, "Which concept allows objects to take many forms in Java?",
				new String[] { "Inheritance", "Encapsulation", "Polymorphism", "Abstraction" }, 'c');

		Question q2 = new Question(2, "Which keyword is used to inherit a class in Java?",
				new String[] { "implements", "extends", "super", "this" }, 'b');

		Question q3 = new Question(3, "Which block is always executed in exception handling?",
				new String[] { "try", "catch", "finally", "throw" }, 'c');

		Question q4 = new Question(4, "What is the parent class of all exceptions in Java?",
				new String[] { "Throwable", "Exception", "RuntimeException", "Error" }, 'a');

		Question q5 = new Question(5, "Which of the following is not a principle of OOP?",
				new String[] { "Polymorphism", "Compilation", "Abstraction", "Inheritance" }, 'b');

		Question q6 = new Question(1, "2+2?", new String[] { "1", "2", "3", "4" }, 'd');
		qs.addIntoCollection(q1);
		qs.addIntoCollection(q2);
		qs.addIntoCollection(q3);
		qs.addIntoCollection(q4);
		qs.addIntoCollection(q5);
		qs.addIntoCollection(q6);
		return qs;
		
	}

}
