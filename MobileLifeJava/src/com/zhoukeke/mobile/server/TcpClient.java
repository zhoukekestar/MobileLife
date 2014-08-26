package com.zhoukeke.mobile.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TcpClient implements Runnable {
	public Socket client;
	private static final int BUFSIZE = 32;

	public static void main(String[] args) throws UnknownHostException,
			IOException, InterruptedException {

		String server = "127.0.0.1";
		int servPort = 1234;

		Socket socket = new Socket(server, servPort);

		TcpClient client = new TcpClient();
		client.client = socket;
		new Thread(client).start();


		while (true) {

			Scanner input = new Scanner(System.in);
			OutputStream out = socket.getOutputStream();
			String msg = input.nextLine();
			out.write(msg.getBytes());
			out.flush();
			out.close();
			System.out.println("client has sent:" + msg);
		}
	}

	@Override
	public void run() {
		try {
			InputStream in = client.getInputStream();
			OutputStream out = client.getOutputStream();

			while (true) {
				byte[] buff = new byte[BUFSIZE];
				String msg = "";

				System.out.println("client is listen...");
				while (in.read(buff) != -1) {
					// out.write(receiveBuf, 0, recvMsgSize);
					msg += new String(buff);
				}
				System.out.println("recv form server:" + msg);
			}

		} catch (IOException e) {
			e.printStackTrace();
			try {
				client.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

	}

}
