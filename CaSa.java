package Bank;

public class CaSa extends BankAccount {

	CaSa(String AccountHolder, long accountNumber, String AccountType, float balance) {
		super(AccountHolder, accountNumber, AccountType, balance);
	}
}

class CurrentAccount extends CaSa {

	CurrentAccount(String AccountHolder, long AccountNumber, String AccountType, float balance) {
		super(AccountHolder, AccountNumber, AccountType, balance);
	}

}

class SavingsAccount extends CaSa {

	SavingsAccount(String AccountHolder, long accountNumber, String AccountType, float balance) {
		super(AccountHolder, accountNumber, AccountType, balance);

	}

}
