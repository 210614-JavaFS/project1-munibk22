package com.revature.controllers;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.models.Employee;
import com.revature.models.Reimbursement;
import com.revature.services.EmployeeService;

public class EmployeeController {

	private EmployeeService empService = new EmployeeService();
	private Employee employee = new Employee();
	private Scanner scan = new Scanner(System.in);
	private Logger log = LoggerFactory.getLogger(EmployeeController.class);
	private boolean loggedIn = false;

	public void empLoginController() {

		do {
			System.out.println("Please enter your username:");
			String userNameScan = scan.nextLine();
			System.out.println("Please enter your password:");
			String passwordScan = scan.nextLine();
			employee.setConfirmPass(passwordScan);
			employee = empService.getByUserName(userNameScan);
//			System.out.println(employee);

			if (employee.getUserName() == null) {
				log.warn("User entered invalid username");
				System.out.println("Username did not match, please try again.");
			} else if (!(employee.getPassword().equals(passwordScan))) {
				log.warn("User entered incorrect password ");
				System.out.println("Password did not match, please try again.");
			} else if (employee.getUserName().equals(userNameScan) && employee.getPassword().equals(passwordScan)) {
				System.err.println("\nWelcome " + employee.getFirstName() + ", You have succesfully loggin in!");
				empMenuController(employee);
			}
		} while (!loggedIn);

	}

	public void empMenuController(Employee employee) {

		boolean menuController = true;
		do {
			System.out.println("\n" + employee.getFirstName() + ", What would you like to do today? \n"
					+ "1.Submit requests for reimbursement \n" + "2.View past tickets \n" + "3.View pending tickets \n"
					+ "4.Exit menu");

			String response = scan.nextLine();
			switch (response) {
			case "1":
				Reimbursement reimbursement = ReimbursementController.reimbursementMenuController(employee);
				break;
			case "2":

				break;
			case "3":

				break;
			case "4":
				loggedIn = true;
				menuController = false;
				break;
			default:
				log.warn("User entered an invalid choice.");
				System.out.println("Not a valid choice, plese try again.");
				break;
			}
		} while (menuController);
	}

	public void showAllEmployees() {
		List<Employee> employees = empService.getAllEmployees();

		for (Employee e : employees) {
			System.out.println(e);
		}
	}

}
