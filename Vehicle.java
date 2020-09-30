package TrainingSession;

import java.util.*;

class MainVehicle {
	static int noOfWheels;
	static ArrayList<String> car = new ArrayList<String>();
	static ArrayList<String> bike = new ArrayList<String>();
	
	
}

class Cars extends MainVehicle {
	String carName;
	Cars(String name) {
		this.carName = name;
		car.add(carName);
	}
	
}
class Bikes extends MainVehicle {
	String BikeName;
	Bikes(String name) {
		this.BikeName = name;
		bike.add(BikeName);
	}
	
}

public class Vehicle extends MainVehicle {
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n;
		String nameOfVehicle;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter number of vehicle");
		n = sc.nextInt();
	
		
		for(int i = 0; i < n; i++) {
			System.out.println("enter the name of vehicle");
			nameOfVehicle = sc.next();
			System.out.println("enter the no.of wheels it has");
			noOfWheels = sc.nextInt();
			if(noOfWheels == 4) {
				Cars objCars = new Cars(nameOfVehicle);
				
			}
			if(noOfWheels == 2) {
				Bikes objBikes = new Bikes(nameOfVehicle);
				
			}
			
		}
		int choice;
		do {
			System.out.println("enter choice 1.cars 2.bikes 3. exit");
			choice = sc.nextInt();
			switch (choice) {
			case 1 :
				System.out.println("car list are:");
				for(int i = 0; i<car.size(); i++) {
					System.out.println(i+1+". "+car.get(i));
				}
				break;
			
			case 2:
				System.out.println("bike list are:--");
				for(int i = 0; i<bike.size(); i++) {
					System.out.println(i+". "+bike.get(i));
				}
				break;
				
			case 3 : 
				System.exit(0);
				break;
				
			default:
				System.out.println("invalid choice");
				break;
			
				}		
			
		}while(true);

	}

}
