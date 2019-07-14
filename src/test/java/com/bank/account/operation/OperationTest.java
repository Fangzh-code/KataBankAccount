package com.bank.account.operation;


import java.util.Date;

import org.junit.Test;
import com.bank.account.exception.BankAccountException;

public class OperationTest {

	@Test(expected=BankAccountException.class)
    public void should_throw_exception_when_type_is_null() throws BankAccountException {
        new Operation(null, new Date(), 0);
    }

    @Test(expected=BankAccountException.class)
    public void should_throw_exception_when_date_is_null() throws BankAccountException {
        new Operation(OperationType.DEPOSIT, null, 0);
    }
}
