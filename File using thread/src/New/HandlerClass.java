package New;

public class HandlerClass {
	
	public static void main(String args[]) {
		
		ThreadClass threadOne = new ThreadClass("Welcome");
		Thread threadTwo = new ThreadClass("to");
		Thread threadThree = new ThreadClass("Training Session");
		threadOne.start();

		threadTwo.start();

		threadThree.start();
		try {
			threadOne.join();
			threadTwo.join();
			threadThree.join();
		} catch (InterruptedException e) {
				e.printStackTrace();
		}

	}

}
