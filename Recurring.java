package com.company;

import java.util.List;

class Recurring extends Deposit {

    Recurring(String AccountHolder, long AccountNumber, String AccountType, double balance) {
        super(AccountHolder, AccountNumber, AccountType, balance);
    }
    public void deposit(float amount) {
        balance = balance + amount;
        System.out.print("Balance of the account:  " + balance);
    }

    public void interestValue(int terms, double rate_of_interest)
    {
        this.balance=this.balance+(this.balance*rate_of_interest*terms);
    }

    public void lastTrans(List<Integer> rc_trans)
    {
        System.out.println("----Last 10 deposit/withdraw----");
        if(rc_trans.size()>=10)
        {
            for(int index=rc_trans.size()-10;index<rc_trans.size();index++)
            {
                if(rc_trans.get(index)>=0)
                    System.out.print("\nDeposit:"+rc_trans.get(index));
                else
                    System.out.print("\nWithdraw:"+(-rc_trans.get(index)));
            }
        }
    }
}