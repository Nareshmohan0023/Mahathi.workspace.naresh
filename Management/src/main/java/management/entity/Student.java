package management.entity;

import java.sql.Date;

public class Student {
	private int studentId;
	private String name;
	private Date DOB;
	private int addId;
	
	

	public Student( String name, Date dOB, int addId) {
		super();
//		this.studentId = studentId;
		this.name = name;
		DOB = dOB;
		this.addId = addId;
	}

	public Student(String name2, Date dOB2) {
		// TODO Auto-generated constructor stub
		this.name = name2;
		DOB = dOB2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public int getAddId() {
		return addId;
	}

	public void setAddId(int addId) {
		this.addId = addId;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", DOB=" + DOB + ", addId=" + addId + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
