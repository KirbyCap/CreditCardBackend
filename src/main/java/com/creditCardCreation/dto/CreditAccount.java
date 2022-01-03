package com.creditCardCreation.dto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/*
 * Created by Sarah Thompson
 */

public class CreditAccount {
	private int accountNo;
	private String fullName;
	private String address;
	private String companyName;
	private double salary;
	private String employField;
	private double accountBalance;
	private String username;
	private String password;
	private double remainingCredit;
	private String employLength;
	private String phoneNo;
	private int ssn;
	private LocalDate dob;

	public CreditAccount(String fullName, String address, String companyName, double salary, String employField,
			double accountBalance, String username, String password, double remainingCredit, String employLength,
			String phoneNo, int ssn, LocalDate dob) {
		this(username, password);
		this.fullName = fullName;
		this.address = address;
		this.companyName = companyName;
		this.salary = salary;
		this.employField = employField;
		this.accountBalance = accountBalance;
		this.remainingCredit = remainingCredit;
		this.employLength = employLength;
		this.phoneNo = phoneNo;
		this.ssn = ssn;
		this.dob = dob;
	}

	public CreditAccount(int accountNo, String username, String password) {
		this(username, password);
		this.accountNo = accountNo;
	}

	public CreditAccount(String username2, String password2) {
		this.username = username2;
		this.password = encryptPass(password2);
	}

	public CreditAccount(int accountNo, String fullName, String address, String companyName, double salary,
			String employField, double accountBalance, String username, String password, double remainingCredit,
			String employLength, String phoneNo, int ssn, Date dob) {
		super();
		this.accountNo = accountNo;
		this.fullName = fullName;
		this.address = address;
		this.companyName = companyName;
		this.salary = salary;
		this.employField = employField;
		this.accountBalance = accountBalance;
		this.username = username;
		this.password = password;
		this.remainingCredit = remainingCredit;
		this.employLength = employLength;
		this.phoneNo = phoneNo;
		this.ssn = ssn;
		try {
			this.dob = LocalDate.of(dob.getYear() + 1900, dob.getMonth() + 1, dob.getDate());
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	private String encryptPass(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte[] b = md.digest();
			StringBuilder s = new StringBuilder();
			for (int i = 0; i < b.length; i++)
				s.append(Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1));
			password = s.toString();
		} catch (NoSuchAlgorithmException e) {
			System.out.println(e);
		}
		return password;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreditAccount other = (CreditAccount) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	@SuppressWarnings("deprecation")
	@Override
	public String toString() {
		return "Account Number = " + accountNo + ", Full Name = " + fullName + ", Address = " + address
				+ "\nCompany Name = " + companyName + ", Salary = " + salary + ", Employment Field = " + employField
				+ "\nAccount Balance = " + accountBalance + ", Username = " + username + ", Remaining Credit = "
				+ remainingCredit + "\nEmployment Length = " + employLength + ", Phone Number = " + phoneNo + ", SSN = "
				+ ssn + ", DOB = " + dob;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getEmployField() {
		return employField;
	}

	public void setEmployField(String employField) {
		this.employField = employField;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getRemainingCredit() {
		return remainingCredit;
	}

	public void setRemainingCredit(double remainingCredit) {
		this.remainingCredit = remainingCredit;
	}

	public String getEmployLength() {
		return employLength;
	}

	public void setEmployLength(String employLength) {
		this.employLength = employLength;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

}
