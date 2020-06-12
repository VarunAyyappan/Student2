package jrJava.network4_pingpong;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import resources.DrawingBoard;

public class PingPong {

	public static final int WIDTH = 400, HEIGHT = 300;
	public static final String IP_ADDRESS = "localhost";
	public static final int PORT_NUMBER = 5454;
	
	
	public static void main(String[] args) throws Exception {
		
		char mode = 'c';
		System.out.println("Are you client('c') or Server('s')?");
		if((char) System.in.read()=='s') mode = 's';
		
		// preapre network connection
		Socket s;
		if(mode=='s') s = new ServerSocket(PORT_NUMBER).accept();
		else s = new Socket(IP_ADDRESS, PORT_NUMBER);
		
		MessageSender sender = new MessageSender(s.getOutputStream());
		MessageReceiver receiver = new MessageReceiver(s.getInputStream());
		new Thread(receiver).start();
		
		// prepare game components:
		DrawingBoard board = new DrawingBoard(0, 0, WIDTH, HEIGHT);
		
		Deflector deflector = new Deflector(mode, true); // active
		Deflector dummy = new Deflector(mode, false);  // dummy
		board.addMouseMotionListener(deflector);
		
		deflector.setMessageSender(sender);
		receiver.setDeflector(dummy);
		
		Ball ball = new Ball(mode);
		ball.setDeflector(deflector);
		ball.setMessageSender(sender);
		receiver.setBall(ball); 
		
		int interval = 50;
		long nextSyncTime = System.currentTimeMillis() + interval;
		int sleepTime;
		
		while(true){
			ball.move();
			board.clear();
			ball.draw(board);
			deflector.draw(board);
			dummy.draw(board);
			board.repaint();
			
			sleepTime = Math.max(0, (int)(nextSyncTime -System.currentTimeMillis()));
			Thread.currentThread().sleep(sleepTime);
			nextSyncTime += interval;
		}
		
	}

}














