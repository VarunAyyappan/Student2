package jrJava.network3;

import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

	private int portNumber = 5454;
	
	
	public void connect() throws Exception {
		
		ServerSocket ss = new ServerSocket(portNumber);
		Socket s = ss.accept();
		
		MessageReceiver receiver = new MessageReceiver(s.getInputStream());
		MessageSender sender = new MessageSender(s.getOutputStream());
		
		Thread t = new Thread(receiver);
		t.start();
		
		GUI gui = new GUI();
		gui.setMessageSender(sender);
		receiver.setGUI(gui);
	}
	
	
	public static void main(String[] args) throws Exception {
		new ChatServer().connect();
	}

}
