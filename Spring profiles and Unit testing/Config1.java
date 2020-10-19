package junitTesting;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalTime;

import org.springframework.context.annotation.Bean;

@Configuration
@Profile("traintest")
public class Config1 
{
	@Bean
		public Trains Trains()
		{
			Trains train1 = new Trains();
			LocalTime at = LocalTime.of(06,30);
			LocalTime dt = LocalTime.of(06,50);
			train1.setArrivalTime(at);
			train1.setDepartureTime(dt);
			train1.setTrainNum(112321);
			train1.setStartingPoint("Shimoga");
			train1.setDestination("Mysore");
			train1.setTrainName("Local");
			
			return train1;
		}
}
