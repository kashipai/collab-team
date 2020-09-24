package assignment_24_9;

import java.io.FileOutputStream;

class WriteToFiles {
	synchronized void writeString(String message) {

		FileOutputStream out = null;
		try {

			out = new FileOutputStream("/Users/soumya/Desktop/TextFile.txt", true);
			String s = message + " " + Thread.currentThread().getName() + "\n";
			byte b[] = s.getBytes();
			out.write(b);
			out.close();
		} catch (Exception e) {
			System.out.println(e);
		} finally {

			System.out.println("Successfully written from " + Thread.currentThread().getName());

		}
	}
}

class MyThread extends Thread {
	WriteToFiles t;
	String text = "Message received from ";

	MyThread(WriteToFiles t) {
		this.t = t;
	}

	 public void run() {
		try {
			t.writeString(text);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class MultiThreadFiles {
	public static void main(String args[]) {
		WriteToFiles obj = new WriteToFiles();
		MyThread t1 = new MyThread(obj);
		MyThread t2 = new MyThread(obj);
		MyThread t3 = new MyThread(obj);
		t1.start();
		t2.start();
		t3.start();
	}
}
