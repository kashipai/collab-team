import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Threadss extends Thread {
	String s;
	File file=new File("E:\\threxample.txt");
	
	Threadss(String s){
		this.s=s;
	}
	
	public void run()
	{
		try {
			file.createNewFile();
			filewriter(file,s);
			System.out.println("Done!!!");
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void filewriter(File f1,String s) throws IOException
	{
		FileWriter dest=new FileWriter(f1,true);
		//f1.createNewFile();
		dest.write(s);
		dest.close();
	}
	
	public static void main(String[] args) throws InterruptedException
	{
		Threadss t1=new Threadss("\n Hi \n");
		Threadss t2=new Threadss("\n Hello \n");
		Threadss t3=new Threadss("\n This is Sumanth \n");
//		
//		t1.setPriority(10);
//		t2.setPriority(8);
//		t3.setPriority(7);
		
		t1.start();
		t1.join();
		
		t2.start();
		t2.join();
		
		t3.start();
		t3.join();
		
	}

}
