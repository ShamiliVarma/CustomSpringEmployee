package org.java.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.java.dao.EmployeeDAO;
import org.java.entity.BankAccountEntity;
import org.java.entity.DepartmentEntity;
import org.java.entity.EmpAddressEntity;
import org.java.entity.EmployeeEntity;
import org.java.util.EmployeeUtil;
import org.java.bean.BankAccount;
import org.java.bean.Department;
import org.java.bean.Employee;
import org.java.bean.EmployeeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDAO empDAO;

	@Transactional
	public List<Employee> getEmployeeList(){

		List<EmployeeEntity> employees = empDAO.getAllEmployeesAndAddressfromDB();

		List<Employee> employeeList = new ArrayList<Employee>();
		for (EmployeeEntity emp : employees) {
			Employee employee = new Employee();
			employee.setEmpId(emp.getEmpId());
			employee.setFirstName(emp.getFirstName());
			employee.setLastName(emp.getLastName());

			EmployeeAddress employeeAddress = new EmployeeAddress();
			employeeAddress.setCounty(emp.getAddressEntity().getCounty());
			employeeAddress.setCity(emp.getAddressEntity().getCity());
			employeeAddress.setState(emp.getAddressEntity().getState());
			employee.setEmployeeAddress(employeeAddress);

			Set<BankAccountEntity> set = emp.getBankAccounts();
			Set<BankAccount> setBanks = new HashSet<BankAccount>();
			for(BankAccountEntity empBankAccEntity : set) {
				BankAccount empBankAccount = new BankAccount();
				empBankAccount.setId(empBankAccEntity.getId());
				empBankAccount.setAccNo(empBankAccEntity.getAccNo());
				empBankAccount.setBank(empBankAccEntity.getBank());
				empBankAccount.setBranch(empBankAccEntity.getBranch());
				setBanks.add(empBankAccount);
			}


			Set<DepartmentEntity> deptSet = emp.getDepartments();
			Set<Department> setDept = new HashSet<Department>();
			for(DepartmentEntity empDeptEntity : deptSet) {
				Department empDept = new Department();
				empDept.setId(empDeptEntity.getId());
				empDept.setDepartmentName(empDeptEntity.getDepartmentName());
				setDept.add(empDept);
			}

			employee.setDepartments(setDept);
			employee.setBankAccounts(setBanks);
			employeeList.add(employee);

			System.out.println(employee.toString());
		}
		return employeeList;
	}

	@Transactional
	public Employee getEmployee(int id) {

		EmployeeEntity emp =  empDAO.getEmployeebyIdfromDB(id);

		Employee employee = new Employee();
		employee.setEmpId(emp.getEmpId());
		employee.setFirstName(emp.getFirstName());
		employee.setLastName(emp.getLastName());

		EmployeeAddress employeeAddress = new EmployeeAddress();
		employeeAddress.setCounty(emp.getAddressEntity().getCounty());
		employeeAddress.setCity(emp.getAddressEntity().getCity());
		employeeAddress.setState(emp.getAddressEntity().getState());
		employee.setEmployeeAddress(employeeAddress);

		Set<BankAccountEntity> set = emp.getBankAccounts();
		Set<BankAccount> setBanks = new HashSet<BankAccount>();
		for(BankAccountEntity empBankAccEntity : set) {
			BankAccount empBankAccount = new BankAccount();
			empBankAccount.setId(empBankAccEntity.getId());
			empBankAccount.setAccNo(empBankAccEntity.getAccNo());
			empBankAccount.setBank(empBankAccEntity.getBank());
			empBankAccount.setBranch(empBankAccEntity.getBranch());
			setBanks.add(empBankAccount);
		}


		Set<DepartmentEntity> deptSet = emp.getDepartments();
		Set<Department> setDept = new HashSet<Department>();
		for(DepartmentEntity empDeptEntity : deptSet) {
			Department empDept = new Department();
			empDept.setId(empDeptEntity.getId());
			empDept.setDepartmentName(empDeptEntity.getDepartmentName());
			setDept.add(empDept);
		}

		employee.setDepartments(setDept);
		employee.setBankAccounts(setBanks);

		System.out.println(employee.toString());

		return employee;
	}

	@Transactional
	public int addEmployee(Employee emp) {

		System.out.println("In Employee Service :: addEmployee");
		EmployeeEntity empEntity = new EmployeeEntity();

		empEntity.setFirstName(emp.getFirstName());
		empEntity.setLastName(emp.getLastName());
		empEntity.setEmail(emp.getFirstName() + "@abc.com");

		if(emp.getEmployeeAddress()!=null) {

			EmpAddressEntity empAdd = new EmpAddressEntity();
			empAdd.setCity(emp.getEmployeeAddress().getCity());
			empAdd.setCounty(emp.getEmployeeAddress().getCounty());
			empAdd.setState(emp.getEmployeeAddress().getState());
			empAdd.setEmpEnitity(empEntity);
			empEntity.setAddressEntity(empAdd);
		}

		if(emp.getBankAccounts()!=null) {

			Set<BankAccount> set = emp.getBankAccounts();
			Set<BankAccountEntity> setBanks = new HashSet<BankAccountEntity>();
			for(BankAccount empBankAcc : set) {
				BankAccountEntity empBankAccount = new BankAccountEntity();
				empBankAccount.setAccNo(empBankAcc.getAccNo());
				empBankAccount.setBank(empBankAcc.getBank());
				empBankAccount.setBranch(empBankAcc.getBranch());
				empBankAccount.setEmpEnitity(empEntity);
				setBanks.add(empBankAccount);
			}
			empEntity.setBankAccounts(setBanks);

		}
		if(emp.getDepartments()!=null) {
			Set<Department> setD = emp.getDepartments();
			Set<DepartmentEntity> setDepts = new HashSet<DepartmentEntity>();
			for(Department empDept : setD) {
				DepartmentEntity deptEntity = new DepartmentEntity();
				deptEntity.setId(empDept.getId());
				deptEntity.setDepartmentName(empDept.getDepartmentName());
				setDepts.add(deptEntity);
			}

			empEntity.setDepartments(setDepts);
		}

		System.out.println("Calling insertEmployeesAndAddress method");
		return empDAO.insertEmployeesAndAddress(empEntity);
	}

	@Transactional
	public int editEmployee(Employee emp) {
		System.out.println("In EmployeeService :: editEmployee");
		EmployeeEntity empEntity = empDAO.getEmployeebyIdfromDB(emp.getEmpId());
		System.out.println("Got EmployeeEntity :: name : "+empEntity.getFirstName()+" "+empEntity.getLastName());
		empEntity.setFirstName(emp.getFirstName());
		empEntity.setLastName(emp.getLastName());
		empEntity.setEmail(emp.getFirstName() + "@abc.com");

		if(emp.getEmployeeAddress()!=null) {
			EmpAddressEntity empAdd =empEntity.getAddressEntity();
			empAdd.setCity(emp.getEmployeeAddress().getCity());
			empAdd.setCounty(emp.getEmployeeAddress().getCounty());
			empAdd.setState(emp.getEmployeeAddress().getState());
			empAdd.setEmpEnitity(empEntity);

			empEntity.setAddressEntity(empAdd);
		}

		//Add BankAccount for employee
		//Update Bank Account for employee
		//Delete Bank Account for employee
		//Add Department for employee
		//Delete Department for employee

		if(emp.getBankAccounts()!=null) {
			Set<BankAccount> set = emp.getBankAccounts(); 
			Set<BankAccountEntity> setBanks	= empEntity.getBankAccounts();
			//Map<Integer, BankAccount> bankMap = EmployeeUtil.bankAccountSetToMap(set);
			//Map<Integer,BankAccountEntity> bankEnitityMap = EmployeeUtil.bankEnititySetToMap(setBanks);


			if(set.size()>setBanks.size()) {
				for(BankAccount empBankAcc : set) {
					if(empBankAcc.getId()==0) {
						BankAccountEntity empBankAccount = new BankAccountEntity();
						empBankAccount.setAccNo(empBankAcc.getAccNo());
						empBankAccount.setBank(empBankAcc.getBank());
						empBankAccount.setBranch(empBankAcc.getBranch());
						empBankAccount.setEmpEnitity(empEntity);
						setBanks.add(empBankAccount);
					}
				}
			} /*
			 * else if(set.size()<setBanks.size()) { Map<Integer,BankAccountEntity>
			 * bankEnitityMap = EmployeeUtil.bankEnititySetToMap(setBanks); for(BankAccount
			 * empBankAcc : set) { if(empBankAcc.getId()==0) {
			 * 
			 * if(!bankEnitityMap.containsKey(empBankAcc.getId())) { BankAccountEntity
			 * empBankAccount = new BankAccountEntity();
			 * empBankAccount.setAccNo(empBankAcc.getAccNo());
			 * empBankAccount.setBank(empBankAcc.getBank());
			 * empBankAccount.setBranch(empBankAcc.getBranch());
			 * empBankAccount.setEmpEnitity(empEntity); setBanks.add(empBankAccount); } }
			 * 
			 * } }
			 */



			empEntity.setBankAccounts(setBanks);
		}

		if(emp.getDepartments()!=null) {
			Set<Department> setD = emp.getDepartments(); 
			Set<DepartmentEntity> setDepts = empEntity.getDepartments();

			if(setD.size()>setDepts.size()) {
				Map<Integer,DepartmentEntity> deptEnMap = EmployeeUtil.deptEntitySetToMap(setDepts);
				for(Department empDept : setD) {
					if(empDept.getId()==0 || !deptEnMap.containsKey(empDept.getId())) {
						DepartmentEntity deptEntity = new DepartmentEntity();
						deptEntity.setId(empDept.getId());
						deptEntity.setDepartmentName(empDept.getDepartmentName());
						setDepts.add(deptEntity);
					}
				}
			}else if(setD.size()<setDepts.size()) {
				Map<Integer, Department> deptMap = EmployeeUtil.departmentSetToMap(setD);
				for(DepartmentEntity empDeptEn : setDepts) {
					if( !deptMap.containsKey(empDeptEn.getId()) ) {
						setDepts.remove(empDeptEn);
						empDeptEn.setEmployees(null);
					}
				}
			}

			empEntity.setDepartments(setDepts);
		}
		return empDAO.changeEmpAndAddress(empEntity);
	}

	@Transactional
	public boolean deleteEmployee(Employee emp) {
		System.out.println("In EmployeeService :: deleteEmployee");
		EmployeeEntity empEntity = empDAO.getEmployeebyIdfromDB(emp.getEmpId());
		if (empEntity != null) {
			System.out.println("empEntity :: "+empEntity.getFirstName()+" "+empEntity.getLastName());
			empEntity.getDepartments().clear(); 
			empDAO.deleteEmployeesAndAddress(empEntity);
			return true;
		}else {
			return false;    	 
		}		
	}

	@Transactional
	public List<Employee> getEmployeesBySearch(String startsWith) {
		return empDAO.getEmployeesBySearch(startsWith);
	}

}
