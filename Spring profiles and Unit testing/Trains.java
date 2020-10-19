package junitTesting;

import java.time.LocalTime;

public class Trains
{
	int trainNum;
	String trainName;
	String startingPoint;
	String destination;
	LocalTime arrivalTime;
	LocalTime departureTime;
	
	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	public LocalTime getArrivalTime() {
		return arrivalTime;
	}
	
	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	public int getTrainNum() {
		return trainNum;
	}
	public void setTrainNum(int trainNum)
	{
		this.trainNum = trainNum;
	}
	
	public String getTrainName() {
		return trainName;
	}
	
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	
	public String getStartingPoint() {
		return startingPoint;
	}
	
	public void setStartingPoint(String startingPoint) 
	{
		this.startingPoint = startingPoint;
	}
	
	public String getDestination()
	{
		return destination;
	}
	
	public void setDestination(String destination)
	
	{
		this.destination = destination;
	}
	
	public void displayTrainDetails()
	{
		System.out.println("Train number :"+getTrainNum());
		System.out.println("Train name :"+getTrainName());
		System.out.println("Starts at :"+getStartingPoint());
		System.out.println("Last station :"+getDestination());
		System.out.println("Arrival time at "+getStartingPoint()+" by "+getArrivalTime());
		System.out.println("Departure time from "+getStartingPoint()+" by "+getDepartureTime());
		
	}
	
	


}
