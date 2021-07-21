package com.revature.models;

public abstract class Character {
	private String firstName;
	private String lastName;
	private String userName;
	private String passWord;
	private String address;
	private String email;
	private String confirmPass;
	private int requests;
//	private boolean reimbursement;
	private Reimbursement reimbursement;

	// No arg Constructor
	public Character() {
		super();
	}

	// Args Constructor
	public Character(String firstName, String lastName, String userName, String passWord, String address, int requests,
			boolean reimbursement) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.passWord = passWord;
		this.address = address;
		this.requests = requests;

	}

	// Getters N Setters
	public String getEmail() {
		return email;
	}

	public Reimbursement getReimbursement() {
		return reimbursement;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setReimbursement(Reimbursement reimbursement) {
		this.reimbursement = reimbursement;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public String getAddress() {
		return address;
	}

	public int getRequests() {
		return requests;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setRequests(int requests) {
		this.requests = requests;
	}

	// toString

	@Override
	public String toString() {
		return "Character [firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", passWord="
				+ passWord + ", address=" + address + ", requests=" + requests + ", reimbursement=" + reimbursement
				+ "]";
	}

	// hascode N equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((passWord == null) ? 0 : passWord.hashCode());
		result = prime * result + requests;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
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
		if (passWord == null) {
			if (other.passWord != null)
				return false;
		} else if (!passWord.equals(other.passWord))
			return false;
		if (reimbursement != other.reimbursement)
			return false;
		if (requests != other.requests)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	/**
	 * @return the confirmPass
	 */
	public String getConfirmPass() {
		return confirmPass;
	}

	/**
	 * @param confirmPass the confirmPass to set
	 */
	public void setConfirmPass(String confirmPass) {
		this.confirmPass = confirmPass;
	}

}
