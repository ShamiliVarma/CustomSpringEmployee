package org.java.config;

import org.java.controller.EmployeeController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmployeeTest {

	public static void main( String[] args ) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(CustomMVCConfig.class);
		EmployeeController empCon = ctx.getBean(EmployeeController.class);
		System.out.println(empCon.getEmployeeList());
	
	}
}
