package rowMapping;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Tester {

	ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
	
	JdbcTemplate temp = (JdbcTemplate) context.getBean("jdbcTemplate");
	CallbackHandler callback = context.getBean(CallbackHandler.class);
	LibraryDaoImpl daoObj = context.getBean(LibraryDaoImpl.class);
	LibraryMapper libmap = context.getBean(LibraryMapper.class);
	RsExtractor extractor = context.getBean(RsExtractor.class);
    
	@Test
	public void testRowMap()
	{
			int budget = 250;
			daoObj.bookInBudget(budget);
	}
	
	@Test
	public void testHandler() {
		 
		 daoObj.getBooksName(callback);
	}
	
	@Test
	public void testExtractor()
	{
		
		daoObj.alphabeticalArrange();
	}

}
