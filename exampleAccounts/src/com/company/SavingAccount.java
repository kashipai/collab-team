package com.company;

class SavingsAccount extends CaSa {

    SavingsAccount(String AccountHolder, long accountNumber, String AccountType, double balance) {
        super(AccountHolder, accountNumber, AccountType, balance);

    }
    public void deposit(float amount) {
        balance = balance + amount;
        System.out.print("Balance of the account:  " + balance+"\n");
    }

    public void withdraw(float amount) {
        if (balance >= amount) {
            balance = balance - amount;
            System.out.print("Balance of the account: " + balance+"\n");
        }
        if (balance==0||balance < amount) {
            System.out.println("Sorry!!! ....Insufficient funds to withdraw.");
        }
    }

    public void interestValue(Double rate_of_interest)
    {
        this.balance=this.balance+(this.balance*rate_of_interest/365);
    }
}

