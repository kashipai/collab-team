package Bank;

import java.util.Scanner;

public class BankAccount {
	protected String AccountHolder;
	protected float balance;
	protected long AccountNumber;
	protected String EmailId;
	protected long MobileNumber;
	protected String AccountType;
	int interest_Rate=4;
	Scanner input = new Scanner(System.in);

	BankAccount(String AccountHolder, long AccountNumber, String AccountType, float balance) {
		this.AccountHolder = AccountHolder;
		this.AccountNumber = AccountNumber;
		this.AccountType = AccountType;
		this.balance = balance;
	}

	public void setMailId() {
		EmailId = input.nextLine();
	}

	public void setMobileNUmber() {
		MobileNumber = input.nextInt();
	}

	public void RateOfInterest() {
        balance=balance*(balance*interest_Rate/365);
        System.out.println("The Amount after intertest: "+balance);
	}

	public void deposit(float amount) {
		balance = balance + amount;
		System.out.println("The Amount after deposition: " + balance);
	}

	public void withdraw(float amount) {
		if (balance >= amount) {
			balance = balance - amount;
			System.out.println("The Amount after withdrawal: " + balance);
		}
		if (balance < amount) {
			System.out.println("Unable to withdraw due to insufficient funds.");
		}
	}

	public void display() {
		System.out.println("Account Holder Name: " + AccountHolder);
		System.out.println("Account Number: " + AccountNumber);
		System.out.println("Account Type: " + AccountType);
		System.out.println("Balance: " + balance);
		System.out.println("Email Id: " + EmailId);
		System.out.println("Mobile NUmber: " + MobileNumber);
	}

}
