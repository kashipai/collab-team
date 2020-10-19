package exercise1610;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)

public class TestClass {

	@Autowired
	private StoreDAO dao;

	@Test
	public void testProfile() {
		dao.deleteItem(101);
		dao.deleteItem(102);
		dao.deleteItem(103);
		dao.deleteItem(104);
		dao.addItem(new Store(101,"Lays",10,50));
		dao.addItem(new Store(102,"Maggie",15,20));
		dao.addItem(new Store(103,"Hide&Seek",20,30));
		dao.updateItem(new Store(101,"Lays",10,40));  
		dao.addItem(new Store(104,"Kurkure",10,50));
		
	}
}