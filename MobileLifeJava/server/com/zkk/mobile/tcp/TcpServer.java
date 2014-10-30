package com.zkk.mobile.tcp;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

import com.zkk.mobile.config.MobileConfig;
import com.zkk.mobile.msg.RecvMsg;
import com.zkk.mobile.msg.SendMsg;

public class TcpServer implements Runnable{

	private static List<Socket> socketList;

	public static void runit() throws IOException,
			InterruptedException {

		int servPort = Integer.parseInt(MobileConfig.serverPort);

		ServerSocket servSock = new ServerSocket(servPort);
		socketList = new ArrayList<Socket>();
		System.out.println("server start.");

		while (true) {

			Socket clntSock = servSock.accept();
			socketList.add(clntSock);
			
			RecvMsg recvMsg = new RecvMsg(clntSock);
			new Thread(recvMsg).start();
			SendMsg sendMsg = new SendMsg(clntSock);
			new Thread(sendMsg).start();
			
		}
	}

	@Override
	public void run() {
		try {
			runit();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	

}
