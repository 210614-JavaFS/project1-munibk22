package com.revature.utils;

import org.mindrot.jbcrypt.BCrypt;

public class Bcrypt {
	private String password;
	protected String userName;
	private String hashedPw = BCrypt.hashpw(password, BCrypt.gensalt());

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
		this.password = password;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setHashedPw(String hashedPw) {
		this.hashedPw = hashedPw;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hashedPw == null) ? 0 : hashedPw.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		Bcrypt other = (Bcrypt) obj;
		if (hashedPw == null) {
			if (other.hashedPw != null)
				return false;
		} else if (!hashedPw.equals(other.hashedPw))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bcrypt [password=" + password + ", userName=" + userName + ", hashedPw=" + hashedPw + "]";
	}
	
	public String getPassword() {
		return password;
	}

	public String getUserName() {
		return userName;
	}

	
}
