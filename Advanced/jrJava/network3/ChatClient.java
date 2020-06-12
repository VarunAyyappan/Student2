package jrJava.network3;

import java.net.Socket;


public class ChatClient {

	private String IPAddress = "localhost";
	private int portNumber = 5454;
	
	
	public void connect() throws Exception {
		
		Socket s = new Socket(IPAddress, portNumber);
		
		MessageReceiver receiver = new MessageReceiver(s.getInputStream());
		MessageSender sender = new MessageSender(s.getOutputStream());
		
		Thread t = new Thread(receiver);
		t.start();
		
		GUI gui = new GUI();
		gui.setMessageSender(sender);
		receiver.setGUI(gui);
	}
	
	
	public static void main(String[] args) throws Exception {
		new ChatClient().connect();
	}

}
