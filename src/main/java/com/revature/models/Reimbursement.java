package com.revature.models;

import java.awt.image.BufferedImage;
import java.sql.Date;

public class Reimbursement {
	private int amount;
	private String rDescription;
	private int author;
	private int resolver;
	private int rStatus;
	private int reimbursementId;
	private String img;

	private byte[] imgHolder;
	private String pastTickets;
	private String pendingRequests;
	private ReimbursementType rType;

	private boolean rSubmitted;
	private boolean rResolved;

	private String timeStamp;

	private Date dateCreated;

	BufferedImage image = null;

	public Reimbursement() {
		super();
	}

	public int getrStatus() {
		return rStatus;
	}

	public byte[] getImg() {
		return img.getBytes();
	}

	public byte[] getImgHolder() {
		return imgHolder;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public void setImgHolder(byte[] imgHolder) {
		this.imgHolder = imgHolder;
	}

	public ReimbursementType getrType() {
		return rType;
	}

	public int getAuthor() {
		return author;
	}

	public int getResolver() {
		return resolver;
	}

	public void setrType(ReimbursementType rType) {
		this.rType = rType;
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

	public int isrStatus() {
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

	public void setrStatus(int rStatus) {
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
