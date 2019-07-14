package com.bank.account.statement;

import java.io.PrintStream;

import com.bank.account.exception.BankAccountException;
import com.bank.account.operation.Operation;
import com.bank.account.operation.OperationType;

public class Statement {
	private final double balanceBefore;
	private final Operation operation;
	private final double balanceAfter;
	
	public double getBalanceBefore() {
		return balanceBefore;
	}

	public Operation getOperation() {
		return operation;
	}

	public double getBalanceAfter() {
		return balanceAfter;
	}
	

	public Statement(double balanceBefore, Operation operation) throws BankAccountException {
		super();
		if (operation == null) {
			throw new BankAccountException("No operation");
		}
		this.balanceBefore = balanceBefore;
		this.operation = operation;
		double balance = balanceBefore;
		if (operation.getType() == OperationType.DEPOSIT) {
			balance = balanceBefore+operation.getAmount();
		} else if (operation.getType() == OperationType.WITHDRAWAL) {
			balance = balanceBefore-operation.getAmount();
		}
		this.balanceAfter = balance;
		
	}
	
	public void print(PrintStream printer) {
		StringBuilder builder = new StringBuilder();
		
		builder.append("Account do operation : ");
		builder.append(operation.getType() + " ");
		builder.append(operation.getAmount() + "\t");
		builder.append(operation.getDate() + " \n");
		builder.append("Account balance from ");
		builder.append(balanceBefore + " ");
		builder.append("to ");
		builder.append(balanceAfter + " \n\n");
		
		printer.println(builder.toString());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(balanceAfter);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(balanceBefore);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((operation == null) ? 0 : operation.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Statement other = (Statement) obj;
		if (Double.doubleToLongBits(balanceAfter) != Double.doubleToLongBits(other.balanceAfter))
			return false;
		if (Double.doubleToLongBits(balanceBefore) != Double.doubleToLongBits(other.balanceBefore))
			return false;
		if (operation == null) {
			if (other.operation != null)
				return false;
		} else if (!operation.equals(other.operation))
			return false;
		return true;
	}
	
	

}
