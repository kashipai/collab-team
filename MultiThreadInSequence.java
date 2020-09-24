package assignment_24_9;

class PrintValues {
	synchronized void incrementCount() {
			if (Thread.currentThread().isDaemon()) {
				System.out.println("Daemon thread: " + Thread.currentThread().getName() + "-----> " + (MultiThreadInSequence.a));
				MultiThreadInSequence.a++;
			} else {
				System.out.println("User thread: " + Thread.currentThread().getName() + "-----> " + (MultiThreadInSequence.a));
				MultiThreadInSequence.a++;
			}
	}
}

public class MultiThreadInSequence extends Thread {
	static int a = 0;
	PrintValues print;

	public MultiThreadInSequence(PrintValues obj) {

		this.print = obj;// TODO Auto-generated constructor stub
	}

	 public void run() {
		print.incrementCount();
	}

	public static void main(String[] args) {
		PrintValues obj = new PrintValues();

		try {
			MultiThreadInSequence dThread1 = new MultiThreadInSequence(obj);
			dThread1.setDaemon(true);
			dThread1.start();
			MultiThreadInSequence[] t = new MultiThreadInSequence[50];
			for (int i = 0; i < 50; i = i + 1) {
				t[i] = new MultiThreadInSequence(obj);
				t[i].start();
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
