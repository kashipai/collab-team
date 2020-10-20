package sneha.springJDBCTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BankRowMapper implements org.springframework.jdbc.core.RowMapper<BankAccount>{

	public BankAccount mapRow(ResultSet resultSet, int arg1) throws SQLException {
	
		BankAccount bankAccount = new BankAccount() ;
		bankAccount.setAccountId(resultSet.getString(1));
		bankAccount.setName(resultSet.getString(2));

		return bankAccount;
	}

}
