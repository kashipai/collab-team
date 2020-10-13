package sneha.springFrameWorkDemo;

public class Bike implements Vehicle {
	int numOfWheels;
	public void setNumOfWheels(int numOfWheels) {
		this.numOfWheels = numOfWheels;
	}
	public int getNumOfWheels() {
		return numOfWheels;
	}
	public void drive() {
		// TODO Auto-generated method stub
		System.out.println("Riding a Bike!!!");
	}

}
