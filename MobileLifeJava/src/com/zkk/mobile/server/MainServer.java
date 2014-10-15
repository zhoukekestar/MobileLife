package com.zkk.mobile.server;

import java.util.ArrayList;
import java.util.List;

public class MainServer {
	public static List<String> msgList = new ArrayList<String>();

	public static TcpServer tcpServer = null;
	
	public static void runServer()
	{
		if (tcpServer == null)
		{
			//System.out.println("Try tcpServer.");
			tcpServer = new TcpServer();
			new Thread(tcpServer).start();
		}
		
	}
}
