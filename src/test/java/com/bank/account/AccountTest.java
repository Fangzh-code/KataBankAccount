package com.bank.account;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.bank.account.exception.BankAccountException;
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

}
