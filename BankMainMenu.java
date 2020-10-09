package BankAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;





class Account{
	public static List<Account> act_casa = new ArrayList<Account>();
	public static List<Account> act_loan = new ArrayList<Account>();
	public static List<Account> act_Deposit = new ArrayList<Account>();
	public static List<Account> Transaction = new ArrayList<Account>();
    public String name, acc_type, email, func;
    public int Acc_num, phone;
    float Acc_Balance;
    public static int t=1;
    static Account[] acc_tr = new Account[20]; 
    
    void Create_Account(String n, int acc_num, float balance, String a_t, int phone, String mail) {
    	this.name=n;
        this.Acc_num=acc_num;
        this.Acc_Balance=balance;
        this.acc_type=a_t;
        this.phone = phone;
        this.email = mail;
        }

    public void showAccount() {
        System.out.println(Acc_num + " -- " + name + " -- " + Acc_Balance + " -- " + acc_type + " -- " + phone+" -- " + email);
    }
 
    void deposit(int amt) {
        Acc_Balance = Acc_Balance + amt;
        
    }
    public static boolean search(int acn, List<Account> list) {
   		for(Account c : list) {                				
				if(c.Acc_num == acn) {
					c.showAccount();
					return true;
				}
   		}
		return false;

       
    }
   /* public static void lastTrancsactions(int acc_no, String func, float acc_Balance2) {
    	int Acc_num = acc_no;
    	String fun = func;
    	float money = acc_Balance2;
    	Transaction.add(acc_tr[t]);
    	   	
    }
    public static void TranctionDetails() {
    	for(Account c : Transaction) {
    		System.out.println(c.Acc_num + " " + c.fun+)
    		
    	}
    	
    }*/

} 

class CaSaAccount extends Account {

    static void withdrawal(int ac_num, int amt) {
    	int flag = 0;
   		for(Account c : act_casa) {                				
				if(c.Acc_num == ac_num) {
					if (c.Acc_Balance >= amt) {
						c.Acc_Balance = c.Acc_Balance - amt;
						break;
					}
					else {
						System.out.println("not enough balance");
					}
				}
			}
   		if(flag == 0) {
					System.out.println("no account found");
				}
    }
    
    static void DepositAmount(int ac_num, int amount) {
    	int flag = 0;
    	for(Account c : act_casa) {
    		if(c.Acc_num == ac_num) {
    			c.Acc_Balance = c.Acc_Balance + amount;
    			flag = 1;

    		}
    		
    	}
    	if(flag == 0) {
    		System.out.println("no account found");
    	}
    }
    
    static void CaSaInterest(float rate) {
    	rate = rate/100;
    	for(Account c : act_casa) {
    		c.Acc_Balance = c.Acc_Balance + (c.Acc_Balance * (rate/365)) ;
    	}
    }
 
}

class DepositAccount extends Account {
    static void DepositAmount(int ac_num, int amount) {
    	int flag = 0;
    	for(Account c : act_Deposit) {
    		if((c.Acc_num == ac_num) && (c.acc_type.equals("R"))) {
    			c.Acc_Balance = c.Acc_Balance + amount;
    			flag = 1;
 
    			
    			
    		}
    		
    	}
    	if(flag == 0) {
    		System.out.println("no account found");
    	}
    }
    
    static void DepositInterest(float rate, float termOfDeposit) {
    	for(Account c : act_Deposit) {
    		c.Acc_Balance = c.Acc_Balance + c.Acc_Balance * (rate/100) * termOfDeposit;
    	}
    }
 
}


class LoanAccount extends Account {
    static void DepositAmount(int ac_num, int amount) {
    	int flag = 0;
    	for(Account c : act_loan) {
    		if(c.Acc_num == ac_num) {
    			c.Acc_Balance = c.Acc_Balance - amount;
    			flag = 1;
    		}
    		
    	}
    	if(flag == 0) {
    		System.out.println("no account found");
    	}
    }
    static void LoanInterest(float rate,String IntrestOn) {
    	rate = rate/100;
    	for(Account c : act_loan) {
    		if(c.acc_type.equals(IntrestOn)) {
    			c.Acc_Balance = c.Acc_Balance + c.Acc_Balance * (rate/365);
    			
    		}
    	}
    }
 

}

