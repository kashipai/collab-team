package assignment_18_9;

public class ThreadOpration extends Thread {
	static int value = 0;

	public void run() {
		if (Thread.currentThread().isDaemon()) {
			System.out.println("Daemon thread: " + Thread.currentThread().getName() + "-----> " + (value++));
		} else {
			System.out.println("User thread: " + Thread.currentThread().getName() + " ------> " + (value++));
		}

	}

	public static void main(String args[]) throws Exception {

		try {
			ThreadOpration daemonThread = new ThreadOpration();
			daemonThread.setDaemon(true);
			Thread.sleep(1000);
			daemonThread.start();
			ThreadOpration[] thread = new ThreadOpration[50];
			for (int i = 0; i < 50; i++) {
				thread[i] = new ThreadOpration();
				thread[i].start();
				Thread.sleep(1000);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}