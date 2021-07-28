package com.revature.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.daos.EmployeeDAO;
import com.revature.daos.EmployeeDaoImpl;
import com.revature.models.Employee;
import com.revature.models.ImageTest;
import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementType;

public class EmployeeService {
	private static EmployeeDAO empDao = new EmployeeDaoImpl();
//	private static Employee employee = new Employee();

	public List<Employee> getAllEmployees() {

		return empDao.findAll();
	};

	public Employee getByName(String name) {
		return empDao.findByName(name);
	}

	public boolean addEmployee(Employee employee) {
		return empDao.addEmployee(employee);
	}

	public Employee getByUserName(String userName) {
		return empDao.findByUserName(userName);
	}

//	public boolean createNewTicket(String amountScan, ReimbursementType reimbursementType) {
//		Reimbursement reimbursement = new Reimbursement();
//		reimbursement.setType(reimbursementType);
//		switch (reimbursementType) {
//		case LODGING:
//
//			break;
//		case TRAVEL:
//
//			break;
//		case FOOD:
//
//			break;
//		case OTHER:
//
//			break;
//		default:
//			break;
//
//		}
//		return true;
//
//	}

//	public boolean login(HttpServletResponse response) {
//		return empDao.findByName(response));
//		Employee employee2 = new Employee();
//		&& employee.getConfirmPass().equals(password)
//		System.out.println(username);
//		employee2 = this.getByUserName(username);
//		employee2.setUserName(username);
//		System.out.println(employee.getFirstName());
//		System.out.println(employee);
//		if (password.equals("a") && employee2.getUserName().equals(username)) {
//			return true;
//		}
//		return false;
//	}

	public boolean login2(String username, String password) {
		if (username.equals("Mike") && password.equals("password")) {
			return true;
		}
		return false;
	}

	public Employee login(String username, String password) {
	
		return empDao.findByName(username);
	}

	public boolean addTicket(Reimbursement reimbursement) {
		return empDao.addTicket(reimbursement);
		
	}

	public boolean addImage(ImageTest image) {
		return empDao.insertImage(image);
		}

	public List<Reimbursement> getAllReimbursements() {
		return empDao.findAllReimbursements();
		
	}
}
