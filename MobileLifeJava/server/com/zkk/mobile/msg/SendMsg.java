package com.zkk.mobile.msg;

import java.io.OutputStream;
import java.net.Socket;

import org.apache.log4j.Logger;
import com.zkk.mobile.server.Server;

public class SendMsg implements Runnable {
	private Socket socket;
	private static Logger logger = Logger.getLogger(SendMsg.class);
	
	@Override
	public void run() {
		try {
			logger.info("send running...");
			OutputStream out = socket.getOutputStream();
			while (true) {
				
				if (Server.msgList.size() == 0)
				{
					Thread.sleep(1000);
					continue;
				}
				String msg = Server.msgList.get(0);
				Server.msgList.remove(0);
				out.write(msg.getBytes());
				out.flush();
				
				logger.debug("sent:[" + msg + "]");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public SendMsg(Socket s) {
		socket = s;
	}

}
