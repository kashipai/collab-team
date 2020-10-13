package sampleProgram;


import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyMain {
	public static void main(String args[])
	{
		try {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		
		Transactions multimap1 = (Transactions)context.getBean("Multimaptest");
		
		multimap1.addTransaction("cust01", "Deposit - 1000");
		multimap1.addTransaction("cust01", "Deposit - 8000");
		multimap1.addTransaction("cust09", "Deposit - 1000");
		multimap1.addTransaction("cust01", "withdraw - 2000");
		
		Collection transactions = multimap1.getValues("cust01");
		System.out.println("transactions of customer cust01 :"+transactions);
		
		String custId = multimap1.getcustId();
		String trans = multimap1.gettransaction();
		
		multimap1.addTransaction(custId, trans);
		
		Collection transactions1 = multimap1.getValues(custId);
		System.out.println("transactions of customer"+custId+" :"+transactions1);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
 
	}

}
