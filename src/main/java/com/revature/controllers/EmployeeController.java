package com.revature.controllers;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Employee;
import com.revature.models.ImageTest;
import com.revature.models.Reimbursement;
import com.revature.services.EmployeeService;
import com.revature.utils.Bcrypt;

public class EmployeeController {

	private EmployeeService empService = new EmployeeService();
	private Scanner scan = new Scanner(System.in);
	private Logger log = LoggerFactory.getLogger(EmployeeController.class);
	private static ObjectMapper objectMapper = new ObjectMapper();
	private boolean loggedIn = false;
	private HttpSession session;
//	public  Employee employee = new Employee();

	public void showAllEmployees(HttpServletResponse response) throws IOException {

		try {
			List<Employee> employeeList = empService.getAllEmployees();

			String json = objectMapper.writeValueAsString(employeeList);

			System.out.println(json);
			PrintWriter pw = response.getWriter();
			pw.print(json);

			response.setStatus(200);

		} catch (Exception e) {
			response.setStatus(400);
			e.printStackTrace();
		}
	}

	public boolean login(HttpServletRequest req, HttpServletResponse response) throws IOException, ServletException {

		BufferedReader reader = req.getReader();
		StringBuilder stringBuilder = new StringBuilder();

		String line = reader.readLine();

		while (line != null) {
			stringBuilder.append(line);
			line = reader.readLine();
		}
		String body = new String(stringBuilder);

//		Bcrypt bcrypt = objectMapper.readValue(body, Bcrypt.class);
		Employee employee = objectMapper.readValue(body, Employee.class);

		employee = empService.getByUserName(employee.getUserName());
		System.out.println("password " + employee.getPassword() + " hased pasword" + employee.getHashedPw());
		String json = objectMapper.writeValueAsString(employee);
		PrintWriter pw = response.getWriter();

		System.out.println("employee.getEmpId() =" + employee.getEmpId2());
		System.out.println(employee);
		response.getWriter().print(json);
		System.out.println(body);

		log.info("loginmodel password " + employee.getPassword());

//		try {

//			if(employee.checkPw(employee.getPassword())) {
//			if(employee.checkPw("password") ) {
		response.setStatus(200);
		session = req.getSession();
		session.setAttribute("username", employee.getUserName());
		log.info(employee.getUserName() + " was logged in");
		System.out.println("new session started");

		return true;
//			} else {
//				RequestDispatcher reqDispatch = req.getRequestDispatcher(json);
//				reqDispatch.include(req, response);
//				log.warn("Invalid user name or password");
//				System.out.println("Invalid user name or password");
//					pw.print("<div style='color:red; text-align:center'>Invalid user name or password</div>");
//				return false;
//			}

//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return false;

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
		Employee employee2 = objectMapper.readValue(body, Employee.class);

		PrintWriter pw = response.getWriter();

		if (empService.addEmployee(employee2)) {
			response.setStatus(201);
			String json = objectMapper.writeValueAsString(employee2);
//			PrinterWriter pw = response.getWriter();
			pw.print(json);

			return true;
		} else {
			response.setStatus(406);
			return false;
		}

	}

	public boolean addTicket(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("Adding ticket");
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
			log.info("Successfully added reimbursement");
			return true;
		} else {
			response.setStatus(406);
			log.warn("Could not add reimbursement");
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

	public void updatePassword(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("Updating password");
		BufferedReader reader = request.getReader();
		StringBuilder stringBuilder = new StringBuilder();

		String line = reader.readLine();

		while (line != null) {
			stringBuilder.append(line);
			line = reader.readLine();
		}
		String body = new String(stringBuilder);

		Employee employee = objectMapper.readValue(body, Employee.class);
		System.out.println(employee);
//		(empService.updatePw()
		if (empService.updatePw(employee)) {
			response.setStatus(201);
			log.info("Successfully added reimbursement");

		}

	}

}
