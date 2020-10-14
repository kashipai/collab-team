package springAnnotations;

public class AccountHolder {
	
	long accNumber;
	String name;
	String email;
	String city;
	Transactions transact;
	
	public AccountHolder(long accNumber, String name, String email, String city, Transactions transact)
	{
		this.accNumber = accNumber;
		this.name = name;
		this.email = email;
		this.city = city;
		this.transact = transact;
	}

	public Transactions getTransact() {
		return transact;
	}

	public void setTransact(Transactions transact) {
		this.transact = transact;
	}

	public long getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(long accNumber) {
		this.accNumber = accNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
