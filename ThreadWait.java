package TrainingSession;


import java.util.*;
public class ThreadWait extends Thread {
	   static int numThread = 1;
	    static int threadMatch = 1;
	    int ThreadID;
	    private static Object myLock = new Object();

	    public void run() {
	        synchronized (myLock) {
	        	  this.ThreadID = numThread;
	        	  numThread++;
	            while (ThreadID != threadMatch) {
	                try {
	                    myLock.wait();
	                } catch (InterruptedException e) {

	                } catch (Exception e) {}
	            }
		        System.out.println("Thread ID:" + ThreadID);

	            System.out.println("Thread which is running: " + ThreadID);
	            System.out.println();
	            myLock.notifyAll();
	            threadMatch++;
	        }
	    }
	public static void main(String[] args) {

	        
	        Thread[] thread = new Thread[50];
	        for(int i = 1; i < 50; i++) {
	        	thread[i] = new Thread(new ThreadWait());
	        	thread[i].start();
	        }
	

	}

}
