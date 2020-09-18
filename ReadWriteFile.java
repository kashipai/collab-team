package assignment_17_9;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadWriteFile {
	public static void main(String[] args) throws IOException {

		String sourceFile = "/Users/soumya/Desktop/Video.mov";
		String destinationFile = "/Users/soumya/Desktop/Videobuffer.mov";
		byte[] buffer = new byte[50000 * 1024];
		int c;

		try {
			BufferedInputStream bin = new BufferedInputStream(new FileInputStream(sourceFile));
			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(destinationFile));

			while ((bin.available()) != 0) {
				c = bin.read(buffer);
				bout.write(buffer, 0, c);

			}
			bout.flush();
			bout.close();
			bin.close();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("File copied successfully");
		}

	}

}