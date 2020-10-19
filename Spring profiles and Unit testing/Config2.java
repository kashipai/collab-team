package junitTesting;

import java.time.LocalTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("bookings")
public class Config2 

{	
	@Bean
	public TrainBooking TrainBookings()
	{
		TrainBooking tb = new TrainBooking(Trains1());
		//tb.setTrain(Trains1());
		tb.setNumOfSeats(3);
		tb.setSelectedClass("first class");
		tb.setTicketNum();
		
		return tb;
	}
	
	@Bean
	public Trains Trains1()
	{
		Trains train1 = new Trains();
		LocalTime at = LocalTime.of(16,30);
		LocalTime dt = LocalTime.of(16,50);
		train1.setArrivalTime(at);
		train1.setDepartureTime(dt);
		train1.setTrainNum(177321);
		train1.setStartingPoint("Shimoga");
		train1.setDestination("Talaguppa");
		train1.setTrainName("Express");
		
		return train1;
	}
}
