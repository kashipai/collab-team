package filevideo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class videoreadwrite {
public static void main(String args[]) {

    final int BUFFERSIZE = 10 * 1024;
    String sourceFilePath = "E:\\Moviess\\check\\r1.mkv";
    String outputFilePath = "E:\\Moviess\\check\\r6.mkv";

    try(
            FileInputStream fileinputs = new FileInputStream(new File(sourceFilePath));
            FileOutputStream fileoutputs = new FileOutputStream(new File(outputFilePath));
            ){

        byte[] buffer = new byte[BUFFERSIZE];
        int bytesRead;

        while(fileinputs.available() != 0) {
        bytesRead = fileinputs.read(buffer);
        fileoutputs.write(buffer, 0, bytesRead);
        }

    }
    catch(Exception e) {
        System.out.println("Error!!! " + e.getMessage());
    }

    }
}
