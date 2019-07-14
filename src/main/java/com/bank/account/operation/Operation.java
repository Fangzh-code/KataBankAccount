package com.bank.account.operation;

import java.util.Date;

import com.bank.account.exception.BankAccountException;

public class Operation {
	private final OperationType type;
	private final Date date;
	private final double amount;

	public OperationType getType() {
		return type;
	}

	public Date getDate() {
		return date;
	}

	public double getAmount() {
		return amount;
	}

	public Operation (OperationType type, Date date, double amount) throws BankAccountException {
		if (type != OperationType.DEPOSIT && type != OperationType.WITHDRAWAL) {
			throw new BankAccountException("Illegal operation");
		}
		if (date == null) {
			throw new BankAccountException("Operation without date");
		}
		this.type = type;
		this.date = date;
		this.amount = amount;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Operation other = (Operation) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Operation [type=" + type + ", date=" + date + ", amount=" + amount + "]";
	}
		
}
