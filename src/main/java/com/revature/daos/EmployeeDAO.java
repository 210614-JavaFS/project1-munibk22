package com.revature.daos;

import java.util.List;

import com.revature.models.Employee;
import com.revature.models.ReimbursementType;

public interface EmployeeDAO {

	public List<Employee> findAll();

	public Employee findByName(String name);

	public Employee findByUserName(String userName);

	public boolean updateReimbursement(Employee employee);

	public boolean addEmployee(Employee employee);

	public boolean addTicket(String amountScan, ReimbursementType reimbursementType);

}
