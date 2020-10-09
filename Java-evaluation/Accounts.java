package evaluation;

import java.util.*;
import java.time.LocalDate;
import java.text.SimpleDateFormat;
import java.time.Period;

class Accounts 
{
	 long accountNumber;
	 String holderName;
	 long initialBalance;
	 String holderEmailId;
	 long phoneNumber;
	 float currentBalance;
	 LocalDate dateOfCreation;
	 float rateOfInterest;
	 String accountType;
	
	public Accounts(long accNumber)
	{
		this.accountNumber = accNumber;
	}
	
	
	void setName(String name)
	{
		this.holderName = name;
	}
	
	String getName()
	{
		return this.holderName;
	}
	
	void setBalance(long amount)
	{
		this.initialBalance = amount;
	}
	
	long getBalance()
	{
		return this.initialBalance;
	}
	
	void setPhNumber(long number)
	{
		this.phoneNumber = number;
	}
	
	long getPhNumber()
	{
		return this.phoneNumber;
	}
	
	void setMail(String mailId)
	{
		this.holderEmailId = mailId;
	}
	
	String getMail()
	{
		return this.holderEmailId;
	}
	
	void setDate(LocalDate creationDate)
	{
		this.dateOfCreation = creationDate;
	}
	
	LocalDate getDate()
	{
		return this.dateOfCreation;
	}
	
	float accrueInterest()
	{
		float altBalance = (this.currentBalance * this.rateOfInterest);
		this.currentBalance = (this.currentBalance + (altBalance)/365);
		return this.currentBalance;
	}
	
}
 
 class CaSaAccounts extends Accounts
 {
	
	 float rateOfInterest = 3;
	 
	 public CaSaAccounts(long accNumber)
	 {
		 super(accNumber);
	 }
 }

 class DepositAccounts extends Accounts
 {
	 
	 float rateOfInterest = 5;
	 static int period;
	 
	 public DepositAccounts(long accNumber)
	 {
		 super(accNumber);
	 }
	 
	 @Override
		float accrueInterest()
		{
		 	LocalDate thisDate = LocalDate.now() ;
  
		 	Period intervalPeriod = Period.between(thisDate, (this.dateOfCreation));
		 	period = intervalPeriod.getYears();
  
			this.currentBalance = (this.currentBalance + (this.currentBalance * this.rateOfInterest * period));
			return this.currentBalance;
		}
	 
 }
 
 class LoanAccounts extends Accounts
 {
	 
	 float rateOfInterest = 9;
	 
	 public LoanAccounts(long accNumber)
	 {
		 super(accNumber);
	 } 
	 
 }
