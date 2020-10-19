package junitTesting;

import java.util.Random;

public class TrainBooking 
{
	Trains train;
	long ticketNum;
	int numOfSeats;
	String selectedClass;
	
	public TrainBooking(Trains train)
	{
		this.train = train;
	}
	
	public Trains getTrain()
	{
		return this.train;
	}
	
	public long getTicketNum() {
		return ticketNum;
	}
	
	public void setTicketNum() {
		this.ticketNum = new Random().nextInt(9999999);
	}
	
	public int getNumOfSeats() {
		return numOfSeats;
	}
	
	public void setNumOfSeats(int numOfSeats) {
		this.numOfSeats = numOfSeats;
	}
	
	public String getSelectedClass() {
		return selectedClass;
	}
	
	public void setSelectedClass(String selectedClass) {
		this.selectedClass = selectedClass;
	}
	
	public void printBookingDetails()
	{
		System.out.println("BOOKING DETAILS");
		
		System.out.println("Ticket number :"+getTicketNum());
		System.out.println("Seating :"+getNumOfSeats()+" seats in "+getSelectedClass());
		train.displayTrainDetails();
	}
	
	
	
}
