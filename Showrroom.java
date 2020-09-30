package begin;

import java.util.ArrayList;
import java.util.ListIterator;

class Vehicle {
	int numberOfWheels;
	String Name;
}

class twoWheeler extends Vehicle {

	public twoWheeler(String Name) {
		this.Name = Name;
		this.numberOfWheels = 2;
	}

}

class fourWheeler extends Vehicle {
	public fourWheeler(String Name) {
		this.Name = Name;
		this.numberOfWheels = 4;
	}

}

public class Showrroom {
	public static void main(String[] args) {
		int count1 = 0;
		int count2 = 0;
		ArrayList<Vehicle> List = new ArrayList<Vehicle>();
		Vehicle[] vehicle = new Vehicle[4];
		vehicle[0] = new twoWheeler("Pulsar");
		vehicle[1] = new twoWheeler("Activa");
		vehicle[2] = new fourWheeler("Santro");
		vehicle[3] = new fourWheeler("Altroz");
		for (int i = 0; i < vehicle.length; i++) {
			List.add(vehicle[i]);
		}
		ListIterator<Vehicle> iterator = List.listIterator();
		while (iterator.hasNext()) {
			Vehicle V = iterator.next();
			System.out.println("The name of the Vehicle is  " + V.Name + " and it has " + V.numberOfWheels + " wheels");
		}
		for (int i = 0; i < vehicle.length; i++) {
			if (vehicle[i].getClass().getSimpleName().equals("twoWheeler")) {
				++count1;
			} else {
				++count2;
			}

		}
		System.out.println("The number of Two-Wheelers are " + count1 + " and the number of Four-Wheelers are " + count2
				+ " Therefore totalnumber of Vehicles are " + (count1 + count2));
	}
}