package begin;

import java.io.DataInputStream;
import java.net.Socket;

public class MyClient {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 5050);
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			String str = (String) dis.readUTF();
			System.out.println("Message= " + str);
			socket.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
