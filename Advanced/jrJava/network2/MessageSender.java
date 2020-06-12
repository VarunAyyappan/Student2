package jrJava.network2;

import java.io.*;

public class MessageSender {

	private BufferedReader br;
	private PrintWriter pw;

	public MessageSender(OutputStream os) {
		br = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(new OutputStreamWriter(os));
	}

	public void send() {
		String msg;

		while(true) {
			try {
				msg = br.readLine();
				pw.println(msg);
				pw.flush();
			}
			catch(IOException e) {
				break;
			}
		}
	}

}
