package trainingAssignment;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;


class ThreadWrite extends Thread{
	static int  count=0;
	int i = 0;
	public synchronized void run() {
		try {
		FileOutputStream fout = new FileOutputStream("E:\\ROBOSOFT\\training\\output.txt", true);   
		BufferedOutputStream bout = new BufferedOutputStream(fout); 
		String content = Thread.currentThread()+": "+(++count)+"\n";
		byte b[] = content.getBytes();
		bout.write(b);
		bout.close();
		System.out.println("Success!!!");
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}
public class SynchronizedThread {
	public static void main(String[] args) {
		Thread thread[] = new Thread[5];
		for( int i = 0; i < 5; i++) {
			thread[i] = new ThreadWrite();
			thread[i].start();
		}
	}
}
