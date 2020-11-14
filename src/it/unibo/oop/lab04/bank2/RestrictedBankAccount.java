package it.unibo.oop.lab04.bank2;

public class RestrictedBankAccount extends AbstractBankAccount{

	public static final double TRANSACTION_FEE = 0.1;
	
	public RestrictedBankAccount(int usrId, double balance) {
		super(usrId, balance);
	}

	protected boolean isWithDrawAllowed(double amount) {
		return this.getBalance() >= amount;
	}

	protected double computeFee() {
        return (MANAGEMENT_FEE + (this.getNTransactions() * TRANSACTION_FEE));
	}

}
