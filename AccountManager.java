package com.company;
import java.util.List;
import java.util.Scanner;



import java.util.ArrayList;
import java.util.Iterator;

public class AccountManager {

    public static void main(String[] args) {
        int menu,select_type,terms;
        boolean quit = false;
        String user_name;
        String account_type;
        Double balance,rate_of_interest=0.075;
        long account_number;
        Scanner input = new Scanner(System.in);
        List<Integer> cs_trans=new ArrayList<>();
        List<Integer> rc_trans=new ArrayList<>();
        List<Integer> la_trans=new ArrayList<>();
        SavingsAccount customer1=null;
        CurrentAccount customer2=null;
        Fixed customer3=null;
        Recurring customer4=null;
        HouseLoan customer5 = null;
        PersonalLoan customer6=null;
        VehicleLoan customer7=null;


        ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
        boolean exit = false;
        do
        {
            System.out.print("Create accounts\n1.Savings Account\n2.Current Account\n3.Fixed Account\n4.Recurring Account\n5.HouseLoan Account\n6.PersonalLoan Account\n7.VehicleLoan Account\n8.Go Back\nEnter your choice:");
            int acc_choice= input.nextInt();
            switch (acc_choice)
            {
                case 1:
                    System.out.println("Enter your name");
                    user_name=input.next();
                    System.out.println("Enter Account type");
                    account_type=input.next();
                    System.out.println("Enter initial amount");
                    balance=input.nextDouble();
                    account_number = (long) Math.floor(Math.random() * 9000000000000L) + 1000000000000L;
                    customer1 = new SavingsAccount(user_name, account_number, account_type, balance);
                    accounts.add(customer1);
                    break;
                case 2:
                    System.out.println("Enter your name");
                    user_name=input.next();
                    System.out.println("Enter Account type");
                    account_type=input.next();
                    System.out.println("Enter initial amount");
                    balance=input.nextDouble();
                    account_number = (long) Math.floor(Math.random() * 9000000000000L) + 1000000000000L;
                    customer2 = new CurrentAccount(user_name, account_number, account_type,balance);
                    accounts.add(customer2);
                    break;
                case 3:
                    System.out.println("Enter your name");
                    user_name=input.next();
                    System.out.println("Enter Account type");
                    account_type=input.next();
                    System.out.println("Enter initial amount");
                    balance=input.nextDouble();
                    System.out.println("Enter terms of deposit");
                    terms=input.nextInt();
                    account_number = (long) Math.floor(Math.random() * 9000000000000L) + 1000000000000L;
                    customer3 = new Fixed(user_name, account_number, account_type, balance);
                    accounts.add(customer3);
                    break;
                case 4:
                    System.out.println("Enter your name");
                    user_name=input.next();
                    System.out.println("Enter Account type");
                    account_type=input.next();
                    System.out.println("Enter initial amount");
                    balance=input.nextDouble();
                    System.out.println("Enter terms of deposit");
                    terms=input.nextInt();
                    account_number = (long) Math.floor(Math.random() * 9000000000000L) + 1000000000000L;
                    customer4 = new Recurring(user_name, account_number, account_type, balance);
                    accounts.add(customer4);
                    break;
                case 5:
                    System.out.println("Enter your name");
                    user_name=input.next();
                    System.out.println("Enter Account type");
                    account_type=input.next();
                    System.out.println("Enter initial amount");
                    balance=input.nextDouble();
                    account_number = (long) Math.floor(Math.random() * 9000000000000L) + 1000000000000L;
                    customer5 = new HouseLoan(user_name, account_number, account_type, balance);
                    accounts.add(customer5);
                    break;
                case 6:
                    System.out.println("Enter your name");
                    user_name=input.next();
                    System.out.println("Enter Account type");
                    account_type=input.next();
                    System.out.println("Enter initial amount");
                    balance=input.nextDouble();
                    account_number = (long) Math.floor(Math.random() * 9000000000000L) + 1000000000000L;
                    customer6 = new PersonalLoan(user_name, account_number, account_type, balance);
                    accounts.add(customer6);
                    break;
                case 7:
                    System.out.println("Enter your name");
                    user_name=input.next();
                    System.out.println("Enter Account type");
                    account_type=input.next();
                    System.out.println("Enter initial amount");
                    balance=input.nextDouble();
                    account_number = (long) Math.floor(Math.random() * 9000000000000L) + 1000000000000L;
                    customer7 = new VehicleLoan(user_name, account_number, account_type, balance);
                    accounts.add(customer7);
                    break;
                case 8:
                    exit=true;

            }
        }while(!exit);

        System.out.println("------------------Choose Your Account Type------------------");
        System.out.println("Press the following:\n1.Savings Account\n2.Current Account\n3.Fixed Account \n4.Recurring Account \n5.HouseLoan Account\n6.PersonalLoan Account\n7.VehicleLoan Account\nPlease enter your choice:");
        select_type = input.nextInt();
        System.out.println("For the operation on the account press the following");
        System.out.println("1. Deposit Amount");
        System.out.println("2. Withdraw Amount");
        System.out.println("3. Account Information");
        System.out.println("4. Update EmailId");
        System.out.println("5. Update Mobile Number");
        System.out.println("6. Exit");
        Iterator<BankAccount> iter = accounts.iterator();
        while (iter.hasNext()) {
            switch (select_type) {
                case 1:
                    if (iter.next() instanceof SavingsAccount) {
                        do{
                            System.out.print("\nPlease enter your choice: ");
                            menu = input.nextInt();
                            switch (menu) {
                                case 1:
                                    System.out.println("Enter the Amount to deposit:");
                                    int amount_dep = input.nextInt();
                                    customer1.deposit(amount_dep);
                                    cs_trans.add(amount_dep);
                                    customer1.interestValue(rate_of_interest);
                                    break;

                                case 2:
                                    System.out.println("Enter the Amount to withdraw:");
                                    int amount_withdraw = input.nextInt();
                                    customer1.withdraw(amount_withdraw);
                                    cs_trans.add(-amount_withdraw);
                                    customer1.interestValue(rate_of_interest);
                                    break;

                                case 3:
                                    customer1.display();
                                    customer1.lastTrans(cs_trans);
                                    break;
                                case 4:
                                    System.out.println("Enter the EmailId");
                                    customer1.setMailId();
                                    break;
                                case 5:
                                    System.out.println("Enter the Mobile Number");
                                    customer1.setMobileNUmber();
                                    break;
                                case 6:
                                    quit = true;
                                    break;
                            }
                        } while (!quit);
                    }
                    break;
                case 2:
                    if (iter.next() instanceof CurrentAccount) {
                        do {
                            System.out.print("Please enter your choice: ");
                            menu = input.nextInt();
                            switch (menu) {
                                case 1:
                                    System.out.println("Enter the Amount to deposit:");
                                    int amount_dep = input.nextInt();
                                    customer2.deposit(amount_dep);
                                    cs_trans.add(amount_dep);
                                    customer2.interestValue(rate_of_interest);
                                    break;

                                case 2:
                                    System.out.println("Enter the Amount to withdraw:");
                                    int amount_withdraw = input.nextInt();
                                    customer2.withdraw(amount_withdraw);
                                    cs_trans.add(-amount_withdraw);
                                    customer2.interestValue(rate_of_interest);
                                    break;

                                case 3:
                                    customer2.display();
                                    customer2.lastTrans(cs_trans);
                                    break;
                                case 4:
                                    System.out.println("Enter the EmailId");
                                    customer2.setMailId();
                                    break;
                                case 5:
                                    System.out.println("Enter the Mobile Number");
                                    customer2.setMobileNUmber();
                                    break;
                                case 6:
                                    quit = true;
                                    break;
                            }
                        } while (!quit);
                    }
                    break;
                case 3:
                    if (iter.next() instanceof Fixed) {
                        do {
                            System.out.print("Please enter your choice: ");
                            menu = input.nextInt();
                            switch (menu) {
                                case 1:
                                    System.out.println("Sorry!!!...It can be deposited only once");
                                    System.out.print("Enter the terms of deposit:");
                                    terms=input.nextInt();
                                    customer3.interestValue(terms,rate_of_interest);
                                    break;

                                case 2:
                                    System.out.println("Sorry!!...Withdraw can not be take place");
                                    break;

                                case 3:
                                    customer3.display();
                                    break;
                                case 4:
                                    System.out.println("Enter the EmailId");
                                    customer3.setMailId();
                                    break;
                                case 5:
                                    System.out.println("Enter the Mobile Number");
                                    customer3.setMobileNUmber();
                                    break;
                                case 6:
                                    quit = true;
                                    break;
                            }
                        } while (!quit);
                    }
                    break;
                case 4:
                    if (iter.next() instanceof Recurring) {
                        do {
                            System.out.print("Please enter your choice: ");
                            menu = input.nextInt();
                            switch (menu) {
                                case 1:
                                    System.out.println("Enter the Amount to deposit:");
                                    int amount_dep = input.nextInt();
                                    customer4.deposit(amount_dep);
                                    rc_trans.add(amount_dep);
                                    System.out.print("Enter the terms of deposit:");
                                    terms=input.nextInt();
                                    customer4.interestValue(terms,rate_of_interest);
                                    break;

                                case 2:
                                    System.out.println("Sorry!!...Withdraw can not be take place");
                                    break;

                                case 3:
                                    customer4.display();
                                    customer4.lastTrans(rc_trans);
                                    break;
                                case 4:
                                    System.out.println("Enter the EmailId");
                                    customer4.setMailId();
                                    break;
                                case 5:
                                    System.out.println("Enter the Mobile Number");
                                    customer4.setMobileNUmber();
                                    break;
                                case 6:
                                    quit = true;
                                    break;
                            }
                        } while (!quit);
                    }
                    break;
                case 5:
                    if (iter.next() instanceof HouseLoan) {
                        do {
                            System.out.print("Please enter your choice: ");
                            menu = input.nextInt();
                            switch (menu) {
                                case 1:
                                    System.out.println("Enter the Amount to deposit:");
                                    int amount_dep = input.nextInt();
                                    la_trans.add(amount_dep);
                                    customer5.deposit(amount_dep);
                                    customer5.interestValue(rate_of_interest);
                                    break;

                                case 2:
                                    System.out.println("Sorry!!...Withdraw can not be take place");
                                    break;

                                case 3:
                                    customer5.display();
                                    customer5.lastTrans(la_trans);
                                    break;
                                case 4:
                                    System.out.println("Enter the EmailId");
                                    customer5.setMailId();
                                    break;
                                case 5:
                                    System.out.println("Enter the Mobile Number");
                                    customer5.setMobileNUmber();
                                    break;
                                case 6:
                                    quit = true;
                                    break;
                            }
                        } while (!quit);
                    }
                    break;
                case 6:
                    if (iter.next() instanceof PersonalLoan) {
                        do {
                            System.out.print("Please enter your choice: ");
                            menu = input.nextInt();
                            switch (menu) {
                                case 1:
                                    System.out.println("Enter the Amount to deposit:");
                                    int amount_dep = input.nextInt();
                                    la_trans.add(amount_dep);
                                    customer6.deposit(amount_dep);
                                    customer6.interestValue(rate_of_interest);
                                    break;

                                case 2:
                                    System.out.println("Sorry!!...Withdraw can not be take place");
                                    break;

                                case 3:
                                    customer6.display();
                                    customer6.lastTrans(la_trans);
                                    break;
                                case 4:
                                    System.out.println("Enter the EmailId");
                                    customer6.setMailId();
                                    break;
                                case 5:
                                    System.out.println("Enter the Mobile Number");
                                    customer6.setMobileNUmber();
                                    break;
                                case 6:
                                    quit = true;
                                    break;
                            }
                        } while (!quit);
                    }
                    break;
                case 7:
                    if (iter.next() instanceof VehicleLoan) {
                        do{
                            System.out.print("Please enter your choice: ");
                            menu = input.nextInt();
                            switch (menu) {
                                case 1:
                                    System.out.println("Enter the Amount to deposit:");
                                    int amount_dep = input.nextInt();
                                    la_trans.add(amount_dep);
                                    customer7.deposit(amount_dep);
                                    customer7.interestValue(rate_of_interest);
                                    break;

                                case 2:
                                    System.out.println("Sorry!!...Withdraw can not be take place");
                                    break;

                                case 3:
                                    customer7.display();
                                    customer7.lastTrans(la_trans);
                                    break;
                                case 4:
                                    System.out.println("Enter the EmailId");
                                    customer7.setMailId();
                                    break;
                                case 5:
                                    System.out.println("Enter the Mobile Number");
                                    customer7.setMobileNUmber();
                                    break;
                                case 6:
                                    quit = true;
                                    break;
                            }
                        } while (!quit);
                    }
                    break;
            }
        }
    }
}

