package TrainingSession;

import java.io.*;

public class FileThread extends Thread {
	
	public synchronized void WriteFile(String s) throws IOException{
	    try{    
	        FileWriter fw=new FileWriter("E:\\training\\test\\threadfile1", true);    
	        fw.write(s); 
	        
	        fw.close();    
	       }
	    catch(Exception e)
	    {
	    	System.out.println(e);
	    }     
	    System.out.println("successful");
	}

	public static void main(String[] args) throws InterruptedException  {
	
		FileThread threadOne = new FileThread();
		Thread t1 = new Thread() {
		 public synchronized void run() {
			try {
				threadOne.WriteFile("1. thread one  ");
				System.out.println("thread 1");		
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}

		};
		
		Thread t2 = new Thread() {
		 public synchronized void run() {
			try {
				threadOne.WriteFile("2. Thread two  ");
				System.out.println("thread 2");
				
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}

		};
		
		Thread t3 = new Thread() {
		 public synchronized void  run() {
			try {
				threadOne.WriteFile("3.  thread three  ");
				System.out.println("thread 3");
				
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
		};
		t1.start();
		t1.join();
		t2.start();
		t2.join();
		t3.start();
		t3.join();

		}
}