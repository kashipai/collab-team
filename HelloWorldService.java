package com.programcreek.helloworld.services;
import org.springframework.stereotype.Service;
@Service("HelloWorldService")
public class HelloWorldService {
	private String name;
	 
	public void setName(String name) {
		this.name = name;
	}
 
	public String sayHello() {
		return "Hello! " + name;
	}
	public int addition(int a, int b) {
		return a+b;
	}

}
