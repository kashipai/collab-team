package begin;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ThreadFile extends Thread {
	static String string1 = "Hello\n";
	static String string2 = "How are you\n";
	static String string3 = "I am fine\n";
	FileWriter objWriter = null;
	String string = "";

	public ThreadFile(String string) {
		this.string = string;
	}

	synchronized public void getLine() throws IOException {
		try {
			objWriter = new FileWriter(new File("F:\\work\\misc\\pi17.txt"), true);
			objWriter.write(this.string);
			System.out.println(this.string);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			objWriter.close();
		}
	}

	public void run() {
		try {
			getLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ThreadFile thread1 = new ThreadFile(string1);
		ThreadFile thread2 = new ThreadFile(string2);
		ThreadFile thread3 = new ThreadFile(string3);
		thread1.start();
		thread2.start();
		thread3.start();
	}

}
