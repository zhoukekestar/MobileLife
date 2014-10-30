package com.zkk.mobile.msg;

import java.io.OutputStream;
import java.net.Socket;

import java.util.Scanner;
import com.zkk.mobile.server.Server;

public class SendMsg implements Runnable {
	private Socket socket;

	@Override
	public void run() {
		try {
			System.out.println("send running...");
			OutputStream out = socket.getOutputStream();
			while (true) {
				
				if (Server.msgList.size() == 0)
				{
					//System.out.println("size:0");
					Thread.sleep(1000);
					continue;
				}
				//System.out.println("size:" + Data.msgList.size());
				String msg = Server.msgList.get(0);
				Server.msgList.remove(0);
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
