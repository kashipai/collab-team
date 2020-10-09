package bankApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

abstract class Accounts{
	protected String accountHolderName;
	public long accountNumber;
	protected double initialAmount;
        protected double balance;
        protected String accountType;
        protected int numberOfDeposite = 1;
        protected int numberOfWithdraw = 1;
        protected ArrayList<String> arrayList = new ArrayList<>();
        protected HashMap<Long,ArrayList<String> > balanceChart = new HashMap<>();
	abstract String deposit(double depositAmount);
	abstract String withdraw(double withdrawAmount);
	abstract double addIntrest(float interestRate, float termOfDeposit);
	
	private Long getAccountNumber() {
	    Random random = new Random();
	    char[] digits = new char[13];
	    digits[0] = (char) (random.nextInt(9) + '1');
	    for (int i = 0; i < 13; i++) {
	        digits[i] = (char) (random.nextInt(10) + '0');
	    }
	    return Long.parseLong(new String(digits));
    }
	
	 public String createAccount(String accountHolderName, double initialAmount, String accountType) {
	    	this.accountHolderName = accountHolderName;
	    	this.initialAmount = initialAmount;
	    	this.accountType = accountType;
	    	balance = initialAmount;
	    	this.accountNumber = getAccountNumber();
	    	this.arrayList.add("initial Amount: : "+initialAmount+"\t balance : "+this.balance );
	    	this.balanceChart.put(this.accountNumber,this.arrayList);
			return "created account successfully and your account number is : "+ this.accountNumber;
	    }
	    HashMap<Long, ArrayList<String>> getAccountDetails() {
			// TODO Auto-generated method stub
			return this.balanceChart;
		}

}
class CaSa extends Accounts{
	 String deposit(double depositeAmount) {
	    	this.balance = this.balance + depositeAmount;
	    	this.numberOfDeposite += 1;
	    	this.arrayList.add("depositeAmount : "+depositeAmount+"\t balance : "+this.balance );
	    	this.balanceChart.put(this.accountNumber,this.arrayList);
	    	return "deposited successfully!!";
	}
	    
    public String withdraw(double withdrawAmount) {
    	this.balance = this.balance - withdrawAmount;
    	this.arrayList.add("withdraw Amount :"+ withdrawAmount+"\t balance :"+this.balance );
    	this.balanceChart.put(this.accountNumber,this.arrayList);
    	return "Withdraw Successfully!!!";
    }

	
	@Override
	double addIntrest(float interestRate, float termOfDeposit) {
		// TODO Auto-generated method stub
		this.balance = this.balance + ( ( this.balance * interestRate ) / 365 );
		this.arrayList.add("interest :"+ interestRate+"\t balance :"+this.balance );
		this.balanceChart.put(this.accountNumber,this.arrayList);
		return this.balance;
	}

}

class CurrentAccount extends CaSa{

	public CurrentAccount(String accountHolderName, double initialAmount, String accountType) {
		this.accountHolderName = accountHolderName;
		this.accountType = accountType;
		this.initialAmount = initialAmount;
	}

	
}
class SavingAccount extends CaSa{
	public SavingAccount(String accountHolderName, double initialAmount, String accountType) {
		this.accountHolderName = accountHolderName;
		this.accountType = accountType;
		this.initialAmount = initialAmount;
	}
	
}

class Deposit extends Accounts{

	@Override
	String deposit(double depositAmount) {
		// TODO Auto-generated method stub
		this.arrayList.add("depositeAmount : "+depositAmount+"\t balance : "+this.balance );
    	this.balanceChart.put(this.accountNumber,this.arrayList);
		return "Deposited successfully!!";
	}

	@Override
	String withdraw(double withdrawAmount) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Withdraw Not Possible!!!");
	}

	@Override
	double addIntrest(float interestRate, float termOfDeposit) {
		// TODO Auto-generated method stub
		this.balance = this.balance + ( ( this.balance * interestRate ) / 365 );
		this.arrayList.add("interest :"+ interestRate+"\t balance :"+this.balance );
		this.balanceChart.put(this.accountNumber,this.arrayList);
		return this.balance;
	}
	
}
class FixedAccount extends Deposit{
	public FixedAccount(String accountHolderName, double initialAmount, String accountType) {
		this.accountHolderName = accountHolderName;
		this.accountType = accountType;
		this.initialAmount = initialAmount;
	}
	@Override
        String deposit(double depositeAmount) {
		if(this.numberOfDeposite == 1) {
	            this.balance = this.balance + depositeAmount;
	            this.arrayList.add("depositeAmount : "+depositeAmount+"\t balance : "+this.balance );
    	            this.balanceChart.put(this.accountNumber,this.arrayList);
	            this.numberOfDeposite += 1;
    	            return "deposited successfully!!!";    	
		}
		else
			throw new UnsupportedOperationException("Fixed deposit more than once not possible");
    }
	  
}
class RecurringDeposit extends Deposit{
	public RecurringDeposit(String accountHolderName, double initialAmount, String accountType) {
		this.accountHolderName = accountHolderName;
		this.accountType = accountType;
		this.initialAmount = initialAmount;
	}
  
}
class Loan extends Accounts{
	@Override
	 String deposit(double depositAmount) {
		// TODO Auto-generated method stub
		this.balance = this.balance + depositAmount;
		this.numberOfDeposite += 1;
		this.arrayList.add("depositeAmount : "+depositAmount+"\t balance : "+this.balance );
        	this.balanceChart.put(this.accountNumber,this.arrayList);
		return "deposited Successfully!!!";
	}

	@Override
	String withdraw(double withdrawAmount) {
		// TODO Auto-generated method stub
		 throw new UnsupportedOperationException("Withdraw Not Possible!!!");
	}

	@Override
	double addIntrest(float interestRate, float termOfDeposit) {
		// TODO Auto-generated method stub
		this.balance = this.balance + ( ( this.balance * interestRate ) / 365 );
		this.arrayList.add("interest :"+ interestRate+"\t balance :"+this.balance );
		this.balanceChart.put(this.accountNumber,this.arrayList);
		return this.balance;
	}
}
class VehicleLoan extends Loan{
	public VehicleLoan(String accountHolderName, double initialAmount, String accountType) {
		this.accountHolderName = accountHolderName;
		this.accountType = accountType;
		this.initialAmount = initialAmount;
	}
	
}
class HomeLoan extends Loan{
	public HomeLoan(String accountHolderName, double initialAmount, String accountType) {
		this.accountHolderName = accountHolderName;
		this.accountType = accountType;
		this.initialAmount = initialAmount;
	}
}
class PersonalLoan extends Loan{
	public PersonalLoan(String accountHolderName, double initialAmount, String accountType) {
		this.accountHolderName = accountHolderName;
		this.accountType = accountType;
		this.initialAmount = initialAmount;
	}
	
}
