package databaseConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class Employees
{
	@Autowired
	private JdbcTemplate template1;
	
	public void insertToDb(int id, String name,String city, int age,String designation)
	{
		
		
		int i = template1.update("insert into employees(id,name,city,designation,age)values("+id+",'"+name+"','"+city+"','"+designation+"',"+age+")");
		if(i > 0)
			System.out.print("Inserted successfully");
		else
			System.out.print("Couldnt insert");
	}
	
	public void deleteFromDb(int delId)
	{
		int i = template1.update("Delete from employees where id = "+delId);
		
		if(i > 0)
			System.out.print("Deleted successfully");
		else
			System.out.print("Couldnt delete");
	}
	
	public void updateName(int updId,String updName)
	{
		int i = template1.update("Update employees set name='"+updName+"' where id="+updId);
		
		if(i > 0)
			System.out.print("Updated successfully");
		else
			System.out.print("Couldnt update");
	}
}
