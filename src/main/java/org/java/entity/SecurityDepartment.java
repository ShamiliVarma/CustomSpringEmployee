package org.java.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
@DiscriminatorValue("Security")
public class SecurityDepartment extends XDepartment{
	
	private int securityBreechCount;

	public int getSecurityBreechCount() {
		return securityBreechCount;
	}

	public void setSecurityBreechCount(int securityBreechCount) {
		this.securityBreechCount = securityBreechCount;
	}

}
