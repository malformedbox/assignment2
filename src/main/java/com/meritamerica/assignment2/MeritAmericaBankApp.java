package com.meritamerica.assignment2;

import java.util.Arrays;

public class MeritAmericaBankApp {
	public static void main(String[] args) {
		//i. Add 5 CDOfferings to MeritBank
    	CDOffering[] CDOfferings = new CDOffering[5];
    	
    	CDOfferings[0] = new CDOffering(1,1.8/100);
    	CDOfferings[1] = new CDOffering(2,1.9/100);
    	CDOfferings[2] = new CDOffering(3,2.0/100);
    	CDOfferings[3] = new CDOffering(5,2.5/100);
    	CDOfferings[4] = new CDOffering(10,2.2/100);
    	MeritBank.setCDOfferings(CDOfferings);
    	
		//ii. Instantiate a new AccountHolder (ah1)
		AccountHolder ah1 = new AccountHolder("John", "James", "Doe", "123-45-6789");
		
		/* iii. Add a checking account with an opening balance of $1,000 
		 * as well as a savings account with an opening balance of $10,000 to ah1
		 */
		ah1.addCheckingAccount(1000);
		ah1.addSavingsAccount(10000);
		/* iv. Add a checking account with an opening balance of $5,000 
		 * as well as a savings account with an opening balance of $50,000 to ah1
		 */
		ah1.addCheckingAccount(5000);
		ah1.addSavingsAccount(50000);
		/* v. Add a checking account with an opening balance of $50,000 
		 * as well as a savings account with an opening balance of $500,000 to ah1
		 */
		ah1.addCheckingAccount(50000);
		ah1.addSavingsAccount(500000);
		/* vi. Add a checking account with an opening balance of $5,000 
		 * as well as a savings account with an opening balance of $50,000 to ah1
		 */
		ah1.addCheckingAccount(5000);
		ah1.addSavingsAccount(50000);

		// vii. Confirm last checking and savings accounts were not created
		System.out.println();
		System.out.println("Number of checking accounts: " + ah1.getNumberOfCheckingAccounts());
		System.out.println("Number of savings accounts: " + ah1.getNumberOfSavingsAccounts());
		
		// viii. Add the best CD offering as a CD account on ah1
		ah1.addCDAccount(MeritBank.getBestCDOffering(5000), 5000);

		//ix. Add ah1 to Merit Bank’s list of account holders
		MeritBank.addAccountHolder(ah1);
		System.out.println();
		
		// x. Instantiate a new AccountHolder (ah2)
		AccountHolder ah2 = new AccountHolder("Billy", "Jean", "Johnson", "777-88,9999");
		/* xi. Add a checking account with an opening balance of $1,000 
		 * as well as a savings account with an opening balance of $10,000 to ah2
		 */
		ah2.addCheckingAccount(1000);
		ah2.addSavingsAccount(10000);

		// xii. Add the second best CD offering as a CD account on ah2
		ah2.addCDAccount(MeritBank.getSecondBestCDOffering(5000), 5000);

		// xiii. Add ah2 to Merit Bank’s list of account holders
		MeritBank.addAccountHolder(ah2);
		
		// xiv. Clear the CDs being offered by MeritBank
		MeritBank.clearCDOfferings();
		
		// xv. Instantiate a new AccountHolder (ah3)
		AccountHolder ah3 = new AccountHolder("Donkey","Kong","Junior", "111-11-1111");
		
		// xvi. Add the second best CD offering as a CD account on ah3
		ah3.addCDAccount(MeritBank.getSecondBestCDOffering(5000), 5000);
		
		// xvii. Confirm a CD account was not created on ah3
		System.out.println("Number of CD Accounts: " + ah3.getNumberOfCDAccounts());
		
		/* xviii. Add a checking account with an opening balance of $1,000 as well as a
		* savings account with an opening balance of $10,000 to ah3
		*/
		ah3.addCheckingAccount(1000);
		ah3.addSavingsAccount(10000);
		
		// xix. Add ah3 to Merit Bank’s list of account holders
		MeritBank.addAccountHolder(ah3);
		
		// xx. Get the total balance of all accounts held by Merit Bank’s account holders
		System.out.println("Merit Bank Balance total of all "
				+ "account holders and their accounts: " + MeritBank.totalBalances());
		
		System.out.println("Account Number: " + MeritBank.getNextAccountNumber());
		System.out.println("Account Number: " + MeritBank.getNextAccountNumber());
		System.out.println("Account Number: " + MeritBank.getNextAccountNumber());
		System.out.println("Account Number: " + MeritBank.getNextAccountNumber());
	}
}