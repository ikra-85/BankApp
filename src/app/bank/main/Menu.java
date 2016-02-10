package app.bank.main;

import java.util.ArrayList;
import java.util.Scanner;

import app.bank.accounts.*;
import app.bank.customers.Customer;

public class Menu {
	Scanner keyboard = new Scanner(System.in);
	Bank bank = new Bank();
	boolean exit;

	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.runMenu();
	}

	
	public void runMenu() {
		printHeader();
		while (!exit) {
			printMenu();
			int choice = getInput();
			performAction(choice);
		}
	}

	private void performAction(int choice) {
		switch (choice) {
		case 0:
			System.out.println("Thank you!");
			System.exit(0);
			break;
		case 1: // create an account
			createAnAccount();
			break;
		case 2: // make a deposit
			makeADeposit();
			break;
		case 3: // make a withdraw
			makeAWithdrawal();
			break;
		case 4: // list balances
			listBalance();
			break;

		default:
			System.out.println("Unknown error");
		}

	}

	private void listBalance() {
		int account = selectAccount();
		if ( account >= 0 ) {
		System.out.println (bank.getCustomer(account).getAccount());
		} else {
			System.out.println ("Invalid number selected");
		}
	}

	private void makeAWithdrawal() {
		int account = selectAccount();
		if ( account >= 0 ) {
		System.out.print("How much to withdraw? : ");
		double amount = 0;
		try {
			amount = Double.parseDouble(keyboard.nextLine());
		} catch (NumberFormatException e) {
			amount = 0;
		}
		bank.getCustomer(account).getAccount().withdraw(amount);
		
		}
		
	}

	private void makeADeposit(/*double amount*/) {
		int account = selectAccount();
		if ( account >= 0 ) {
		System.out.print("How much to deposit? : ");
		double amount = 0;
		try {
			amount = Double.parseDouble(keyboard.nextLine());
		} catch (NumberFormatException e) {
			amount = 0;
		}
		bank.getCustomer(account).getAccount().deposit(amount);
		
		}
		
	}

	private int selectAccount() {
		ArrayList<Customer> customers = bank.getCustomers();
		if ( customers.size() <= 0 ) {
			System.out.println("No customers yet");
			return -1;
		}
		for (int i = 0; i < customers.size(); i++) {
			System.out.println((i+1) + ": " + customers.get(i).basicInfo());
		}
		int account = 0;
		System.out.print("Enter the number: ");
		try {
			account = Integer.parseInt(keyboard.nextLine()) - 1;
		} catch (NumberFormatException e) {
			account = -1;
		}
		if (account < 0 || account >customers.size()) {
			account = -1;
			System.out.println("Invalid account selected ");
		}
		return account;
	}

	private void createAnAccount() {
		String firstName, lastName, ssn, accountType = "";
		double initialDeposit = 0;
		boolean valid = false;

		while (!valid) {
			System.out.print("Print an account type(savings/checking): ");
			accountType = keyboard.nextLine();

			if (accountType.equalsIgnoreCase("Checking") || accountType.equalsIgnoreCase("savings")) {
				valid = true;
			} else {
				System.out.println("Wrong input. Choose 'Savings/Checking'");
			}
		}
		System.out.print("First name: ");
		firstName = keyboard.nextLine();
		System.out.print("Last name: ");
		lastName = keyboard.nextLine();
		System.out.print("SSN: ");
		ssn = keyboard.nextLine();
		
		valid = false;
		while (!valid) {
			System.out.print("Please enter an initial deposit: ");
			try {
				initialDeposit = Double.parseDouble(keyboard.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Deposit must be a number");
			}
			if (accountType.equalsIgnoreCase("checking")) {
				if ( initialDeposit < 100) {
					System.out.println("Checking account needs 100$ minimum");
				} else {
					valid = true;
				}
			} else if (accountType.equalsIgnoreCase("savings")) {
				if ( initialDeposit < 50) {
					System.out.println("Savings account needs 50$ minimum");
				} else {
					valid = true;
				}
			}	
		}
		// now new account
		Account account;
		if ( accountType.equalsIgnoreCase("checking") ) {
			account = new Checking(initialDeposit);
		} else {
			account = new Savings(initialDeposit);
		}
		
		Customer customer = new Customer(firstName, lastName, ssn, account);
		bank.addCustomer(customer);
	}

	private int getInput() {
		int choice = -1;
		do {
			System.out.print("Enter 0-4: ");
			try {
				choice = Integer.parseInt(keyboard.nextLine());

			} catch (NumberFormatException e) {
				System.out.println("Wrong input");
			}
			if (choice < 0 || choice > 4)
				System.out.println("Wrong input. Please choose again");
		} while (choice < 0 || choice > 4);

		return choice;
	}

	private void printMenu() {
		System.out.println("Please make seletion");
		System.out.println("1. Create new account");
		System.out.println("2. Make a deposite");
		System.out.println("3. Make a withdrawal");
		System.out.println("4. List account balance");
		System.out.println("0. Exit");

	}
	
	// 
	private void printHeader() {
		System.out.println("=============================================");
		System.out.println("	Welcome to the Bank Application		");
		System.out.println("	This is Virtual Global Bank App		");
		System.out.println("=============================================");
	}
} // class
