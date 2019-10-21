package org.java.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class StudentIdPK implements Serializable {

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

	@Column(name = "BRANCHID")
	private String branchId;
	@Column(name = "STUDENTID")
	private int studentId;
	
	public StudentIdPK() {}
	
	public StudentIdPK(String branchId,int studentId) {
		this.branchId=branchId;
		this.studentId=studentId;
	}
	
	
}
