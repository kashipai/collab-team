package evaluation;

import java.time.LocalDate;
import java.util.*;

public class BankAccountManagement 
{
	public static void main(String args[])
	{
			Scanner sc = new Scanner(System.in);
			AccountManager accountManager = new AccountManager();
			int choice;
			try {
			while(true)
			{
				System.out.println("Enter your choice");
				System.out.println(" 1. Create New Account\n 2. Transact with existing account\n 3. Print previous transactions\n 4. View account info");
				choice = sc.nextInt();
				switch(choice)
				{
				
					case 1: 				
						accountManager.addAccount();
						
						break;
					
					case 2: 
						System.out.println(" 1. Deposit\n 2. Withdraw\n 3. Check balance");
						int transactChoice = sc.nextInt();
						if(transactChoice == 1) {
							accountManager.depositMoney();}
							
						if(transactChoice == 2) {
							accountManager.withdrawMoney();}
						
						if(transactChoice == 3) {
								accountManager.viewBalance();}
						
						break;
						
					case 3:
						accountManager.printTransactions();
						break;
						
					case 4:
						accountManager.viewInfo();
						break;
						
					default : 
						System.out.println("Invalid choice");
				}
				
				}
			} catch(InputMismatchException ie)
			{
				System.out.println("Input data types mismatch!!");
			}
			{
				
			}
		}
}

