package it.unibo.oop.lab04.bank;

public class ExtendedStrictBankAccount extends SimpleBankAccount {

    private static final double TRANSACTION_FEE = 0.1;
	
	public ExtendedStrictBankAccount(int usrID, double balance) {
		super(usrID, balance);
	}
	
    private boolean isWithdrawAllowed(final double amount) {
        return this.getBalance() > amount;
    }

    public void computeManagementFees(final int usrID) {
        final double feeAmount = MANAGEMENT_FEE + (this.getNTransactions() * TRANSACTION_FEE);
        if (checkUser(usrID) && isWithdrawAllowed(feeAmount)) {
            this.setBalance(this.getBalance()-feeAmount);
            this.resetTransactions();
        }
    }
    
    public void withdraw(final int usrID, final double amount) {
        if (isWithdrawAllowed(amount)) {
        	
            super.withdraw(usrID, amount);
        }
    }

}
