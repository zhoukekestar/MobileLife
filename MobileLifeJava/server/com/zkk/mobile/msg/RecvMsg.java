package com.zkk.mobile.msg;

import java.io.InputStream;
import java.net.Socket;

import org.apache.log4j.Logger;

public class RecvMsg implements Runnable {
	
	private static Logger logger = Logger.getLogger(RecvMsg.class);
	private Socket socket;

	@Override
	public void run() {
		try {

			InputStream in = socket.getInputStream();
			
			logger.info("recv runing...");
			while (true) {

				byte begin[] = new byte[1];
				in.read(begin);
				int len = in.available();
				if (len > 99999)
					logger.warn("warn: too large.");
				byte data[] = new byte[len];
				in.read(data);

				String msg = new String(begin);
				msg += new String(data);

				logger.debug("redv:[" + msg + "]");
				
				if (msg == "" || msg == null || msg.trim().length() == 0)
				{
					System.out.println("Socket is closed.");
					in.close();
					socket.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public RecvMsg(Socket s) {
		socket = s;
	}

}
