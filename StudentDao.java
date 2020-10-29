package demo_spring_mvc.student.dao;

import java.util.List;

import demo_spring_mvc.student.model.Student;

public interface StudentDao {
	public int insert(Student student);

	public int delete(int RollNo);

	public List<Student> getAllStudent();
}
