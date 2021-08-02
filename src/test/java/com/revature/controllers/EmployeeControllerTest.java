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
import com.revature.services.EmployeeService;
import com.revature.utils.Bcrypt;

public class EmployeeControllerTest {

	public static String password;
	public static String hashedPw;
	private static EmployeeService empService = new EmployeeService();
	public static boolean result;
	public static List<Employee> employeeList;
	public static Employee employee = new Employee();

	@BeforeAll
	public static void bCryptUtil() {
		System.out.println("In before all");
		
	}

	@BeforeEach
	public void showAllEmployees() {
		System.out.println("In before each");
		 employeeList = empService.getAllEmployees();
		
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

	@Test
	public void testList() {
		System.out.println("In after @Test");
		 
		assertEquals(result, employee);

	}
	
	@Test
	public void testLogin() {
		System.out.println("In after @Test");
		 
		assertEquals(result, employee);

	}

	@Test
	public void test2() {
		System.out.println("In after @Test");
//		result = bcrypt.checkPw(hashedPw);
		assertEquals(result, true);
//		assertTrue(result.equals("password"));

	}

}
