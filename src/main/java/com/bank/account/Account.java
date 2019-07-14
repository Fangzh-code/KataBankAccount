package com.bank.account;

import java.util.List;

import com.bank.account.operation.OperationType;
import com.bank.account.statement.Statement;

public class Account {
	
	private double accountBalance;
	private List<Statement> history;
	
	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public List<Statement> getHistory() {
		return history;
	}

	public void setHistory(List<Statement> history) {
		this.history = history;
	}
	
	public Account(double accountBalance, List<Statement> history) {
		super();
		this.accountBalance = accountBalance;
		this.history = history;
	}
	
	public void doOperation(OperationType type, double amount) {
		
	}
}
