package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SuccessServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession(false);

		res.setContentType("aapliction/json");
		PrintWriter pw = res.getWriter();
		System.out.println("Testing success ervlet");
		System.out.println("Testing success ervlet");

		if (session == null) {
			pw.print("<h1>You are not Logged In!!</h1>");
			System.out.println("Testing success ervlet");
		} else {
//			String username = (String) session.getAttribute("username");

//			String username = req.getParameter("userId");
			System.out.println("Testing success ervlet");
			pw.print("<h2>Welcome, you have successfully logged in!</h2>");

			pw.print("<a href='logout'>Click here to logout!</a>");
		}

//		RequestDispatcher reqDispatch = null;

	}
}
