package com.revature.daos;

import java.util.List;

import com.revature.models.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();

	public Employee findByName(String name);

	public Employee findByUserName(String userName);
	public boolean updateReimbursement(Employee employee);

	public boolean addEmployee(Employee employee);
	
	

}
