package com.bank.account.statement;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.Test;
import com.bank.account.exception.BankAccountException;
import com.bank.account.operation.Operation;
import com.bank.account.operation.OperationType;

public class StatementTest {

	@Test(expected=BankAccountException.class)
	public void should_throw_exception_when_operation_is_null_then_() throws BankAccountException {
		new Statement(2000, null);
	}
	
	@Test
	public void when_statement_is_printed_then_should_print_value_in_printer() throws BankAccountException {
		
		Operation operation = new Operation(OperationType.DEPOSIT, new Date(), 1000);
		Statement statement = new Statement(2000, operation);
		statement.print(System.out);
		
	}

}
