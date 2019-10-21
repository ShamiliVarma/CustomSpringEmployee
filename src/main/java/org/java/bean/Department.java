package org.java.bean;

public class Department {

	
	private int id;
	
	private String departmentName;
	
	private String departmentType;
	
	private int monthlySales;
	
	private int securityBreech;

	

	public int getMonthlySales() {
		return monthlySales;
	}

	public void setMonthlySales(int monthlySales) {
		this.monthlySales = monthlySales;
	}

	public int getSecurityBreech() {
		return securityBreech;
	}

	public void setSecurityBreech(int securityBreech) {
		this.securityBreech = securityBreech;
	}

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

	public String getDepartmentType() {
		return departmentType;
	}

	public void setDepartmentType(String departmentType) {
		this.departmentType = departmentType;
	}
	
}
