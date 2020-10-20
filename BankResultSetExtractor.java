package sneha.springJDBCTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class BankResultSetExtractor implements ResultSetExtractor<List<BankAccount>> {

	public List<BankAccount> extractData(ResultSet rs) throws SQLException, DataAccessException {
		// TODO Auto-generated method stub
		List<BankAccount> accountList = new ArrayList<>();
		while(rs.next()) {
			BankAccount account = new BankAccount();
			account.setAccountId(rs.getString(1));
			account.setName(rs.getString(2));
			accountList.add(account);
			}
		return accountList;
	}

}
