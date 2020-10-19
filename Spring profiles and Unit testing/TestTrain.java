package junitTesting;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Test;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config1.class)
@ActiveProfiles("traintest")

public class TestTrain {
	
	@Autowired
	private Trains newTrain1;
	
	@Test
	public void testTrain()
	{
		Assert.assertNotNull(newTrain1);
		newTrain1.displayTrainDetails();
	}

	
}
