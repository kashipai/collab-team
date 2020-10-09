package samplebank;

import java.util.ArrayList;

public class Bank
{   
   private ArrayList<BankAccount> accounts ;  
   
   
   public Bank()
   {
      accounts = new ArrayList<BankAccount>() ;
   }

   
   public void addAccount(BankAccount newAccount)
   {
      accounts.add(newAccount) ;  
   } 
   
  
   public void printList() 
   {
      
      for ( int i = 0 ; i < accounts.size() ; i++ )
      {
         BankAccount current = accounts.get( i ) ;  
         System.out.println("Owner Name is"+current.getownername());
         System.out.println("Balance"+current.getBalance());
      }
   }
   
   public void printAccount(String Searchacnumber) 
   {
     
      for ( int i = 0 ; i < accounts.size() ; i++ )
      {
    	  //if(Searchacnumber==)
    	  
         BankAccount current = accounts.get( i ) ;  
         if(Searchacnumber.equals(current.getAccountNumber()))
         {
             System.out.println("Account Holder Name is "+current.getownername());
             System.out.println("Account Number is "+current.getAccountNumber());
             System.out.println("Balance "+current.getBalance());
             System.out.println("Type of account is "+current.getType());
             System.out.println("Sub Type is "+current.getSubtype());
             try {
            	 if(!(current.getPhone().isEmpty()))
                 {
                	 //System.out.println("\n");
                	 System.out.println("Mobile Number is: "+current.getPhone());
                	 System.out.println("Email id is: "+current.getEmail());
                 }
             }
             catch(Exception e)
             {
            	 System.out.println("\n");
             }
             
             System.out.println("\n");
         }
         
      
      }
   }
   
   public BankAccount find(String target)
   {
      for ( int i = 0 ; i < accounts.size() ; i++ )
      {
         BankAccount current = accounts.get( i ) ;        
         String accountNum = current.getAccountNumber()	; 
         if ( accountNum.equals(target) )  		  
        	 return current ;			
      } 
      return null ; 
   }

}
