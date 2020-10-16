package SpringExample.Sample;

import org.springframework.beans.factory.annotation.Autowired;

import Sample1.Department;
import junit.framework.Assert;

public class DepartmentTest {
	@Autowired
	Department department;
	
	public void testNull() {
		//String str = "Junit is working fine";
		//assertEquals("Junit is working fine", str);
		Assert.assertNotNull(department);
		department.display();	
		}
}


