package com.creditCardCreation.dto;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

/*
 * Created by Sarah Thompson
 */

public class CreditScore {
	private int id;
	private int accountNo;
	private int score;
	private LocalDate scoreDay;
	
	public CreditScore( int accountNo, int score, LocalDate scoreDay) {
		super();
		this.accountNo = accountNo;
		this.score = score;
		this.scoreDay = scoreDay;
	}

	public CreditScore(int id, int accountNo, int score, Date date) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.accountNo=accountNo;
		this.score=score;
		this.scoreDay=LocalDate.of(date.getYear()+1900, date.getMonth()+1, date.getDate());
	}


	@Override
	public String toString() {
		return "Credit Score Id = " + id + ", Account Number = " + accountNo + ", score = " + score + ", Date = " + scoreDay;
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


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public LocalDate getScoreDay() {
		return scoreDay;
	}


	public void setScoreDay(LocalDate scoreDay) {
		this.scoreDay = scoreDay;
	}
	

}
