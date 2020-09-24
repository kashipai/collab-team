package practice;

import java.io.*;
import java.util.*;


public class ThreadExercise extends Thread
{	
	
	public void run()
  {
	  writeToFile();
  }
	
	public synchronized void writeToFile()
	{
		File destination = new File("F://threadExample.txt");
		
	      try 
	      {
	    	  	
	    	    FileWriter fwr = new FileWriter(destination, true);
	    	    Scanner sc = new Scanner(System.in);
	    	    System.out.println("Enter the statements to be written in file by:"+Thread.currentThread().getName());
	    	    String sentance = sc.nextLine();
	    	    BufferedWriter bwr = new BufferedWriter(fwr);
	    	    bwr.write(sentance);
	    	    bwr.newLine();
	    	    bwr.close();
	    	   
	    	    System.out.println(Thread.currentThread().getName()+" done writing");
	      }
	     
	      catch (IOException e) 
	      {
	            e.printStackTrace();
	      }

	            
	}
	
	public static void main(String args[])
	{
		ThreadExercise t1 = new ThreadExercise();

		
		Thread thread1 = new Thread(t1);
		Thread thread2 = new Thread(t1);
		Thread thread3 = new Thread(t1);
		
		
			thread1.start();
			
			thread2.start();
			
			thread3.start();
	
			
	}
}
