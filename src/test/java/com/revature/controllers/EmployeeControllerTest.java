package com.revature.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;

import com.revature.models.Employee;
import com.revature.models.Reimbursement;
import com.revature.services.EmployeeService;
import com.revature.utils.Bcrypt;

public class EmployeeControllerTest {

	public static String password;
	public static String hashedPw;
	private static EmployeeService empService = new EmployeeService();
	public static boolean result;
	public static List<Employee> employeeList;
	public static Employee employee = new Employee();
	public static Reimbursement reimbursement = new Reimbursement();

	@BeforeAll
	public static void bCryptUtil() {
		System.out.println("In before all");

	}

	@BeforeEach
	public void showAllEmployees() {
		System.out.println("In before each");

	}

	@AfterEach
	public void clearResult() {
		System.out.println("In after each");

		result = false;
	}

	@AfterAll
	public static void clearBCryptUtil() {
		System.out.println("In after all");
		employeeList = null;
	}

//	@Test
//	public void testList() {
//		System.out.println("In after @Test");
//		employeeList = empService.getAllEmployees();
//		assertEquals(1, employee.getEmpId());
//
//	}

	@Test
	public void addTicket() {
		System.out.println("In after @Test");
		reimbursement.setAmount(1);
		employee.setEmpId(2);
		reimbursement.setAuthor(2);
		reimbursement.setrDescription("junit testing addticket");
	

		assertEquals(result, empService.addTicket(reimbursement));

	}
	@Test
	public void updatePasswordTest() {
		System.out.println("In after @Test");
		employee.setPassword("updated password");
		employee.setEmpId(15);
	

		assertEquals(result, empService.updatePw(employee));

	}

}
