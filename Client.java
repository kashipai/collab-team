package ServerClient;

import java.net.*;
import java.io.*;


public class Client {
	
	private Socket socket = null;
	private DataInputStream input = null;
	private DataOutputStream output = null;
	
	public Client(String address, int port) {
		try {
			socket = new Socket(address, port);
			System.out.println("Successfully connected");
			input = new DataInputStream(System.in);
			output = new DataOutputStream(socket.getOutputStream());
			
		}
		catch(Exception e) {
			System.out.println("exception1"+e);
		}
		
		String line = "";
		while(!line.equals("0000")) {
			try {
				line = input.readLine();
				output.writeUTF(line);
				
			}
			catch(Exception e) {
				System.out.println("exception2"+e);
			}

		}
		
		try {
			System.out.println("closing client connection");
			input.close();
			output.close();
			socket.close();
			
			
		}
		catch(Exception e) {
			System.out.println("exception3"+e);
		}
	}
	

	public static void main(String[] args) {
		String address = "127.0.0.1";
		int Port = 5000;
		
		Client client = new Client(address, Port);
		

	}

}
