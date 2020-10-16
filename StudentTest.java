package assignment15_10;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfigTest1.class)
@ActiveProfiles("Student")
public class StudentTest {

	@Autowired
	private Student student;

	@Test
	public void testProfile() {
		Assert.assertNotNull(student);
		student.display();
	}
}
