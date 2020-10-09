package evaluation;

import java.util.*;
import java.time.LocalDate;

public class AccountManager
{
	
	Scanner sc = new Scanner(System.in);
	
	Accounts account[] = new Accounts[10000];
	ArrayList <String> deposits = new ArrayList<String>();
	Map<Integer, ArrayList<String>> transactions = new HashMap<Integer, ArrayList<String>>();
	Set<Integer> customerIds = new HashSet<Integer>();
	List <Accounts> accountDetails = new ArrayList();
	String type;
	
	public static long AccountNumGenerator() {
	    while (true) {
	        long numb = (long)(Math.random() * 100000000 * 1000000);
	        if (String.valueOf(numb).length() == 13)
	            return numb;
	    }
	    
	}
	
	public void addAccount()
	{
	
		System.out.println(" 1. CaSa Account \n 2. Deposit Account\n 3. Loan Account");
		int choice1 = sc.nextInt();
		if(choice1 == 1)
		{
			System.out.println(" 1. Current Account\n 2. Savings Account");
			int Casachoice = sc.nextInt();
			if(Casachoice == 1)
				type = "Current Account";
			else
				type = "Savings account";
			if(Casachoice == 1 || Casachoice == 2)
				addCaSaAccount();
			else
				System.out.println("Invalid!!");
		}
		if(choice1 == 2)
		{
			System.out.println(" 1. Fixed deposit\n 2. Recurring deposit");
			int Depositchoice = sc.nextInt();
			
			if(Depositchoice == 1)
				type = "Fixed deposit";
			if(Depositchoice == 2)
				type = "Recurring deposit";
			if(Depositchoice == 1 || Depositchoice == 2)
				addDepositAccount();
			
			else
				System.out.println("Invalid!!");
		}
		if(choice1 == 3)
		{
			System.out.println(" 1. House Loan\n 2. Vehicle Loan\n 3. Personal Loan");
			int Loanchoice = sc.nextInt();
			
			if(Loanchoice == 1)
				type = "House Loan";
			if(Loanchoice == 2)
				type = "Vehicle Loan";
			else if(Loanchoice == 3)
				type = "Personal Loan";
			if(Loanchoice == 1 || Loanchoice == 2 || Loanchoice == 3)
				addLoanAccount();
			
			else
				System.out.println("Invalid!!");
		}

	}
	
	public void addCaSaAccount()
	{
			
			System.out.println("Customer id:");
			int custId = sc.nextInt();
			
			if(customerIds.contains(custId))
				System.out.println("Customer id isnt available. Try another id");
			else {
			customerIds.add(custId);
			
	    	long accNumber = AccountNumGenerator();
	    	
	    	account[custId] = new CaSaAccounts(accNumber);
	    	
	    	System.out.println("Name of the account holder");
	    	account[custId].holderName = sc.next();
	    	
	    	System.out.println("Initial amount deposited"); 
	    	account[custId].initialBalance = sc.nextLong();
	    	
	    	System.out.println("Enter Email id of the account holder"); 
	    	account[custId].holderEmailId = sc.next();
	    	
	    	System.out.println("Phone number of the account holder"); 
	    	account[custId].phoneNumber = sc.nextLong();
	    	
	    	account[custId].dateOfCreation = LocalDate.now();
	    	
	    	account[custId].currentBalance = account[custId].initialBalance;
	    	
	    	account[custId].accountType = type;
	    	
	    	accountDetails.add(account[custId]);
	    	
	    	System.out.println("Account number : "+accNumber+" Added successfully!");
			}
	}
	
	public void addDepositAccount()
	{
			
			System.out.println("Customer id:");
			int custId = sc.nextInt();
			
			if(customerIds.contains(custId))
				System.out.println("Customer id isnt available. Try another id");
			else {
			customerIds.add(custId);
			
	    	long accNumber = AccountNumGenerator();
	    	
	    	account[custId] = new DepositAccounts(accNumber);
	    	
	    	System.out.println("Name of the account holder");
	    	account[custId].holderName = sc.next();
	    	
	    	System.out.println("Initial amount deposited"); 
	    	account[custId].initialBalance = sc.nextLong();
	    	
	    	System.out.println("Enter Email id of the account holder"); 
	    	account[custId].holderEmailId = sc.next();
	    	
	    	System.out.println("Phone number of the account holder"); 
	    	account[custId].phoneNumber = sc.nextLong();
	    	
	    	account[custId].dateOfCreation = LocalDate.now();
	 
	    	account[custId].accountType = type;
	    	
	    	account[custId].currentBalance = account[custId].initialBalance;
	    	
	    	accountDetails.add(account[custId]);
	    	
	    	System.out.println("Account number : "+accNumber+" Added successfully!");
	    	
	    	
			}
	}
	public void addLoanAccount()
	{
			
			System.out.println("Customer id:");
			int custId = sc.nextInt();
			
			if(customerIds.contains(custId))
				System.out.println("Customer id isnt available. Try another id");
			
			else {
				customerIds.add(custId);
			
				long accNumber = AccountNumGenerator();
	    	
				account[custId] = new LoanAccounts(accNumber);
	    	
				System.out.println("Name of the account holder");
				account[custId].holderName = sc.next();
	    	
				System.out.println("Initial amount deposited"); 
				account[custId].initialBalance = sc.nextLong();
	    	
				System.out.println("Enter Email id of the account holder"); 
				account[custId].holderEmailId = sc.next();
	    	
				System.out.println("Phone number of the account holder"); 
				account[custId].phoneNumber = sc.nextLong();
	    	
				account[custId].dateOfCreation = LocalDate.now();
	    	
				account[custId].currentBalance = account[custId].initialBalance;
				account[custId].accountType = type;
	    	
				accountDetails.add(account[custId]);
	    	
				System.out.println("Account number : "+accNumber+" Added successfully!");
	    		}
			
	}
	
	
	public void depositMoney()
	{
		
		System.out.println("Enter the customer id for further transactions:");;
		int customerId = sc.nextInt();
		System.out.println(account[customerId].accountType);
		if(customerIds.contains(customerId))
		{
			if((account[customerId].accountType).equals("Fixed deposit"))
			{
				System.out.println("You cannot desposit money because it is a fixed account and you have initially depositted");
				
			}
			else {
			System.out.println("Verify the account number");
			long accNum = sc.nextLong();
			
			if(accNum != account[customerId].accountNumber)
			{
				System.out.println("Account number mismatch!!!");
			}
			
			else
			{
				System.out.println("Amount to be deposited :");
				float newDeposit = sc.nextFloat();
				
				if(newDeposit <= 0)
				{
					System.out.println("depositing amount should be positive ");
					System.exit(1);
				}
				else {
					account[customerId].currentBalance += newDeposit;
				
					deposits.add("deposit +"+newDeposit);
					transactions.put(customerId,deposits);
				
					System.out.println("Deposited successfully");	
				}
				
			}
		}
		}
		else
			System.out.println("Customer Id doesnt exist");
	}
	
