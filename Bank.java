package sneha.springJDBCTemplate;

public class BankAccount {
	
	private String accountId;
	private String name;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountId() {
		return accountId;
	}
	

	@Override
	public String toString() {
		return "BankAccount [accountId=" + accountId + ", name=" + name + "]";
	}
	
}
