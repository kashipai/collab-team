package rowMapping;

import java.util.List;

import javax.sql.DataSource;

public interface LibraryDao 
{
	void bookInBudget(int cost);
	void alphabeticalArrange();
	void getBooksName(CallbackHandler cbh);
	void setDataSource(DataSource dataSource);
}
