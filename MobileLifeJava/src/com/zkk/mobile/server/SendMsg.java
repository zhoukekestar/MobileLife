package com.zkk.mobile.server;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

import com.zkk.mobile.model.Data;

public class SendMsg implements Runnable {
	private Socket socket;

	@Override
	public void run() {
		try {
			System.out.println("send running...");
			OutputStream out = socket.getOutputStream();
			while (true) {
				
				if (Data.msgList.size() == 0)
				{
					//System.out.println("size:0");
					Thread.sleep(1000);
					continue;
				}
				//System.out.println("size:" + Data.msgList.size());
				String msg = Data.msgList.get(0);
				Data.msgList.remove(0);
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
