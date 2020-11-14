package it.unibo.oop.lab04.bank2;

import it.unibo.oop.lab04.bank.BankAccount;

public abstract class AbstractBankAccount implements BankAccount{

	public static final double ATM_TRANSACTION_FEE = 1;
	public static final double MANAGEMENT_FEE = 5;

	
    private double balance;
    private int nTransactions;
    private final int usrID;
    
	public AbstractBankAccount(final int usrId, final double balance) {
		this.usrID = usrId;
        this.balance = balance;
        this.nTransactions = 0;
	}
	
    private boolean checkUser(final int id) {
        return this.usrID == id;
    }
	
	public void computeManagementFees(int usrID) {
		final double feeAmount = this.computeFee();
		if (this.checkUser(usrID) && this.isWithDrawAllowed(feeAmount)) {
            this.balance -= computeFee();
            this.resetTransactions();
        }
	}

	public void deposit(int usrID, double amount) {
		this.transactionOp(usrID, amount);	
	}
	
	private void transactionOp(final int usrID, final double amount) {
        if (checkUser(usrID)) {
            this.balance += amount;
            this.incTransactions();
        }
    }

	public void depositFromATM(int usrID, double amount) {
        this.deposit(usrID, amount - AbstractBankAccount.ATM_TRANSACTION_FEE);
	}

    private void incTransactions() {
        this.nTransactions++;
    }
	
	public double getBalance() {
		return this.balance;
	}

	public int getNTransactions() {
		return this.nTransactions;
	}
	
    protected final void resetTransactions() {
        this.nTransactions = 0;
    }

    protected final void setBalance(final double amount) {
        this.balance = amount;
    }

	public void withdraw(int usrID, double amount) {
        if(this.isWithDrawAllowed(amount)) {
        	this.transactionOp(usrID, -amount);
        }
	}

	public void withdrawFromATM(int usrID, double amount) {
        this.withdraw(usrID, amount + AbstractBankAccount.ATM_TRANSACTION_FEE);
	}
	
	protected abstract boolean isWithDrawAllowed (final double amount);
	
	protected abstract double computeFee();
}
