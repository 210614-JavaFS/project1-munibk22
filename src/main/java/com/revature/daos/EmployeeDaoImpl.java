package com.revature.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.utils.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDAO {

	@Override
	public Employee findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateReimbursement(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Employee> findAll() {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM employees";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);

			List<Employee> empList = new ArrayList<>();

			while (result.next()) {
				Employee employee = new Employee();
				employee.setEmpId(result.getInt("emp_id"));
				employee.setFirstName(result.getString("first_name"));
				employee.setLastName(result.getString("lastName"));
				employee.setUserName(result.getString("user_name"));
				employee.setEmail(result.getString("email"));
				employee.setPassword(result.getString("password"));
				empList.add(employee);

			}
			return empList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
