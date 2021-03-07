package com.meritamerica.assignment2;

import java.util.Date;

public class CDAccount extends BankAccount{
	private CDOffering offering;
	private double balance;
	java.util.Date startDate;
	
	public CDAccount(CDOffering offering, double balance) {
		super();
		this.offering = offering;
		this.balance = balance;
		this.startDate = new java.util.Date();
	}
	
	public double getBalance() {
		return this.balance;
	}
	public double getInterestRate() {
		return this.offering.getInterestRate();
	}
	
	public int getTerm() {
		return this.offering.getTerm();
	}
	public java.util.Date getStartDate(){
		return startDate;
	}
	
	public long getAccountNumber() {
		return super.accountNumber;
	}
	public double futureValue() {
		return getBalance() * Math.pow(1 + getInterestRate(), getTerm());
	}
	
}
