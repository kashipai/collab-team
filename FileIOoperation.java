package trainingAssignment;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileIOoperation {
	 static final int MegaBytes = 1024*1024;
	 public static void main(String[] args) {
			
			int i;
			try {
				FileInputStream fileIp = new FileInputStream("E:\\Project 2019-2020\\videos\\ppt.mp4");
				BufferedInputStream bin = new BufferedInputStream(fileIp);
				FileOutputStream fout = new FileOutputStream("E:\\ROBOSOFT\\training\\ppt1.mp4");    
				BufferedOutputStream bout = new BufferedOutputStream(fout);    	
				while((i =bin.read())!=-1) {
				bout.write((char)i);
				}
				bout.close();
				bin.close();
				System.out.println("Sucess!!!");
			}catch (Exception e) {System.out.println(e);	}
	       long memoryUsed = Runtime.getRuntime().totalMemory()/MegaBytes - Runtime.getRuntime().freeMemory()/MegaBytes;//MegaBytes
		   System.out.println("memoryUsed : "+memoryUsed + "MB");
		}
}
