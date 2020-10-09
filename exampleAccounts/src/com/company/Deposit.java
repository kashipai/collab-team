package com.company;

public class Deposit extends BankAccount {

    Deposit(String AccountHolder, long AccountNumber, String AccountType, Double balance) {
        super(AccountHolder, AccountNumber, AccountType, balance);

    }

    public void withdraw(float amount1) {
        System.out.println("Cannot withdraw amount");
    }
}