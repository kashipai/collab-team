package DAO;



public class HolderDetails {
	static long iniAccNumber= 1000000000000L;
	private String holderName;
	private float balance;
	private String email;
	private String number;
	private String accType;
	private long  accNumber;
	public HolderDetails(String holderName, float balance,String accType) {
		super();
		this.holderName = holderName;
		this.balance += balance;
		this.accType = accType;
		this.accNumber=this.iniAccNumber;
		this.iniAccNumber += 1;
		
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setBalance(float balance) {
		this.balance = balance;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	public float getBalance() {
		return balance;
	}
	
	public long getAccNumber() {
		return accNumber;
	}
	
	@Override
	public String toString() {
		return "Account Details \nName=" + holderName + ", Balance=" + balance + ", Email=" + email + ", Mobile Number="
				+ number + ", Account Type=" + accType + ", Account Number=" + accNumber;
	}
	

}
