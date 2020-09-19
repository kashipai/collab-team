package com.company;

public class ThreadExample extends Thread {
    static int count=0;
    synchronized public static void counter()
    {
        System.out.println(Thread.currentThread()+" "+ (++count));
    }


    public static void main(String[] args) throws InterruptedException {
         Thread[] t=new Thread[50];
        for(int i=0;i<50;i++)
        {
         t[i]=new Thread(){
            @Override
            public void run ()
            {
                counter();
            }
        };
         t[i].start();
          t[i].sleep(1000);
        }
    }
}

