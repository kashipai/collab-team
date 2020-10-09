package com.company;



class PersonalLoan extends Loan {

    PersonalLoan(String AccountHolder, long AccountNumber, String AccountType, Double balance) {
        super(AccountHolder, AccountNumber, AccountType, balance);

    }
    public void deposit(float amount) {
        balance = balance + amount;
        System.out.print("Balance of the account:  " + balance);
    }

    public void interestValue(Double rate_of_interest)
    {
        this.balance=this.balance+(this.balance*rate_of_interest/365);
    }
}