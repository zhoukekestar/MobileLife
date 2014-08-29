package com.zhoukeke.mobile.server;

import java.io.InputStream;
import java.net.Socket;

public class RecvMsg implements Runnable {
	private Socket socket;

	@Override
	public void run() {
		try {

			InputStream in = socket.getInputStream();

			System.out.println("recv runing...");
			while (true) {

				byte begin[] = new byte[1];
				in.read(begin);
				int len = in.available();
				if (len > 99999)
					System.out.println("warn: too large.");
				byte data[] = new byte[len];
				in.read(data);

				String msg = new String(begin);
				msg += new String(data);

				System.out.println(msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public RecvMsg(Socket s) {
		socket = s;
	}

}
