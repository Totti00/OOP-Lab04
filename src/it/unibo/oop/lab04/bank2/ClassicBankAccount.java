package it.unibo.oop.lab04.bank2;

public class ClassicBankAccount extends AbstractBankAccount{

	public ClassicBankAccount(int usrId, double balance) {
		super(usrId, balance);
	}

	protected boolean isWithDrawAllowed(double amount) {
		return true;
	}

	protected double computeFee() {

		return ClassicBankAccount.MANAGEMENT_FEE;
	}
}
