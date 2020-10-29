package demo_spring_mvc.student.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import demo_spring_mvc.student.model.Student;

public class ResultSetextractorImpl implements ResultSetExtractor<List<Student>> {

	public List<Student> extractData(ResultSet rs) throws SQLException, DataAccessException {

		List<Student> student = new ArrayList<Student>();
		while (rs.next()) {
			Student student1 = new Student();
			student1.setRollNo(rs.getInt(1));
			student1.setFirstName(rs.getString(2));
			student1.setLastName(rs.getString(3));
			student1.setEmail(rs.getString(4));
			student.add(student1);
		}
		return student;
	}

}
