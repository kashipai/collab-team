package begin;

public class ThreadCheck extends Thread {
	static int count = 0;
	static Object lock = new Object();

	public void run() {
		synchronized (lock) {
			while(!Thread.currentThread().getName().equals("Thread-" + count)) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + " " + (++count));
			lock.notifyAll();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ThreadCheck[] t = new ThreadCheck[50];
		for (int ThreadId = 0; ThreadId < 50; ++ThreadId) {
			t[ThreadId] = new ThreadCheck();
			t[ThreadId].start();
		}
	}
}
