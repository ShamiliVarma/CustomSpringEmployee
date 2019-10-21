package org.java.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Employees")
@NamedQueries(value = { @NamedQuery(name = "EmployeeEntity.getAllDetails", query = "select X from EmployeeEntity X"),
		 @NamedQuery(name = "EmployeeEntity.getDetailsById", query = "select X from EmployeeEntity X where X.empId=?")})
public class EmployeeEntity {

	@Id @GeneratedValue
	@Column(name = "id")
	private int empId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	
	@OneToOne(mappedBy = "empEnitity", cascade = CascadeType.ALL)
	private EmpAddressEntity addressEntity;
	
	@OneToMany(mappedBy = "empEnitity", cascade = CascadeType.ALL)
	private Set<BankAccountEntity> bankAccounts;
	
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "Employee_Department", joinColumns={@JoinColumn(name="empId")}, inverseJoinColumns = {@JoinColumn(name="departmentId")})
	private Set<DepartmentEntity> departments;
	
	
	public Set<DepartmentEntity> getDepartments() {
		return departments;
	}

	public void setDepartments(Set<DepartmentEntity> departments) {
		this.departments = departments;
	}

	public EmpAddressEntity getAddressEntity() {
		return addressEntity;
	}

	public void setAddressEntity(EmpAddressEntity addressEntity) {
		this.addressEntity = addressEntity;
	}

	public EmployeeEntity() {
		super();
	}
	
	public EmployeeEntity(int empId, String firstName, String lastName, String email) {
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/*
	 * public EmployeeAddress getEmployeeAddress() { return employeeAddress; }
	 * 
	 * public void setEmployeeAddress(EmployeeAddress employeeAddress) {
	 * this.employeeAddress = employeeAddress; }
	 */

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<BankAccountEntity> getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(Set<BankAccountEntity> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}
	
	
	
}
