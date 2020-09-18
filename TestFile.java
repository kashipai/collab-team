package practice;

import java.io.*;


public class BuffReading 
{
	public static void main(String args[])
	{
		try
		
		{
		File src = new File("F:\\Movies and Series\\S1E1.mkv");
		File dest = new File("D:\\Videocopy.mkv");
		
		System.out.println("Size of the source file :"+((src.length())/1000000)+" Mb");
		
		BufferedInputStream bin = new BufferedInputStream(new FileInputStream("F:\\Movies and Series\\S1E1.mkv"));
		BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream("D:\\Videocopy.mkv"));
		
		
		//Setting buffersize 46mb
		
		byte[] buffer = new byte[1024 * 45000];
        int readBuf;

        while(((bin.read())!=-1)) 
        {
        readBuf = bin.read(buffer);
        bout.write(buffer, 0, readBuf);
        
         long destLength = dest.length();
         
        System.out.println("Written "+((destLength)/1000000)+" Mb");
        }
        
        System.out.println("Done writing the file");
        
        bin.close();
        bout.flush();
        bout.close();
		
		}
	    catch(Exception ex)
	 	{
	        System.out.println(ex.getMessage());
	    } 
	}
}
