package samplebank;

import java.awt.Choice;
import java.util.Scanner;

//import com.sun.java.util.jar.pack.Instruction.Switch;

public class BankMain {
	Bank bankobj = new Bank() ;
	BankAccount AccountObj ;
	static BankMain a;
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		a=new BankMain();
		a.menu();
	}
	
	public void menu()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("\n Enter 1 for Existing account\n 2 For Open New Account");
		int choice=sc.nextInt();
		switch(choice)
		{
			case 1:System.out.println("Do You Want to see existing account details");
				   System.out.println("Enter Account Number");
			       String Acnum=sc.next();
			   	if(bankobj.find(Acnum)==null)
				{
					System.out.println("Account Not Found");
					//Acnum=sc.next();
					a.menu();
					break;
				}
			   	else
			   	{
			   		System.out.println("Details of Account Are:- ");
			   		bankobj.printAccount(Acnum);
			   		System.out.println("Select 1 for Deposit\n 2 For Withdraw\n 3 For Display Account Statements \n 4 For Display Account Information\n 5 To Add Mobile And Emailid\n");
			   		int Opchoice=sc.nextInt();
			   		
			   		if(Opchoice==1)
			   		{
			   			if(AccountObj.getSubtype().equals("Fixed"))
			   			{
			   				System.out.println("Deposit Can be Performed Only Once!!!");
			   				a.menu();
			   				break;
			   			}
			   			double amt;
			   			System.out.println("Enter the Amount to Deposit");
			   			amt=sc.nextDouble();
			   			AccountObj.deposit(amt);
			   			bankobj.printAccount(Acnum);
			   			a.menu();
			   			break;
			   		}
			   		
			   		if(Opchoice==2)
			   		{
			   			if((AccountObj.getType().equals("CaSa")))
			   			{
			   				double amt;
				   			System.out.println("Enter the Amount to Withdraw");
				   			amt=sc.nextDouble();
				   			if(amt>AccountObj.getBalance())
				   			{
				   				System.out.println("No sufficient balance");
				   				a.menu();
				   				break;
				   			}
				   			AccountObj.withdraw(amt);
				   			bankobj.printAccount(Acnum);
				   			a.menu();
				   			break;
			   			}
			   			else
			   			{
			   				System.out.println("Cannot Withdraw From "+AccountObj.getType()+" Accounts");
			   			}
			   		}
			   		
			   		
			   		if(Opchoice==3)
			   			{
			   				//next.displayledger();
			   				if((AccountObj.getType().equals("CaSa")))
			   				{
			   					AccountObj.displayledger();
			   					a.menu();
			   					break;
			   				}
			   			else
			   			{
			   				System.out.println("Can not Show Statement in "+AccountObj.getType()+" Accounts");
			   				a.menu();
			   				break;
			   			}
			   		
			   		}
			   		
			   		if(Opchoice==4)
			   		{
			   			System.out.println("Account Information");
			   			bankobj.printAccount(Acnum);
			   			a.menu();
			   			break;
			   		}
			   		
			   		if(Opchoice==5)
			   		{
			   			System.out.println("Enter Phone Number");
			   			String phone=sc.next();
			   			if(phone.length()!=10)
			   			{
			   				System.out.println("Phone Number Should Have 10 Digits");
			   				phone=sc.next();
			   			}
			   			AccountObj.setPhone(phone);
			   			System.out.println("\n");
			   			System.out.println("Enter Email");
			   			String email=sc.next();
			   			AccountObj.setEmail(email);
			   			a.menu();
			   			break;
			   		}
			   		
			   		else
			   		{
			   			System.out.println("Give Correct Choice");
			   			a.menu();
			   			break;
			   		}
					   //break;
			   	}
			       
				   
			case 2:System.out.println("Open new Account");
			       a.OpenAccount();
					break;
			default:System.out.println("Please chose correct choice");
					a.menu();
		}
	}
	
	public void OpenAccount()
	{
		Scanner sc=new Scanner(System.in);
		String names;
		String numbers;
		double bal;
		System.out.println("Enter Account Holder Name");
		names=sc.next();
		System.out.println("Enter Account Number");
		numbers=sc.next();
		if(numbers.length()!=3)
		{
			System.out.println("Account Number Should be 13 Digits");
			System.out.println("Enter Account Number Correctly");
			numbers=sc.next();
		}
		if(bankobj.find(numbers)!=null)
		{
			System.out.println("Account Number Already Exists");
			System.out.println("Enter Account Number Correctly");
			numbers=sc.next();
		}
		System.out.println("Enter Initial Deposit");
		bal=sc.nextDouble();
		System.out.println("EnterType of Account To be Opened");
		System.out.println("1 for caSa\n 2 For deposit Account\n 3 For Loan Account");
		int type1=sc.nextInt();
		String typename="";
		String subtypename="";
		int subtype;
		switch(type1)
		{
			case 1:System.out.println("You Have Selected CaSa");
				   typename="CaSa";
				   System.out.println("Select 1 for Current\n 2 For Saving");
				   subtype=sc.nextInt();
				   if(subtype==1)
				   {
					   subtypename="Current";
					   System.out.println("You have selected "+subtypename+"Account \n");
					   break;
				   }
				   else if(subtype==2)
				   {
					   subtypename="Saving";
					   System.out.println("You have selected "+subtypename+"Account \n");
					   break;
				   }
				   else
				   {
					   System.out.println("Give Correct Choices");
					   break;
				   }
				   
			case 2:System.out.println("You Have Selected Deposit Account");
			   typename="Deposit";
			   System.out.println("Select 1 for Fixed and Select 2 For Recurring");
			   subtype=sc.nextInt();
			   if(subtype==1)
			   {
				   subtypename="Fixed";
				   System.out.println("You have selected "+subtypename+"Account \n");
				   break;
			   }
			   else if(subtype==2)
			   {
				   subtypename="Recurring";
				   System.out.println("You have selected "+subtypename+"Account \n");
				   break;
			   }
			   else
			   {
				   System.out.println("Give Correct Choices");
				   break;
			   }
			   
			   
			case 3:System.out.println("You Have Selected Loan Account");
			   typename="Loan";
			   System.out.println("Select 1 for House Loan \n Select 2 For Vehicle Loan \n Select 3 For Personal Loan");
			   subtype=sc.nextInt();
			   if(subtype==1)
			   {
				   subtypename="House";
				   System.out.println("You have selected "+subtypename+"Account \n");
				   break;
			   }
			   else if(subtype==2)
			   {
				   subtypename="Vehicle";
				   System.out.println("You have selected "+subtypename+"Account \n");
				   break;
			   }
			   else if(subtype==3)
			   {
				   subtypename="Personal";
				   System.out.println("You have selected "+subtypename+"Account \n");
				   break;
			   }
			   else
			   {
				   System.out.println("Give Correct Choices");
				   break;
			   }
		}
		
		if(bankobj.find(numbers)==null)
		{
			AccountObj = new BankAccount(names,numbers,bal,typename,subtypename) ;
			bankobj.addAccount( AccountObj ) ;
			bankobj.printAccount(numbers); 	
			a.menu();
		}
		else
		{
			System.out.println("Account Already Exists");
			a.menu();
		}
	
	}

}
