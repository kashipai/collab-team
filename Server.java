package sample;

import java.io.*;  
import java.net.*;

public class Server {
	public static void main(String[] args){  
		try{  
		ServerSocket ss=new ServerSocket(6666);  
		Socket s=ss.accept();//accept connections   
		DataInputStream dis=new DataInputStream(s.getInputStream());  
		String  str=(String)dis.readUTF();  
		System.out.println("message= "+str);
		DataOutputStream dout=new DataOutputStream(s.getOutputStream()); 
		dout.writeUTF("Hello Client"); 
		ss.close();  
		}catch(Exception e){
			System.out.println(e);}  
		} 
}
