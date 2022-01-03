package com.creditCardCreation.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.creditCardCreation.db.dbConnection;
import com.creditCardCreation.dto.CreditScore;

public class CreditScoreDaoImpl extends dbConnection implements CreditScoreDao {
	private dbConnection dc;
	private Statement st;
	public CreditScoreDaoImpl() throws Exception {
		super();
		this.dc = new dbConnection();
	}
	public CreditScore findCreditScoreById(int id) throws SQLException {
		st = con.createStatement();
		CreditScore findScore = null;
		String query ="SELECT * FROM creditscores WHERE scoreId = "+id;
		ResultSet re = st.executeQuery(query);
		while(re.next()) {
			findScore = new CreditScore(re.getInt("scoreId"), re.getInt("accountNo"), re.getInt("score"),
					re.getDate("scoreDate"));
		}
		return findScore;
	}
	public List findCreditScoresByAccountNo(int accountNo) throws SQLException {
		st = con.createStatement();
		List<CreditScore> scoreList = new ArrayList<CreditScore>();
		String query ="SELECT * FROM creditscores WHERE accountNo = "+accountNo;
		ResultSet re = st.executeQuery(query);
		while(re.next())
		{
			scoreList.add(new CreditScore(re.getInt("scoreId"), re.getInt("accountNo"), re.getInt("score"),
					re.getDate("scoreDate")));
		}

		return scoreList;
	}
	public void createNewCreditScore(CreditScore newScore) {
		try {
			CallableStatement stmt = con.prepareCall("INSERT INTO creditScores VALUES(" + null + ","+
			newScore.getAccountNo()+","+newScore.getScore()+",'"+newScore.getScoreDay()+"')");
			stmt.execute();
			stmt.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			ex.printStackTrace();
		}
	}
	
	
}
