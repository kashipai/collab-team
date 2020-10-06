package assignment_29_9;

import java.util.ArrayList;
import java.util.ListIterator;

class Vehicles {
	int noOfWheels;
	String modelName;
	String vehicleType;

	public static void printAll(ArrayList<Vehicles> list) {
		ListIterator<Vehicles> itr = list.listIterator();
		while (itr.hasNext()) {
			Vehicles ob = itr.next();
			System.out.println("A " + ob.noOfWheels + " wheeler " + ob.vehicleType + " of model name " + ob.modelName);
		}
	}
}

class TwoWheeler extends Vehicles {
	TwoWheeler(String name, String type) {
		this.noOfWheels = 2;
		this.modelName = name;
		this.vehicleType = type;
	}
}

class FourWheeler extends Vehicles {
	FourWheeler(String name, String type) {
		this.noOfWheels = 4;
		this.modelName = name;
		this.vehicleType = type;
	}
}

public class VehicleMain {
	public static void main(String[] args) {
		ArrayList<Vehicles> listOfVehicles = new ArrayList<Vehicles>();
		Vehicles[] vehicles = new Vehicles[4];
		vehicles[0] = new TwoWheeler("Activa", "Scooter");
		vehicles[1] = new FourWheeler("Maruti Suzuki", "Car");
		vehicles[2] = new TwoWheeler("Pulsar", "Bike");
		vehicles[3] = new FourWheeler("Santro", "Car");
		int twoWheelerCount = 0;
		int fourWheelerCount = 0;
		for (int i = 0; i < vehicles.length; i++) {
			listOfVehicles.add(vehicles[i]);
		}
		Vehicles.printAll(listOfVehicles);
		for (int i = 0; i < vehicles.length; i++) {
			if (listOfVehicles.get(i).getClass().getSimpleName().equals("TwoWheeler")) {

				twoWheelerCount++;
			} else
				fourWheelerCount++;
		}
		System.out.println("Total number of 2 wheelers: " + twoWheelerCount);
		System.out.println("Total number of 4 wheelers: " + fourWheelerCount);
		System.out.println("Total number of vehicles: " + (twoWheelerCount + fourWheelerCount));

	}
}