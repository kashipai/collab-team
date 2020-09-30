package com.company;

public class TwoWheeler extends vehicle
{

    public TwoWheeler(String str)
    {
        super();
        this.Name=str;
    }
    public void vchlType()
    {

        System.out.println(Name+" is a Two Wheeler vehicle");
    }
}
