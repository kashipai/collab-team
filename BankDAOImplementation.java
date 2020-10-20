package sneha.springJDBCTemplate;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
@Component
public class BankDAOImplementation implements BankDAO{
	JdbcTemplate jdbcTemplate;
	private final String SQL_FIND_ACCOUNT = "select * from bankAccount where accountId = ? ";
	private final String SQL_UPDATE_ACCOUNT = "update bankAccount set name = ?  where accountId = ? ";
	private final String SQL_GET_ALL = "select * from bankAccount";
	private final String SQL_DELETE_ACCOUNT = "delete from bankAccount where accountId = ? ";
	private final String SQL_CREATE_ACCOUNT = "insert into bankAccount (accountId, name) values (?,?)";

	
	public BankDAOImplementation(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public BankAccount getBankAccountById(String accountId) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(SQL_FIND_ACCOUNT, new Object[] {accountId} ,new BankRowMapper());
	}

	public List<BankAccount> getAllAccountHolder() {
		// TODO Auto-generated method stub
		return  jdbcTemplate.query(SQL_GET_ALL, new BankResultSetExtractor());
	}

	public boolean deleteAccount(String accountId) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(SQL_DELETE_ACCOUNT,accountId)>0;
	}

	public boolean updateAccount(BankAccount bankAccount) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(SQL_UPDATE_ACCOUNT,bankAccount.getName(),bankAccount.getAccountId())>0;
	}

	public boolean createAccount(String accountId,String name) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(SQL_CREATE_ACCOUNT,accountId ,name)>0;
	}
}
