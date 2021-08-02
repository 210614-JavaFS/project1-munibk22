package com.revature.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Employee;
import com.revature.models.Reimbursement;
import com.revature.services.ReimbursementService;

public class ReimbursementControllerTest {
	public static Reimbursement reimbursement = new Reimbursement();
	public static boolean booleanResult;
	public ReimbursementService reimbService = new ReimbursementService();
	public ObjectMapper objectMapper = new ObjectMapper();
	public static Employee employee = new Employee();
	
	@BeforeAll
	public static void bCryptUtil() {
		System.out.println("In before all");

	}

	@BeforeEach
	public void beforeEach() {
		System.out.println("In before each");

	}

	@AfterEach
	public void clearResult() {
		System.out.println("In after each");
		Reimbursement reimbursement = new Reimbursement();
		booleanResult = false;
	}

	@AfterAll
	public static void clearBCryptUtil() {
		System.out.println("In after all");
		 Reimbursement reimbursement = new Reimbursement();
	}

	@Test
	public void pastticketsTest() throws JsonProcessingException {
		System.out.println("In after @pastticketsTest");
		

		reimbursement.setAmount(1);
		reimbursement.setAuthor(1);
		reimbursement.setrDescription("pastticketsTest jUnit Test");
		employee.setEmpId(1);
		reimbursement.setStatus("1");
		List<Reimbursement>  pendingList =reimbService.getPastTickets();
		String json = objectMapper.writeValueAsString(pendingList);
		
		System.out.println(json);
		assertEquals(1,employee.getEmpId2());
	}
	
	@Test
	public void pendingRequestsTest() throws IOException  {
		System.out.println("In after @pendingRequestsTest");
		

		reimbursement.setAmount(1);
		reimbursement.setAuthor(1);
		reimbursement.setrDescription("pastticketsTest jUnit Test");
		employee.setEmpId(1);
		reimbursement.setStatus("1");
		List<Reimbursement>  pendingList =reimbService.gettAllPending();
		String json = objectMapper.writeValueAsString(pendingList);
		
		System.out.println(json);
		assertEquals(1,employee.getEmpId2());
	}
	
	@Test
	public void approvalRequestsTest() throws IOException  {
		System.out.println("In after @approvalRequestsTest");
		ResultSet result;

		
		employee.setEmpId(2);
		reimbursement.setStatus("1");
		List<Reimbursement>  pendingList =reimbService.findAllApprovals();
		String json = objectMapper.writeValueAsString(pendingList);
		
		System.out.println(json);
		assertEquals(2,employee.getEmpId2());
	}

	

}
