package Student;

import java.util.List;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("BeanTemplate")
public class StudentJDBCTemplate {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	public void setJdbctemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplateObject = jdbcTemplate;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void create(Student student) {
		String SQL = "insert into Student (name, age) values (?, ?)";
		Object[] obj = {student.getName(),student.getAge()};

		jdbcTemplateObject.update(SQL, student.getName(),student.getAge());
		System.out.println("Created Record Name = " + student.getName() + " Age = " + student.getAge());
		return;
	}

	public List<Student> listStudents() {
		String SQL = "select * from Student";
		List<Student> students = jdbcTemplateObject.query(SQL, new StudentMapper());
		return students;
	}

	public Student getStudent(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}

