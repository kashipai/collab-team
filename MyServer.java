package begin;

import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

	public static void main(String[] args) {
		try {
			ServerSocket serversocket = new ServerSocket(5050);
			Socket socket = serversocket.accept();
			DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
			dout.writeUTF("Hello Client");
			dout.flush();
			dout.close();
			serversocket.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
