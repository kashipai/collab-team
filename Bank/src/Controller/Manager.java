package Controller;

import java.util.ArrayList;
import java.util.Scanner;

import DAO.Account;


public class Manager {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Account> accountArray = new ArrayList<Account>();
		ArrayList<String> statement = new ArrayList<String>();
	  int choice,choice1,choice2;

		do {
			System.out.println("1.Create New Account\n2.Show All Accounts\n3.Deposit to Particular Account\n4.Withdraw from Particular Account\n5.Account Statement of Particular Account\n6.Add Email and Phone number to Existing Account\n7.Add Interest\n8.Close");
			choice = scanner.nextInt();
			switch(choice) {
			case 1:
				System.out.println("1.Current Account\n2.Savings Account\n3.Fixed Account\n4.Recurring Account\n5.House Loan Account\n6.Vehicle Loan Account\n7.Personal Loan Account");
				choice1=scanner.nextInt();
				switch(choice1) {
				case 1:
					System.out.println("Enter the Name");
					String name1 = scanner.next();
					System.out.println("Enter the Initial Amount to Deposit");
					float ini1 = scanner.nextFloat();
					accountArray.add( new Account(name1,ini1,"Current Account"));
				    break;
				case 2:
					System.out.println("Enter the Name");
					String name2 = scanner.next();
					System.out.println("Enter the Initial Amount to Deposit");
					float ini2 = scanner.nextFloat();
					accountArray.add(new Account(name2,ini2,"Savings Account")) ;
				    break;
				case 3:
					System.out.println("Enter the Name");
					String name3 = scanner.next();
					System.out.println("Enter the Initial Amount to Deposit");
					float ini3 = scanner.nextFloat();
					accountArray.add( new Account(name3,ini3,"Fixed Account"));
				    break;
				case 4:
					System.out.println("Enter the Name");
					String name4 = scanner.next();
					System.out.println("Enter the Initial Amount to Deposit");
					float ini4 = scanner.nextFloat();
					accountArray.add( new Account(name4,ini4,"Recurring Account"));
				    break;
				case 5:
					System.out.println("Enter the Name");
					String name5 = scanner.next();
					System.out.println("Enter the Initial Amount to Deposit");
					float ini5 = scanner.nextFloat();
					accountArray.add( new Account(name5,ini5,"House Loan Account"));
				    break;
				case 6:
					System.out.println("Enter the Name");
					String name6 = scanner.next();
					System.out.println("Enter the Initial Amount to Deposit");
					float ini6 = scanner.nextFloat();
					accountArray.add(new Account(name6,ini6,"Vehicle Loan Account"));
					break;
				case 7:
					System.out.println("Enter the Name");
					String name7 = scanner.next();
					System.out.println("Enter the Initial Amount to Deposit");
					float ini7 = scanner.nextFloat();
					accountArray.add( new Account(name7,ini7,"Personal Loan Account"));
				    break;
					
					
				
				}
				
				break;
			case 2:
				if(accountArray.size() == 0) {
					System.out.println("No Account Exists");
				}else {
				for(int i=0; i<accountArray.size();i++) {
					accountArray.get(i).showAccount();
				}
				}
				break;
			case 3:
				if(accountArray.size()!=0) {
					System.out.println("Enter the AccNo");
					long accno = scanner.nextLong();
					for(int i=0;i<accountArray.size();i++) {
						if(accountArray.get(i).getAccno()==accno) {
							System.out.println("Enter the Amount to be Deposit");
						    int amt = scanner.nextInt();
							accountArray.get(i).Deposit(amt);
						}else {
							System.out.println("Account not Found");
						}
					}
					}else
						System.out.println("No Account Exists");
					
					break;
			
			case 4:
				if(accountArray.size()!=0) {
					System.out.println("Enter the AccNo");
					long accno = scanner.nextLong();
					for(int i=0;i<accountArray.size();i++) {
						if(accountArray.get(i).getAccno()==accno) {
							System.out.println("Enter the Amount to be Withdraw");
						    int amt = scanner.nextInt();
							accountArray.get(i).Withdraw(amt);
						}else {
							System.out.println("Account not Found");
						}
					}
					}else
						System.out.println("No Account Exists");
					
					break;
			case 5:
				if(accountArray.size()!=0) {
					System.out.println("Enter the AccNo");
					long accno = scanner.nextLong();
					for(int i=0;i<accountArray.size();i++) {
						if(accountArray.get(i).getAccno()==accno) {
				          statement=accountArray.get(i).getStatement();
				          for(int t=0;t<statement.size();t++) {
				        	  System.out.println(statement.get(t)); 
				          }
							
						}else {
							System.out.println("Account not Found");
						}
					}
					}else
						System.out.println("No Account Exists");
					
					break;
			case 6:
				if(accountArray.size()!=0) {
				  String regex1 = "(0/91)?[6-9][0-9]{9}";   
				      
				System.out.println("Enter the AccNo");
				long accno = scanner.nextLong();
				for(int i=0;i<accountArray.size();i++) {
					if(accountArray.get(i).getAccno()==accno) {
						System.out.println("Enter the email");
						String email = scanner.next();
						
						System.out.println("Enter the Number");
						String number = scanner.next();
						boolean result1 = number.matches(regex1);
						

						if( result1) {
						accountArray.get(i).addDetails(email,number);
						System.out.println("Email and Phone Number Added Successfully");
						}else {
							System.out.println("Invalid Phone Number");
						}
					}else {
						System.out.println("Account not Found");
					}
				}
				}else
					System.out.println("No Account Exists");
				
				break;
			case 7:
				System.out.println("1.Add Annual Interest\n2.Add Deposit Interest");
				choice2=scanner.nextInt();
				switch(choice2) {
				case 1:
					if(accountArray.size()!=0) {
						System.out.println("Enter the AccNo");
						long accno = scanner.nextLong();
						for(int i=0;i<accountArray.size();i++) {
							if(accountArray.get(i).getAccno()==accno) {
								System.out.println("Enter the Interest in Percent");
								int per1 = scanner.nextInt();
					          accountArray.get(i).getAnnualInterest(per1);
					          
								
							}else {
								System.out.println("Account not Found");
							}
						}
						}else
							System.out.println("No Account Exists");
						
						break;
				case 2:
					if(accountArray.size()!=0) {
						System.out.println("Enter the AccNo");
						long accno = scanner.nextLong();
						for(int i=0;i<accountArray.size();i++) {
							if(accountArray.get(i).getAccno()==accno) {
							System.out.println("Enter the Interest in Percent");
								float per2 = scanner.nextFloat();
								System.out.println("Enter the Term of Deposit");
								int term = scanner.nextInt();
					          accountArray.get(i).getDepositInterest(per2,term);
					          
								
							}else {
								System.out.println("Account not Found");
							}
						}
						}else
							System.out.println("No Account Exists");
						
						break;
				}
				break;
		    case 8:
		    	System.out.println("Closing");
		        break;
				
				
			}
			
		}while(choice!=8);
		
		scanner.close();

	}

}
