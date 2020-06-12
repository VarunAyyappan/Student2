package jrJava.network3;

import java.io.*;

// Gets the text from the KB and forward to the socket output Stream.
public class MessageSender {
	
	private PrintWriter pw; // writes to Socket
	
	public MessageSender(OutputStream os){
		pw = new PrintWriter(new OutputStreamWriter(os));
	}
	
	
	public void send(String msg){
		pw.println(msg);
		pw.flush();
	}
	
}
