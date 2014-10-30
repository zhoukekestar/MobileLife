package com.zkk.mobile.msg;

import java.io.OutputStream;
import java.net.Socket;
<<<<<<< HEAD:MobileLifeJava/server/com/zkk/mobile/msg/SendMsg.java
import java.util.Scanner;

import com.zkk.mobile.server.Server;
=======
>>>>>>> 0b4bd7341c7fc2818aca4df8a5f04307a3d7d7bf:MobileLifeJava/src/com/zkk/mobile/server/SendMsg.java

public class SendMsg implements Runnable {
	private Socket socket;

	@Override
	public void run() {
		try {
			System.out.println("send running...");
			OutputStream out = socket.getOutputStream();
			while (true) {
				
<<<<<<< HEAD:MobileLifeJava/server/com/zkk/mobile/msg/SendMsg.java
				if (Server.msgList.size() == 0)
=======
				if (MainServer.msgList.size() == 0)
>>>>>>> 0b4bd7341c7fc2818aca4df8a5f04307a3d7d7bf:MobileLifeJava/src/com/zkk/mobile/server/SendMsg.java
				{
					//System.out.println("size:0");
					Thread.sleep(1000);
					continue;
				}
				//System.out.println("size:" + Data.msgList.size());
<<<<<<< HEAD:MobileLifeJava/server/com/zkk/mobile/msg/SendMsg.java
				String msg = Server.msgList.get(0);
				Server.msgList.remove(0);
=======
				String msg = MainServer.msgList.get(0);
				MainServer.msgList.remove(0);
>>>>>>> 0b4bd7341c7fc2818aca4df8a5f04307a3d7d7bf:MobileLifeJava/src/com/zkk/mobile/server/SendMsg.java
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
