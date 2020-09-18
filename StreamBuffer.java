package myproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;


public class StreamBuffer {

	public static void main(String[] args) {
		try {
			int size = 1024*10;
			String source = "E:\\training\\data\\small.txt";
			String dest = "E:\\training\\test\\read105.txt";
			File fin = new File(source);
			FileInputStream fis = new FileInputStream(fin);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis),size);
	 
			FileWriter fstream = new FileWriter(dest, true);
			BufferedWriter out = new BufferedWriter(fstream,size);
	 

			final char[] buf = new char[100]; //specific size of buffer
			int Length = 0;
			

			while ((Length = in.read(buf))!= -1) {   // in.read(buf, 0, 100);
				System.out.println(Length);
				out.write(buf);                     //out.write(buf, 0, length);
			
				
				
				
			}
			System.out.println("done");
			in.close();
			out.close();
			
			
		}
		catch(Exception e) {
			System.out.println("exception"+e);
		}

	}

}
