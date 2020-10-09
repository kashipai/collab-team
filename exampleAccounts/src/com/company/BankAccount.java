package com.company;


import java.util.Scanner;

public class BankAccount {
    protected String account_holder;
    protected double balance;
    protected long account_number;
    protected String email_id;
    protected long mobile_number;
    protected String account_type;
    Scanner input = new Scanner(System.in);

    BankAccount(String AccountHolder, long AccountNumber, String AccountType, double balance) {
        this.account_holder = AccountHolder;
        this.account_number = AccountNumber;
        this.account_type = AccountType;
        this.balance = balance;
    }

    public void setMailId() {
        email_id = input.next();
    }

    public void setMobileNUmber() {
        mobile_number = input.nextLong();
    }


    public void display() {
        System.out.print("\nAccount Holder Name: " + account_holder+"\n");
        System.out.print("Account Number: " + account_number+"\n");
        System.out.print("Account Type: " + account_type+"\n");
        System.out.print("Balance: " + balance+"\n");
        System.out.print("Email Id: " + email_id+"\n");
        System.out.print("Mobile NUmber: " + mobile_number+"\n");
    }
}


