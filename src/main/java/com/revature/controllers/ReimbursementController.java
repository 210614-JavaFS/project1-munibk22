package com.revature.controllers;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.models.Employee;
import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementType;
import com.revature.services.EmployeeService;

public class ReimbursementController {
	private static Scanner scan = new Scanner(System.in);
	private static Logger log = LoggerFactory.getLogger(ReimbursementController.class);
	private static EmployeeService empService = new EmployeeService();
//	private ReimbursementType type = new ReimbursementType();

	public static Employee reimbursementMenuController(Employee employee) {
		employee = newTicketBuilder(employee);
		return employee;
	}

	private static Employee newTicketBuilder(Employee employee) {
		System.out.println("What is the reimbursement amount?");
		String amountScan = scan.nextLine();

		System.out.println(
				"What is your reimbursement type? \n" + "1.LODGING \n" + "2.TRAVEL \n" + "3.FOOD \n" + "4.OTHER");
		String typeScan = scan.nextLine().toUpperCase();

		ReimbursementType reimbursementType = null;
		try {
			reimbursementType = ReimbursementType.valueOf(typeScan);
		} catch (IllegalArgumentException e) {
			log.warn("User attempted to create a type that does not exist");
			log.warn(e.getMessage());
			System.out.println("You must choose tpye of reimburment from list. Please try again.");
			employee = newTicketBuilder(employee);
		}
		empService.createNewTicket(amountScan, reimbursementType);
		return null;
	}

}
