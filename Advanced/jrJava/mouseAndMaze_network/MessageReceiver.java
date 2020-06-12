package jrJava.mouseAndMaze_network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MessageReceiver implements Runnable {

	private BufferedReader br;
	private Mouse enemyMouse;
	
	
	public MessageReceiver(InputStream is){
		InputStreamReader isr = new InputStreamReader(is);
		br = new BufferedReader(isr);
	}
	
	
	public void setEnemyMouse(Mouse enemyMouse){ this.enemyMouse = enemyMouse; }
	
	
	public void run(){
		try {
			while(true){
				String msg = br.readLine();
				//System.out.println(msg);
				if(enemyMouse!=null) enemyMouse.receiveData(msg);
			}
		} catch (IOException e) { }
	}
	
}












