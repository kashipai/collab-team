package trainingAssignment;

import java.io.DataInputStream;
import java.net.*;

public class SocketClient {
	public static void main(String[] args) {
		try{      
			Socket s=new Socket("localhost",6666);  
			DataInputStream dis=new DataInputStream(s.getInputStream());  
			String  str=(String)dis.readUTF();  
			System.out.println("message= "+str); 
			dis.close();  
			s.close();  
			}catch(Exception e){System.out.println(e);}  
	}
}
