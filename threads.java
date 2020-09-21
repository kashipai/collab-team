package threads;

public class threads extends Thread{
	
	public static int count = 0;
	public void run()
	{
		count++;
	}

	public static void main(String[] args) throws InterruptedException {
		
		threads[] thread = new threads[50];

		try {
			for(int x = 0; x < 50; x++) {
				thread[x] = new threads();
					
				}
			int y = 0;
			while (y < 50)
			{
				
				thread[y].start();
				thread[y].sleep(500);
				thread[y].join();
				System.out.print(count+" ");
				y++;	
			}
						
		} catch(Exception e ) {
			System.out.println(e);
		}
		
	}

}