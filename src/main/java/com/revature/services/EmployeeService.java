package com.revature.services;

import java.util.List;

import com.revature.daos.EmployeeDAO;
import com.revature.daos.EmployeeDaoImpl;
import com.revature.models.Employee;

public class EmployeeService {
	private static EmployeeDAO empDao = new EmployeeDaoImpl();

	public List<Employee> getAllEmployees() {

		return (empDao.findAll());
	};
}
