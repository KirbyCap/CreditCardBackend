package com.creditCardCreation.dao;

import java.sql.SQLException;
import java.time.LocalDate;

import com.creditCardCreation.dto.CreditAccount;

/*
 * Author Sarah Thompson 
 */

public interface CreditAccountDao {

	public boolean loginCheck(String username, String password);

	public CreditAccount findUserByUsername(String username) throws SQLException;

	public String createAccount(CreditAccount newAccount);

	public CreditAccount findUserByAccountNo(int accountNo) throws SQLException;
}
