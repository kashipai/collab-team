package junitTesting;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config2.class)
@ActiveProfiles("bookings")


public class TestBookings {

	@Autowired
	private TrainBooking trainBook;
	
	@Test
	public void BookingsTest()
	{
		Assert.assertNotNull(trainBook);
		trainBook.printBookingDetails();	
	}


}
