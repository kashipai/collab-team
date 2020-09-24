package com.company;

import java.io.*;

public class FileThread {
      public static void myWriter(File f1, String s) throws IOException {

         FileWriter fw = null;
         try {
             fw = new FileWriter(f1, true);
             fw.write(s);
             System.out.println("Writing successful");
         } catch (IOException e) {
             e.printStackTrace();
         } finally {
             fw.close();
         }

     }

    public static void main(String[] args) throws IOException {
        File f1=new File("D:\\file.txt");
        f1.createNewFile();
        Thread t1=new Thread(){
            @Override
            synchronized public void run ()
            {
                try {
                    myWriter(f1,"My name is Vikram Kumar\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t2=new Thread(){
            @Override
            synchronized public void run ()
            {
                try {
                    myWriter(f1,"I am a worker in Robosoft\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t3=new Thread(){
            @Override
            synchronized public void run ()
            {
                try {
                    myWriter(f1,"I like coding....Bye....\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        t1.start();
        t2.start();
        t3.start();

    }



}

