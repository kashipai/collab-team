import java.util.ArrayList;

import java.util.Scanner;


public class AccountManager {
	public String AccountHolderName; 
	protected int InitialAmount=0;
	public static String AccountType;
	protected static long AccountNumber;
	protected static Float Balance;
	static Scanner sc=new Scanner(System.in);	
	
	
	 static String GetAccountType() {
    	 
		    System.out.println("Enter the Account Type:");
		    AccountType=sc.nextLine();
		    return  AccountType;
		    
				
  }
	 
	 String GetAccountHolderName() {
		 
			System.out.println("Enter Your Name:");
			AccountHolderName=sc.nextLine();
			return AccountHolderName;
				 
	  }
			
	 Float GetInitialBalance() {
	    	 
		   System.out.println("Enter the Initial Balance:");
		   Balance=sc.nextFloat();
		   return Balance;
		  
		   
	 }	
     
	 
	public static  void main(String args[]){
		
	AccountManager accountmanager=new AccountManager();
	AccountManager.GetAccountType();
	accountmanager.GetAccountHolderName();
	accountmanager.GetInitialBalance();
	
//to generate 13 digit account number
	long num = (long)(Math.random() * 100000000 * 1000000);
	long num1 = (long)(Math.random() * 100000000 * 1000000);
	long num2 = (long)(Math.random() * 100000000 * 1000000);
	
	
    
      	
    ArrayList<AccountManager> accountmanager1=new ArrayList<AccountManager>();
    accountmanager1.add(new CaSa(num));
    accountmanager1.add(new Deposit(num1));
    accountmanager1.add(new Loan(num2));
    
	for (AccountManager s : accountmanager1) 
    {

    	System.out.println(s.GetInitialBalance()+" "+s.GetAccountHolderName()+" "+GetAccountType());
    	System.out.println();
    }

     
    if(AccountManager.AccountType=="CaSa") {
    	
		System.out.println("Do yoy Want to deposit Ammount?");
		String depo=sc.nextLine();
		
		if(depo=="yes") {
			System.out.println("Enter the amount");
			int cash=sc.nextInt();
			CaSa.deposit(cash);	
		}
		System.out.println("Do you Want to Withdraw amount?");
		String withdraw=sc.nextLine();
		
		if(withdraw=="yes") {
			System.out.println("Enter the amount");
			int amountfor=sc.nextInt();
			CaSa.WithDraw(amountfor);	
		}
		
	}
		
	
 if(AccountManager.AccountType=="FixedDeposit") {
		
		System.out.println("Do you want to Query the balance");
		String view=sc.nextLine();
		
		if(view=="yes") {
			FixedDeposit.getBalance();	
		}
		System.out.println("Do yoy Want to deposit initial Ammount?");
		String depo=sc.nextLine();
		
		if(depo=="yes") {
			System.out.println("Enter the amount");
			int cash=sc.nextInt();
			FixedDeposit.deposit(cash);	
		}
		
}   
 
 if(AccountManager.AccountType=="Recurring") {
		
		System.out.println("Do you want to Query the balance");
		String view=sc.nextLine();
		
		if(view=="yes") {
			Recurring.getBalance();	
		}
		System.out.println("Do yoy Want to deposit initial Ammount?");
		String depo=sc.nextLine();
		
		if(depo=="yes") {
			System.out.println("Enter the amount");
			int cash=sc.nextInt();
			Recurring.deposit(cash);	
		}
		
}   
 
 if(AccountManager.AccountType=="Loan") {
 
		
		System.out.println("Do you want to Query the balance");
		String view=sc.nextLine();
		
		if(view=="yes") {
			Loan.getBalance();	
		}
		System.out.println("Do yoy Want to deposit Ammount?");
		String depo=sc.nextLine();
		
		if(depo=="yes") {
			System.out.println("Enter the amount");
			int cash=sc.nextInt();
			Loan.deposit(cash);	
		}
		
	}
}
}
class CaSa extends AccountManager{
	
	static int numberofdeposition=0;
	int n=0;
	static int count=0;
	static int[] array=new int[10];
	