public class BankMainMenu extends Account {
	public static void main(String[] args) {
	    String name, a_t, email;
	     int acc_num, balance, phone;

	Scanner sc = new Scanner(System.in);
  
   BankMainMenu C[] = new BankMainMenu[100];
 //  BankMainMenu T[] = new BankMainMenu[100];
   int ch, z = 1, d = 1, l = 1;
   do {
       System.out.println("Main Menu \n1.create_caaount \n 2.Display all \n 3. Search By Account\n 4. Withdrawal\n 5.Deposit \n 6.Interest Addition \n 7. Exit  ");
           System.out.println("Ur Choice :"); 
           ch = sc.nextInt();
           switch (ch) {
               case 1:
            	System.out.println("=========CREATE ACCOUNT=======");
               	System.out.println("1. CASA account  2.Deposit account 3.Loan account ");
               	int choice = sc.nextInt();
               	if(choice == 1) {
               		C[z] = new BankMainMenu();
               		//C[z].Create_Account(n, acc_num, balance, a_t, phone, mail);
               		System.out.println("enter account number:");
               		acc_num = sc.nextInt();
               		System.out.println("enter account holder name:");
               		name = sc.next();
               		System.out.println("enter account type(Saving account(SA) / Current accoumt(CA):");
               		a_t = sc.next();
               		System.out.println("enter email:");
               		email = sc.next();
               		System.out.println("enter initial amount:");
               		balance = sc.nextInt();
               		System.out.println("enter phone:");
               		phone = sc.nextInt();
               		
               		C[z].Create_Account(name, acc_num, balance, a_t, phone, email);
               		
               		if (a_t.equals("SA") || a_t.equals("CA")) {
               			act_casa.add(C[z]);
               			z++;
        
               		}
               		else {
               			System.out.println("account type miss_match ");
               			
               		}
               	}
               	else if(choice == 2) {
               		C[z] = new BankMainMenu();
               		//C[z].Create_Account(n, acc_num, balance, a_t, phone, mail);
               		System.out.println("enter account number:");
               		acc_num = sc.nextInt();
               		System.out.println("enter account holder name:");
               		name = sc.next();
               		System.out.println("enter account type 1.Fixed(F)   2. Recurring(R)");
               		a_t = sc.next();
               		System.out.println("enter email:");
               		email = sc.next();
               		System.out.println("enter initial amount:");
               		balance = sc.nextInt();
               		System.out.println("enter phone:");
               		phone = sc.nextInt();
               		
               		C[z].Create_Account(name, acc_num, balance, a_t, phone, email);
               		
               		if (a_t.equals("F") || a_t.equals("R")) {
               			act_Deposit.add(C[d]);
               			d++;
        
               		}
               		else {
               			System.out.println("account type miss_match ");
               			
               		}
               	}
               	else if(choice == 3) {
               		C[z] = new BankMainMenu();
               		//C[z].Create_Account(n, acc_num, balance, a_t, phone, mail);
               		System.out.println("enter account number:");
               		acc_num = sc.nextInt();
               		System.out.println("enter account holder name:");
               		name = sc.next();
               		System.out.println("enter Loan type 1.house(H) , 2.vehicle(V)  3.personal(P)");
               		a_t = sc.next();
               		System.out.println("enter email:");
               		email = sc.next();
               		System.out.println("enter initial amount:");
               		balance = sc.nextInt();
               		System.out.println("enter phone:");
               		phone = sc.nextInt();
               		
               		C[z].Create_Account(name, acc_num, balance, a_t, phone, email);
               		
               		if (a_t.equals("V") || a_t.equals("P") || a_t.equals("H")) {
               			act_loan.add(C[l]);
               			l++;
        
               		}
               		else {
               			System.out.println("account type miss_match ");
               			
               		}
               		
               	}
                   break;
               case 2:
            	   System.out.println("=========DEATAILS OF ALL ACCOUNT HOLDERS=======");
               	System.out.println("enter the choice for knowing details of \n 1. CASA account\n 2.loan account \n 3. deposit account");
               	int make_Choice = sc.nextInt();
               	if (make_Choice == 1) {
               		System.out.println("account details of all CASA customers:-");
               		System.out.println("account-number -- name -- balance -- accType -- phone -- email.");
               		for(Account c : act_casa) {
           				c.showAccount();
           				}
               		}
               	else if (make_Choice == 2) {
               		System.out.println("account details of all Loan holder customers:-");
               		System.out.println("account-number -- name -- balance -- accType -- phone -- email.");
               		for(Account c : act_loan) {                				
           				c.showAccount();
           				}
               		}
               	else if (make_Choice == 3) {
               		System.out.println("account details of all Deposit customers:-");
               		System.out.println("account-number -- name -- balance -- accType -- phone -- email.");
               		for(Account c : act_Deposit) {              				
           				c.showAccount();
           				}
               		}
               	else {
               		System.out.println("choice was wrong");
               	}
               	break;
               case 3:
            	   System.out.println("=========PARTICULAR ACCOUNT DETAILS=======");
            	   System.out.println("Searched results");
        		   System.out.println("enter account number");
        		   int acnum = sc.nextInt();
            	   System.out.println("enter option to see account number details in - 1. CaSa  2.Deposit 3.loan ");
            	   int your_choice = sc.nextInt();
            	   if(your_choice == 1) {
            		   //System.out.println("account-number -- name -- balance -- accType -- phone -- email.");
            		   System.out.println("account-number -- name -- balance -- accType -- phone -- email.");
            		   search(acnum, act_casa);
            		   
            		   
            	   }
            	   else if(your_choice == 2) {
            		   System.out.println("account-number -- name -- balance -- accType -- phone -- email.");
            		   search(acnum, act_Deposit);
            		   
            	   }
            	   else if(your_choice == 3) {
            		   System.out.println("account-number -- name -- balance -- accType -- phone -- email.");
            		   if(!search(acnum, act_loan)) {
            			   System.out.print("no result found");
            		   }
            		   
            	   }
            	   else {
            		   System.out.println("invalid choice");
            	   }
            	   break;
               case 4:
            	   System.out.println("=========WITHDRAW MONEY=======");
            	   System.out.println("withdraw money");
            	   System.out.println("enter account number");
            	   int an = sc.nextInt();
            	   System.out.println("enter the amout to be withdraw");
            	   int amt = sc.nextInt();
            	   CaSaAccount wo = new CaSaAccount();
            	   wo.withdrawal(an, amt); 
            	   
            	   
            	   break;
               case 5:
            	   System.out.println("=========DEPOSIT MONEY=======");
            	   System.out.println("enter the account you want to deposit 1. CASA 2.Deposit 3.Loan");
            	   int my_choice = sc.nextInt();
            	   if(my_choice == 1) {
            		   CaSaAccount obj = new CaSaAccount();
            		   System.out.println("enter account number ");
            		   int my_csacc_num = sc.nextInt();
            		   System.out.println("enter the amount");
            		   int amount = sc.nextInt();
            		   obj.DepositAmount(my_csacc_num, amount);
            	   }
            	   if(my_choice == 2) {
            		   DepositAccount obj = new DepositAccount();
            		   System.out.println("enter account number ");
            		   int my_Dacc_num = sc.nextInt();
            		   System.out.println("enter the amount");
            		   int amount = sc.nextInt();
            		   obj.DepositAmount(my_Dacc_num, amount);
            	   }
            	   if(my_choice == 3) {
            		   LoanAccount obj = new LoanAccount();
            		   System.out.println("enter account number ");
            		   int my_Lacc_num = sc.nextInt();
            		   System.out.println("enter the amount");
            		   int amount = sc.nextInt();
            		   obj.DepositAmount(my_Lacc_num, amount);
            	   }
            	   else {
            		   System.out.println("invalid choice");
            	   }
            	
            	   break;
               case 6:
            	   System.out.println("=========INTEREST ON ACCOUNT=======");
            	   System.out.println("intrest on accounts");
            	   System.out.println("choose for 1.CASA  2.Deposit  3.Loan");
            	   int in_choice = sc.nextInt();
            	   if(in_choice == 1) {
            		   System.out.println("enter the rate of interest :-");
            		   float rate = sc.nextFloat();
            		   CaSaAccount io = new CaSaAccount();
            		   io.CaSaInterest(rate);
            	   }
            	   else if(in_choice == 2) {
            		   System.out.println("enter the rate of interest :-");
            		   float rate = sc.nextFloat();
            		   System.out.println("enter the term");
            		   int term = sc.nextInt();
            		   DepositAccount io = new DepositAccount();
            		   io.DepositInterest(rate, term);
            	   }
            	   if(in_choice == 3) {
            		   String IntrestOn = null;
            		   System.out.println("enter the rate of interest :-");
            		   float rate = sc.nextFloat();
            		   System.out.println("make choice on interest for 1.house,2.vechicle,3.personal ");
            		   int cc = sc.nextInt();
            		   if(cc == 1) {
            			  IntrestOn = "H";
            			   
            		   }
            		   else if(cc == 2) {
            			 IntrestOn = "V";
            		   }
            		   else if(cc == 3) {
            			 IntrestOn = "P";
            		   }
            		   LoanAccount io = new LoanAccount();
            		   LoanAccount.LoanInterest(rate,IntrestOn);
            	   }
            	   else {
            		   System.out.println("choice was not currect");
            	   }
            	   
            	   break;
               case 7:
            	   System.exit(0);
            	   break;
               default :
            	   System.out.println("invalid choice");
            	   break;
               	
           }
         }while(true);
   
   
	}
}
        

        
	
	


