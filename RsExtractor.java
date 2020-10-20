package rowMapping;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;


public class RsExtractor implements ResultSetExtractor<List<Library>> {
	
	public List<Library> extractData(ResultSet rs) throws SQLException, DataAccessException {
		// TODO Auto-generated method stub
		List<Library> bookList = new ArrayList<Library>();
		while(rs.next())
		{
			Library lib = new Library();
			lib.setIsbn(rs.getInt("isbn"));
			lib.setbName(rs.getString("bName"));
			lib.setbAuthor(rs.getString("bAuthor"));
			lib.setCost(rs.getInt("cost"));
			bookList.add(lib);
	
			}
		return bookList;
	}

	   }


