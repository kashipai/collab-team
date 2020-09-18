package begin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReadWriteTxt {
	public static void main(String[] args) throws IOException {
		BufferedReader objReader = null;
		BufferedWriter objWriter = null;
		try {
			String strCurrentLine;
			int buffersize = 64 * 1024;
			objReader = new BufferedReader(new FileReader("F:\\work\\misc\\pi.txt"), buffersize);
			objWriter = new BufferedWriter(new FileWriter("F:\\work\\misc\\pi1.txt"), buffersize);
			while ((strCurrentLine = objReader.readLine()) != null) {
				objWriter.write(strCurrentLine);
			}
			objWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			if (objReader != null)
				objReader.close();
			if (objWriter != null)
				objWriter.close();

			System.out.println("The File is Copied");

		}
	}
}
