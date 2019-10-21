package org.java.bean;

import java.util.Date;

public class Student{

	private String branchId;
	private int studentId;

	private String firstName;

	private String lastName;
	
	private Date dob;

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Student [branchId=" + branchId + ", studentId=" + studentId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", dob=" + dob + "]";
	}
	
	
}
