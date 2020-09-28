package threadcounter;

public class counter extends Thread {
	static counter c=null;
	static int t=0;
	
	public void run() {
		try {
			//System.out.println(Thread.currentThread().getName());
			increament();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	 private void increament() throws InterruptedException{
		 synchronized(c) {
			String b=Thread.currentThread().getName();
			String a="Thread-"+t;
			while(!b.equals(a)) {
				c.wait(1); 
			} 
			System.out.println(Thread.currentThread()+" "+(t++));
			     c.notifyAll();
			     
			 
		 }
	
	}
	 
 
public static void main(String[] args) throws InterruptedException {
	for(int i=0;i<5;i++) {
	c=new counter();
	c.start();
	//c.join();
	
	
}
}
}