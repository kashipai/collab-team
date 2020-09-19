package practice;

class ThreadClass extends Thread
{
	static int cnt = 0;

	 public void run() 
	 {
		
	   try 
	   {
		   Thread.sleep(1000);
		   if(Thread.currentThread().isDaemon())
		   {
			   System.out.println(Thread.currentThread().getName()+" is a daemon thread and it is running");
			   cnt++;
			   
		   }
		   else
		   {
			   System.out.println(Thread.currentThread().getName()+" is running"); 
			   cnt++;
		   }
		   System.out.println(cnt); 
		    
	   } 	
	   
	   catch (Exception e) 
	   {
		   System.out.println(e.getMessage());
	   }
	  
	  }
	
	 }
	 
	public class ThreadExample {
	 
	 public static void main(String[] args) 
	 {
		 
	  ThreadClass t[] = new ThreadClass[50];
	  
	  for(int i = 0; i < 50; i++)
	  {
		  t[i] = new ThreadClass();
	  }
	  	int j = 0;
	  	
	  	while(j < 49)
	  	{
	  		t[j].start();
	  		
	  		j++;
	  	}
	  	
	  	t[49].setDaemon(true);
	  	t[49].start();
	 
	 }
	 
	}

