package demo_spring_mvc.student.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import demo_spring_mvc.student.model.Student;

class StudentDaoTest {
	private DriverManagerDataSource datasource;
	private StudentDao dao;

	@BeforeEach
	void setupBeforeEach() {
		datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/database4");
		datasource.setPassword("naruto#420");
		datasource.setUsername("root");
		dao = new StudentDaoImpl(datasource);
	}

	@Test
	void testInsert() {
		Student student = new Student(2, "Harsharaj", "Devadiga", "harsharajdevadiga@gmail.com");
		int result = dao.insert(student);
		assertTrue(result > 0);
	}

	@Test
	void testDelete() {
		int result = dao.delete(2);
		assertTrue(result > 0);
	}

	@Test
	void testgetAllStudent() {
		List<Student> students = dao.getAllStudent();
		for (Student e : students) {
			System.out.println(e);
		}
		assertTrue(!students.isEmpty());
	}

}
