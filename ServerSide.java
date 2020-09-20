package assignment_18_9;

import java.io.*;
import java.net.*;

public class ServerSide {
	public static void main(String[] args) {
		try {
			ServerSocket serversocket = new ServerSocket(65535);
			Socket socket = serversocket.accept();

			DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());
			dataOut.writeUTF("Hello Client!!!");
			
			dataOut.flush();
			dataOut.close();
			serversocket.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
