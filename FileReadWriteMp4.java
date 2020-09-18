package begin;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileReadWriteMp4 {
	public static void main(String[] args) throws IOException {
		BufferedInputStream objReader = null;
		BufferedOutputStream objWriter = null;
		try {
			int buffersize = 64 * 1024;
			objReader = new BufferedInputStream(new FileInputStream("F:\\Movies\\a1.mp4"), buffersize);
			objWriter = new BufferedOutputStream(new FileOutputStream("F:\\Movies\\a2.mp4"), buffersize);
			int Object;
			while ((Object = objReader.read()) != -1) {
				objWriter.write(Object);
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
