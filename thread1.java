package threads;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class thread1 {
	synchronized  void write() {
		try {
	String a=Thread.currentThread().getName();
	File file=new File("F:\\JAVA\\myfile1.txt");
	FileWriter mywriter = new FileWriter("F:\\\\JAVA\\\\myfile1.txt",true);
	BufferedWriter bufferedWriter = new BufferedWriter(mywriter);
    bufferedWriter.write("thread"+a+"is running");
    bufferedWriter.newLine();
    System.out.println("y");
    bufferedWriter.close();
    
    
	}catch(Exception e) {
		System.out.println("something went wrong"+e.getMessage());
	}
	

}
}