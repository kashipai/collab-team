package file;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class bufferedreading {
	public static void main(String args[]) {
        BufferedInputStream in = null;
        BufferedOutputStream out=null;
         
	    try {
	    		in=new BufferedInputStream(new FileInputStream("F:\\buffer\\video.MP4"));
	    		out=new BufferedOutputStream(new FileOutputStream("D:\\myfolder.MP4"));
	    		int a=in.read();
	    		while(a!=-1) {
	    			out.write(a);
	    			a=in.read();
	    			
	    		}
	    		out.flush();   
	            } catch(Exception e) {
	    	        System.out.println("Something went wrong! Reason: " + e.getMessage());
	    	    }
	   
	    Runtime runtime = Runtime.getRuntime();	    
	    runtime.gc();
	    long memory = runtime.totalMemory() - runtime.freeMemory();
	    System.out.println("Used memory is bytes: " + memory);
	  
	}

}

