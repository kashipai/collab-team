package Bank;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class AccountManager {

	public static void main(String[] args) {
		int menu;
		int type;
		boolean quit = false;
		Scanner input = new Scanner(System.in);
		long accountNumber = (long) Math.floor(Math.random() * 9000000000000L) + 1000000000000L;
		ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
		BankAccount customer1 = new SavingsAccount("Aman", accountNumber, "Savings Account", 800);
		BankAccount customer2 = new CurrentAccount("Anush", accountNumber, " Current Account", 1800);
		BankAccount customer3 = new Fixed("Prajwal", accountNumber, "Fixed Account", 8000);
		BankAccount customer4 = new Recurring("Harsharaj", accountNumber, "Recurring Account", 2000);
		BankAccount customer5 = new HouseLoan("Prasad", accountNumber, "HouseLoan Account", 4000);
		BankAccount customer6 = new PersonalLoan("Pranav", accountNumber, "PersonalLoan Account", 9000);
		BankAccount customer7 = new VehicleLoan("Kiran", accountNumber, "VehicleLoan Account", 9000);

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
		System.out.println("3. Amount after Interest");
		System.out.println("4. Account Information");
		System.out.println("5. Update EmailId");
		System.out.println("6. Update Mobile Number");
		System.out.println("7. Exit");
		Iterator<BankAccount> iter = accounts.iterator();
		while (iter.hasNext()) {
			switch (type) {
			case 1:
				if (iter.next() instanceof SavingsAccount) {
					do {
						System.out.print("Please enter your choice: ");
						menu = input.nextInt();
						switch (menu) {
						case 1:
							System.out.println("Enter the Amount to deposit:");
							int Amount = input.nextInt();
							customer1.deposit(Amount);
							break;

						case 2:
							System.out.println("Enter the Amount to withdraw:");
							int Amount1 = input.nextInt();
							customer1.withdraw(Amount1);
							break;
						case 3:
							customer1.RateOfInterest();
							break;
						case 4:
							customer1.display();
							break;
						case 5:
							System.out.println("Enter the EmailId");
							customer1.setMailId();
							break;
						case 6:
							System.out.println("Enter the Mobile Number");
							customer1.setMobileNUmber();
							break;
						case 7:
							quit = true;
							break;
						}
					} while (!quit);
				}
				break;
			case 2:
				if (iter.next() instanceof CurrentAccount) {
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
							customer1.RateOfInterest();
							break;
						case 4:
							customer2.display();
							break;
						case 5:
							System.out.println("Enter the EmailId");
							customer1.setMailId();
							break;
						case 6:
							System.out.println("Enter the Mobile Number");
							customer1.setMobileNUmber();
							break;
						case 7:
							quit = true;
							break;
						}
					} while (!quit);
				}
				break;
			case 3:
				if (iter.next() instanceof Fixed) {
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
							customer1.RateOfInterest();
							break;
						case 4:
							customer3.display();
							break;
						case 5:
							System.out.println("Enter the EmailId");
							customer1.setMailId();
							break;
						case 6:
							System.out.println("Enter the Mobile Number");
							customer1.setMobileNUmber();
							break;
						case 7:
							quit = true;
							break;
						}
					} while (!quit);
				}
				break;
			case 4:
				if (iter.next() instanceof Recurring) {
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
							customer1.RateOfInterest();
							break;
						case 4:
							customer4.display();
							break;
						case 5:
							System.out.println("Enter the EmailId");
							customer1.setMailId();
							break;
						case 6:
							System.out.println("Enter the Mobile Number");
							customer1.setMobileNUmber();
							break;
						case 7:
							quit = true;
							break;
						}
					} while (!quit);
				}
				break;
			case 5:
				if (iter.next() instanceof HouseLoan) {
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
							customer1.RateOfInterest();
						case 4:
							customer5.display();
							break;
						case 5:
							System.out.println("Enter the EmailId");
							customer1.setMailId();
							break;
						case 6:
							System.out.println("Enter the Mobile Number");
							customer1.setMobileNUmber();
							break;
						case 7:
							quit = true;
							break;
						}
					} while (!quit);
				}
				break;
			case 6:
				if (iter.next() instanceof PersonalLoan) {
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
							customer1.RateOfInterest();
							break;
						case 4:
							customer6.display();
							break;
						case 5:
							System.out.println("Enter the EmailId");
							customer1.setMailId();
							break;
						case 6:
							System.out.println("Enter the Mobile Number");
							customer1.setMobileNUmber();
							break;
						case 7:
							quit = true;
							break;
						}
					} while (!quit);
				}
				break;
			case 7:
				if (iter.next() instanceof VehicleLoan) {
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
							customer1.RateOfInterest();
							break;
						case 4:
							customer7.display();
							break;
						case 5:
							System.out.println("Enter the EmailId");
							customer1.setMailId();
							break;
						case 6:
							System.out.println("Enter the Mobile Number");
							customer1.setMobileNUmber();
							break;
						case 7:
							quit = true;
							break;
						}
					} while (!quit);
				}
				break;
			}

		}

	}
}