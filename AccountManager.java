package Bank;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class AccountManager {
	static int lastAccountNumber = 0;

	/*
	 * void createAccount() { Scanner sc = new Scanner(System.in);
	 * 
	 * System.out.println("Enter Account Holder name"); AccountHolderName =
	 * sc.nextLine(); setAccountHolderName(AccountHolderName);
	 * System.out.println("Enter emailID *optinal if not press Enter"); emailID =
	 * sc.nextLine(); setEmailID(emailID);
	 * System.out.println("Enter contact *optinal if not press Enter"); contact =
	 * sc.nextInt(); setContact(contact); System.out.println("Enter Account type:");
	 * System.out.println("1.CaSa"); System.out.println("2.Deposit");
	 * System.out.println("3.Loan"); AccountType = sc.nextLine();
	 * setAccountType(AccountType); System.out.println("Enter Account SubType:"); if
	 * (AccountType.equals("CaSa")) { System.out.println("1.Current Account");
	 * System.out.println("2.Savings Account"); } else if
	 * (AccountType.equals("1.Deposit")) { System.out.println("2.Fixed Deposit");
	 * System.out.println("3.Recurring Deposit"); } else {
	 * System.out.println("1.House Loan"); System.out.println("2.Vehicle Loan");
	 * System.out.println("3.Personal Loan"); } SubAccountType = sc.nextLine();
	 * setAccountType(SubAccountType); System.out.println("Enter Initial Amount");
	 * initialAmmount = sc.nextInt(); setInitialAmmount(initialAmmount); balance =
	 * balance + initialAmmount; AccountNumber = lastAccountNumber + 1;
	 * setAccountNumber(AccountNumber); System.out.println("Your Account Number: " +
	 * AccountNumber);
	 * 
	 * }
	 */
	public static void main(String[] args) {
		double AccountNumber;
		double balance = 0;
		AccountManager am;
		/*
		 * Account account1 = new Account("Vaishnavi", 1, "mail", "CaSa",
		 * "Savings Account", 94844, 10000); Account account2 = new Account("swathi", 2,
		 * "mail2", "CaSa", "Current Account", 94844, 20000);
		 */
		ArrayList<Account> al = new ArrayList<Account>();
		// al.add(account1);
		// al.add(account2);

		int count = 1;
		int choice;
		do {
			System.out.println("Bank Account Application");
			System.out.println("1.Create Bank Account");
			System.out.println("2.Withdraw Amount");
			System.out.println("3.Deposit Amount");
			System.out.println("4.Check Balance");
			System.out.println("5.View Account Details");
			System.out.println("6.Add Email and Contact");
			System.out.println("6.Exit");
			Scanner scanner = new Scanner(System.in);
			choice = scanner.nextInt();
			switch (choice) {
			case 1:

				System.out.println("Enter Account Holder name:");
				String accountHolderName = scanner.next();

				System.out.println("Enter Account type:");
				System.out.println("1.CaSa");
				System.out.println("2.Deposit");
				System.out.println("3.Loan");
				String AccountType = scanner.next();
				System.out.println("Enter Account SubType:");
				if (AccountType.equals("CaSa")) {
					System.out.println("1.Current_Account");
					System.out.println("2.Savings_Account");
				} else if (AccountType.equals("Deposit")) {
					System.out.println("1.Fixed_Deposit");
					System.out.println("2.Recurring_Deposit");
				} else if (AccountType.equals("Loan")) {
					System.out.println("1.House_Loan");
					System.out.println("2.Vehicle_Loan");
					System.out.println("3.Personal_Loan");
				}
				String SubAccountType = scanner.next();
				System.out.println("Enter Initial Amount");
				int initialAmmount = scanner.nextInt();
				balance = balance + initialAmmount;
				Random rand = new Random();
				AccountNumber = rand.nextDouble();
				System.out.println("Your Account Number: " + AccountNumber);
				count++;
				Object a1 = new Account(accountHolderName, initialAmmount, AccountNumber, AccountType, SubAccountType,
						balance);
				al.add((Account) a1);
				// System.out.println( al.indexOf(a1) > 0 );

				for (int i = 0; i < al.size(); i++) {
					if (AccountNumber == (al.get(i).getAccountNumber())) {
						al.get(i).showDetails();
					}
				}
				break;
			case 2:
				System.out.println("Enter the Account Number");
				AccountNumber = scanner.nextInt();
				System.out.println("Enter the Amount");
				double withdrawAmount = scanner.nextInt();
				for (int i = 0; i < al.size(); i++) {
					if (AccountNumber == (al.get(i).getAccountNumber())) {
						al.get(i).withdraw(withdrawAmount);

						System.out.println("Withdraw successfull");
					} else {
						System.out.println("The Account Number is wrong.");
					}

				}

				break;
			case 3:
				System.out.println("Enter the Account Number");
				AccountNumber = scanner.nextInt();
				System.out.println("Enter the Amount");
				double depositAmount = scanner.nextInt();
				for (int i = 0; i < al.size(); i++) {
					if (AccountNumber == (al.get(i).getAccountNumber())) {
						// balance = acc.getBalance();
						al.get(i).deposit(depositAmount);
					} else {
						System.out.println("The Account Number is wrong.");
					}
				}
				break;
			case 4:
				System.out.println("Enter the Account Number");
				AccountNumber = scanner.nextInt();
				System.out.println("Current Balance:");
				for (int i = 0; i < al.size(); i++) {
					if (AccountNumber == (al.get(i).getAccountNumber())) {
						System.out.println(al.get(i).getBalance());
					} else {
						System.out.println("The Account Number is wrong.");
					}
				}
				break;
			case 5:
				System.out.println("Enter the Account Number");
				AccountNumber = scanner.nextInt();

				Iterator<Account> it = al.iterator();
				while (it.hasNext()) {
					System.out.println(it.next());
				}
				for (int i = 0; i < al.size(); i++) {
					if (AccountNumber == (al.get(i).getAccountNumber())) {
						al.get(i).showDetails();
					}
				}

				for (int i = 0; i < al.size(); i++) {
					if (AccountNumber == (al.get(i).getAccountNumber())) {

						System.out.println("Account Holder Name" + al.get(i).getAccountHolderName());
						System.out.println("Account Type:" + al.get(i).getAccountType());
						System.out.println("Sub Account Type:" + al.get(i).getSubAccountType());
						System.out.println("Contact" + al.get(i).getContact());
						System.out.println("Email ID:" + al.get(i).getEmailID());

						System.out.println(al.get(i).getBalance());
					} else {
						System.out.println("The Account Number is wrong.");
					}
				}
				break;
			case 6:

				System.out.println("Enter emailID ");
				String emailID = scanner.next();
				System.out.println("Enter contact" );
				String contact = scanner.next();

				System.exit(0);

			}
		} while (choice != 7);
	}
}
