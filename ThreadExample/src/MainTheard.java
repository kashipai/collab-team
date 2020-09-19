
public class MainTheard {

	public static void main(String[] args) {
		
		
		ChildThread Carray[]=new ChildThread[50];
		for(int i=0;i<50;i++) {
			Carray[i]=new ChildThread();
			Carray[i].start();
		}
		for(int i=0;i<50;i++) {
			try {
				Carray[i].join();
			}catch(InterruptedException e) {
				
			}
			
		}
		
		Counter c=new Counter();
		
		
		System.out.println("Final value of Counter:"+c.getCount());
		

	}

}
