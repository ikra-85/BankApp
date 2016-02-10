package app.bank.accounts;

public class Savings extends Account {
	private static String accountType = "Saving";
	
	public Savings(double initialDeposit) {
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
