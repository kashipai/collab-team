package trainingAssignment;

import java.util.ArrayList;

abstract class Vehicle{
	String name;
	abstract int numberOfWheels();
}

class TwoWheeler extends Vehicle{
	
	TwoWheeler(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	int numberOfWheels() {
		return 2;
	}
}

class Car extends Vehicle{
	
	Car(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	int numberOfWheels() {
		return 4;
	}
}
public class InheritedVehicle {
	public static void main(String[] args) {	
		ArrayList<Vehicle> vehicles = new ArrayList<>();
		vehicles.add(new TwoWheeler("pulsar"));
		vehicles.add(new TwoWheeler("Royal Enfeild"));
		vehicles.add(new Car("Maruthi"));
		vehicles.add(new Car("BMW"));
		
		for(int i = 0; i < vehicles.size(); i++) {
			System.out.println(vehicles.get(i).getClass().getSimpleName()+ " named "+ vehicles.get(i).name+" has "+ vehicles.get(i).numberOfWheels()+" wheels");
		}
	}
}
