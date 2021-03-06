package com.revature.models;

import java.awt.image.BufferedImage;

import java.util.Arrays;

public class Reimbursement {
	private int reimbursementId;
	private int amount;
	private String rDescription;
	private int author;
	private int resolver;

	private String empId;
	private byte[] imgHolder;
	private int empId2;
	private String rType;
	private String status;
	private String timeStamp;

	private String dateCreated;
	private String userName;
	private String firstName;
	private String userRole;

//	private Employee employee;;

	public String getUserName() {
		return userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Reimbursement() {
		super();
	}

//	BufferedImage image = null;

	public byte[] getImgHolder() {
		return imgHolder;
	}

	public void setImgHolder(byte[] imgHolder) {
		this.imgHolder = imgHolder;
	}

	public int getAuthor() {
		return author;
	}

	public int getResolver() {
		return resolver;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public void setResolver(int resolver) {
		this.resolver = resolver;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public int getAmount() {
		return amount;
	}

	public String getrDescription() {
		return rDescription;
	}

	public int getReimbursementId() {
		return reimbursementId;
	}

//	public BufferedImage getImage() {
//		return image;
//	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setrDescription(String rDescription) {
		this.rDescription = rDescription;
	}

	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

//	public void setImage(BufferedImage image) {
//		this.image = image;
//	}

	@Override
	public String toString() {
		return "Reimbursement [reimbursementId=" + reimbursementId + ", amount=" + amount + ", rDescription=" + empId
				+ rDescription + ", img=" + imgHolder + ", author=" + author + ", resolver=" + resolver + ", userRole="
				+ userRole + ", dateCreated=" + dateCreated + " ,timeStamp"+timeStamp+"]";
	}

	

	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(String empId) {
		this.empId = empId;
	}

	/**
	 * @return the rType
	 */
	public String getrType() {
		return rType;
	}

	/**
	 * @param string the rType to set
	 */
	public void setrType(String rType) {
		this.rType = rType;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + amount;
		result = prime * result + author;
		result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
		result = prime * result + Arrays.hashCode(imgHolder);
		result = prime * result + ((rDescription == null) ? 0 : rDescription.hashCode());
		result = prime * result + ((rType == null) ? 0 : rType.hashCode());
		result = prime * result + reimbursementId;
		result = prime * result + resolver;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((timeStamp == null) ? 0 : timeStamp.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		if (amount != other.amount)
			return false;
		if (author != other.author)
			return false;
		if (dateCreated == null) {
			if (other.dateCreated != null)
				return false;
		} else if (!dateCreated.equals(other.dateCreated))
			return false;
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if (!empId.equals(other.empId))
			return false;
		if (!Arrays.equals(imgHolder, other.imgHolder))
			return false;
		if (rDescription == null) {
			if (other.rDescription != null)
				return false;
		} else if (!rDescription.equals(other.rDescription))

			if (rType == null) {
				if (other.rType != null)
					return false;
			} else if (!rType.equals(other.rType))
				return false;
		if (reimbursementId != other.reimbursementId)
			return false;
		if (resolver != other.resolver)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (timeStamp == null) {
			if (other.timeStamp != null)
				return false;
		} else if (!timeStamp.equals(other.timeStamp))
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

	

	/**
	 * @return the empId2
	 */
	public int getEmpId2() {
		return empId2;
	}

	/**
	 * @param empId2 the empId2 to set
	 */
	public void setEmpId2(int empId2) {
		this.empId2 = empId2;
	}

}
