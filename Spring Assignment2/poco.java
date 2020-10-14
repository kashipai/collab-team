package com.smk.Assignment2;

import org.springframework.beans.factory.annotation.Autowired;

public class poco {
	@Autowired
	camerasensor s1;
	public camerasensor gets1()
	{
		return s1;
	}
	
	public  void sets1(camerasensor s1)
	{
		this.s1=s1;
	}
	public void specs()
	{
		System.out.println(" Display:-6.7\n Processor:-Snapdragon 720G");
		s1.cs();
	}

}
