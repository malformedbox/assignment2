package com.meritamerica.assignment2;

import java.text.DecimalFormat;

public class CheckingAccount extends BankAccount{//extends BankAccount
	
	public CheckingAccount(double openingBalance) {
		super(openingBalance, 0.0001);
	}
}