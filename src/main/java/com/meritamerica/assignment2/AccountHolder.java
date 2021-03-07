package com.meritamerica.assignment2;

import java.util.Arrays;

import com.meritamerica.assignment2.CheckingAccount;
import com.meritamerica.assignment2.SavingsAccount;

public class AccountHolder {
	private String firstName;
	private String middleName; 
	private String lastName;
	private String ssn;
	private static final double BALANCE_LIMIT = 250000;
	
	MeritBank meritBank = new MeritBank();
	
	private CheckingAccount[] listOfCheckingAccounts = new CheckingAccount[10];
	private SavingsAccount[] listOfSavingsAccounts = new SavingsAccount[10];
	private CDAccount[] listOfCDAccounts = new CDAccount[10];
		
	public AccountHolder() {} //Default constructor
	public AccountHolder(String firstName, String middleName, String lastName, String ssn) {
		this.firstName = firstName;
		this.middleName = middleName; 
		this.lastName = lastName; 
		this.ssn = ssn;
	}
	public String getFirstName() {
		return this.firstName;
	}
	public void setFirstName(String firstname) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return this.middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSSN() {
		return this.ssn;
	}
	public void setSSN(String ssn) {
		this.ssn = ssn;
	}
	/* This method is used for when a CheckingAccount is opened.
	 * To open a CheckingAccount, the conditions must be met.*/
	public CheckingAccount addCheckingAccount(double openingBalance) {
		if((openingBalance + getCombinedBalance() - getCDBalance()) < BALANCE_LIMIT) {
			return addCheckingAccount(new CheckingAccount(openingBalance));	
		}
		System.out.println("Cannot add any more checking accounts. "
				+ "Combined balances from Checking and Savings "
				+ "account exceed the limit of $" + BALANCE_LIMIT);
		return null;	
	}
	/* This method is used when addCheckingAccount passes the conditions for
	 * opening more accounts.*/
	public CheckingAccount addCheckingAccount(CheckingAccount checkingAccount) {
		if((checkingAccount.getBalance() + getCombinedBalance() - getCDBalance()) < BALANCE_LIMIT) {
			for(int i = 0; i < listOfCheckingAccounts.length; i++) {
				if(listOfCheckingAccounts[i] == null) {
					listOfCheckingAccounts[i] = checkingAccount;
					break;
				}
			}
		}
		return null;
	}
	public CheckingAccount[] getCheckingAccounts() {
		return this.listOfCheckingAccounts;
	}
	public int getNumberOfCheckingAccounts() {
		int numberOfCheckingAccounts = 0;
		for(CheckingAccount i : listOfCheckingAccounts) {
			if(i!=null) {
				numberOfCheckingAccounts++;
			}
		}
		return numberOfCheckingAccounts;
	}
	public double getCheckingBalance() {
		double balance = 0;
		for(int i = 0; i < listOfCheckingAccounts.length; i++) {
			if(listOfCheckingAccounts[i] != null) {
				balance += listOfCheckingAccounts[i].getBalance();
			}
		}
		return balance;
	}
	//This method is used for when a SavingsAccount is opened
	public SavingsAccount addSavingsAccount(double openingBalance) {
		if((openingBalance + getCombinedBalance() - getCDBalance()) < BALANCE_LIMIT) {
			return addSavingsAccount(new SavingsAccount(openingBalance));
		}
		System.out.println("Cannot add any more savings accounts. "
				+ "Combined balances from Checking and Savings "
				+ "account exceed the limit of $" + BALANCE_LIMIT);
		return null;	
	}
	/* This method is used when addSavingsAccount passes the conditions for
	 * opening more accounts.*/
	public SavingsAccount addSavingsAccount(SavingsAccount savingsAccount) {
		if((savingsAccount.getBalance() + getCombinedBalance() - getCDBalance()) < BALANCE_LIMIT) {
			for(int i = 0; i < listOfSavingsAccounts.length; i++) {
				if(listOfSavingsAccounts[i] == null) {
					listOfSavingsAccounts[i] = savingsAccount;
					break;
				}
			}
		}
		return null;
	}
	public SavingsAccount []getSavingsAccounts() {
		return this.listOfSavingsAccounts;
	}
	public int getNumberOfSavingsAccounts() {
		int numberOfSavingsAccounts = 0;
		for(int i = 0; i < listOfSavingsAccounts.length; i++) {
			if(listOfSavingsAccounts[i] != null) {
				numberOfSavingsAccounts++;
			}
		}
		return numberOfSavingsAccounts;
	}
	public double getSavingsBalance() {
		double balance = 0;
		for(int i = 0; i < this.listOfSavingsAccounts.length; i++) {
			if(this.listOfSavingsAccounts[i] != null) {
				balance += this.listOfSavingsAccounts[i].getBalance();
			}
		}
		return balance;
	}
	
	//This method is used for when a CDAccount is opened with balance
	public CDAccount addCDAccount(CDOffering offering, double openingBalance) {
		if(MeritBank.getCDOfferings() ==  null) {
			return null;
		}
			return addCDAccount(new CDAccount(offering, openingBalance));
	
	}
	//This method adds a new CDAccount to the list of open CDAccounts
	public CDAccount addCDAccount(CDAccount cdAccount) {
		if(MeritBank.getCDOfferings() != null) {
			System.out.println("CD Account created on: " + cdAccount.getStartDate());
			for(int i = 0; i < listOfCDAccounts.length; i++) {
				if(listOfCDAccounts[i] == null) {
					listOfCDAccounts[i] = cdAccount;
					break;
				}
			}
		}
		return null;
	}
	public CDAccount[] getCDAccounts() {
		return this.listOfCDAccounts;
	}
	public int getNumberOfCDAccounts() {
		int numberOfCDAccounts = 0;
		for(int i = 0; i < listOfCDAccounts.length; i++) {
			if(listOfCDAccounts[i] != null) {
				numberOfCDAccounts++;
			}
		}
		return numberOfCDAccounts;
	}
	public double getCDBalance() {
		double balance = 0;
		for(int i = 0; i < listOfCDAccounts.length; i++) {
			if(listOfCDAccounts[i] != null) {
				balance += listOfCDAccounts[i].getBalance();
			}
		}
		return balance;
	}
	public double getCombinedBalance() { //Total of Checking, Savings, CDBalance
		double combinedBalance = getCheckingBalance() + getSavingsBalance() + getCDBalance();		
		return combinedBalance;
	}
	public String toString() { //ONLY FOR DISPLAY/TESTING PURPOSES
		return "Checking Balance: " + getCheckingBalance() + "\n";
	}
}