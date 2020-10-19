package spring.profile.annotation.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import spring.profile.annotation.Customer;
import spring.profile.annotation.CustomerConfig;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= {CustomerConfig.class},loader=AnnotationConfigContextLoader.class)
@ActiveProfiles(value="dev")
public class Test2 {
	@Autowired
	private ApplicationContext applicationContext;
	
	@Test
	public void test() {
		Customer customer = (Customer)applicationContext.getBean("customer");
		  assertNotNull(customer);
		  assertEquals("John", customer.getName());
	}

}
