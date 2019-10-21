package org.java.dao;

import java.util.List;

import org.java.entity.FullTimeStudent;
import org.java.entity.PartTimeStudent;
import org.java.entity.SalesDepartment;
import org.java.entity.SecurityDepartment;
import org.java.entity.StudentEntity;
import org.java.entity.StudentIdPK;
import org.java.entity.XDepartment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<StudentEntity> getStudents() {
		System.out.println("In StudentDAO :: getStudents");
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM StudentEntity").list();
	}
	
	public StudentEntity getStudentById(StudentIdPK id) {
		System.out.println("In StudentDAO :: getStudentById");
		Session session = sessionFactory.getCurrentSession();
		//return (StudentEntity) session.get(StudentEntity.class, id);
		return (StudentEntity) session.getNamedQuery("StudentEntity.getStudentById").setParameter("bId", id.getBranchId()).setParameter("sId", id.getStudentId()).list().get(0);
		//Expected positional parameter count: 1, actual parameters: [org.java.entity.StudentIdPK@61429ba5] [select E from StudentEntity E where E.studentIdPK=?]
		
	}
	
	public String insertStudent(StudentEntity stu) {
		System.out.println("In StudentDAO :: insertStudent");
		Session session = sessionFactory.getCurrentSession();
		session.save(stu);
		return "Success";
	}
	
	public String updateStudent(StudentEntity stu) {
		System.out.println("In StudentDAO :: updateStudent");
		Session session = sessionFactory.getCurrentSession();
		session.update(stu);
		return "Success";
	}
	
	public String deleteStudent(StudentEntity stu) {
		System.out.println("In StudentDAO :: deleteStudent");
		Session session = sessionFactory.getCurrentSession();
		session.delete(stu);
		return "Success";		
	}
	
	
	//College Student 
	
	public List<FullTimeStudent> getAllFTCollegeStudents(){
		System.out.println("In StudentDAO :: getAllFTCollegeStudents ");
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("From FullTimeStudent").list();
	}
	public List<PartTimeStudent> getAllPTCollegeStudents(){
		System.out.println("In StudentDAO :: getAllPTCollegeStudents ");
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("From PartTimeStudent").list();
	}
	
	//XDepartment
	
	public List<SalesDepartment> getSalesDept(){
		System.out.println("In StudentDAO :: getSalesDept ");
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("From SalesDepartment").list();
	}
	public List<SecurityDepartment> getSecurityDept(){
		System.out.println("In StudentDAO :: getSecurityDept ");
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("From SecurityDepartment").list();
	}

	public String insertSecDept(SecurityDepartment sd) {
		System.out.println("In StudentDAO :: insertSecDept ");
		Session session = sessionFactory.getCurrentSession();
		session.save(sd);
		return "Success";
	}
	public String insertSalesDept(SalesDepartment sd) {
		System.out.println("In StudentDAO :: insertSalesDept ");
		Session session = sessionFactory.getCurrentSession();
		session.save(sd);
		return "Success";
	}

	public XDepartment getXDeptById(int id) {
		System.out.println("In StudentDAO :: getXDeptById");
		Session session = sessionFactory.getCurrentSession();
		return (XDepartment) session.get(XDepartment.class, id);
		//return (XDepartment) session.getNamedQuery("XDepartment.getDepartmentById").setParameter(0, id).list().get(0);
	}

	public SalesDepartment getSalesDeptById(int id) {
		System.out.println("In StudentDAO :: getSalesDeptById");
		Session session = sessionFactory.getCurrentSession();
		return (SalesDepartment) session.get(SalesDepartment.class, id);
		//return (SalesDepartment) session.getNamedQuery("SalesDepartment.getDepartmentById").setParameter(0, id).list().get(0);
	}

	public SecurityDepartment getSecDeptById(int id) {
		System.out.println("In StudentDAO :: getSecDeptById");
		Session session = sessionFactory.getCurrentSession();
		return (SecurityDepartment) session.get(SecurityDepartment.class, id);
	}

	public String updateSalesDept(SalesDepartment sd) {
		System.out.println("In StudentDAO :: updateSalesDept ");
		Session session = sessionFactory.getCurrentSession();
		session.update(sd);
		return "Success";
	}

	public String updateSecDept(SecurityDepartment sd) {
		System.out.println("In StudentDAO :: updateSecDept ");
		Session session = sessionFactory.getCurrentSession();
		session.update(sd);
		return "Success";
	}

	public String deleteXDept(XDepartment xd) {
		System.out.println("In StudentDAO :: deleteXDept ");
		Session session = sessionFactory.getCurrentSession();
		session.delete(xd);
		return "Success";
	}
}
