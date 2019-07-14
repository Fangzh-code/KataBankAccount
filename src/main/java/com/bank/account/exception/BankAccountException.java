package com.bank.account.exception;

public class BankAccountException extends Exception{

	public BankAccountException() {
        super();
    }

    public BankAccountException(String message, Throwable cause) {
        super(message, cause);
    }

    public BankAccountException(String message) {
        super(message);
    }

    public BankAccountException(Throwable cause) {
        super(cause);
    }
}
