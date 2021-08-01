package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Employee;
import com.revature.models.Reimbursement;

import com.revature.services.EmployeeService;
import com.revature.services.ReimbursementService;

public class ReimbursementController extends Employee {

	private static Logger log = LoggerFactory.getLogger(ReimbursementController.class);
	private static EmployeeService empService = new EmployeeService();

	private ObjectMapper objectMapper = new ObjectMapper();
	private ReimbursementService reimbService = new ReimbursementService();

	public void pasttickets(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		List<Reimbursement> reimbursementList = reimbService.getPastTickets();
		System.out.println("getEmpId 2=" + getEmpId2());

		System.out.println("getEmpId 2=" + getEmpId2());

		System.out.println("pasttickets connected!!");

		String json = objectMapper.writeValueAsString(reimbursementList);

		System.out.println(json);
		PrintWriter pw = response.getWriter();
		pw.print(json);

		if (reimbService.getPastTickets() != null) {
			response.setStatus(200);
			log.info("Employee requested past tickets");
		} else {
			log.warn("Could not retrieve past tickets");
		}

	}

	public void pendingRequests(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		List<Reimbursement> pendingList = reimbService.gettAllPending();
		String json = objectMapper.writeValueAsString(pendingList);

		System.out.println(json);
		PrintWriter pw = response.getWriter();
		pw.print(json);

		response.setStatus(200);

	}

	public void approvalRequests(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		log.info("Retriving Approval data from Database");
		List<Reimbursement> rList = reimbService.findAllApprovals();
		System.out.println(rList);

		try {
			String json = objectMapper.writeValueAsString(rList);
			PrintWriter pw = response.getWriter();
			pw.print(json);
			response.setStatus(200);

		} catch (Exception e) {
			log.error("Error retrieving Data");
		}

	}

	public void approveStatus(HttpServletRequest request, HttpServletResponse response) throws IOException {
		BufferedReader reader = request.getReader();
		StringBuilder stringBuilder = new StringBuilder();

		String line = reader.readLine();

		stringBuilder.append(line);

		String body = new String(stringBuilder);

		Reimbursement reimbursement = objectMapper.readValue(body, Reimbursement.class);

		int rId = reimbursement.getReimbursementId();
		System.out.println(rId);

		try {
			if (reimbService.approveStatus(rId)) {
				response.setStatus(200);
				log.info("Status successfully updated");
			}

		} catch (Exception e) {
			log.error("Could not retrieve information");
			e.printStackTrace();
		}

	}

	public void denyStatus(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		log.info("Denying request..");
		BufferedReader reader = request.getReader();
		StringBuilder stringBuilder = new StringBuilder();

		String line = reader.readLine();

		stringBuilder.append(line);

		String body = new String(stringBuilder);

		Reimbursement reimbursement = objectMapper.readValue(body, Reimbursement.class);

		int rId = reimbursement.getReimbursementId();
		System.out.println("Deny iD: "+rId);
		try {
			if (reimbService.denyStatus(rId)) {
				response.setStatus(200);
				log.info("Status Deny successfully updated");
			}

		} catch (Exception e) {
			log.error("Could not retrieve information");
			e.printStackTrace();
		}

	}

	public void getReimbursements(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, JsonProcessingException {
		try {
			List<Reimbursement> reimbursementList = empService.getAllReimbursements();

			String json = objectMapper.writeValueAsString(reimbursementList);

			System.out.println(json);
			PrintWriter pw = response.getWriter();
			pw.print(json);

			response.setStatus(200);
		} catch (Exception e) {
			log.error("Could not retrieve information");
			e.printStackTrace();
		}

	}



}
