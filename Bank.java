package bankApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Bank {
	   
	public static void main(String[] args) {
		String accountHolderName;
		Long accountNumber;
		double initialAmount;
		Scanner scanner = new Scanner(System.in);
		
		HashMap<Long, Accounts> accountManager = new HashMap<>();
		while(true) {
			System.out.println("Please Select Your Options:");
			System.out.println("\t\t1 : for Account Creation \n\t\t2 : for Account Statements \n\t\t3 : for deposit \n\t\t4 : for Withdraw\n\t\t5: for rate of Interest ");
			System.out.println("Enter your options here : ");
			int option = scanner.nextInt();
			
			switch (option) {
				case 1: System.out.println("Enter account holder name : ");
						accountHolderName = scanner.next();
				        System.out.println("Enter initial amount : ");
				        initialAmount = scanner.nextDouble();
				        System.out.println("Enter account type (1 : for CaSa | 2 : for Deposite | 3 : for Loan) : ");
				        int accountType = scanner.nextInt();
				        switch (accountType) {
							case 1 : System.out.println("Enter CaSa account type (1 : for Current Account | 2: Saving Account) : ");
									 int casaType = scanner.nextInt();
									 if (casaType == 1) {
										 CurrentAccount currentAccount = new CurrentAccount(accountHolderName, initialAmount,  "CurrentAccount");
										 System.out.println(currentAccount.createAccount(accountHolderName, initialAmount, "CurrentAccount" ));
										 accountManager.put(currentAccount.accountNumber,currentAccount);
									 }
									 else {
										 SavingAccount savingAccount = new SavingAccount(accountHolderName, initialAmount,  "SavingAccount");
										 System.out.println(savingAccount .createAccount(accountHolderName, initialAmount, "SavingAccount"));
										 accountManager.put(savingAccount.accountNumber, savingAccount);
									 }
								     break;
							case 2 : System.out.println("Enter Deposit account type (1 : for Fixed Deposit Account | 2: Recurring Deposit Account) : ");
									 int depositType = scanner.nextInt();
									 
									 if (depositType == 1) {
										 									 
										 FixedAccount fixedAccount = new FixedAccount(accountHolderName, initialAmount, "FixedDeposit");
										 System.out.println(fixedAccount.createAccount(accountHolderName, initialAmount, "FixedDeposit"));
										
										 accountManager.put(fixedAccount.accountNumber, fixedAccount);
									 }
									 else {
								 
										 RecurringDeposit recurringDeposit = new RecurringDeposit(accountHolderName, initialAmount, "RecurringDeposit");
										 System.out.println(recurringDeposit.createAccount(accountHolderName, initialAmount, "RecurringDeposit"));
										
										 accountManager.put(recurringDeposit.accountNumber, recurringDeposit);
									 }
								     break;
							case 3 : System.out.println("Enter Loan account type (1 : for Vehicle Loan | 2: Home Loan | 3: Personal Loan) : ");
									 int loanType = scanner.nextInt();
									 switch (loanType) {
										case 1:	 VehicleLoan vehicleLoan = new VehicleLoan(accountHolderName, initialAmount, "VehicleLoan");
												 System.out.println(vehicleLoan.createAccount(accountHolderName, initialAmount, "VehicleLoan"));
												 accountManager.put(vehicleLoan.accountNumber, vehicleLoan);											
											   break;
										case 2: HomeLoan homeLoan = new HomeLoan(accountHolderName, initialAmount, "HomeLoan");
												System.out.println(homeLoan.createAccount(accountHolderName, initialAmount, "HomeLoan"));
												accountManager.put(homeLoan.accountNumber,homeLoan);
										case 3: PersonalLoan personalLoan = new PersonalLoan(accountHolderName, initialAmount, "PersonalLoan");
												System.out.println(personalLoan.createAccount(accountHolderName, initialAmount, "PersonalLoan"));
												accountManager.put(personalLoan.accountNumber, personalLoan);
										default:System.out.println("Invalid Loan Type!!!");
											break;
									 }
									
								     break;
		
							default: System.out.println("Invalid Account Type!!!");
								break;
						}
					    break;
				case 2: System.out.println("Enter your account number :");
						accountNumber = scanner.nextLong();
					    HashMap<Long, ArrayList<String>> balanceSheet=accountManager.get(accountNumber).getAccountDetails();
					   // System.out.println(balanceSheet.get(accountNumber));
					    for(int i = 0; i < balanceSheet.size();i++) {
					    	System.out.println(balanceSheet.get(accountNumber));
					    }
				
				        break;
				case 3: System.out.println("Enter a account number : ");
				        accountNumber = scanner.nextLong();
				        
				        if (accountManager.containsKey(accountNumber)) {
				        	System.out.println("Enter deposit amount : ");
					        double depositAmount = scanner.nextDouble();
				        	System.out.println(accountManager.get(accountNumber).deposit(depositAmount));
				        }
				        else {
				        	System.out.println("Invalid Account Number For Deposit!!!");
				        }
				        break;
				case 4: System.out.println("Enter a account number : ");
				        accountNumber = scanner.nextLong();
				        
				        if (accountManager.containsKey(accountNumber)) {
				        	try{
				        		System.out.println("Enter withdraw amount : ");
				        		double withdrawAmount = scanner.nextDouble();
					        	System.out.println(accountManager.get(accountNumber).withdraw(withdrawAmount));
				        	}
					        catch (UnsupportedOperationException e) {
								// TODO: handle exception
					        	System.out.println("Withdraw not Possible!!!");
							}
				        }
				        else {
				        	System.out.println("Invalid Account Number For WithDraw!!!");
				        }
				        break;
				case 5: System.out.println("Enter a account number : ");
						accountNumber = scanner.nextLong();
				        
				        if (accountManager.containsKey(accountNumber)) {
				        	
				        		System.out.println("Enter rate of interest : ");
				        		float interestRate = scanner.nextFloat();
				        		System.out.println("Enter term Of Deposit :");
				        		float termOfDeposit = scanner.nextFloat();
					        	System.out.println(accountManager.get(accountNumber).addIntrest(interestRate, termOfDeposit));
				        }
				        else {
				        	System.out.println("Invalid Account Number For WithDraw!!!");
				        }
				        break;
				default:System.out.println("Invalid Option!!! Please Enter the valid option!!!");
					    break;
			}
			scanner.close();	
	  }
	  
	}

}
