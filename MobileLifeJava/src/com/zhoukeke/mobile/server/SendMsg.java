package com.zhoukeke.mobile.server;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SendMsg implements Runnable {
	private Socket socket;

	@Override
	public void run() {
		try {
			System.out.println("send running...");
			while (true) {

				Scanner input = new Scanner(System.in);
				OutputStream out = socket.getOutputStream();
				String msg = input.nextLine();
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