	CaSa(long NewAccountNumber){
		if(String.valueOf(NewAccountNumber).length() == 13) {
			
			AccountNumber=NewAccountNumber;
		}
		
	}
	
	static Float SetBalance(Float balancE) {
		 Balance=balancE;
		 System.out.println("The availabe balance is:");
		 return Balance;
		   
	 }	
	

    static void deposit(int Amount) {
    	if(Amount>0) {
    		Balance+=Amount;
    		
    		int n=numberofdeposition++;
    		int c=count++;
    		numberofdeposition=numberofdeposition-1;
    		if(n==numberofdeposition+1) {
    			array[c-1]=Amount;
    			if(c==10) {
    				DisplayLast10Transaction();
    				c=0;
    			}
    			
    		}
    		
    	}
        SetBalance(Balance);
	
	}
    	
    
    
    static void DisplayLast10Transaction() {
		   for(int i=0;i<10;i++) {
		    System.out.println(array[i]);
		}
    }
    	
 
	static void WithDraw(int RequiredAmount) {
	        if ( RequiredAmount> getBalance()) {
	            System.out.println("Current Balance: " + getBalance() + "\nThewithdrawal  cannot be made due to insufficient amount.");
	        }
	         else
	         {
	            SetBalance(getBalance() - RequiredAmount);
	    
	         }
	}
	
	static Float getBalance() {
		return Balance;
	}
	
}

class Deposit extends AccountManager{

	Deposit(long NewAccountNumber){
		if(String.valueOf(NewAccountNumber).length() == 13) {
			
			AccountNumber=NewAccountNumber;
		}
		
	}
}

class FixedDeposit extends Deposit{

	
	FixedDeposit(long NewAccountNumber) {
		super(NewAccountNumber);
	}	
	

    static void deposit(int Amount) {
    	if(Balance>0) {
    		System.out.println("You can not Deposit amount");
    	}     
	}
    
    static Float getBalance() {
		return Balance;
	}
    
}

class Recurring extends Deposit{
	static int numberofdeposition=0;
	int n=0;
	static int count=0;
	static int[] array=new int[10];
	
	
	Recurring(long NewAccountNumber) {
		super(NewAccountNumber);
	}


	static Float SetBalance(Float balancE) {
		 Balance=balancE;
		 System.out.println("The availabe balance is:");
		 return Balance;
		   
	 }	
	

    static void deposit(int Amount) {
    	if(Amount>0) {
    		Balance+=Amount;
    		int n=numberofdeposition++;
    		int c=count++;
    		numberofdeposition=numberofdeposition-1;
    		if(n==numberofdeposition+1) {
    			array[c-1]=Amount;
    			if(c==10) {
    				DisplayLast10Transaction();
    				c=0;
    			}
    			
    		}

    	}
        SetBalance(Balance);
	
	}
    
    static Float getBalance() {
		return Balance;
	}
    
    
    static void DisplayLast10Transaction() {
		   for(int i=0;i<10;i++) {
		    System.out.println(array[i]);
		}
    	
    
}

}
 class Loan extends AccountManager{
	static int numberofdeposition=0;
	int n=0;
	static int count=0;
	static int[] array=new int[10];

	
	Loan(long NewAccountNumber) {
			if(String.valueOf(NewAccountNumber).length() == 13) {
				
				AccountNumber=NewAccountNumber;
			}
			
		}


	static Float SetBalance(Float balancE) {
		 Balance=balancE;
		 System.out.println("The availabe balance is:");
		 return Balance;
		   
	 }	
	

    static void deposit(int Amount) {
    	if(Amount>0) {
    		Balance+=Amount;
    		int n=numberofdeposition++;
    		int c=count++;
    		numberofdeposition=numberofdeposition-1;
    		if(n==numberofdeposition+1) {
    			array[c-1]=Amount;
    			if(c==10) {
    				DisplayLast10Transaction();
    				c=0;
    			}
    			
    		}

    	}
        SetBalance(Balance);
	
	}

    static void DisplayLast10Transaction() {
		   for(int i=0;i<10;i++) {
		    System.out.println(array[i]);
		}
    }
    
    
    static Float getBalance() {
		return Balance;
	}
    
 }



	 
	 
		

		


