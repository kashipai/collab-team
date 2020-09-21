package sample;

public class thread implements Runnable {
	
	static int[] mt;
	static int count = 0;
	int i;
	
	public thread(int i) {
		this.i=i;
	}
	
	public void run(){  
		//System.out.println("thread is running"); 
		
		count++;
		
		System.out.println("Count = " +count);
	} 

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mt = new int[50];
		for(int i = 0; i < 50; i++) {
			thread t1 = new thread(i);
			//System.out.println(i); 
			for (int j = 0; j < 1; j++) {
	            Thread t = new Thread(t1);
	            t.start();
	            //System.out.println(j+ " " +j);
	            try {
	                t.join();
	                t.sleep(60);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
			}
		}
		

	}

}
