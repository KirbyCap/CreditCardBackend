package com.creditCardCreation.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import com.creditCardCreation.db.dbConnection;
import com.creditCardCreation.db.dbInitializer;
import com.creditCardCreation.dto.CreditAccount;

/*
 *  Created by Sarah Thompson
 */

public class CreditAccountDaoImpl extends dbConnection implements CreditAccountDao {

	private dbConnection dc;
	private Statement st;

	public CreditAccountDaoImpl() throws Exception {
		super();
		this.dc = new dbConnection();
	}

	public boolean loginCheck(String username, String password) {
		try {
			CreditAccount tempUser = new CreditAccount(username, password);
			CreditAccount posUser = findUserByUsername(username);
			if (posUser != null && posUser.getPassword().equals(tempUser.getPassword()))
				return true;
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return false;
	}

	public CreditAccount findUserByUsername(String username) throws SQLException {
		st = con.createStatement();
		CreditAccount user = null;
		String query = "SELECT * FROM creditaccounts WHERE username = '" + username + "'";
		ResultSet re = st.executeQuery(query);
		while (re.next()) {
			user = new CreditAccount(re.getString("username"), re.getString("password"));
			user.setPassword(re.getString("password"));
		}
		return user;
	}

	public String createAccount(CreditAccount newAccount) {
		try {
			st = con.createStatement();
			String query = "SELECT * FROM creditaccounts WHERE username = '" + newAccount.getUsername() + "'";
			ResultSet re = st.executeQuery(query);
			if (re.getFetchSize() != 0) {
				return "Username taken";
			}
			query = "SELECT * FROM creditaccounts WHERE SSN = " + newAccount.getSsn();
			re = st.executeQuery(query);
			if (re.getFetchSize() != 0) {
				return "SSN in use";
			}
			CallableStatement stmt = con.prepareCall("INSERT INTO creditaccounts VALUES(" + null + ",'"
					+ newAccount.getFullName() + "','" + newAccount.getDob() + "'," + newAccount.getSsn() + ",'"
					+ newAccount.getAddress() + "','" + newAccount.getPhoneNo() + "','" + newAccount.getUsername()
					+ "','" + newAccount.getPassword() + "','" + newAccount.getCompanyName() + "',"
					+ newAccount.getSalary() + ",'" + newAccount.getEmployField() + "','" + newAccount.getEmployLength()
					+ "'," + newAccount.getAccountBalance() + "," + newAccount.getRemainingCredit() + ")");
			stmt.execute();
			st.close();
			stmt.close();

		} catch (Exception ex) {
			System.out.println(ex);
			ex.printStackTrace();
			return "Sign up failed";
		}
		return "Sign up Success";

	}

	public CreditAccount findUserByAccountNo(int accountNo) throws SQLException {
		st = con.createStatement();
		CreditAccount user = null;
		String query = "SELECT * FROM creditaccounts WHERE accountNo = " + accountNo;
		ResultSet re = st.executeQuery(query);
		while (re.next()) {
			user = new CreditAccount(re.getInt("accountNo"), re.getString("fullName"), re.getString("address"),
					re.getString("companyName"), re.getDouble("salary"), re.getString("employField"),
					re.getDouble("balance"), re.getString("username"), re.getString("password"),
					re.getDouble("creditLeft"), re.getString("employLength"), re.getString("phoneNo"), re.getInt("SSN"),
					re.getDate("DOB"));
		}
		return user;
	}

}
