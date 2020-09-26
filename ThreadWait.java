package com.company;

public class ThreadWait extends Thread {
    static ThreadWait te=null;
    static int count=0;

    @Override
    public void run()
    {
        try
        {
            counter();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private void counter() throws InterruptedException {
        synchronized (te)
        {
            while(Integer.parseInt(Thread.currentThread().getName().replaceAll("[^0-9]", "")) != count)
            {
                te.wait();
            }
            System.out.println(Thread.currentThread()+" "+(++count));
            te.notifyAll();
        }
    }


    public static void main(String[] args) {
        for(int i=0;i<50;i++)
        {
            te=new ThreadWait();
            te.start();
        }
    }
}
