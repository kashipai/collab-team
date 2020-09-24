package New;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandlerClass {
	
	synchronized void printToFile(String Data) {
		
		try {
		FileWriter writer = new FileWriter("C:\\Users\\HARSHA\\Desktop\\DataFile.txt",true);
		writer.write(Data);
		writer.write(" ");
		writer.close();
		System.out.print(Data);
		Thread.sleep(100);
		}catch (IOException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
