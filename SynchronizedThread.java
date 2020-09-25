package trainingAssignment;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;


class ThreadWrite extends Thread{
	
	public  void run() {
		

		String content1 = Thread.currentThread().getName()+"\t hi!! \n";
		String content2 = Thread.currentThread().getName()+ "\t Hello world!!!\n";
		
		try {
			
			FileOutputStream fout = new FileOutputStream("E:\\ROBOSOFT\\training\\output.txt", true);   
			BufferedOutputStream bout = new BufferedOutputStream(fout);
			byte b1[] = content1.getBytes();
			byte b2[] = content2.getBytes();
			synchronized (bout) {
					bout.write(b1);
					bout.write(b2);
					bout.close();
			}
			
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		System.out.println("Success!!!");
	}
}
public class SynchronizedThread {
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread thread[] = new Thread[5];
		for( int i = 0; i < 5; i++) {
			thread[i] = new ThreadWrite();
			thread[i].start();
			//thread[i].join();
		}
		
	}
}
