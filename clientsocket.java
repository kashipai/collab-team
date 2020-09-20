package socket;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

//import socketclient.client;
public class clientsocket {
	
	   Socket client= null; 
	   DataInputStream  in = null; 
	   DataOutputStream out = null; 
	   public clientsocket(String ipaddress,int portnum) {
	  
		try {
		Socket client=new Socket(ipaddress,portnum);
		System.out.println("initiating connection!!");
		DataInputStream in=new DataInputStream(client.getInputStream());  
	    DataOutputStream out=new DataOutputStream(client.getOutputStream());  
	  
	    String str1="hii!!",str2="";   
	    out.writeUTF(str1);  
	    System.out.println("client says: "+str1);
	    str2=in.readUTF();  
	    System.out.println("Server says: "+str2);  
	    out.close();  
	    client.close();  
	    
	}catch(Exception e) {
		System.out.println("something went wrong"+e.getMessage());
	}
	
		}
	public static void main(String[] args) {
		//String serverName = args[0];
	   // int port = Integer.parseInt(args[1]);
		clientsocket c =new clientsocket( "127.0.0.1",1342);
		
	}
		
}



