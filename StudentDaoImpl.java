package demo_spring_mvc.student.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import demo_spring_mvc.student.model.Student;

public class StudentDaoImpl implements StudentDao {

	private JdbcTemplate jdbcTemplate;

	public StudentDaoImpl(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	public int insert(Student student) {
		String sql = "INSERT INTO database4.student Values(?,?,?,?)";
		Object[] obj = { student.getRollNo(), student.getFirstName(), student.getLastName(), student.getEmail() };
		jdbcTemplate.update(sql, obj);
		System.out.println("Student Inserted!!!");
		return 1;
	}

	public int delete(int RollNo) {
		jdbcTemplate.update("DELETE from database4.student WHERE RollNo = ? ", +RollNo);
		System.out.println("Student with Roll Number " + RollNo + " Deleted!!");
		return 1;
	}

	public List<Student> getAllStudent() {
		String sql = "SELECT * FROM database4.student";
		ResultSetExtractor<List<Student>> resultSetExtractor = new ResultSetextractorImpl();
		List<Student> student = jdbcTemplate.query(sql, resultSetExtractor);
		return student;
	}
}
