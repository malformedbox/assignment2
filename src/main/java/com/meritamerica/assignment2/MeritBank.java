package com.meritamerica.assignment2;

import java.util.Arrays;
import java.util.Random;

public class MeritBank {
	BankAccount bankAccess = new BankAccount();
	private static long accountNumber = 1000;
	private static int accountHolderIndex = 0;
	private static AccountHolder[] listOfAccounts = new AccountHolder[10];
	private static CDOffering[] listOfOfferings = new CDOffering[5];
	
	public static void addAccountHolder(AccountHolder accountHolder) {
		for(int i = 0; i < listOfAccounts.length; i++) {
			if(listOfAccounts[i] == null) {
				listOfAccounts[i] = accountHolder;
				break;
			}
		}
	}
	public static AccountHolder[] getAccountHolders() {
		return listOfAccounts;
	}
	//Returns a list of the CD offerings
	public static CDOffering[] getCDOfferings() {
		return listOfOfferings;
	}
	public static CDOffering getBestCDOffering(double depositAmount) {
		if(listOfOfferings != null) {
	        double stored = futureValue(depositAmount, listOfOfferings[0].getInterestRate(), listOfOfferings[0].getTerm());
	        int indexBiggest = 0;
	        for(int i = 1; i < listOfOfferings.length; i++)
	        {
	            double tempStored = futureValue(depositAmount, listOfOfferings[i].getInterestRate(), listOfOfferings[i].getTerm());
	            if(tempStored > stored)
	            {
	                stored = tempStored;
	                indexBiggest = i;
	            }
	        }
	        return listOfOfferings[indexBiggest];
		}
        return null;
	}
	public static CDOffering getSecondBestCDOffering(double depositAmount) {
		if(listOfOfferings != null) {
	        double biggest = futureValue(depositAmount, listOfOfferings[0].getInterestRate(), listOfOfferings[0].getTerm());
	        double secondBiggest = futureValue(depositAmount, listOfOfferings[0].getInterestRate(), listOfOfferings[0].getTerm());
	        int indexBiggest = 0;
	        int indexSecondBiggest = 0;
	        for(int i = 1; i < listOfOfferings.length; i++)
	        {
	            double tempStored = futureValue(depositAmount, listOfOfferings[i].getInterestRate(), listOfOfferings[i].getTerm());
	            if(tempStored > biggest)
	            {
	                indexSecondBiggest = indexBiggest;
	                indexBiggest = i;
	            }
	            if(tempStored > secondBiggest && tempStored != biggest)
	            {
	                indexSecondBiggest = i;
	            }
	        }
	        return listOfOfferings[indexSecondBiggest];
		}
		return null;
	}
	public static void clearCDOfferings() {
		listOfOfferings = null;
	}
	//Sets the CDs offered
	public static void setCDOfferings(CDOffering[] offerings) {
		listOfOfferings = offerings;
	}
	public static long getNextAccountNumber() {
		for(int i = accountHolderIndex; i < listOfAccounts.length; i++) {
			if(listOfAccounts[i] != null) {
				accountNumber++;
				accountHolderIndex++;
				break;
			}else if(listOfAccounts[i] == null) {
				System.out.println("Reached end of account holder's list. Starting at list first account.");
				accountHolderIndex = 0;
				accountNumber = 1000;
				break;
			}
		}
		return accountNumber;
	}
	public static double totalBalances() {//Total balances of all the account holders, checking,savings,cd balance
		double totalBalance = 0;
		for(AccountHolder allAccounts : listOfAccounts) {
			if(allAccounts != null) {
				totalBalance += allAccounts.getCombinedBalance();
			}		
		}
		return totalBalance;
	}
	public static double futureValue(double presentValue, double interestRate, int term) {
		return presentValue * Math.pow(1 + interestRate, term);
	}

}
