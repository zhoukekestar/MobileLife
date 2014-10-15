package com.zkk.mobile.server;

import java.io.OutputStream;
import java.net.Socket;

public class SendMsg implements Runnable {
	private Socket socket;

	@Override
	public void run() {
		try {
			System.out.println("send running...");
			OutputStream out = socket.getOutputStream();
			while (true) {
				
				if (MainServer.msgList.size() == 0)
				{
					//System.out.println("size:0");
					Thread.sleep(1000);
					continue;
				}
				//System.out.println("size:" + Data.msgList.size());
				String msg = MainServer.msgList.get(0);
				MainServer.msgList.remove(0);
				out.write(msg.getBytes());
				out.flush();
				System.out.println("client has sent:" + msg);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public SendMsg(Socket s) {
		socket = s;
	}

}
