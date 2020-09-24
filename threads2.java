package thread2;
import java.io.File;
import java.io.FileWriter;

public class threads2 extends Thread  {
	String n;
	threads2(String name){
		n=name;	
		start();
	}
	  synchronized  public void run() {
		try {
			File file=new File("F:\\JAVA\\myfile1.txt");
			FileWriter mywriter = new FileWriter("F:\\\\JAVA\\\\myfile1.txt");
			mywriter.write(n);
			mywriter.close();
			
		}catch(Exception e) {
			System.out.println("something went wrong"+e.getMessage());
		}
		
	}
		

public static void main(String[] args) throws InterruptedException {
	threads2 t=new threads2("file writing is started");
	threads2 t1=new threads2("this  is a text file");
	threads2 t2=new threads2("file wrote successfully");
	
	
}
	
}
