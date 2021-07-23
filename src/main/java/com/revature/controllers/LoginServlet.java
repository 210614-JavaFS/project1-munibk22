package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.models.Employee;
import com.revature.services.EmployeeService;

public class LoginServlet extends HttpServlet {
	private static EmployeeService empService = new EmployeeService();
//	private Employee employee = new Employee();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("userId");
		String password = req.getParameter("password");
		Employee employee = new Employee();
		RequestDispatcher reqDispatch = null;
//		System.out.println(username);
//		employee.setConfirmPass(password);

//		employee = empService.getByName(username);
//		employee.setUserName(username);
//		System.out.println(employee);
//		System.out.println(employee.getUserName());

		PrintWriter pw = resp.getWriter();

		if (empService.login(username, password)) {
			HttpSession session = req.getSession();

			session.setAttribute("username", username);

			reqDispatch = req.getRequestDispatcher("success");
			reqDispatch.forward(req, resp);
		} else {
			reqDispatch = req.getRequestDispatcher("index.html");
			reqDispatch.include(req, resp);

			pw.print("<span style='color:red; text-align:center'>Invalid user name or password</span>");
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

	};

}
