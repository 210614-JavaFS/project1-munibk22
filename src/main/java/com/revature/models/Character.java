package com.revature.models;

import org.mindrot.jbcrypt.BCrypt;


public abstract class Character {

//	public  int empId;
	private String userName;
	private String firstName;
	private String lastName;
	private String email;
	private int userRoleId;
	private String userRole;
	private Reimbursement reimbursement;

//	private String timeStamp;

	private String password;
	private String hashedPw= BCrypt.hashpw(password, BCrypt.gensalt()) ;

	// No arg Constructor
	public Character() {
		super();
	}

	// Args Constructor
	public Character(String userName, String firstName, String lastName, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;

	}

//	public int getEmpId() {
//		return empId;
//	}
	public boolean checkPw(String pw) {
		if(BCrypt.checkpw(pw, hashedPw)) {
			System.out.println("password match");
			return true;
		}else {
			System.out.println("password does not match");
			return false;
		}
		
	}

	
	public String getHashedPw() {
		return hashedPw;
	}

	public void setPassword(String password) {
		this.password = BCrypt.hashpw(password, BCrypt.gensalt());
	}

	

	public void setHashedPw(String hashedPw) {
		this.hashedPw = hashedPw;
	}
	
	public String getUserName() {
		return userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public int getUserRoleId() {
		return userRoleId;
	}

	public String getPassword() {
		return password;
	}

//	public String getPassConfirm() {
//		return passConfirm;
//	}

//	public void setEmpId(int empId) {
//		this.empId = empId;
//	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

//	public void setPassword(String password) {
//		this.password = password;
//	}

//	public void setPassConfirm(String passConfirm) {
//		this.passConfirm = passConfirm;
//	}

	@Override
	public String toString() {
		return "Character [ userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", userRoleId=" + userRoleId + userRole + ", password=" + password +hashedPw+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((reimbursement == null) ? 0 : reimbursement.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userRole == null) ? 0 : userRole.hashCode());
		result = prime * result + userRoleId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Character other = (Character) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (reimbursement == null) {
			if (other.reimbursement != null)
				return false;
		} else if (!reimbursement.equals(other.reimbursement))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userRole == null) {
			if (other.userRole != null)
				return false;
		} else if (!userRole.equals(other.userRole))
			return false;
		if (userRoleId != other.userRoleId)
			return false;
		return true;
	}

	/**
	 * @return the userRole
	 */
	public String getUserRole() {
		return userRole;
	}

	/**
	 * @param userRole the userRole to set
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	// Getters N Setters

}
