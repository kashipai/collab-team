package ServerClient;


import java.net.*;
import java.io.*;

public class Server {
	 
    private Socket          socket   = null; 
    private ServerSocket    server   = null; 
    private DataInputStream in       =  null; 

  
    public Server(int port) 
    { 
        try
        { 
            server = new ServerSocket(port); 
            System.out.println("Server started.......Waiting for a client"); 
            socket = server.accept(); 
            System.out.println("Client Accepted"); 
            in = new DataInputStream( 
                new BufferedInputStream(socket.getInputStream())); 
  
            String line = ""; 
            while (!line.equals("0000")) 
            { 
                try
                { 
                    line = in.readUTF(); 
                    System.out.println(line); 
  
                } 
                catch(Exception e) 
                { 
                    System.out.println("exception==" + e); 
                } 
            } 
            System.out.println("Closing Connection"); 
            socket.close(); 
            in.close(); 
        } 
        catch(Exception e) 
        { 
            System.out.println("exception==" + e); 
        } 	
		
	}
	


	public static void main(String[] args) {
		int port = 5000;
		Server server =new Server(port);

	}

}
