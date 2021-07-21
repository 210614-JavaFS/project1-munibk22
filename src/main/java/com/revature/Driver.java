package com.revature;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.controllers.EmployeeController;

public class Driver {
	private static Scanner scan = new Scanner(System.in);
	private static Logger log = LoggerFactory.getLogger(Driver.class);
	private static EmployeeController empController = new EmployeeController();

	public static void main(String[] args) {

		driverController();

	}

	private static void driverController() {
		System.out.println("****Welcome To The Expense Reimbursement System****\n");
		String response = "a";

		while (!response.equals("3")) {
			System.err.println("What would you like to do next?");
			System.out.println("1.Login as an employee to submit requests for reimbursement \n"
					+ "2.Login as finance manager to view all reimbursement requests \n" + "3.Exit program ");
			response = scan.nextLine();
			if (response.equals("1")) {
				empController.empLoginController();

				empController.empMenuController();
			} else if (response.equals("2")) {

			} else if (response.equals("3")) {
				System.exit(0);
			} else {
				log.warn("User entered invalid choice in the driver Controller");
				System.out.println("You didn not choose a valid option, please try again. \n");

			}

		}

	}

}
