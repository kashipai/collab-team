package springEmployee.JDBCtemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class Employee {
    
	@Autowired
	private JdbcTemplate jdbcTemplate;  
	  
	
	public void deleteRow(int EmpId){
		jdbcTemplate.update("DELETE from database2.emptable WHERE person_id = ? ",+EmpId);
	}

	public void updateRow() {
		 jdbcTemplate.update("INSERT INTO database2.emptable (EmpId,FirstName,LastName,Salary,Age) VALUES(?,?,?,?,?)", 106,"Aman","Rai",30000,22);
	}
}
