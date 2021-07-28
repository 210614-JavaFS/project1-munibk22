package com.revature.models;

public class Employee extends Character {
//	int empId;
//	private String firstName;
//	private String lastName;
//	private String userName;
//	private String email;
	

	public Employee(int empId, String firstName, String lastName, String userName, String email) {
		super();
			
	}

	public Employee() {
		super();
	}

	

	@Override
	public String toString() {
		return "Employee [getEmpId()=" + getEmpId() + ", getEmail()=" + getEmail() + ", getFirstName()="
				+ getFirstName() + ", getLastName()=" + getLastName() + ", getUserName()=" + getUserName()
				+ ", getpassword()=" + getPassword() + "]";
	}
	
	

//	public int getEmpId() {
//		return empId;
//	}

//	public String getFirstName() {
//		return firstName;
//	}

//	public String getLastName() {
//		return lastName;
//	}
//
//	public String getUserName() {
//		return userName;
//	}
//
//	public String getEmail() {
//		return email;
//	}

	

//	public void setEmpId(int empId) {
//		this.empId = empId;
//	}

//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}

//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}

	


//	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = super.hashCode();
//		result = prime * result + ((email == null) ? 0 : email.hashCode());
//		result = prime * result + empId;
//		result = prime * result + ((this.getFirstName() == null) ? 0 : this.getFirstName().hashCode());
//		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
//		
//		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (!super.equals(obj))
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Employee other = (Employee) obj;
//		if (email == null) {
//			if (other.email != null)
//				return false;
//		} else if (!email.equals(other.email))
//			return false;
//		if (empId != other.empId)
//			return false;
//		if (this.getFirstName() == null) {
//			if (other.getFirstName() != null)
//				return false;
//		} else if (!this.getFirstName().equals(other.getFirstName()))
//			return false;
//		if (lastName == null) {
//			if (other.lastName != null)
//				return false;
//		} else if (!lastName.equals(other.lastName))
//			return false;
//	
//		if (userName == null) {
//			if (other.userName != null)
//				return false;
//		} else if (!userName.equals(other.userName))
//			return false;
//		return true;
//	}

}
