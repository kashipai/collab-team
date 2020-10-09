package Bank;

public class Deposit extends BankAccount {
	int Term_of_deposit = 2;

	Deposit(String AccountHolder, long AccountNumber, String AccountType, float balance) {
		super(AccountHolder, AccountNumber, AccountType, balance);
	}

	public float withdraw(float amount1) {
		System.out.println("Cannot withdraw amount");
		return 0;
	}

	public void RateOfInterest() {
		balance = balance + balance * interest_Rate * Term_of_deposit;
		System.out.println("The Amount after intertest: " + balance);
	}
}

class Fixed extends Deposit {

	Fixed(String AccountHolder, long AccountNumber, String AccountType, float balance) {
		super(AccountHolder, AccountNumber, AccountType, balance);
	}

	public float deposit(float amount) {
		System.out.println("Can Deposit only once");
		return 0;
	}
}

class Recurring extends Deposit {

	Recurring(String AccountHolder, long AccountNumber, String AccountType, float balance) {
		super(AccountHolder, AccountNumber, AccountType, balance);
	}
}