package org.java.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@DiscriminatorValue("Sales")
@NamedQueries(value = { @NamedQuery(name = "SalesDepartment.getDepartmentById", query = "select E from SalesDepartment E where E.xdepartmentId = ?") })
public class SalesDepartment extends XDepartment {

	private int monthlySales;
	public int getMonthlySales() {
		return monthlySales;
	}
	public void setMonthlySales(int monthlySales) {
		this.monthlySales = monthlySales;
	}
}
