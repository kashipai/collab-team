package practice;

import java.io.*;
import java.net.*;

public class socketClient
{
	public static void main (String args[])
	{
		try
		{
			Socket soc = new Socket("localhost",3333);
			
			DataInputStream dis = new DataInputStream (soc.getInputStream());
			
			String messageSer = dis.readUTF();
			
			System.out.println(messageSer);
		
			dis.close();
		}

		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
}
