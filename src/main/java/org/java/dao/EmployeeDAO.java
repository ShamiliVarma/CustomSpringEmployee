package org.java.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.java.bean.Employee;
import org.java.entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDAO {

	List<Employee> emplist = new ArrayList<Employee>();
	Map<Integer, Employee> empMap = new HashMap<Integer, Employee>();

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<EmployeeEntity> getAllEmployeesAndAddressfromDB() {
		Session session = sessionFactory.getCurrentSession();
		return (List<EmployeeEntity>) session.getNamedQuery("EmployeeEntity.getAllDetails").list();
	}

	public EmployeeEntity getEmployeebyIdfromDB(int id) {
		Session session = sessionFactory.getCurrentSession();
		//return (EmployeeEntity) session.get(EmployeeEntity.class, id);
		
		return (EmployeeEntity) session.getNamedQuery("EmployeeEntity.getDetailsById").setParameter(0, id).list().get(0);
	}

	public int insertEmployeesAndAddress(EmployeeEntity empEntity) {
		System.out.println("In EmployeeDAO :: insertEmployeesAndAddress");
		Session session = sessionFactory.getCurrentSession();
		return (Integer) session.save(empEntity);
	}

	public int changeEmpAndAddress(EmployeeEntity empEntity) {
		System.out.println("In EmployeeDAO :: changeEmpAndAddress");
		Session session = sessionFactory.getCurrentSession();
		session.update(empEntity);
		return empEntity.getEmpId();
	}

	public void deleteEmployeesAndAddress(EmployeeEntity empEntity) {
		System.out.println("In EmployeeDAO :: deleteEmployeesAndAddress");
		Session session = sessionFactory.getCurrentSession();
		session.delete(empEntity);
	}

	public List<Employee> getEmployeesBySearch(String startsWith) {
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(EmployeeEntity.class);
		// Criteria : First Name starts with "" AND emp Id <=1003

		criteria.add(Restrictions.ilike("firstName", startsWith + "%"));
		criteria.add(Restrictions.le("empId", 1005));

		// Criteria : First Name Starts with between A and ""
		// criteria.add(Restrictions.between("firstName", "A", startsWith));

		// Criteria : First Name starts with "" OR emp Id <=1003
		// criteria.add(Restrictions.or(Restrictions.ilike("firstName", startsWith+"%"),
		// Restrictions.le("empId", 1003)));

		// Criteria Order desc
		criteria.addOrder(Order.asc("firstName"));

		// Add Projections for getting unique first name - It just gives Count
		// criteria.setProjection(Projections.countDistinct("firstName"));
		List<EmployeeEntity> employees = criteria.list();

		List<Employee> employeeList = new ArrayList<Employee>();
		for (EmployeeEntity emp : employees) {
			Employee employee = new Employee();
			employee.setEmpId(emp.getEmpId());
			employee.setFirstName(emp.getFirstName());
			employee.setLastName(emp.getLastName());
			employeeList.add(employee);
		}
		return employeeList;
	}
}
