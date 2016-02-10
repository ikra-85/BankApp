package app.bank.accounts;

public class Account {
	private double balance = 0;
	private double interest = 0.02;
	private int accountNumber;
	private static int numberOfAccounts = 100_000;
	
	public Account() {
		accountNumber = numberOfAccounts++;
	}
	
	public double getBalance() {
		return balance;
	}
	public double getInterest() {
		return interest * 100;
	}
	public int getAcountNumber() {
		return accountNumber;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public void setInterest(double interest) {
		this.interest = interest;
	}
	
	public void withdraw (double amount) {
		if ( amount + 5 > balance ) {
			System.out.println("Not enough money");
			return;
		}
		
		balance -= amount + 5;
		System.out.println("You have withdrawn $" + amount + " and incurred a fee of 5$");
		System.out.println("Current balance: " + balance + "$");
	}

	public void deposit (double amount) {
		if ( amount <= 0) {
			System.out.println("Must be positive");
			return;
		} 
		checkInterest(0);
		amount = amount + amount * interest ;
		balance+=amount;
		System.out.println("You have deposited $" + amount + " with an interest rate of "+
				(interest * 100) + "%");
		System.out.println("Current balance: " + balance + "$");
	}

	public void checkInterest(double amount) {
		if ( balance + amount > 10_000 ) {
			interest = 0.05;
		} else {
			interest = 0.02;
		}
	}
}
