package springMvcLibrary.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import springMvcLibrary.Model.Library;
import org.springframework.jdbc.core.RowMapper;

public class LibraryDaoImpl implements LibraryDao {
	
	private JdbcTemplate jdbcTemplate;

	public LibraryDaoImpl(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public int save(Library book) {
		String sql = "INSERT INTO Library Values(?,?,?,?)";
		Object[] obj = { book.getId(), book.getName(), book.getAuthor(), book.getCost() };
		jdbcTemplate.update(sql, obj);
		System.out.println("NEW BOOK ADDED");
		return 1;
	}

	@Override
	public int Update(Library book) {
		String sql = "Update Library set name= ?, author = ?, cost = ?, where id =?";
		Object[] obj = { book.getName(), book.getAuthor(), book.getCost(),  book.getId() };
		jdbcTemplate.update(sql, obj);
		System.out.println("BOOK UPDATED SUCCESSFULLY");
		return 1;
	}

	@Override
	public int delete(Integer id) {
		String sql = "Delete from Library where id ="+id;
		jdbcTemplate.update(sql);
		System.out.println("BOOK DELETED SUCCESSFULLY");
		
		return 1;
	}

	@Override
	public Library get(String name) {
String sql = "SELECT * FROM Library WHERE author ='"+name+"'";

RowMapper<Library> rowmap = new RowMapper <Library>() {

	public Library mapRow(ResultSet rs, int rowNum) throws SQLException {
		int id = rs.getInt("id");
		String name = rs.getString("name");
		int cost = rs.getInt("cost");
		String author = rs.getString("author");
		
		return new Library(id, name, author, cost);
	}
	 
};

			return null;

	}

	@Override
	public List<Library> list() {
		 String sql = "SELECT * FROM LIBRARY";
		 
		 RowMapper<Library> rowmap = new RowMapper <Library>() {

			public Library mapRow(ResultSet rs, int rowNum) throws SQLException {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int cost = rs.getInt("cost");
				String author = rs.getString("author");
				
				return new Library(id, name, author, cost);
			}
			 
		 };
		 return jdbcTemplate.query(sql, rowmap);
		
	}

}



