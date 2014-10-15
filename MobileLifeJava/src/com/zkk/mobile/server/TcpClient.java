package com.zkk.mobile.server;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient {

	public static void main(String[] args) throws UnknownHostException,
			IOException, InterruptedException {

		String server = "127.0.0.1";
		int servPort = 1234;

		Socket socket = new Socket(server, servPort);

		
		RecvMsg recvMsg = new RecvMsg(socket);
		new Thread(recvMsg).start();
		SendMsg sendMsg = new SendMsg(socket);
		//new Thread(sendMsg).start();
		sendMsg.run();
	}

}
