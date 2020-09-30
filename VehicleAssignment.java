package vehicle;

import java.util.ArrayList;
import java.util.List;

abstract class vehicle {
	abstract public void add();
	abstract public void print();
}

class TwoWheeler extends vehicle
{
	List bikes=new ArrayList();
	public void add()
	{
		bikes.add("Pulsar");
		bikes.add("Activa");
	}
	
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("Two Wheeler "+bikes);
	}
	
}


class Car extends vehicle
{
	List cars=new ArrayList();
	public void add()
	{
		cars.add("Santro");
		cars.add("Suzuki");
	}
	
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("Cars "+cars);
		
	}
}


public class VehicleAssignment
{
	public static void main(String[] args)
	{
		List alls=new ArrayList();
		
		alls.add("Pulsar");
		alls.add("Santro");
		alls.add("Suzuki");
		alls.add("Activa");
		
		TwoWheeler t1=new TwoWheeler();
		t1.add();
		t1.print();
		
		Car c1=new Car();
		c1.add();
		c1.print();
		
		System.out.println();
		
		for(Object s : alls)
		{
			if(t1.bikes.contains(s))
			{
				System.out.println(s+" is two wheeler");
			}
			else if(c1.cars.contains(s))
			{
				System.out.println(s+" is a car");
			}
			else
			{
				System.out.println("It is something");
			}
			
		}
	}
	
}
