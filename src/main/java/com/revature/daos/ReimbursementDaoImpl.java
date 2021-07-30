package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.revature.models.Employee;
import com.revature.models.Reimbursement;
import com.revature.utils.ConnectionUtil;

public class ReimbursementDaoImpl extends Employee implements ReimbursementDAO {

	@Override
	public List<Reimbursement> findPastTickets() {
		
		String sql = "SELECT reib.reimb_id ,emp.user_name, emp.first_name,reib.REIMB_ID ticketnumber,reib.REIMB_AMOUNT ,reib.REIMB_SUBMITTED ,status.REIMB_STATUS \r\n"
				+ ",reib.reimb_description, reib.reimb_submitted, to_char(reimb_submitted ,'MON-DD-YY')\r\n"
				+ "FROM ERS_USERS emp\r\n"
				+ "JOIN ERS_REIMBURSEMENT reib \r\n"
				+ "ON emp.emp_id=reib.REIMB_AUTHOR \r\n"
				+ "JOIN ERS_REIMBURSEMENT_STATUS status \r\n"
				+ "ON reib.REIMB_STATUS_ID =status.REIMB_STATUS_ID \r\n"
				+ "WHERE emp.EMP_ID = " + getEmpId2();

		System.out.println("getEmpId "+ getEmpId2());
//		reib.reimb_id 
		
		List<Reimbursement> rList = new ArrayList<>();

		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				Reimbursement reimbursement = new Reimbursement();
				
			
				reimbursement.setReimbursementId(result.getInt("REIMB_ID"));
				reimbursement.setAmount(result.getInt("REIMB_AMOUNT"));
				reimbursement.setAuthor(getEmpId2());
				reimbursement.setrDescription(result.getString("reimb_description"));
//				reimbursement.setImgHolder(result.getBytes("reimb_reciept"));
				reimbursement.setStatus(result.getString("REIMB_STATUS"));					
				reimbursement.setEmpId(result.getString("user_name"));
				reimbursement.setDateCreated(result.getString("reimb_submitted"));
				
				rList.add(reimbursement);
			}
			
			return rList;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Reimbursement> findAllApprovals(){
		System.out.println("Getting pending requests");
		
		return null;		
	}
	
	@Override
	public List<Reimbursement> findAllPending(){
		String SQL ="SELECT r.reimb_submitted, to_char(reimb_submitted ,'MON-DD-YY') ,r.reimb_id,u.user_name, u.first_name, r.REIMB_DESCRIPTION ,"
				+ "s.REIMB_STATUS , t.REIMB_TYPE,r.REIMB_AMOUNT,u.emp_id \r\n"
				+ "FROM ers_reimbursement r\r\n"
				+ "JOIN ERS_REIMBURSEMENT_STATUS s \r\n"
				+ "ON r.reimb_status_id=s.REIMB_STATUS_ID \r\n"
				+ "JOIN ERS_USERS u\r\n"
				+ "ON r.reimb_author = u.EMP_ID\r\n"
				+ "JOIN ERS_REIMBURSEMENT_TYPE t\r\n"
				+ "ON r.REIMB_TYPE_ID =t.REIMB_TYPE_ID \r\n"
				+ "WHERE r.REIMB_STATUS_ID = 2 AND u.emp_id = " +getEmpId2();
	System.out.println("getting pending requests");
		
		try(Connection conn=ConnectionUtil.getConnection()) {
			Statement statement = conn.createStatement();
			
			ResultSet result= statement.executeQuery(SQL);
			
			List<Reimbursement> reimbList = new ArrayList<>();
			
			while (result.next()) {				 
				Reimbursement reimbursement=new Reimbursement();

				reimbursement.setUserName(result.getString("user_name"));
				reimbursement.setFirstName(result.getString("first_name"));
				reimbursement.setrDescription(result.getString("REIMB_DESCRIPTION"));
				reimbursement.setStatus(result.getString("REIMB_STATUS"));
				reimbursement.setrType(result.getString("REIMB_TYPE"));		
				reimbursement.setAmount(result.getInt("REIMB_AMOUNT"));
				reimbursement.setReimbursementId(result.getInt("reimb_id"));
				reimbursement.setDateCreated(result.getString("reimb_submitted"));
				
				reimbList.add(reimbursement);

			}
			return reimbList;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		 SQL ="SELECT r.reimb_submitted, to_char(reimb_submitted ,'MON-DD-YY') ,r.reimb_id,u.user_name, u.first_name, r.REIMB_DESCRIPTION ,"
//					+ "s.REIMB_STATUS , t.REIMB_TYPE,r.REIMB_AMOUNT \r\n"
		return null;		
		
	}

}
