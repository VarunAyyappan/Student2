package jrJava.network2;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

	private int portNumber = 5454;

	public static void main(String[] args) throws Exception {
		new ChatServer().connect();
	}

	public void connect() throws Exception {
		ServerSocket ss = new ServerSocket(portNumber);
		Socket s = ss.accept();

		InputStream is = s.getInputStream();
		OutputStream os = s.getOutputStream();
		
		MessageReceiver receiver = new MessageReceiver(is);
		MessageSender sender = new MessageSender(os);

		System.out.println("Ready: ");
		Thread t = new Thread(receiver);
		t.start();
		sender.send();
	}

}
