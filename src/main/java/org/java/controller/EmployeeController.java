package org.java.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.java.bean.Employee;
import org.java.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@Autowired
	HttpServletRequest httpServlet;
	
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public List<Employee> getEmployeeList(){
		System.out.println("In EmployeeController :: getEmployeeList");
		System.out.println("Session :: "+httpServlet.getSession().getAttribute("user"));
		return empService.getEmployeeList();
	}
	
	@RequestMapping(value = "/employees/{id}", method = RequestMethod.GET )
	public Employee getEmployee(@PathVariable int id){
		System.out.println("In EmployeeController :: getEmployee");
		System.out.println("Session :: "+httpServlet.getSession().getAttribute("user"));
		/*
		 * System.out.println("getHeaderNames "+httpServlet.getHeaderNames().toString())
		 * ; System.out.println("getContextPath "+httpServlet.getContextPath());
		 * System.out.println("getHeader "+httpServlet.getHeader("userName"));
		 * System.out.println("getIntHeader "+httpServlet.getIntHeader("UserKey"));
		 * System.out.println("getMethod "+httpServlet.getMethod());
		 * System.out.println("getPathlnfo "+httpServlet.getPathInfo());
		 * System.out.println("getpathTranslated "+httpServlet.getPathTranslated());
		 * System.out.println("getQueryString "+httpServlet.getQueryString());
		 * System.out.println("getRequestedSessionld "+httpServlet.getRequestedSessionId
		 * ()); System.out.println("getRequestURI "+httpServlet.getRequestURI());
		 * System.out.println("getRequestURL "+httpServlet.getRequestURL());
		 * System.out.println("getServletpath "+httpServlet.getServletPath());
		 * System.out.println("isRequestedSessionldFromCookie "+httpServlet.
		 * isRequestedSessionIdFromCookie());
		 * System.out.println("isRequestedSessionldValid "+httpServlet.
		 * isRequestedSessionIdValid());
		 */
		return empService.getEmployee(id);
	}
	
	@RequestMapping(value = "/employeeSearch/{startsWith}", method = RequestMethod.GET)
	public List<Employee> getEmployeesBySearch(@PathVariable String startsWith){
		System.out.println("In EmployeeController :: getEmployeeList");
		return empService.getEmployeesBySearch(startsWith);
	}
	
	@RequestMapping(value = "/employees", method = RequestMethod.POST)
	public int addEmployee(@RequestBody Employee emp){
		System.out.println("In EmployeeController :: addEmployee");
		return empService.addEmployee(emp);
	}
	
	@RequestMapping(value = "/employees", method = RequestMethod.PUT)
	public int editEmployee(@RequestBody Employee emp){
		System.out.println("In EmployeeController :: editEmployee");
		return empService.editEmployee(emp);
	}
	
	@RequestMapping(value = "/employees", method = RequestMethod.DELETE)
	public boolean deleteEmployee(@RequestBody Employee emp){
		System.out.println("In EmployeeController :: deleteEmployee");
		return empService.deleteEmployee(emp);
	}

}