	public void withdrawMoney()
	{
		
		System.out.println("Enter the customer id for further transactions:");
		int customerId = sc.nextInt();
		
		if(customerIds.contains(customerId))
		{	
			if(account[customerId] instanceof LoanAccounts || account[customerId] instanceof DepositAccounts)
			{
				System.out.println("You cannot withdraw money beacause you have a "+account[customerId].getClass().getSimpleName());
				System.exit(1);
			}
			
		else {
			System.out.println("Verify the account number");
			long accNum = sc.nextLong();
			
			if(accNum != account[customerId].accountNumber)
				System.out.println("Account number mismatch!!!");
			
			else
			{
				System.out.println("Amount to be withdrawn :");
				float withdraw = sc.nextFloat();
				
				if(withdraw <= 0)
				{
					System.out.println("withdrawing amount should be positive :");
				}
				
				else if(withdraw > account[customerId].currentBalance)
				{
					System.out.println("Withdrawing money is more than the current balance");
					System.out.println("Withdraw amount that is less than or equal to "+account[customerId].currentBalance);
					
				}
				else
				{
					account[customerId].currentBalance -= withdraw;
					
					deposits.add("withdraw -"+withdraw);
					transactions.put(customerId,deposits);
					
					System.out.println("Withdrawn successfully");	
				}
				
			}
		}
	}
		else
			System.out.println("Customer Id doesnt exist");
	}
	void printTransactions()
	{
		
		System.out.println("Enter the customer id for further transactions:");
		int customerId = sc.nextInt();
		
		
		if(customerIds.contains(customerId))
		{
			
			if((account[customerId].accountType).equals("Fixed deposit"))
			{
				System.out.println("You cannot Print the Transcation Details because it is a fixed account");
				
			}
			else {
				System.out.println("Verify the account number");
				long accNum = sc.nextLong();
			
			if(accNum != account[customerId].accountNumber)
			{
				System.out.println("Account number mismatch!!!");
			}
			else
			{
				System.out.println("Previous transactions of "+account[customerId].holderName+" with account number "+account[customerId].accountNumber);
				System.out.println(transactions.get(customerId));
				
				
			}
		}
		}
	
	}
	
	void viewBalance()
	{
		System.out.println("Enter the customer id for further transactions:");
		int customerId = sc.nextInt();
		
		if(customerIds.contains(customerId))
		{
			System.out.println("Verify the account number");
			long accNum = sc.nextLong();
			
			if(accNum != account[customerId].accountNumber)
			{
				System.out.println("Account number mismatch!!!");
			}
			
			else
			{
				float newBalance = account[customerId].accrueInterest();
				System.out.println("Balance in account:"+account[customerId].accountNumber+" ");
				System.out.println(newBalance);
			}
		}
		else
			System.out.println("Customer Id doesnt exist");
		
	}
	
	void viewInfo()
	{
		System.out.println("Enter the customer id for further transactions:");
		int customerId = sc.nextInt();
		
		if(customerIds.contains(customerId))
		{
			System.out.println("Verify the account number");
			long accNum = sc.nextLong();
			
			if(accNum != account[customerId].accountNumber)
			{
				System.out.println("Account number mismatch!!!");
			}
			else
			{
				System.out.println("Account Holder : "+account[customerId].holderName);
				System.out.println("Account number : "+account[customerId].accountNumber);
				System.out.println("Account created on : "+account[customerId].dateOfCreation);
				System.out.println("Contact details : "+account[customerId].holderEmailId+"||"+account[customerId].phoneNumber);				
			}
		}
		else
			System.out.println("Customer Id "+customerId+" is invalid");
	
	}
	
	}

