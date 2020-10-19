package databaseConnection;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestDbOperations {

	

	ApplicationContext context = new AnnotationConfigApplicationContext(ConfigEmployee.class);
	
	Employees employee1 = context.getBean(Employees.class);
	@Test
	public void testInsert() 
	{
		employee1.insertToDb(20882,"Dobby","Canada",54,"HR");
	}
	
	@Test
	public void testDelete()
	{
		employee1.deleteFromDb(667);
	}
	
	@Test
	public void testUpdate()
	{
		employee1.updateName(100,"Gregora george");
	}

}
