package com.revature.daos;

import java.util.List;

import com.revature.models.Reimbursement;

public interface ReimbursementDAO {

	public List<Reimbursement> findPastTickets();

	public List<Reimbursement> findAllPending();

	public List<Reimbursement> findAllApprovals();

}
