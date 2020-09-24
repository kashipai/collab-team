package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileThread {

    synchronized static void function1()
    {
        Scanner in=new Scanner(System.in);
        File f1=new File("D:\\file1.txt");
        try {
            f1.createNewFile();
            System.out.println("Enter writeable content:");
            String content=in.nextLine();
            myWriter(f1,content);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    synchronized static void function2()
    {
        Scanner in=new Scanner(System.in);
        File f1=new File("D:\\file2.txt");
        try {
            f1.createNewFile();
            System.out.println("Enter writeable content:");
            String content=in.nextLine();
            myWriter(f1,content);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    synchronized static void function3()
    {
        Scanner in=new Scanner(System.in);
        File f1=new File("D:\\file3.txt");
        try {
            f1.createNewFile();
            System.out.println("Enter writeable content:");
            String content=in.nextLine();
            myWriter(f1,content);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void myWriter(File f1, String content) throws IOException {
        FileWriter fw = null;
        try {
            fw = new FileWriter(f1);
            for (int i = 0; i < content.length(); i++)
                fw.write(content.charAt(i));
            System.out.println("Writing successful");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fw.close();
        }
    }


    public static void main(String[] args) {
        Thread t1=new Thread(){
            @Override
            public void run ()
            {
                function1();
            }
        };
        Thread t2=new Thread(){
            @Override
            public void run ()
            {
                function2();
            }
        };
        Thread t3=new Thread(){
            @Override
            public void run ()
            {
                function3();
            }
        };
        t1.start();
        t2.start();
        t3.start();

    }
}
