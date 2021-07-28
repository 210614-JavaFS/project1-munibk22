package com.revature.controllers;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Employee;
import com.revature.models.ImageTest;
import com.revature.models.LoginModel;
import com.revature.models.Reimbursement;
import com.revature.services.EmployeeService;

public class EmployeeController {

	private EmployeeService empService = new EmployeeService();
	private Scanner scan = new Scanner(System.in);
	private Logger log = LoggerFactory.getLogger(EmployeeController.class);
	private static ObjectMapper objectMapper = new ObjectMapper();
//	public static Employee employee = new Employee();
	private boolean loggedIn = false;
	private HttpSession session;

	public void showAllEmployees(HttpServletResponse response) throws IOException {
//		ObjectMapper objectMapper = new ObjectMapper();
		List<Employee> employeeList = empService.getAllEmployees();

		String json = objectMapper.writeValueAsString(employeeList);

		System.out.println(json);
		PrintWriter pw = response.getWriter();
		pw.print(json);

		response.setStatus(200);
	}

	public boolean login(HttpServletRequest req, HttpServletResponse response) throws IOException, ServletException {
		String userPw = req.getParameter("userName");
		System.out.println(userPw);
		System.out.println(req.getParameter("userName"));

		BufferedReader reader = req.getReader();
		StringBuilder stringBuilder = new StringBuilder();

		String line = reader.readLine();

		while (line != null) {
			stringBuilder.append(line);
			line = reader.readLine();
		}
		String body = new String(stringBuilder);

		LoginModel loginModel = objectMapper.readValue(body, LoginModel.class);

		Employee employee2 = empService.getByUserName(loginModel.getUserName());

		String json = objectMapper.writeValueAsString(employee2);
		PrintWriter pw = response.getWriter();

		System.out.println(employee2.getFirstName());
		response.getWriter().print(json);
		System.out.println(body);
		
		log.info("loginmodel password " + loginModel.getPassword());
	

		try {

			if (employee2.getFirstName() != null && employee2.getPassword().equals(loginModel.getPassword())) {
				response.setStatus(200);
				session = req.getSession();
				session.setAttribute("username", employee2.getUserName());
				log.info(employee2.getUserName()+" was logged in");
				System.out.println("new session started");
;

				return true;
			} else {
//				RequestDispatcher reqDispatch = req.getRequestDispatcher(json);
//				reqDispatch.include(req, response);
				log.warn("Invalid user name or password");
				System.out.println("Invalid user name or password");
//					pw.print("<div style='color:red; text-align:center'>Invalid user name or password</div>");
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public boolean addEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
		BufferedReader reader = request.getReader();
		StringBuilder stringBuilder = new StringBuilder();

		String line = reader.readLine();

		while (line != null) {
			stringBuilder.append(line);
			line = reader.readLine();
		}
		String body = new String(stringBuilder);
		Employee employee = objectMapper.readValue(body, Employee.class);

		if (empService.addEmployee(employee)) {
			response.setStatus(201);
			return true;
		} else {
			response.setStatus(406);
			return false;
		}

	}

	public boolean addTicket(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		BufferedReader reader = request.getReader();
		StringBuilder stringBuilder = new StringBuilder();

		String line = reader.readLine();

		while (line != null) {
			stringBuilder.append(line);
			line = reader.readLine();
		}
		String body = new String(stringBuilder);
		Reimbursement reimbursement = objectMapper.readValue(body, Reimbursement.class);
		System.out.println(reimbursement);
		if (empService.addTicket(reimbursement)) {
			response.setStatus(201);
			return true;
		} else {
			response.setStatus(406);
			return false;
		}
	}

	public void lougout(HttpServletRequest request, HttpServletResponse response) {
		session = request.getSession();
		session.invalidate();

	}

	public void addImage(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		BufferedImage image2 = null;
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader reader = request.getReader();

		String line = reader.readLine();
		while (line != null) {
			stringBuilder.append(line);
			line = reader.readLine();
		}
		String body = new String(stringBuilder);

		System.out.println(body);
		ImageTest image = objectMapper.readValue(body, ImageTest.class);

		if (empService.addImage(image)) {
			System.err.println("Image inserted successfully");
		} else {
			System.out.println("Error in inserting image");
		}

	}

	public void getReimbursements(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, JsonProcessingException {
		List<Reimbursement> reimbursementList = empService.getAllReimbursements();

		String json = objectMapper.writeValueAsString(reimbursementList);

		System.out.println(json);
		PrintWriter pw = response.getWriter();
		pw.print(json);

		response.setStatus(200);

	}

}
