package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Employee;
import com.revature.services.EmployeeService;

public class LoginServlet extends HttpServlet {
	private static EmployeeService empService = new EmployeeService();
	private ObjectMapper objectMapper = new ObjectMapper();


	protected void doGet(HttpServletRequest req, HttpServletResponse response, String userName)
			throws ServletException, IOException {
		Employee employee2 = empService.getByUserName(userName);
		String json = objectMapper.writeValueAsString(employee2);
//		System.out.println(userName);
//		System.out.println(json);
		PrintWriter pw = response.getWriter();

		System.out.println(employee2.getFirstName());
		response.getWriter().print(json);
		response.setStatus(200);

//		String password = req.getParameter("password");
//		Employee employee = empService.getByUserName(username);
		RequestDispatcher reqDispatch = null;
		System.out.println(userName);
//		employee.setConfirmPass(password);

//		employee = empService.getByName(username);
//		employee.setUserName(username);
//		System.out.println(employee);
		

		  if(employee2.getPassword()==null) {
			reqDispatch = req.getRequestDispatcher(json);
			reqDispatch.include(req, response);
			pw.print("<span style='color:red; text-align:center'>Invalid user name or password</span>");
		}else if (employee2.getPassword().equals("password")) {
			HttpSession session = req.getSession();
			session.setAttribute("username", employee2.getUserName());
			System.out.println("new session started");
			reqDispatch = req.getRequestDispatcher("success");
//			reqDispatch.forward(req, response);
		}

//		if (empService.login2(username, password)) {
//			reqDispatch = req.getRequestDispatcher("success");
//			reqDispatch.forward(req, resp);
//		} else {
//			reqDispatch = req.getRequestDispatcher("index.html");
//			reqDispatch.include(req, resp);
//
//			PrintWriter pw = resp.getWriter();
//			pw.print("<span style='color:red; text-align:center'>Invalid user name or password</span>");
//		}

	}
}
