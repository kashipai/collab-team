package threads;

public class thread extends Thread {
	static int count;
	public thread(int k){
		count=k;
	}
	public void run() {	
		System.out.println("thread"+" "+count+" "+"started");
		System.out.println("current thread is:"+count);
		
	}
	
	
		
public static void main(String args[]) throws InterruptedException{
	for (int i= 0; i<=50;i++) { 
	      thread t=new thread(i);
          t.start();   
          t.join(20);
          System.out.println("thread"+" "+count+" "+"ended");
	}
}
}