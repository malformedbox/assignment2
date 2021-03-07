package com.meritamerica.assignment2;

public class BankAccount {
	protected double balance;
	protected double interestRate;
	protected long accountNumber;
	
	public BankAccount() {} //Default constructor
	public BankAccount(double balance, double interestRate) {
		this.balance = balance;
		this.interestRate = interestRate;
	}
	public BankAccount(long accountNumber, double balance, double interestRate) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.interestRate = interestRate;
	}
	public long getAccountNumber() {
		return this.accountNumber;
	}
	public double getBalance() {
		return this.balance;
	}
	public double getInterestRate() {
		return this.interestRate;
	}
	public boolean withdraw(double amount) {
		if(amount < 0 || amount > getBalance()) {
			System.out.println("Cannot withdraw.");
			return false;
		}
		return true;
	}
	public boolean deposit (double amount) {
		if(amount < 0) {
			System.out.println("Cannot deposit.");
			return false;
		}
		return true;
	}
	public double futureValue(int years) {
		double futureValue = getBalance() * Math.pow(1 + getInterestRate(), years);
		return futureValue;
	}

}
