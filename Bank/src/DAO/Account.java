package DAO;

import java.util.ArrayList;

public class Account {

	private HolderDetails holder;
	private ArrayList<String> statement = new ArrayList<String>();
	
	public Account(String name,float init,String acctype) {
		holder= new HolderDetails(name,init,acctype);
		System.out.println("Account Created Successfully");
		statement.add("Initail Deposited amount:"+init+" Balance"+holder.getBalance());
	}
	
	
	

	public void showAccount() {
		// TODO Auto-generated method stub
		System.out.println(holder.toString());
	}
	public void addDetails(String email,String number) {
		
		holder.setEmail(email);
		holder.setNumber(number);
		
	}
	

	public long getAccno() {
		// TODO Auto-generated method stub
		return holder.getAccNumber();
	}
	
	public void Deposit(float amount) {
		String acctype = holder.getAccType();
		if(acctype.equals("Fixed Account")) {
			
			
			System.out.println("Deposit Limit Exceeds");
			}
				
			
		else {
			float balance = holder.getBalance();
			balance += amount;
			holder.setBalance(balance);
			statement.add("Deposited amount:"+amount+" Balance"+holder.getBalance()); 
			System.out.println("Amount Deposited Successfully");
		}
		
		
	}
	
	public ArrayList getStatement() {
		return statement;
		
	}

	public void Withdraw(int amt) {
		float balance = holder.getBalance();
		String acctype = holder.getAccType();
		if(acctype.equals("Savings Account")|| acctype.equals("Current Account")) {
		if(amt<=0) {
			System.out.println("Invalid Amount");
		}
		else if( amt>balance) {
			System.out.println("Insufficient Balance");
			
		}else {
		balance -= amt;
		holder.setBalance(balance);
		statement.add("Withdraw amount:"+amt+" Balance"+holder.getBalance());
		System.out.println("Amount withdrawn Successfully");
		}
		}else {
			System.out.println("Cannot Withdraw Amount from "+acctype);
		}
		
	}




	public void getAnnualInterest(float per1) {
		// TODO Auto-generated method stub
		float per=per1/100;
		float balance = holder.getBalance();
		balance =balance + (balance * per/365);
		holder.setBalance(balance);
		statement.add("Annual Interest rate:"+per1+" Balance"+holder.getBalance());
		System.out.println("Interest Added Successfully");
		
	}




	public void getDepositInterest(float per, int term) {
		// TODO Auto-generated method stub
		float per1=per/100;
		float balance = holder.getBalance();
		balance += balance * per1 *term;
		holder.setBalance(balance);
		statement.add("Deposit Interest rate:"+per+" Balance"+holder.getBalance());
		System.out.println("Interest Added Successfully");

	}

}
