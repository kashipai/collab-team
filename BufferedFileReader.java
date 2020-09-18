package com.company;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class BufferedFileReader {
    public static void main(String[] args) throws IOException {

        BufferedInputStream bin = null;
        BufferedOutputStream bout = null;
        FileInputStream fin = null;
        FileOutputStream fout = null;


        try {
            fin = new FileInputStream("C:\\Users\\user\\Downloads\\BTS-DNA.mp4");
            bin = new BufferedInputStream( fin);
            fout = new FileOutputStream("C:\\Users\\user\\Downloads\\BTS-DNA(copy).mp4");
            bout = new BufferedOutputStream(fout);

            byte[] buf=new byte[1024];
            int readValues;
            while ((readValues = bin.read(buf,0,1024)) != -1) { //reads from the BTS-DNA
                bout.write(buf);               //writes to the file BTS-DṆA(copy)
            }
            bout.flush();
        }
        catch(IOException ex) {
            System.err.println(ex.getMessage());
        }
        //closing all the objects after the process
        finally {
            if(fin!=null) fin.close();
            if(bin!=null) bin.close();
            if(fout!=null) fout.close();
            if(bout!=null) bout.close();
            System.out.println("-----File copied-----");
        }

    }
}
