	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;
public class FileRW {
	
	    public static void main(String[] args)
	    {	
	    	FileInputStream instream = null;
		FileOutputStream outstream = null;
	 
	    	try{
	    	    File infile =new File("I:\\g recovered\\arduino-1.8.10-windows.exe");
	    	    File outfile =new File("I:\\g recovered\\arduino-1.8.10-windows1.exe");
	 
	    	    instream = new FileInputStream(infile);
	    	    outstream = new FileOutputStream(outfile);
	 
	    	    byte[] buffer = new byte[30000];
	 
	    	    int length;
	    	  
	    	    while ((length = instream.read(buffer)) > 0){
	    	    	outstream.write(buffer, 0, length);
	    	    }

	    	    instream.close();
	    	    outstream.close();
	    	    

	    	    System.out.println("File copied successfully!!");
	 
	    	}catch(IOException ioe){
	    		ioe.printStackTrace();
	    	 }
	    }
	}


