package com.bank.account.operation;

import java.util.Date;

public class Operation {
	private final OperationType type;
	private final Date date;
	private final double amount;
	
	public Operation (OperationType type, Date date, double amount) {
		this.type = type;
		this.date = date;
		this.amount = amount;
	}
		
}
