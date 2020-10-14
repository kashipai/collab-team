package springAnnotations;

public class Transactions 
{

	String transDetails;
	long amount;
	
	public Transactions(String type,long amount)
	{
		this.transDetails = type;
		this.amount = amount;
	}
	

	public long getAmount() {
		return amount;
	}


	public void setAmount(long amount) {
		this.amount = amount;
	}


	public String getTransDetails() {
		return transDetails;
	}
	public void setTransDetails(String transDetails) {
		this.transDetails = transDetails;
	}

}
