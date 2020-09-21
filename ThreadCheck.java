package begin;

public class ThreadCheck extends Thread {
	static int count = 1;

	public void run() {
		System.out.println(count);
		++count;
	}

	public static void main(String[] args) throws InterruptedException {
		ThreadCheck[] t = new ThreadCheck[50];
		try {
			for (int ThreadId = 0; ThreadId < 50; ++ThreadId) {
				t[ThreadId] = new ThreadCheck();
				t[ThreadId].start();
				t[ThreadId].join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
