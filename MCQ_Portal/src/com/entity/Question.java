package com.entity;

public class Question {
	private int id;
	private String question;
	private String[] options;
	private char answer;
	
	public Question(int id, String question, String[] options, char answer) {
		super();
		this.id = id;
		this.question = question;
		this.options = options;
		this.answer = answer;
	}
	
	public boolean isCorrect(char ch) {
		if(ch==this.answer){
			return true;
		}return false;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String[] getOptions() {
		return options;
	}

	public void setOptions(String[] options) {
		this.options = options;
	}

	public char getAnswer() {
		return answer;
	}

	public void setAnswer(char answer) {
		this.answer = answer;
	}
	
	
	
	
	
	
	
	

}
