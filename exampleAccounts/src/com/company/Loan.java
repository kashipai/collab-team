package com.company;


import java.util.List;

public class Loan extends BankAccount {

    Loan(String AccountHolder, long AccountNumber, String AccountType, Double balance) {
        super(AccountHolder, AccountNumber, AccountType, balance);

    }
    public void withdraw(float amount) {
        System.out.println("Cannot withdraw amount");
    }

    public void lastTrans(List<Integer> la_trans)
    {
        System.out.println("----Last 10 deposit/withdraw----");
        if(la_trans.size()>=10)
        {
            for(int index=la_trans.size()-10;index<la_trans.size();index++)
            {
                if(la_trans.get(index)>=0)
                    System.out.print("\nDeposit:"+la_trans.get(index));
                else
                    System.out.print("\nWithdraw:"+la_trans.get(index));
            }
        }
        else
            for(int index=0;index<la_trans.size();index++)
            {
                if(la_trans.get(index)>=0)
                    System.out.print("\nDeposit:"+la_trans.get(index));
                else
                    System.out.print("\nWithdraw:"+(-la_trans.get(index)));
            }
    }
}

