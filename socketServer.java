package practice;

import java.io.*;
import java.net.*;

public class socketServer 
{
	public static void main (String args[])
	{
		try
		{
			
		ServerSocket ss = new ServerSocket (3333);
		Socket soc = ss.accept();
		
		DataOutputStream dp = new DataOutputStream (soc.getOutputStream());
		
		dp.writeUTF(" Connection established successfully \n Server says hello");
		
		ss.close();
	}
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
}