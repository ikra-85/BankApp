package app.bank.customers;

import app.bank.accounts.Account;

public class Customer {

	private final String firstName;
	private final String lastName;
	private final Account account;
	private final String ssn;

	public Customer(String firstName, String lastName, String ssn, Account account) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.ssn = ssn;
		this.account = account;
	}

	@Override
	public String toString() {
		return "Customer's Name:" + firstName + " " + lastName + "\n"
				+ "SSN:" + ssn + "/n"
				+ account;
	}

	public String basicInfo() {
return "Name: " + firstName + " " + lastName + ". SSN: " + ssn + ". Account: "	+ account.getAcountNumber();
	}
	
	public Account getAccount() {
		return account;
	}
	
	
	
}
