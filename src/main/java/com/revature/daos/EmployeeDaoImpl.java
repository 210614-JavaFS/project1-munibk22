package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.models.ImageTest;
import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementType;
import com.revature.utils.ConnectionUtil;

public class EmployeeDaoImpl extends Employee implements EmployeeDAO {

	@Override
	public Employee findByUserName(String userName) {
		String sql = "SELECT u.* , roles.user_role \n"
				+ "FROM ers_users u \n"
				+ "JOIN ers_user_roles roles \n"
				+ "ON u.user_role_id = roles.ers_user_role_id \n" 
				+ "WHERE user_name = ?";

		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, userName);
			ResultSet result = statement.executeQuery();

			Employee employee = new Employee();
			while (result.next()) {
				employee.setEmpId(result.getInt("emp_id"));
				employee.setFirstName(result.getString("first_name"));
				employee.setLastName(result.getString("last_name"));
				employee.setUserName(result.getString("user_name"));
				employee.setEmail(result.getString("email"));
				employee.setPassword(result.getString("password"));
				employee.setUserRole(result.getString("user_role"));
			}
			return employee;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	@Override
	public Employee findByName(String name) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM ers_users WHERE first_name = ?";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, name);
			ResultSet result = statement.executeQuery();

			Employee employee = new Employee();

			while (result.next()) {
				employee.setEmpId(result.getInt("emp_id"));
				employee.setFirstName(result.getString("first_name"));
				employee.setLastName(result.getString("last_name"));
				employee.setUserName(result.getString("user_name"));
				employee.setEmail(result.getString("email"));
				employee.setPassword(result.getString("password"));

			}
			return employee;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}

	@Override
	public boolean updateReimbursement(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertImage(ImageTest image) {
		String sql = "INSERT INTO imageholder(image) Values(?)";

		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(sql);

//			ImageTest imageT = new ImageTest();
			statement.setBytes(1, image.getImage());

			statement.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

//	@Override	
//	public boolean getImage() {

//try(Connection conn=ConnectionUtil.getConnection()) {
//	PreparedStatement ps = conn.prepareStatement("SELECT image FROM IMAGEHOLDER WHERE imageid=1");
//	ps.setString(1, "myimage.jpg");
//	ResultSet rs = ps.executeQuery();
//	if (rs != null) {
//	    while(rs.next()) {
//	        byte[] imgBytes = rs.getBytes(1);
//	       
//	    }
//	    rs.close();
//	}
//	ps.close();
//	
//} catch (Exception e) {
//	// TODO: handle exception
//}
//		return false;
//	
//		
//	}

	@Override
	public boolean addEmployee(Employee employee) {
		String sql = "INSERT INTO ers_users(USER_NAME,FIRST_NAME,LAST_NAME,EMAIL, password)" + "VALUES(?,?,?,?,?) ";

		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(sql);

			int index = 0;
			statement.setString(++index, employee.getUserName());
			statement.setString(++index, employee.getFirstName());
			statement.setString(++index, employee.getLastName());
			statement.setString(++index, employee.getEmail());
			statement.setString(++index, employee.getPassword());

			statement.execute();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean addTicket(Reimbursement reimbursement) {
		String sql = "INSERT INTO ers_reimbursement(reimb_amount, reimb_description, reimb_author,"
				+ "reimb_type_id, reimb_reciept)" + "values(?,?,?,?,?)";

		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(sql);
			int index = 0;

			statement.setInt(++index, reimbursement.getAmount());
			statement.setString(++index, reimbursement.getrDescription());
			statement.setInt(++index, getEmpId2());
			statement.setInt(++index, reimbursement.getReimbursementId());
			statement.setBytes(++index, reimbursement.getImgHolder());

			statement.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<Employee> findAll() {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM ers_users";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);

			List<Employee> empList = new ArrayList<>();

			while (result.next()) {
				Employee employee = new Employee();
				employee.setEmpId(result.getInt("emp_id"));
				employee.setFirstName(result.getString("first_name"));
				employee.setLastName(result.getString("last_name"));
				employee.setUserName(result.getString("user_name"));
				employee.setEmail(result.getString("email"));
				employee.setUserRoleId(result.getInt("user_role_id"));
				employee.setPassword(result.getString("password"));
				empList.add(employee);

			}
			return empList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Reimbursement> findAllReimbursements() {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT r.reimb_submitted, to_char(reimb_submitted ,'MON-DD-YY') ,r.*, u.*, \n"
					+ "s.reimb_status, u.user_name, u.emp_id \n" + "FROM ERS_REIMBURSEMENT r \n" + "JOIN ers_users u \n"
					+ "ON r.reimb_author=u.emp_id \n" + "JOIN ers_reimbursement_status s \n"
					+ "ON r.reimb_status_id = s.reimb_status_id \n" + "WHERE r.reimb_status_id != 2";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);

			List<Reimbursement> reimbList = new ArrayList<>();

			while (result.next()) {

				Reimbursement reimbursement = new Reimbursement();

				reimbursement.setReimbursementId(result.getInt("reimb_id"));
				reimbursement.setAmount(result.getInt("reimb_amount"));
				reimbursement.setrDescription(result.getString("reimb_description"));
				reimbursement.setAmount(result.getInt("reimb_author"));
				reimbursement.setResolver(result.getInt("reimb_resolver"));
				reimbursement.setStatus(result.getString("reimb_status"));
//				reimbursement.setrIntType(result.getInt("reimb_type_id"));
				reimbursement.setDateCreated(result.getString("reimb_submitted"));

				reimbursement.setUserName(result.getString("user_name"));

				reimbList.add(reimbursement);

			}
			return reimbList;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean login() {
		// TODO Auto-generated method stub
		return false;
	}

}
