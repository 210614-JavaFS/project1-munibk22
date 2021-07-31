package com.revature.services;

import java.util.List;

import com.revature.daos.ReimbursementDAO;
import com.revature.daos.ReimbursementDaoImpl;
import com.revature.models.Reimbursement;

public class ReimbursementService {
	private static ReimbursementDAO reimbDao=new ReimbursementDaoImpl();

	public List<Reimbursement> getPastTickets() {
		return reimbDao.findPastTickets();
		
	}

	public List<Reimbursement> gettAllPending() {
		
		return reimbDao.findAllPending();
	}

	public List<Reimbursement> findAllApprovals() {
		
		return reimbDao.findAllApprovals();
	}

	public boolean approveStatus(int rId) {
		
		return reimbDao.approveStatus(rId) ;
	}

	public boolean denyStatus(int rId) {
	
		return reimbDao.denyStatus(rId);
	}

}
