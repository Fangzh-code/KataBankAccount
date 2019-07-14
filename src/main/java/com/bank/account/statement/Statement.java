package com.bank.account.statement;

import com.bank.account.operation.Operation;

public class Statement {
	private final double balanceBefore;
	private final Operation operation;
	private final double balanceAfter;
	
	public Statement(double balanceBefore, Operation operation, double balanceAfter) {
		super();
		this.balanceBefore = balanceBefore;
		this.operation = operation;
		this.balanceAfter = balanceAfter;
	}

}
