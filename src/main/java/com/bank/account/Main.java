package com.bank.account;

import java.util.ArrayList;

import com.bank.account.exception.BankAccountException;
import com.bank.account.operation.OperationType;
import com.bank.account.statement.Statement;

public class Main {

	public static void main(String[] args) throws BankAccountException {
		Account account = new Account(0, new ArrayList<Statement>());
		
		account.doOperation(OperationType.DEPOSIT, 1500);
		account.doOperation(OperationType.DEPOSIT, 500);
		account.doOperation(OperationType.DEPOSIT, 2500);
		account.doOperation(OperationType.WITHDRAWAL, 3500);
		
		account.historyPrint();

		System.out.println("Account balance : " + account.getAccountBalance());
	}

}
