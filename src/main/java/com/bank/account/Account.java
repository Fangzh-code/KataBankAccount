package com.bank.account;

import java.util.Date;
import java.util.List;

import com.bank.account.exception.BankAccountException;
import com.bank.account.operation.Operation;
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
	
	public void doOperation(OperationType type, double amount) throws BankAccountException {
		if (amount<0) {
			throw new BankAccountException("Negative amount");
		}
		
		double oldBalance = accountBalance;
		if (type == OperationType.DEPOSIT) {
			accountBalance += amount;
		} else if (type == OperationType.WITHDRAWAL) {
			accountBalance -= amount;
		} else {
			throw new BankAccountException("Illegal operation");
		}
		
		saveOperationInHitory(type, amount, oldBalance);
	}
	
	public void saveOperationInHitory(OperationType type, double amount, double oldBalance) throws BankAccountException {
		Operation operation = new Operation(type, new Date(), amount);
		Statement statement = new Statement(oldBalance, operation);
		history.add(statement);
	}
	
	public void historyPrint() {
		for (Statement statement : history) {
			statement.print(System.out);
		}
	}
}
