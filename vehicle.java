package vehicles;

import java.util.ArrayList;

public class vehicle {
	String name;
	int wheeels;
	String engine;
	
public  static void main(String args[]) {
	ArrayList<vehicle> v =new ArrayList<vehicle>();
	
	v.add(new TwoWheeler("pulser"));
	v.add(new TwoWheeler("Activa"));
	v.add(new car("suzuki"));
	v.add(new car("santro"));
	
	
for(int i=0;i<v.size();i++) {
	System.out.println(v.get(i).name);
	
	
}
	
}
}


class TwoWheeler extends vehicle {
	int wheels;
	TwoWheeler(String n){
		name=n;
	}
  

}


class car extends vehicle{
	int wheels;
	
	car(String name){
		this.name=name;
	}

}


