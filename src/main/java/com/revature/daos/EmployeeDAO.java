package com.revature.daos;

import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Reimbursement;

public interface EmployeeDAO {

	public List<Employee> findAll();

	public Employee findByName(String name);

	public boolean updateReimbursement(Employee employee);

	public boolean addEmployee(Employee employee);

}
