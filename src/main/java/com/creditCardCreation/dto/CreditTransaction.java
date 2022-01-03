package com.creditCardCreation.dto;

import java.time.LocalDateTime;

/*
 * Created by Sarah Thompson
 */

public class CreditTransaction {
	private int id;
	private int accountNo;
	private double newBlance;
	private String tranDate;
	private double moneyPaidBorrow;
	
	
	public CreditTransaction(int accountNo, double newBlance, String tranDate,
			double moneyPaidBorrow) {
		super();
		this.accountNo = accountNo;
		this.newBlance = newBlance;
		this.tranDate = tranDate;
		this.moneyPaidBorrow = moneyPaidBorrow;
	}


	public CreditTransaction(int id, int accountNo, double newBlance, String tranDate,
			double moneyPaidBorrow) {
		this(accountNo, newBlance, tranDate, moneyPaidBorrow);
		this.id = id;
	}


	@Override
	public String toString() {
		return "Transaction Id = " + id + ", Account Number = " + accountNo + ", Blance = " + newBlance + ", Date = "
				+ tranDate + ", Money Paid or Borrow = " + moneyPaidBorrow;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getAccountNo() {
		return accountNo;
	}


	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}


	public double getNewBlance() {
		return newBlance;
	}


	public void setNewBlance(double newBlance) {
		this.newBlance = newBlance;
	}


	public String getTranDate() {
		return tranDate;
	}


	public void setTranDate(String tranDate) {
		this.tranDate = tranDate;
	}


	public double getMoneyPaidBorrow() {
		return moneyPaidBorrow;
	}


	public void setMoneyPaidBorrow(double moneyPaidBorrow) {
		this.moneyPaidBorrow = moneyPaidBorrow;
	}
	
}
