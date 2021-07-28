package com.revature;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.controllers.EmployeeController;

public class Driver {
	private static Scanner scan = new Scanner(System.in);
	private static Logger log = LoggerFactory.getLogger(Driver.class);
	private static EmployeeController empController = new EmployeeController();

//	public static void main(String[] args) {
//		System.out.println("****Welcome To The Expense Reimbursement System****\n");
////		empController.showAllEmployees();
//
//		driverController();
//
//	}

	private static void driverController() {

		String response = "";

		while (!response.equals("3")) {
			System.out.println("What would you like to do today?");
			System.out.println("1.Login as an employee to submit requests for reimbursement \n"
					+ "2.Login as finance manager to view all reimbursement requests \n" + "3.Exit program ");
			response = scan.nextLine();
			if (response.equals("1")) {
				System.err.println("\n***Welcome to Employee Login Menu***");
//				empController.empLoginController();
			} else if (response.equals("2")) {
				System.err.println("\n***Welcome to Manager Login Menu***");
			} else if (response.equals("3")) {
				System.exit(0);
			} else {
				log.warn("User entered invalid choice in the driver Controller");
				System.out.println("You didn not choose a valid option, please try again. \n");

			}

		}

	}

}

//--MDC.put("name","1");
