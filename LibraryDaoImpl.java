package rowMapping;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class LibraryDaoImpl implements LibraryDao {
	
	   private DataSource dataSource;
	   private JdbcTemplate temp;
	   
	   public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.temp = new JdbcTemplate(dataSource);
	   }

	public void bookInBudget(int cost) {
		System.out.println("---BOOKS AVAILABLE WITHIN Rs:"+cost+"---");
		
		int budget = 250;
		String SQL = "select * from Library where library.cost <="+budget;
		List <Library> books = temp.query(SQL, new LibraryMapper());

		
		for (Library record : books)
		{   
	         System.out.print("| Name : " + record.getbName() );
	         System.out.print("| Author : " + record.getbAuthor());
	         System.out.println("| Cost : " + record.getCost() );
	     }
	}

	public void alphabeticalArrange()
	{
		String sql = "select * from library order by library.bName ASC";
		List <Library> books = temp.query(sql, new RsExtractor());
		
		for (Library record : books)
		{   
	         System.out.print("| Name : " + record.getbName() );
	         System.out.print("| Author : " + record.getbAuthor());
	         System.out.println("| Cost : " + record.getCost() );
	     }
	}
	
	public void getBooksName(CallbackHandler cbh)
	{
		System.out.println("----BOOKS AVAILABLE IN LIBRARY----");
		System.out.println("---BOOKS AVAILABLE IN ALPHABETICAL ORDER:---");
		temp.query("select library.bName from Library", cbh);
		System.out.print(cbh.getBookNames());
	}
		
	}

