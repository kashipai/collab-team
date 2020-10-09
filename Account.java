package Bank;

public class Account {
	Customer customer;

	public Account(String accountHolderName, int initialAmmount, double accountNumber, String accountType,
			String subAccountType, double balance) {
		// TODO Auto-generated constructor stub
		customer = new Customer(accountHolderName, initialAmmount, accountNumber, accountType, subAccountType, balance);
	}

	public void showDetails() {
		System.out.println(customer.toString());
	}

	public void withdraw(double withdrawAmount) {
		double balance = customer.getBalance();
		if (customer.getAccountType().equals("CaSa")) {
			if (withdrawAmount > balance) {
				System.out.println("Insufficient Funds!!!");
			} else {
				balance -= withdrawAmount;
				customer.setBalance(balance);
				System.out.println("Balance:" + customer.getBalance());
				System.out.println("withdrawal Successfull");

			}
		}

	}

	public void deposit(double depositAmount) {
		// TODO Auto-generated method stub
		String SubAccountType = customer.getSubAccountType();
		double balance = customer.getBalance();
		if (SubAccountType.equals("Fixed_Deposit")) {
			final double fixedDeposit = balance + depositAmount;
			customer.setBalance(balance);
			System.out.println("Balance:" + customer.getBalance());
		} else {
			balance = balance + depositAmount;
			customer.setBalance(balance);
			System.out.println("Balance:" + customer.getBalance());
		}

	}

	public double getAccountNumber() {
		return customer.getAccountNumber();
	}

	public double getBalance() {
		// TODO Auto-generated method stub
		return customer.getBalance();
	}

	public String getAccountHolderName() {
		// TODO Auto-generated method stub
		return customer.getAccountHolderName();
	}

	public String getAccountType() {
		// TODO Auto-generated method stub
		return customer.getAccountType();
	}

	public String getSubAccountType() {
		// TODO Auto-generated method stub
		return customer.getSubAccountType();
	}

	public String getContact() {
		// TODO Auto-generated method stub
		return customer.getContact();
	}

	public String getEmailID() {
		// TODO Auto-generated method stub
		return customer.getEmailID();
	}

	public void test() {
		System.out.println(customer.getAccountHolderName());
	}

	public void addDetails(String email, String contact) {

		customer.setEmailID(email);
		customer.setContact(contact);

	}
}
