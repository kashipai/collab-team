package Bank;

public class Deposit extends BankAccount {

	Deposit(String AccountHolder, long AccountNumber, String AccountType, float balance) {
		super(AccountHolder, AccountNumber, AccountType, balance);

	}

	public void withdraw(float amount1) {
		System.out.println("Cannot withdraw amount");
	}

}

class Fixed extends Deposit {

	Fixed(String AccountHolder, long AccountNumber, String AccountType, float balance) {
		super(AccountHolder, AccountNumber, AccountType, balance);
	}

	public void deposit(float amount) {
		System.out.println("Can Deposit only once");
	}

}

class Recurring extends Deposit {

	Recurring(String AccountHolder, long AccountNumber, String AccountType, float balance) {
		super(AccountHolder, AccountNumber, AccountType, balance);

	}
}