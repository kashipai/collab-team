package assignment_18_9;

import java.io.*;
import java.net.*;

public class ClientSide {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 65535);

			DataInputStream dataIn = new DataInputStream(socket.getInputStream());

			String message = (String) dataIn.readUTF();
			System.out.println("Message from the server: " + message);

			socket.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
