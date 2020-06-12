package jrJava.network4_pingpong;

import java.io.*;

public class MessageReceiver implements Runnable {

	private Deflector dummy;
	private Ball ball;
	
	private BufferedReader br;
	
	public MessageReceiver(InputStream is){
		br = new BufferedReader(new InputStreamReader(is));
	}
	
	public void setDeflector(Deflector dummy){ this.dummy = dummy; }
	public void setBall(Ball ball){ this.ball = ball; }
	
	
	public void run(){
		receive();
	}
	
	
	public void receive(){
		String msg;
		while(true){
			try {
				msg = br.readLine();
				if(msg.startsWith("B:")) ball.update(msg);
				else dummy.update(msg);
			} catch (IOException e) {
				break;
			}
		}
	}
	
}





