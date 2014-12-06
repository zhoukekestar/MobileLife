package com.zkk.mobile.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.zkk.mobile.msg.RecvMsg;
import com.zkk.mobile.msg.SendMsg;
import com.zkk.mobile.server.config.ServerConfig;

public class TcpServer implements Runnable{

	private static List<Socket> socketList;
	private static Logger logger = Logger.getLogger(TcpServer.class);
	
	@SuppressWarnings("resource")
	public static void runit() throws IOException,
			InterruptedException {

		ServerSocket servSock = new ServerSocket(ServerConfig.port );
		socketList = new ArrayList<Socket>();
		logger.info("server start.");

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
