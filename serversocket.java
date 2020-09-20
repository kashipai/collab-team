package socket;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;



public class serversocket {
	   Socket client  = null; 
	   DataInputStream  in   = null; 
	   DataOutputStream out     = null; 
	   public serversocket(int port) {
		  
	
		try{ 
			    ServerSocket serverSocket = new ServerSocket(port);
			    Socket client = serverSocket.accept();
			    System.out.println("connection accepted");
			    DataInputStream in=new DataInputStream(client.getInputStream());  
			    DataOutputStream out=new DataOutputStream(client.getOutputStream()); 
			    System.out.println("server says"); 
			  
			    String str2="hello!!";     
			    out.writeUTF(str2); 
			    in.close();  
				client.close();  
				serverSocket.close();   
	
		}catch(Exception e) {
			System.out.println("something went wrong" +e.getMessage());
			
		}
}
public static void main(String[] args) {
	//String serverName = args[0];
 //int port =Integer.parseInt(args[1]);
	serversocket s=new serversocket(1342);
	
}
	  

	   }  


