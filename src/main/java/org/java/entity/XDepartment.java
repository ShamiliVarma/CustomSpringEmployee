package org.java.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@DiscriminatorColumn(name = "xdepartmentType")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries(value = { @NamedQuery(name = "XDepartment.getDepartmentById", query = "select E from XDepartment E where E.xdepartmentId = ?") })
public class XDepartment {

	
	@Id @GeneratedValue
	private int xdepartmentId;
	
	private String xdepartmentName;
	private String xdepartmentType;
	
	public int getXdepartmentId() {
		return xdepartmentId;
	}
	public void setXdepartmentId(int xdepartmentId) {
		this.xdepartmentId = xdepartmentId;
	}
	public String getXdepartmentName() {
		return xdepartmentName;
	}
	public void setXdepartmentName(String xdepartmentName) {
		this.xdepartmentName = xdepartmentName;
	}
	public String getXdepartmentType() {
		return xdepartmentType;
	}
	public void setXdepartmentType(String xdepartmentType) {
		this.xdepartmentType = xdepartmentType;
	}

}
