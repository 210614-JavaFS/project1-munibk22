package com.revature.services;

import java.util.List;

import com.revature.daos.EmployeeDAO;
import com.revature.daos.EmployeeDaoImpl;
import com.revature.models.Employee;

public class EmployeeService {
	private static EmployeeDAO empDao = new EmployeeDaoImpl();

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
}
