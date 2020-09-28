package trainingAssignment;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

class ThreadCounter extends Thread{
	    static int count = 1; 
	    private static Object lock = new Object(); 	   
		public  void run() {
			
			synchronized (lock) {
				 System.out.println(Thread.currentThread().getName() + " : " + count);
		            count++;
			 }
			
			/* 
			 private ReentrantLock lock;
			 public ThreadCounter(ReentrantLock lock) {
			// TODO Auto-generated constructor stub
	    	this.lock=lock;
		     }
			lock.lock();
	        try {
	            System.out.println(Thread.currentThread().getName() + " : " + count);
	            count++;
	        }catch (Exception e) {
				// TODO: handle exception
	        	System.out.println(e);
			} finally {
	            lock.unlock();
	        }*/
	        
			/* 
			 try {
				if(Thread.holdsLock(this)) {
					count = count + 1;
					System.out.println(Thread.currentThread().getName()+"\t"+count);
					this.notifyAll();
					
				}
				else {
					wait();
				}
				}catch (Exception e) {
					// TODO: handle exception
		        	System.out.println(e);
				} 			
				
		     */
	
	}
}	
public class ThreadSynchronization {

		public static void main(String[] args) {
				// TODO Auto-generated method
			
			 ExecutorService executor = Executors.newFixedThreadPool(10);
			  for(int i = 0; i < 50; i++) {
				ThreadCounter thread = new ThreadCounter();
				executor.execute(thread);
				
			  }
			 executor.shutdown();
			
			/*
			 ReentrantLock sharedLock = new ReentrantLock();
			 Thread t[] = new Thread [50];
			  for(int i = 0; i < 50; i++) {
					t[i] = new ThreadCounter(sharedLock);
					t[i].start();
			  }*/
			 
		}

	}
