package com.company;

import java.util.ArrayList;

public class arrayList{
    public  static int tCount=0;
    public  static int fCount=0;
    public static void main(String[] args)
    {
        ArrayList<vehicle> myArr=new ArrayList();

        myArr.add(new TwoWheeler("Bajaj"));tCount++;
        myArr.add(new TwoWheeler("Tvs"));tCount++;
        myArr.add(new FourWheeler("Tata"));fCount++;
        myArr.add(new FourWheeler("Maruthi"));fCount++;
        myArr.add(new TwoWheeler("Tvs"));tCount++;


        for (int i=0;i<myArr.size();i++)
        {
            System.out.println(myArr.get(i).getClass().getSimpleName()+":"+myArr.get(i).Name);
            myArr.get(i).vchlType();
        }
        System.out.println("Number of Two wheeler vehicles:"+tCount);
        System.out.println("Number of Four wheeler vehicles:"+fCount);
        System.out.println("Total Number of vehicles:"+(tCount+fCount));
    }
}
