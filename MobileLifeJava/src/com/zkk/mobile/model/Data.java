package com.zkk.mobile.model;

import java.util.ArrayList;
import java.util.List;

import com.zkk.mobile.server.TcpServer;

public class Data {
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
