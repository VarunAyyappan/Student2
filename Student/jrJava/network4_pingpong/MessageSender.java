package jrJava.network4_pingpong;

import java.io.*;

public class MessageSender {

	private PrintWriter pw;
	
	
	public MessageSender(OutputStream os){
		pw = new PrintWriter(new OutputStreamWriter(os));
	}
	
	
	public void send(String msg){
		pw.println(msg);
		pw.flush();
	}
}
