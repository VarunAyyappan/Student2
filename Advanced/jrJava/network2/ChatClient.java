package jrJava.network2;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ChatClient {

	private String IPAdress = "192.168.1.34";
	private int portNumber = 5454;

	public static void main(String[] args) throws Exception {
		new ChatClient().connect();
	}

	public void connect() throws Exception {
		Socket s = new Socket(IPAdress, portNumber);

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
