package sneha.springJDBCTemplate;

import java.util.List;

public interface BankDAO {
	BankAccount getBankAccountById(String accountId);
	List<BankAccount> getAllAccountHolder();
	boolean deleteAccount(String accountId);
	boolean updateAccount(BankAccount bankAccount);
	boolean createAccount(String accountId, String name);
	
}
