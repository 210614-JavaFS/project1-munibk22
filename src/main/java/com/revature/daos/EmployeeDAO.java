package com.revature.daos;

import java.util.List;

import com.revature.models.Employee;
import com.revature.models.ImageTest;
import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementType;

public interface EmployeeDAO {

	public List<Employee> findAll();

	public Employee findByName(String name);

	public Employee findByUserName(String userName);

	public boolean updateReimbursement(Employee employee);

	public boolean addEmployee(Employee employee);

	public boolean addTicket(Reimbursement reimbursement);

	public boolean login();

	boolean insertImage(ImageTest image);

	public List<Reimbursement> findAllReimbursements();

}
