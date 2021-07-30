package com.revature.models;

public class Employee extends Character {

//	private String firstName;
//	private String lastName;
//	private String userName;
//	private String email;
	public static int empId;
	

	
	public Employee(int empId, String firstName, String lastName, String userName, String email) {
		super();
		Employee.empId =empId;
	}

	public Employee() {
		super();	}
	
	
	public Employee(int empId) {
		super();
		Employee.empId = empId;
	}
	
	

	public int getEmpId2() {
		return empId;
	}

	
	public void setEmpId(int empId) {
		Employee.empId = empId;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", getEmpId2()=" + getEmpId2() + ", getUserName()=" + getUserName()
				+ ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName() + ", getEmail()="
				+ getEmail() + ", getUserRoleId()=" + getUserRoleId() + ", getPassword()=" + getPassword()				
				+ "]";
	}
	
	
	
	



}
