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

		String sql = "SELECT reib.*, reib.reimb_id, reib.reimb_resolver, emp.user_name, emp.first_name,reib.REIMB_ID ticketnumber,reib.REIMB_AMOUNT ,reib.REIMB_SUBMITTED ,status.REIMB_STATUS \r\n"
				+ ",reib.reimb_description, reib.reimb_submitted, to_char(reimb_submitted ,'MON-DD-YY')\r\n"
				+ "FROM ERS_USERS emp\r\n" + "JOIN ERS_REIMBURSEMENT reib \r\n" + "ON emp.emp_id=reib.REIMB_AUTHOR \r\n"
				+ "JOIN ERS_REIMBURSEMENT_STATUS status \r\n" + "ON reib.REIMB_STATUS_ID =status.REIMB_STATUS_ID \r\n"
				+ "WHERE emp.EMP_ID = " + getEmpId2()+" AND reib.reimb_status_id != 2";

		System.out.println("getEmpId " + getEmpId2());
//		reib.reimb_id 

		List<Reimbursement> rList = new ArrayList<>();

		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				Reimbursement reimbursement = new Reimbursement();

				reimbursement.setReimbursementId(result.getInt("REIMB_ID"));
				reimbursement.setResolver(result.getInt("reimb_resolver"));
				reimbursement.setAmount(result.getInt("REIMB_AMOUNT"));
				reimbursement.setAuthor(getEmpId2());
				reimbursement.setrDescription(result.getString("reimb_description"));
//				reimbursement.setImgHolder(result.getBytes("reimb_reciept"));
				reimbursement.setStatus(result.getString("REIMB_STATUS"));
				reimbursement.setUserName(result.getString("user_name"));
				reimbursement.setDateCreated(result.getString("reimb_submitted"));
				reimbursement.setTimeStamp(result.getString("reimb_resolveds"));
				rList.add(reimbursement);
			}

			return rList;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Reimbursement> findAllApprovals() {
		String sql = "SELECT r.reimb_id, r.REIMB_AMOUNT, r.reimb_author, u.user_name, r.reimb_submitted, \n"
				+ "r.reimb_description, s.reimb_status,t.reimb_type ,roles.user_role \n"
				+ "FROM ERS_REIMBURSEMENT r \n"
				+ "JOIN ers_users u \n" + "ON r.reimb_author=u.emp_id \n" 
				+ "JOIN ERS_REIMBURSEMENT_STATUS s \n"
				+ "ON r.reimb_status_id= s.reimb_status_id \n"
				+ "JOIN ERS_REIMBURSEMENT_TYPE t \n"
				+ "ON r.reimb_type_id = t.reimb_type_id \n"
				+ "JOIN ers_user_roles roles \n"
				+ "ON u.user_role_id = roles.ers_user_role_id \n"
				+ "WHERE s.reimb_status_id=2;";

		try (Connection conn = ConnectionUtil.getConnection()) {
			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);

			List<Reimbursement> rList = new ArrayList<>();

			while (result.next()) {
				Reimbursement reimbursement = new Reimbursement();

				reimbursement.setReimbursementId(result.getInt("reimb_id"));
				reimbursement.setAmount(result.getInt("REIMB_AMOUNT"));
				reimbursement.setAuthor(result.getInt("reimb_author"));
				reimbursement.setUserName(result.getString("user_name"));
				reimbursement.setDateCreated(result.getString("reimb_submitted"));
				reimbursement.setrDescription(result.getString("reimb_description"));
				reimbursement.setStatus(result.getString("reimb_status"));
				reimbursement.setrType(result.getString("reimb_type"));
				reimbursement.setDateCreated(result.getString("reimb_submitted"));
				reimbursement.setUserRole(result.getString("user_role"));
				rList.add(reimbursement);
			}

			return rList;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Reimbursement> findAllPending() {
		String SQL = "SELECT r.reimb_submitted, to_char(reimb_submitted ,'MON-DD-YY') ,r.reimb_id,u.user_name, u.first_name, r.REIMB_DESCRIPTION ,"
				+ "s.REIMB_STATUS , t.REIMB_TYPE,r.REIMB_AMOUNT,u.emp_id, roles.user_role  \n"
				+ "FROM ers_reimbursement r \n"
				+ "JOIN ERS_REIMBURSEMENT_STATUS s \n" 
				+ "ON r.reimb_status_id=s.REIMB_STATUS_ID \n"
				+ "JOIN ERS_USERS u \n"
				+ "ON r.reimb_author = u.EMP_ID \n" + "JOIN ERS_REIMBURSEMENT_TYPE t \n"
				+ "ON r.REIMB_TYPE_ID =t.REIMB_TYPE_ID \n"
				+ "JOIN ers_user_roles roles \n"
				+ "ON u.user_role_id = roles.ers_user_role_id \n" 
				+ "WHERE r.REIMB_STATUS_ID = 2 AND u.emp_id = " + getEmpId2();
				
		
		
		System.out.println("getting pending requests");

		try (Connection conn = ConnectionUtil.getConnection()) {
			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(SQL);

			List<Reimbursement> reimbList = new ArrayList<>();

			while (result.next()) {
				Reimbursement reimbursement = new Reimbursement();

				reimbursement.setUserName(result.getString("user_name"));
				reimbursement.setFirstName(result.getString("first_name"));
				reimbursement.setrDescription(result.getString("REIMB_DESCRIPTION"));
				reimbursement.setStatus(result.getString("REIMB_STATUS"));
				reimbursement.setrType(result.getString("REIMB_TYPE"));
				reimbursement.setAmount(result.getInt("REIMB_AMOUNT"));
				reimbursement.setReimbursementId(result.getInt("reimb_id"));
				reimbursement.setDateCreated(result.getString("reimb_submitted"));
				reimbursement.setUserRole(result.getString("user_role"));
				reimbList.add(reimbursement);

			}
			return reimbList;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	@Override
	public boolean approveStatus(int rId, Reimbursement reimbursement) {		
		String sql ="UPDATE ERS_REIMBURSEMENT \n"
				+ "SET reimb_status_id = 1, \n"
				+ "reimb_resolveds = '"+reimbursement.getTimeStamp()+ "',\n"
				+ "reimb_resolver = " + reimbursement.getResolver() +" \n"
				+ "WHERE reimb_id = "+rId;
				
				
		try(Connection conn=ConnectionUtil.getConnection()){
			Statement statement = conn.createStatement();
			
			statement.execute(sql);
			System.out.println("Approved request from req DAO");
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;

	}

	
	@Override
	public boolean denyStatus(int rId, Reimbursement reimbursement) {		
		String sql ="UPDATE ERS_REIMBURSEMENT \n"
				+ "SET reimb_status_id = 3, \n"
				+ " reimb_resolveds = "+reimbursement.getTimeStamp()+ ",\n"				
				+ "reimb_resolver = "+ reimbursement.getResolver() +" \n"
				+ "WHERE reimb_id = "+rId;
				
				
		try(Connection conn=ConnectionUtil.getConnection()){
			Statement statement = conn.createStatement();
			
			statement.executeQuery(sql);
			System.out.println("Denied request from req DAO");
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
