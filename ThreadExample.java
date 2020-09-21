package TrainingSession;

public class ThreadExample extends Thread{
	
	public static int count = 0;
	public void run()
	{
		count++;
	}

	public static void main(String[] args) throws InterruptedException {
		
		ThreadExample[] thread = new ThreadExample[50];

		try {
			for(int i = 0; i < 50; i++) {
				thread[i] = new ThreadExample();
					
				}
			int j = 0;
			while (j < 50)
			{
				
				thread[j].start();
				thread[j].sleep(1000);
				thread[j].join();
				System.out.print(count+" ");
				j++;	
			}
						
		} catch(Exception e ) {
			System.out.println(e);
		}
		
	}

}
