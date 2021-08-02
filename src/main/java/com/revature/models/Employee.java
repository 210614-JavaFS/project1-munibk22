package com.revature.models;

public class Employee extends Character {

	private static int empId;
	private  int empId3;
	

	
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

	/**
	 * @return the empId3
	 */
	public int getEmpId3() {
		return empId3;
	}

	/**
	 * @param empId3 the empId3 to set
	 */
	public void setEmpId3(int empId3) {
		this.empId3 = empId3;
	}
	
	
	
	



}
