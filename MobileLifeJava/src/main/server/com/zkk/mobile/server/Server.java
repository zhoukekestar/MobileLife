package com.zkk.mobile.server;

import java.util.ArrayList;
import java.util.List;

import com.zkk.mobile.tcp.TcpServer;

public class Server {
	
	public static List<String> msgList = new ArrayList<String>();
	private static TcpServer tcpServer = null;
	
	public static void runServer()
	{
		if (tcpServer == null)
		{
			tcpServer = new TcpServer();
			new Thread(tcpServer).start();
		}
	}
}
