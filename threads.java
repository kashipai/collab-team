package threads;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

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
 class trd extends Thread {
	thread1 T;
	trd(thread1 T){
		this.T=T;
	}
	public void run() {
		T.write();
	}

}


 class thread{
 		
 public static void main(String args[]) throws InterruptedException{
 	      thread1 t=new thread1();
  
 	      trd t1=new trd(t);
 	      trd t2=new trd(t);
 	     
 	      t1.start();
 	      t2.start();
 	     
         
 	}      
 }