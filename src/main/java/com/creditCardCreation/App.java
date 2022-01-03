package com.creditCardCreation;

import java.time.LocalDate;
import java.util.Date;

import com.creditCardCreation.dao.CreditAccountDaoImpl;
import com.creditCardCreation.dao.CreditScoreDaoImpl;
import com.creditCardCreation.db.dbConnection;
import com.creditCardCreation.db.dbInitializer;
import com.creditCardCreation.dto.CreditAccount;
import com.creditCardCreation.dto.CreditScore;
import com.creditCardCreation.dto.CreditTransaction;

/*
 * Created by Sarah Thompson
 */

public class App 
{
    @SuppressWarnings("deprecation")
	public static void main( String[] args ) throws Exception
    {
    	dbConnection dbc = new dbConnection();
    	
    	//dbInitializer dbi = new dbInitializer();
    	//dbi.createDBTables();
    	

    	LocalDate d = LocalDate.of(2002, 6, 7);
    	//CreditAccount nca = new CreditAccount("Jane Doe","180 fake Dr.","fake company",
    	//		100000.20,"field",100.00,"user22","password",100.50,"5 months","(123)-123-4567",223456789,d);
    //	CreditAccountDaoImpl dbca = new CreditAccountDaoImpl();
    	//System.out.println(nca);
    //	System.out.println(dbca.createAccount(nca));
    //	System.out.println(dbca.logginCheck("user21","password"));
    	//System.out.println(dbca.findUserByAccountNo(3));
    	
    	//CreditTransaction nct = new CreditTransaction(1,1,10,"1/2/2003",20);
    	//System.out.println("\n"+nct);
    	
    	CreditScore ncs = new CreditScore(1,650,d);
    //	System.out.println("\n"+ncs);
    	CreditScoreDaoImpl csdi= new CreditScoreDaoImpl();
    	csdi.createNewCreditScore(ncs);
    	//System.out.println(csdi.findCreditScoreById(1));
    	System.out.println(csdi.findCreditScoresByAccountNo(1));
     	dbc.close();
    }
}
