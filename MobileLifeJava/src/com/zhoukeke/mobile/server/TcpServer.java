package com.zhoukeke.mobile.server;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class TcpServer implements Runnable {

	private static final int BUFSIZE = 32;
	private static List<Socket> socketList;

	public static void main(String[] args) throws IOException,
			InterruptedException {

		int servPort = Integer.parseInt("1234");

		// 1.创建一个ServerSocket实例并制定本地端口。此套接字的功能是侦听该制定端口收到的连接。
		ServerSocket servSock = new ServerSocket(servPort);
		socketList = new ArrayList<Socket>();
		// 2.重复执行
		while (true) {

			Socket clntSock = servSock.accept();
			socketList.add(clntSock);
			TcpServer server = new TcpServer();
			server.client = clntSock;
			new Thread(server).start();
			
			//sendMsg("A new socket in.");
		}
	}

	public Socket client;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int recvMsgSize;

		byte[] receiveBuf = new byte[BUFSIZE];
		try {

			while (true) {
				SocketAddress clientAddress = client.getRemoteSocketAddress();
				System.out.println("Handling client at " + clientAddress);

				// b,使用所返回的Socket实例的InputStream和OutputStream与客户端进行通信
				InputStream in = client.getInputStream();
				OutputStream out = client.getOutputStream();

				String msg = "";
				System.out.println("Server is listening...");
				while ((recvMsgSize = in.read(receiveBuf)) != -1) {
					//out.write(receiveBuf, 0, recvMsgSize);
					msg += new String(receiveBuf);
				}
				System.out.println("server recv:" + msg);
			}
		} catch (Exception e) {

			e.printStackTrace();
			try {
				client.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

	}

	public static void sendMsg(String msg) {
		try {
			for (Socket socket : socketList) {
				OutputStream out;

				out = socket.getOutputStream();

				out.write(msg.getBytes());
				out.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
