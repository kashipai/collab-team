package com.company;

class Fixed extends Deposit {

    Fixed(String AccountHolder, long AccountNumber, String AccountType, double balance) {
        super(AccountHolder, AccountNumber, AccountType, balance);
    }

    public void interestValue(int terms, double rate_of_interest)
    {
        this.balance=this.balance+(this.balance*rate_of_interest*terms);
    }
}
