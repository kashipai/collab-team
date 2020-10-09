package samplebank;

public class BankAccount
{  
   private String ownername; 
   private String accountNumber ;	// account ID number
   private double balance ;	// amount on deposit
   private String Type,Subtype;
   private Double Interestrate=0.0;
   private String email;
   private String phone;
   private Ledgerentry[] accountLedger;
   private int Ledgercount;
   public BankAccount(String ownername,String acctNum, double initialBalance,String Type,String Subtype)
   {   
	  this.ownername=ownername;
      accountNumber = acctNum ;
      balance = initialBalance ;
      this.Type=Type;
      this.Subtype=Subtype;
      Ledgercount=0;
      initledger();
   }

   /**
      Gets the account number of this bank account.
      @return the account number
   */
   public String getownername()
   {   
      return ownername;
   }
   
   public String getAccountNumber()
   {   
      return accountNumber;
   }
   
   /**
      Gets the current balance of the bank account.
      @return the current balance
   */
   public double getBalance()
   {   
      return balance;
   }
   
   
   
   public String getType()
   {   
      return Type;
   }
   
   
   public String getSubtype()
   {   
      return Subtype;
   }
   

   /**
      Deposits money into the bank account.
      @param amount the amount to deposit
   */
   public void deposit(double amount)
   {  
      double newBalance = balance + amount;
      balance = newBalance;
      accountLedger[Ledgercount]=new Ledgerentry();
      accountLedger[Ledgercount].addentry("deposit", amount);
      Ledgercount+=1;
   }

   /**
      Withdraws money from the bank account.
      @param amount the amount to withdraw
   */
   public void withdraw(double amount)
   {   
      double newBalance = balance - amount;
      balance = newBalance;
      accountLedger[Ledgercount]=new Ledgerentry();
      accountLedger[Ledgercount].addentry("Withdraw", amount);
      Ledgercount+=1;
   }
   
   public double getInterestrate() {
       return Interestrate;
   }
   
   public void setInterestRate(double Interestrate) {
       this.Interestrate = Interestrate;
	}
   
   public void addInterest()
   {
	   double newBalance=balance*(balance*Interestrate/365);
	   balance=newBalance;
   }
   
   public void addInterestdeposit() {
       double interest = getBalance() * Interestrate / 100;
       deposit(interest);
   }

   public String getEmail() {
	   return email;
   }

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	private void initledger()
	{
		accountLedger=new Ledgerentry[10];
		accountLedger[Ledgercount]=new Ledgerentry();
		accountLedger[Ledgercount].addentry("Deposit",balance);
		Ledgercount+=1;
	}
	
	
	public void displayledger()
	{
		System.out.println("Account Name:"+getownername());
		System.out.println("Account Number"+getAccountNumber());
		for(int i=0;i<Ledgercount;i++)
		{
			accountLedger[i].displayentry();
		}
	}

}
