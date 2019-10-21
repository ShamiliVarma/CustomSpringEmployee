package org.java.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="EmployeeAddress")
public class EmpAddressEntity {

	
	@Id @GeneratedValue
	@Column(name="id")
	private int id;
	
	@OneToOne
	@JoinColumn(name = "empid", referencedColumnName = "id")
	private EmployeeEntity empEnitity;
	
	public EmployeeEntity getEmpEnitity() {
		return empEnitity;
	}
	public void setEmpEnitity(EmployeeEntity empEnitity) {
		this.empEnitity = empEnitity;
	}
	@Column(name="county")
	private String county;
	@Column(name="city")
	private String city;
	@Column(name="state")
	private String state;
	
	
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
