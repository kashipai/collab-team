package java_ex;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;



public class thread1 implements Runnable{
	
	public static void filewriter(File file,String s) throws IOException {
		FileWriter fw = new FileWriter(file,true);
		fw.write(s);
		fw.close();
	}


	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		File file = new File("F:\\Example\\test\\output.txt");
        //file.createNewFile();
    
		thread1 T = new thread1();

	    Thread t1 = new Thread(){
	    synchronized public void run() {
			try {
				filewriter(file,"\nthread1 executing...\n");
				
				
			}catch (IOException e)
		    {
		        e.printStackTrace();
		    }
		}
	    };
	    
	    Thread t2 = new Thread(){
		    synchronized public void run() {
				try {
					filewriter(file,"\nthread2 executing...\n");
				}catch (IOException e)
			    {
			        e.printStackTrace();
			    }
			}
		 };
		 
		 Thread t3 = new Thread(){
			    synchronized public void run() {
					try {
						filewriter(file,"\nthread3 executing...\n");
					}catch (IOException e)
				    {
				        e.printStackTrace();
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


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
