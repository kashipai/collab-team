package rowMapping;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class LibraryMapper implements RowMapper<Library> {


	   public Library mapRow(ResultSet rs, int rowNum) throws SQLException {
	      Library book = new Library();
	      book.setIsbn(rs.getInt("isbn"));;
	      book.setbName(rs.getString("bName"));
	      book.setbAuthor(rs.getString("bAuthor"));
	      book.setCost(rs.getInt("cost"));
	      return book;
	   }
	}

