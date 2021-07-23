package com.revature.models;

import java.awt.image.BufferedImage;
import java.sql.Date;

public class Reimbursement {

	private String pastTickets;
	private String pendingRequests;
	private ReimbursementType rType;
	private boolean rStatus;
	private int amount;
	private boolean rSubmitted;
	private boolean rResolved;
	private String rDescription;
	private int reimbursementId;
	private String timeStamp;

	private Date dateCreated;

	BufferedImage image = null;

	public Reimbursement(String pastTickets, String pendingRequests, ReimbursementType rType) {
		super();
		this.pastTickets = pastTickets;
		this.pendingRequests = pendingRequests;
		this.rType = rType;
	}

	public Reimbursement() {
		super();
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getPastTickets() {
		return pastTickets;
	}

	public String getPendingRequests() {
		return pendingRequests;
	}

	public ReimbursementType getType() {
		return rType;
	}

	public void setPastTickets(String pastTickets) {
		this.pastTickets = pastTickets;
	}

	public void setPendingRequests(String pendingRequests) {
		this.pendingRequests = pendingRequests;
	}

	public void setType(ReimbursementType type) {
		this.rType = type;
	}

	public boolean isrStatus() {
		return rStatus;
	}

	public int getAmount() {
		return amount;
	}

	public boolean isrSubmitted() {
		return rSubmitted;
	}

	public boolean isrResolved() {
		return rResolved;
	}

	public String getrDescription() {
		return rDescription;
	}

	public int getReimbursementId() {
		return reimbursementId;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setrStatus(boolean rStatus) {
		this.rStatus = rStatus;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setrSubmitted(boolean rSubmitted) {
		this.rSubmitted = rSubmitted;
	}

	public void setrResolved(boolean rResolved) {
		this.rResolved = rResolved;
	}

	public void setrDescription(String rDescription) {
		this.rDescription = rDescription;
	}

	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

}
