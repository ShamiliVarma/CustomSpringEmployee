package org.java.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table( name = "Department")
public class DepartmentEntity {

	
	@Id @GeneratedValue
	@Column(name="departmentId")
	private int id;
	
	@Column(name="departmentName")
	private String departmentName;

	@ManyToMany(mappedBy = "departments", fetch = FetchType.LAZY)
	private Set<EmployeeEntity> employees;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Set<EmployeeEntity> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<EmployeeEntity> employees) {
		this.employees = employees;
	}
}
