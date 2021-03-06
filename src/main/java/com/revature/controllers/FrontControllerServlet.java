package com.revature.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontControllerServlet extends HttpServlet {
	private static EmployeeController employeeController = new EmployeeController();
	private static ReimbursementController reimbursementController = new ReimbursementController();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");

		response.setStatus(404);

		final String URL = request.getRequestURI().replace("/project1/", "");

		System.out.println(URL);

		String[] UrlSections = URL.split("/");

		switch (UrlSections[0]) {
		case "3":
			if (UrlSections.length == 1) {
				if (request.getMethod().equals("GET")) {
					employeeController.showAllEmployees(response);
				} else if (request.getMethod().equals("POST")) {
					employeeController.addEmployee(request, response);
				}
			} else if (UrlSections.length == 2) {

			}

			break;
		case "register":
			employeeController.addEmployee(request, response);
			break;
		case "addticket":
			employeeController.addTicket(request, response);
			break;
		case "logout":
			employeeController.lougout(request, response);
			break;
		case "insertimage":
			employeeController.addImage(request, response);
			break;
		case "reimbursements":
			reimbursementController.getReimbursements(request, response);
			break;
		case "login":
			employeeController.login(request, response);
			break;
		case "pasttickets":
			reimbursementController.pasttickets(request, response);
			break;
		case "pending":
			reimbursementController.pendingRequests(request, response);
			break;
		case "approvals":
			if (UrlSections.length == 1) {
				if (request.getMethod().equals("GET")) {
					reimbursementController.approvalRequests(request, response);
					break;
				} else if (request.getMethod().equals("POST")) {
					reimbursementController.approveStatus(request, response);
					break;
				} 
			}else if (UrlSections.length == 2) {
				reimbursementController.denyStatus(request, response);
				break;
			}
			break;

		case "approvestatus":
			reimbursementController.approveStatus(request, response);
			break;
		case "denystatus":
			reimbursementController.denyStatus(request, response);
			break;
		case"update":
			
			employeeController.updatePassword(request, response);
break;
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		doGet(request, response);
	}

}
