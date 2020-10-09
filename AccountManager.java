package Bank;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class AccountManager {

	public static void main(String[] args) {
		int menu;
		int type;
		int i = 0;
		boolean quit = false;
		Scanner input = new Scanner(System.in);
		long accountNumber1 = (long) Math.floor(Math.random() * 9000000000000L) + 1000000000000L;
		long accountNumber2 = (long) Math.floor(Math.random() * 9000000000000L) + 1000000000000L;
		long accountNumber3 = (long) Math.floor(Math.random() * 9000000000000L) + 1000000000000L;
		long accountNumber4 = (long) Math.floor(Math.random() * 9000000000000L) + 1000000000000L;
		long accountNumber5 = (long) Math.floor(Math.random() * 9000000000000L) + 1000000000000L;
		long accountNumber6 = (long) Math.floor(Math.random() * 9000000000000L) + 1000000000000L;
		long accountNumber7 = (long) Math.floor(Math.random() * 9000000000000L) + 1000000000000L;
		ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
		BankAccount customer1 = new SavingsAccount("Aman", accountNumber1, "Savings Account", 800);
		BankAccount customer2 = new CurrentAccount("Anush", accountNumber2, " Current Account", 1800);
		BankAccount customer3 = new Fixed("Prajwal", accountNumber3, "Fixed Account", 8000);
		BankAccount customer4 = new Recurring("Harsharaj", accountNumber4, "Recurring Account", 2000);
		BankAccount customer5 = new HouseLoan("Prasad", accountNumber5, "HouseLoan Account", 4000);
		BankAccount customer6 = new PersonalLoan("Pranav", accountNumber6, "PersonalLoan Account", 9000);
		BankAccount customer7 = new VehicleLoan("Kiran", accountNumber7, "VehicleLoan Account", 9000);

		accounts.add(customer1);
		accounts.add(customer2);
		accounts.add(customer3);
		accounts.add(customer4);
		accounts.add(customer5);
		accounts.add(customer6);
		accounts.add(customer7);
		System.out.println("Choose Your Account Type");
		System.out.println("Press the following:\n" + "Savings Account       - Press 1\n"
				+ "Current Account       - Press 2\n" + "Fixed Account         - Press 3\n"
				+ "Recurring Account     - Press 4\n" + "HouseLoan Account     - Press 5\n"
				+ "PersonalLoan Account  - Press 6\n" + "VehicleLoan Account   - Press 7");
		type = input.nextInt();
		System.out.println("");
		System.out.println("For the operation on the account press the following");
		System.out.println("1. Deposit Amount");
		System.out.println("2. Withdraw Amount");
		System.out.println("3. Account Information");
		System.out.println("4. Update EmailId");
		System.out.println("5. Update Mobile Number");
		System.out.println("6. View Transaction");
		System.out.println("7. Exit");
		Iterator<BankAccount> iter = accounts.iterator();
		while (iter.hasNext()) {
			switch (type) {
			case 1:
				if (iter.next() instanceof SavingsAccount) {
					float[] transaction = new float[10];
					do {
						System.out.print("Please enter your choice: ");
						menu = input.nextInt();
						switch (menu) {
						case 1:
							System.out.println("Enter the Amount to deposit:");
							int Amount = input.nextInt();
							transaction[i] = customer1.deposit(Amount);
							System.out.println("value of i" + i);
							++i;
							break;

						case 2:
							System.out.println("Enter the Amount to withdraw:");
							int Amount1 = input.nextInt();
							transaction[i] = customer1.withdraw(Amount1);
							System.out.println("value of i" + i);
							++i;
							break;

						case 3:
							customer1.display();
							break;
						case 4:
							System.out.println("Enter the EmailId");
							customer1.setMailId();
							break;
						case 5:
							System.out.println("Enter the Mobile Number");
							customer1.setMobileNUmber();
							break;
						case 6:
							System.out.println("Transactions:");
							for (i = 0; i < 10; i++) {
								if (transaction[i] > 0)
									System.out.println("The Deposits: " + transaction[i]);
								else
									System.out.println("The Withdrawal: " + transaction[i]);
							}
						case 7:
							quit = true;
							break;
						}
					} while (!quit);
				}
				break;
			case 2:
				if (iter.next() instanceof CurrentAccount) {
					float[] transaction = new float[10];
					do {
						System.out.print("Please enter your choice: ");
						menu = input.nextInt();
						switch (menu) {
						case 1:
							System.out.println("Enter the Amount to deposit:");
							int Amount = input.nextInt();
							customer2.deposit(Amount);
							break;

						case 2:
							System.out.println("Enter the Amount to withdraw:");
							int Amount1 = input.nextInt();
							customer2.withdraw(Amount1);
							break;

						case 3:
							customer2.display();
							break;
						case 4:
							System.out.println("Enter the EmailId");
							customer1.setMailId();
							break;
						case 5:
							System.out.println("Enter the Mobile Number");
							customer1.setMobileNUmber();
							break;
						case 6:
							System.out.println("Transactions:");
							for (i = 0; i < 10; i++) {
								if (transaction[i] > 0)
									System.out.println("The Deposits: " + transaction[i]);
								else
									System.out.println("The Withdrawals:" + transaction[i]);
							}
						case 7:
							quit = true;
							break;
						}
					} while (!quit);
				}
				break;
			case 3:
				if (iter.next() instanceof Fixed) {
					float[] transaction = new float[10];
					do {
						System.out.print("Please enter your choice: ");
						menu = input.nextInt();
						switch (menu) {
						case 1:
							System.out.println("Enter the Amount to deposit:");
							int Amount = input.nextInt();
							customer3.deposit(Amount);
							break;

						case 2:
							System.out.println("Enter the Amount to withdraw:");
							int Amount1 = input.nextInt();
							customer3.withdraw(Amount1);
							break;

						case 3:
							customer3.display();
							break;
						case 4:
							System.out.println("Enter the EmailId");
							customer1.setMailId();
							break;
						case 5:
							System.out.println("Enter the Mobile Number");
							customer1.setMobileNUmber();
							break;
						case 6:
							System.out.println("Transactions:");
							for (i = 0; i < 10; i++) {
								if (transaction[i] > 0)
									System.out.println("The Deposits: " + transaction[i]);
								else
									System.out.println("The Withdrawals:" + transaction[i]);
							}
						case 7:
							quit = true;
							break;
						}
					} while (!quit);
				}
				break;
			case 4:
				if (iter.next() instanceof Recurring) {
					float[] transaction = new float[10];
					do {
						System.out.print("Please enter your choice: ");
						menu = input.nextInt();
						switch (menu) {
						case 1:
							System.out.println("Enter the Amount to deposit:");
							int Amount = input.nextInt();
							customer4.deposit(Amount);
							break;

						case 2:
							System.out.println("Enter the Amount to withdraw:");
							int Amount1 = input.nextInt();
							customer4.withdraw(Amount1);
							break;

						case 3:
							customer4.display();
							break;
						case 4:
							System.out.println("Enter the EmailId");
							customer1.setMailId();
							break;
						case 5:
							System.out.println("Enter the Mobile Number");
							customer1.setMobileNUmber();
							break;
						case 6:
							System.out.println("Transactions:");
							for (i = 0; i < 10; i++) {
								if (transaction[i] > 0)
									System.out.println("The Deposits: " + transaction[i]);
								else
									System.out.println("The Withdrawals:" + (transaction[i] * -1));
							}
						case 7:
							quit = true;
							break;
						}
					} while (!quit);
				}
				break;
			case 5:
				if (iter.next() instanceof HouseLoan) {
					float[] transaction = new float[10];
					do {
						System.out.print("Please enter your choice: ");
						menu = input.nextInt();
						switch (menu) {
						case 1:
							System.out.println("Enter the Amount to deposit:");
							int Amount = input.nextInt();
							customer5.deposit(Amount);
							break;

						case 2:
							System.out.println("Enter the Amount to withdraw:");
							int Amount1 = input.nextInt();
							customer5.withdraw(Amount1);
							break;

						case 3:
							customer5.display();
							break;
						case 4:
							System.out.println("Enter the EmailId");
							customer1.setMailId();
							break;
						case 5:
							System.out.println("Enter the Mobile Number");
							customer1.setMobileNUmber();
							break;
						case 6:
							System.out.println("Transactions:");
							for (i = 0; i < 10; i++) {
								if (transaction[i] > 0)
									System.out.println("The Deposits: " + transaction[i]);
								else
									System.out.println("The Withdrawals:" + transaction[i]);
							}
						case 7:
							quit = true;
							break;
						}
					} while (!quit);
				}
				break;
			case 6:
				if (iter.next() instanceof PersonalLoan) {
					float[] transaction = new float[10];
					do {
						System.out.print("Please enter your choice: ");
						menu = input.nextInt();
						switch (menu) {
						case 1:
							System.out.println("Enter the Amount to deposit:");
							int Amount = input.nextInt();
							customer6.deposit(Amount);
							break;

						case 2:
							System.out.println("Enter the Amount to withdraw:");
							int Amount1 = input.nextInt();
							customer6.withdraw(Amount1);
							break;

						case 3:
							customer6.display();
							break;
						case 4:
							System.out.println("Enter the EmailId");
							customer1.setMailId();
							break;
						case 5:
							System.out.println("Enter the Mobile Number");
							customer1.setMobileNUmber();
							break;
						case 6:
							System.out.println("Transactions:");
							for (i = 0; i < 10; i++) {
								if (transaction[i] > 0)
									System.out.println("The Deposits: " + transaction[i]);
								else
									System.out.println("The Withdrawals:" + transaction[i]);
							}
						case 7:
							quit = true;
							break;
						}
					} while (!quit);
				}
				break;
			case 7:
				if (iter.next() instanceof VehicleLoan) {
					float[] transaction = new float[10];
					do {
						System.out.print("Please enter your choice: ");
						menu = input.nextInt();
						switch (menu) {
						case 1:
							System.out.println("Enter the Amount to deposit:");
							int Amount = input.nextInt();
							customer7.deposit(Amount);
							break;

						case 2:
							System.out.println("Enter the Amount to withdraw:");
							int Amount1 = input.nextInt();
							customer7.withdraw(Amount1);
							break;

						case 3:
							customer7.display();
							break;
						case 4:
							System.out.println("Enter the EmailId");
							customer1.setMailId();
							break;
						case 5:
							System.out.println("Enter the Mobile Number");
							customer1.setMobileNUmber();
							break;
						case 6:
							System.out.println("Transactions:");
							for (i = 0; i < 10; i++) {
								if (transaction[i] > 0)
									System.out.println("The Deposit: " + transaction[i]);
								else
									System.out.println("The Withdrawals:" + transaction[i]);
							}
						case 7:
							quit = true;
							break;
						}
					} while (!quit);
				}
				break;
			}

		}
		input.close();
	}
}
