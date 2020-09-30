package practice;

import java.util.*;

abstract class Vehicles
{
	abstract String printName();
}

class TwoWheelers extends Vehicles
{
	String name;
	public TwoWheelers(String name)
	{
		this.name = name;
	}
	public String printName() {
		return name;
	}
		
}

class Cars extends Vehicles
{
	String name;
	public Cars(String name)
	{
		this.name = name;
	}
	
	public String printName() {
		return name;
	}
}

public class VehicleInherit
{
	public static void main(String args[])
	{
		List<Vehicles> vehicle = new ArrayList<Vehicles>();
		
		int carCount = 0;
		int twCount = 0;
		int suzukiCount = 0;
		int pulsarCount = 0;
		int activaCount = 0;
		int santroCount = 0;
		
		vehicle.add(new Cars("Suzuki"));
		vehicle.add(new TwoWheelers("Activa"));
		vehicle.add(new Cars("Suzuki"));
		vehicle.add(new TwoWheelers("Pulsar"));
		vehicle.add(new Cars("Santro"));
		vehicle.add(new Cars("Santro"));
		vehicle.add(new TwoWheelers("Activa"));
	
		
		for(Vehicles ve : vehicle)
		{
			String veName = ve.printName();
			System.out.print("Vehicle :"+ve.getClass().getSimpleName());
			System.out.println("-->"+veName);
			System.out.println();
		}
		System.out.println("----------------------------------------------------------------------");
		
		for(Vehicles v : vehicle) 
		{
		
			String vName = v.getClass().getSimpleName();
			
			if(vName.equals("Cars"))
			{
				carCount++;
				String cName = v.printName();
				
				if(cName.equals("Santro"))
					santroCount++;
				
				if(cName.equals("Suzuki"))
					suzukiCount++;
			}
			
			
			if(vName.equals("TwoWheelers"))
			{
				twCount++;
				String twName = v.printName();
				
				if(twName.equals("Activa"))
					activaCount++;
				
				if(twName.equals("Pulsar"))
					pulsarCount++;
				
			}
		}

		int size = vehicle.size();
		
		System.out.println("Total number of vehicles :"+size);
		System.out.println(twCount+" Two wheeler, "+carCount+" Car");
		System.out.println();
		
		System.out.println("Total two wheelers :"+twCount+"\n"+pulsarCount+" Pulsar , "+activaCount+" Activa ");
		System.out.println();
		
		System.out.print("Total Cars :"+carCount+"\n"+suzukiCount+" Suzuki , "+santroCount+" Santro");
		

}		
	
}