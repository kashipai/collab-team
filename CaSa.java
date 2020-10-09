package com.company;

import java.util.List;

public class CaSa extends BankAccount {

    CaSa(String AccountHolder, long accountNumber, String AccountType, double balance) {
        super(AccountHolder, accountNumber, AccountType, balance);
    }

    public void lastTrans(List<Integer> cs_trans)
    {
        System.out.println("----Last 10 deposit/withdraw----");
        if(cs_trans.size()>=10)
        {
            for(int index=cs_trans.size()-10;index<cs_trans.size();index++)
            {
                if(cs_trans.get(index)>=0)
                    System.out.print("\nDeposit:"+cs_trans.get(index));
                else
                    System.out.print("\nWithdraw:"+cs_trans.get(index));
            }
        }
        else
            for(int index=0;index<cs_trans.size();index++)
            {
                if(cs_trans.get(index)>=0)
                    System.out.print("\nDeposit:"+cs_trans.get(index));
                else
                    System.out.print("\nWithdraw:"+(-cs_trans.get(index)));
            }
    }
}











