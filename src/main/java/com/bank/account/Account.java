package com.bank.account;

import java.util.List;

import com.bank.account.statement.Statement;

public class Account {
	
	private double accountBalance;
	private List<Statement> history;
	
	public Account(double accountBalance, List<Statement> history) {
		super();
		this.accountBalance = accountBalance;
		this.history = history;
	}
}
