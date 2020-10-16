package SpringExample.Sample;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import Sample1.Employee;
import junit.framework.Assert;
import junit.framework.TestCase;

public class EmployeeTest extends TestCase {
	@Autowired
	Employee employee;
	
	@Test

	public void testNull() {
		//String str = "Junit is working fine";
		//assertEquals("Junit is working fine", str);
		Assert.assertNotNull(employee);
		employee.display();	}
}
