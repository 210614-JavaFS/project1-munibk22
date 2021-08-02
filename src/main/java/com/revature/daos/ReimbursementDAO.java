package com.revature.daos;

import java.util.List;

import com.revature.models.Reimbursement;

public interface ReimbursementDAO {

	public List<Reimbursement> findPastTickets();

	public List<Reimbursement> findAllPending();

	public List<Reimbursement> findAllApprovals();

	public boolean approveStatus(int rId, Reimbursement reimbursement);

	boolean denyStatus(int rId, Reimbursement reimbursement);

}
