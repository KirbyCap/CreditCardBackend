package com.creditCardCreation.db;

import java.sql.SQLException;
import java.sql.Statement;

/*
 * author Sarah Thompson
 */

public class dbInitializer extends dbConnection {

	public dbInitializer() throws Exception {
		super();
	}
	public void createDBTables() throws SQLException {
		Statement st = con.createStatement();
		String query="CREATE TABLE IF NOT EXISTS creditAccounts "
		+"(accountNo INT NOT NULL AUTO_INCREMENT PRIMARY KEY, "
		+"fullName VARCHAR(255), "
		+"DOB DATE, "
		+"SSN INTEGER, "
		+"address VARCHAR(255), "
		+"phoneNo VARCHAR(255), "
		+"username VARCHAR(255), "
		+"password VARCHAR(255), "
		+"companyName VARCHAR(255), "
		+"salary DOUBLE, "
		+"employField VARCHAR(255), "
		+"employLength VARCHAR(255), "
		+"balance DOUBLE, "
		+"creditLeft DOUBLE "
		+");";
		st.addBatch(query);
		
		query ="CREATE TABLE IF NOT EXISTS creditScores"
		+"(scoreId INT NOT NULL AUTO_INCREMENT PRIMARY KEY, "
				+"accountNo INTEGER, "
				+"score INTEGER, "
				+"scoreDate DATE"
		+");";
		st.addBatch(query);
		query="CREATE TABLE IF NOT EXISTS creditTrans"
		+"(transId INT NOT NULL AUTO_INCREMENT PRIMARY KEY, "
				+"accountNo INTEGER, "
				+"newBalance DOUBLE, "
				+"tranDate DATE, "
				+"paidOrBorrow DOUBLE"
				+");";
		st.addBatch(query);
		int[] rs =st.executeBatch();
		if(rs!=null) System.out.println("Tables created");
		else System.out.print("Tables not created");;
		st.close();
		con.close();
	}
}
