package com.company;

class CurrentAccount extends CaSa {

    CurrentAccount(String AccountHolder, long AccountNumber, String AccountType, Double balance) {
        super(AccountHolder, AccountNumber, AccountType, balance);
    }
    public void deposit(float amount) {
        balance = balance + amount;
        System.out.print("Balance of the account:  " + balance);
    }
    public void withdraw(float amount) {
        if (balance >= amount) {
            balance = balance - amount;
            System.out.print("Balance of the account: " + balance);
        }
        if (balance==0||balance < amount) {
            System.out.println("Sorry!!! ....Insufficient funds to withdraw.");
        }
    }

    public void interestValue(Double rate_of_interest) {
    }
}


