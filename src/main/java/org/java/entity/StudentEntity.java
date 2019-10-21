package org.java.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "STUDENTS")
@NamedQueries({ @NamedQuery(name = "StudentEntity.getStudentById", query = "select E from StudentEntity E where E.studentIdPK.branchId=:bId and E.studentIdPK.studentId=:sId") })
public class StudentEntity implements Serializable{

	/*
	 * @Id
	 * 
	 * @Column(name = "BRANCHID") private int branchId;
	 * 
	 * @Id
	 * 
	 * @Column(name = "STUDENTID") private int studentId;
	 */

	@EmbeddedId
	private StudentIdPK studentIdPK;
	
	@Column(name = "FIRSTNAME")
	private String firstName;
	
	@Column(name = "LASTNAME")
	private String lastName;
	
	@Column(name = "DOB")
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	public StudentIdPK getStudentIdPK() {
		return studentIdPK;
	}

	public void setStudentIdPK(StudentIdPK studentIdPK) {
		this.studentIdPK = studentIdPK;
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
}
