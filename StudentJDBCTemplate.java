package Student;

import java.util.List;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("BeanTemplate")
public class StudentJDBCTemplate implements StudentDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	private Student student;
	
	public void setJdbctemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplateObject = jdbcTemplate;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void create(String name, Integer age) {
		String SQL = "insert into Student (name, age) values (?, ?)";
		//Object[] obj = {student.getName(),student.getAge()};

		jdbcTemplateObject.update(SQL, name, age);
		System.out.println("Created Record Name = " + name + " Age = " + age);
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
