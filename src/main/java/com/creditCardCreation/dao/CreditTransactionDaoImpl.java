package com.creditCardCreation.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.creditCardCreation.db.dbConnection;
import com.creditCardCreation.db.dbInitializer;
import com.creditCardCreation.dto.CreditTransaction;

/* Made by Kristin Bradley */

public class CreditTransactionDaoImpl extends dbInitializer implements CreditTransactionDao {

	private dbConnection dc;
	private Statement st;
	
	public void createCreditTransaction(CreditTransaction transaction) {
		try {
			CallableStatement st = con.prepareCall("INSERT INTO creditTrans VALUES(" + null + ", " + transaction.getAccountNo() + ", " + transaction.getNewBlance() + ", " + transaction.getTranDate() + ", " + transaction.getMoneyPaidBorrow() + ")");
			st.execute();
			st.close();
		} catch (Exception ex) {
			System.out.println(ex);
			ex.printStackTrace();
		}
	}
	
	public CreditTransactionDaoImpl() throws Exception {
		super();
		this.dc = new dbConnection();
	}
	
	public CreditTransaction findTransactionById(int id) throws SQLException {
		st = con.createStatement();
		ResultSet results = st.executeQuery("SELECT * FROM creditTrans WHERE transID=" + id);
		return results.getObject(0, CreditTransaction.class);
	}

	public List<CreditTransaction> findTransactionsByAccountNum(int accountNo) throws SQLException {
		st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM creditTrans WHERE accountNo=" + accountNo);
		ArrayList<CreditTransaction> results = new ArrayList();
		while (rs.next()) {
			results.add(new CreditTransaction(rs.getInt("transId"), rs.getInt("accountNo"), rs.getDouble("newBalance"), rs.getString("tranDate"), rs.getDouble("paidOrBorrow")));
		}
		return results;
	}

	public List<CreditTransaction> findTransactionsFromTimePeriod(int numberOfDays) throws SQLException {
		Date today = new Date();
		Calendar cal = new GregorianCalendar();
		cal.setTime(today);
		cal.add(Calendar.DAY_OF_MONTH, -numberOfDays);
		Date pastDate = cal.getTime();
		st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM creditTrans WHERE tranDate >" + pastDate.toString());
		ArrayList<CreditTransaction> results = new ArrayList();
		while (rs.next()) {
			results.add(new CreditTransaction(rs.getInt("transId"), rs.getInt("accountNo"), rs.getDouble("newBalance"), rs.getString("tranDate"), rs.getDouble("paidOrBorrow")));
		}
		return results;
	}

}
