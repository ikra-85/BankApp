package app.bank.accounts;

public class Checking extends Account {
	private static String accountType = "Checking";
	
	public Checking(double initialDeposit) {
		super();
		this.setBalance(initialDeposit);
		
		this.checkInterest(0);
	}

	@Override
	public String toString() {
		return "Account Type: " + accountType + " account\n" +
				"Account number: " + this.getAcountNumber() + "\n" + 
				"Balance: " + this.getBalance() + "$\n" +
				"Interest rate: " + this.getInterest() + "%\n";
	}
	
	
}
