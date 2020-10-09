package com.company;

class HouseLoan extends Loan {

    HouseLoan(String AccountHolder, long AccountNumber, String AccountType, double balance) {
        super(AccountHolder, AccountNumber, AccountType, balance);

    }
    public void deposit(float amount) {
        balance = balance + amount;
        System.out.print("Balance of the account:  " + balance+"\n");
    }

    public void interestValue(Double rate_of_interest)
    {
        this.balance=this.balance+(this.balance*rate_of_interest/365);
    }
}