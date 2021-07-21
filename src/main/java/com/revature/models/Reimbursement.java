package com.revature.models;

public class Reimbursement {

	private String pastTickets;
	private String pendingRequests;
	private ReimbursementType type;

	public Reimbursement(String pastTickets, String pendingRequests, ReimbursementType type) {
		super();
		this.pastTickets = pastTickets;
		this.pendingRequests = pendingRequests;
		this.type = type;
	}

	public Reimbursement() {
		super();
	}

	public String getPastTickets() {
		return pastTickets;
	}

	public String getPendingRequests() {
		return pendingRequests;
	}

	public ReimbursementType getType() {
		return type;
	}

	public void setPastTickets(String pastTickets) {
		this.pastTickets = pastTickets;
	}

	public void setPendingRequests(String pendingRequests) {
		this.pendingRequests = pendingRequests;
	}

	public void setType(ReimbursementType type) {
		this.type = type;
	}

}
