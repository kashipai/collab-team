package Bank;

public class Customer {
	public String AccountHolderName;
	int initialAmmount;
	double AccountNumber;
	String emailID;
	String AccountType;
	String SubAccountType;
	String contact;
	int amount;
	protected double balance = 0;
	
	public Customer(String accountHolderName, int initialAmmount, double accountNumber2, String accountType,
			String subAccountType, double balance) {
		super();
		AccountHolderName = accountHolderName;
		this.initialAmmount = initialAmmount;
		AccountNumber = accountNumber2;
		AccountType = accountType;
		SubAccountType = subAccountType;
		this.balance = balance;
	}

	public String getAccountHolderName() {
		return AccountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		AccountHolderName = accountHolderName;
	}

	public int getInitialAmmount() {
		return initialAmmount;
	}

	public void setInitialAmmount(int initialAmmount) {
		this.initialAmmount = initialAmmount;
	}

	public double getAccountNumber() {
		return AccountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		AccountNumber = accountNumber;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getAccountType() {
		return AccountType;
	}

	public void setAccountType(String accountType) {
		AccountType = accountType;
	}

	public String getSubAccountType() {
		return SubAccountType;
	}

	public void setSubAccountType(String subAccountType) {
		SubAccountType = subAccountType;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact2) {
		this.contact = contact2;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account Details: [AccountHolderName=" + AccountHolderName + ", AccountNumber=" + AccountNumber + ", emailID="
				+ emailID + ", AccountType=" + AccountType + ", SubAccountType=" + SubAccountType + ", contact="
				+ contact + ", balance=" + balance + "]";
	}
	
	
	
	
}
