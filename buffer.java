package sample;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.*;


public class buffer {
	
		public static void main(String[] args)
		{
			
			try {
				int size=1024*10;
				String source="F:\\Example\\Example2.txt";
				String dest = "F:\\Example\\test\\data000.txt";
				File f1=new File(source);
				
				FileInputStream  fin=new FileInputStream(new File(source));
				FileOutputStream  fw=new FileOutputStream(new File(dest));
				BufferedInputStream bin=new BufferedInputStream(fin);
				BufferedOutputStream bw=new BufferedOutputStream(fw,size);
				
				byte[] buffer = new byte[1024 * 45000];
				
				int rb=0;
				
				while((bin.read())!=-1)
				{
					rb = bin.read(buffer);
			        bw.write(buffer, 0, rb );
					bw.write(rb);
				}
				bw.flush();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}

	
}
