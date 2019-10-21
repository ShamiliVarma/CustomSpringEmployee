package org.java.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="BankAccount")
public class BankAccountEntity {
	
	@Id @GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="accNo")
	private String accNo;
	@Column(name="bankName")
	private String bank;
	@Column(name="branch")
	private String branch;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "empid", referencedColumnName = "id")
	private EmployeeEntity empEnitity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public EmployeeEntity getEmpEnitity() {
		return empEnitity;
	}

	public void setEmpEnitity(EmployeeEntity empEnitity) {
		this.empEnitity = empEnitity;
	}
	

}
