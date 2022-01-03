package com.creditCardCreation.dao;

import java.sql.SQLException;
import java.util.List;

import com.creditCardCreation.dto.CreditScore;

public interface CreditScoreDao {

	public CreditScore findCreditScoreById(int id) throws SQLException;
	public List findCreditScoresByAccountNo(int accountNo) throws SQLException;
	public void createNewCreditScore(CreditScore newScore);
}
