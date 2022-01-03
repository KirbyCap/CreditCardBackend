package com.creditCardCreation.dao;

import java.sql.SQLException;
import java.util.List;

import com.creditCardCreation.dto.CreditTransaction;

public interface CreditTransactionDao {
	
	public void createCreditTransaction(CreditTransaction transaction);
	
	public CreditTransaction findTransactionById(int id) throws SQLException;
	
	public List<CreditTransaction> findTransactionsByAccountNum(int accountNo) throws SQLException;
	
	public List<CreditTransaction> findTransactionsFromTimePeriod(int numberOfDays) throws SQLException;
}
