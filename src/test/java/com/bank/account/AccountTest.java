package com.bank.account;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import com.bank.account.exception.BankAccountException;
import com.bank.account.operation.Operation;
import com.bank.account.operation.OperationType;
import com.bank.account.statement.Statement;

public class AccountTest {

	Account account;

	@Test
	public void account_balance_should_increases_500_when_account_do_a_deposit_500() throws BankAccountException {
		//Given balance 0
		account = new Account(0, new ArrayList<Statement>());
		
		//When deposit 500
		account.doOperation(OperationType.DEPOSIT, 500);
		
		//Then balance 500
		assertEquals(500,  account.getAccountBalance());
	}
	
	@Test
	public void account_balance_should_decreases_1500_when_account_do_a_withdrawal_1500() throws BankAccountException {
		//Given balance 0
		account = new Account(2000, new ArrayList<Statement>());
		
		//When deposit 500
		account.doOperation(OperationType.WITHDRAWAL, 1500);
		
		//Then balance 500
		assertEquals(500,  account.getAccountBalance());
	}
	
	@Test(expected=BankAccountException.class)
	public void should_return_exception_When_do_a_deposit_negative() throws BankAccountException{
		//Given balance 0
		account = new Account(1000, new ArrayList<Statement>());
		
		//When deposit -500
		account.doOperation(OperationType.DEPOSIT, -500);
		
		//Then BankAccountException
	}
	
	@Test(expected=BankAccountException.class)
	public void should_return_exception_When_do_a_withdrawal_negative() throws BankAccountException{
		//Given balance 0
		account = new Account(2000, new ArrayList<Statement>());
		
		//When deposit 500
		account.doOperation(OperationType.WITHDRAWAL, -1500);

		//Then BankAccountException
	}
	
	@Test
	public void should_have_statement_deposited_when_do_a_deposited() throws BankAccountException {
		//Given
		account = new Account(0, new ArrayList<Statement>());
		
		//When deposit 500
		account.doOperation(OperationType.DEPOSIT, 3500);
		
		//Then have statement
		Operation operation = new Operation(OperationType.DEPOSIT, new Date(), 3500);
		Statement statement = new Statement(0, operation);
		assertEquals(true, account.getHistory().contains(statement));
	}
	
	@Test
	public void should_have_statement_withdrawal_when_do_a_withdrawal() throws BankAccountException {
		//Given
		account = new Account(6666, new ArrayList<Statement>());
		
		//When deposit 500
		account.doOperation(OperationType.WITHDRAWAL, 3500);
		
		//Then have statement
		Operation operation = new Operation(OperationType.WITHDRAWAL, new Date(), 3500);
		Statement statement = new Statement(6666, operation);
		assertEquals(true, account.getHistory().contains(statement));
	}

}
