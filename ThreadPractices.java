package trainingAssignment;

//import java.util.concurrent.*;

class MyThread extends Thread{
	static public int count = 0;
	
	public void run() {
		System.out.println(Thread.currentThread().getName()+": " + count++ );
	}
}
public class ThreadPractices {

	public static void main(String[] args) {
		/*ExecutorService executor = Executors.newFixedThreadPool(10); // Thread pool
		for( int i = 0; i < 50; i++) {
			MyThread myThread = new MyThread();
			executor.execute(myThread);
		}
		executor.shutdown();*/
		MyThread thread[] = new MyThread[50];
		try {
			 for ( int i = 0; i < 50; i++) {
			    	thread[i] = new MyThread();
			    	thread[i].start();
			    	thread[i].join();
			    }
		}
		catch(Exception e) {
			System.out.println(e);
		}
	   
	}
}
