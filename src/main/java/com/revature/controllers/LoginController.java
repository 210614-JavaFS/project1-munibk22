package com.revature.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Employee;
import com.revature.services.EmployeeService;

public class LoginController {
	private static Employee employee = new Employee();
private static EmployeeService empService = new EmployeeService();
private ObjectMapper objectMapper = new ObjectMapper();

public void login(HttpServletRequest request, HttpServletResponse response) throws IOException{
	String username = request.getParameter("userId");
	String password = request.getParameter("password");
//	empService.login(username, password);
		
}

public void getByUserName(HttpServletRequest request,HttpServletResponse response) {

//	employee= empService.getByUserName(username);
	System.out.println(employee.getUserName());
}


}
