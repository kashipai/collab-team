package Bank;

public class Loan extends BankAccount {

	Loan(String AccountHolder, long AccountNumber, String AccountType, float balance) {
		super(AccountHolder, AccountNumber, AccountType, balance);
	}

	public float withdraw(float amount) {
		System.out.println("Cannot withdraw amount");
		return 0;
	}
}

class HouseLoan extends Loan {

	HouseLoan(String AccountHolder, long AccountNumber, String AccountType, float balance) {
		super(AccountHolder, AccountNumber, AccountType, balance);
	}
}

class VehicleLoan extends Loan {

	VehicleLoan(String AccountHolder, long AccountNumber, String AccountType, float balance) {
		super(AccountHolder, AccountNumber, AccountType, balance);
	}
}

class PersonalLoan extends Loan {

	PersonalLoan(String AccountHolder, long AccountNumber, String AccountType, float balance) {
		super(AccountHolder, AccountNumber, AccountType, balance);
	}
}