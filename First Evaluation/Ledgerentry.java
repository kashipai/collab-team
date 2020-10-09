package samplebank;

public class Ledgerentry {
	private double amount;
	private String entrytype;
	
	
	public Ledgerentry()
	{
		entrytype="";
		amount=0.0;
	}
	
	public void addentry(String entrytype,double amount)
	{
		this.entrytype=entrytype;
		this.amount=amount;
	}
	
	public void displayentry()
	{
		System.out.println("Entry type: "+entrytype);
		System.out.println("Amount: "+ amount);
	}

}
