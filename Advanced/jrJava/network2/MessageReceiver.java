package jrJava.network2;

import java.io.*;

public class MessageReceiver implements Runnable {
	
	private BufferedReader br;
	
	public MessageReceiver(InputStream is) {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	public void receive() {
		String msg;
		while(true){
			try {
			msg = br.readLine();
			System.out.println(msg);
			}
			catch(IOException e) {
				break;
			}
		}
	}

	@Override
	public void run() {
		receive();
	}
}
