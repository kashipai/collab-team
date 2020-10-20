package sneha.springJDBCTemplate;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DBmain {


	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	
	
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
		BankDAO bankDAO = context.getBean(BankDAO.class);
		
		/*Getting list of account using ResultSetExecutor interface */
		System.out.println("List of account : ");
		for(BankAccount b : bankDAO.getAllAccountHolder()) {
			System.out.println(b);
		}
		
		/*Getting a account details using RowMapper interface*/
		System.out.println("\nGet account holder detail by id: ");
		System.out.println("please enter account id: ");		
		String accountid = sc.nextLine();
		System.out.println(bankDAO.getBankAccountById(accountid));

		System.out.println("\nCreate a account: ");
		System.out.println("account id: ");		
		String accountId = sc.nextLine();
		System.out.println("account holder name: ");
		String name = sc.nextLine();
		bankDAO.createAccount(accountId, name);
		
		
		System.out.println("\nEnter Account id to be updated:");
		String acntid = sc.nextLine();
		BankAccount bankAccount = bankDAO.getBankAccountById(acntid);
		bankAccount.setName("Browny");
		bankDAO.updateAccount(bankAccount);
				
		System.out.println("\nEnter Account id to be deleted: ");
		String accountID = sc.nextLine();
		bankDAO.deleteAccount(accountID);
		
		System.out.println("\nList of account : ");
		for(BankAccount b : bankDAO.getAllAccountHolder()) {
			System.out.println(b);
		}
		
		context.close();
		
		}
}
