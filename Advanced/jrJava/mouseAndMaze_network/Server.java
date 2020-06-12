package jrJava.mouseAndMaze_network;

import java.awt.Graphics;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private int portNumber = 5454;
	private InputStream is;
	private OutputStream os;
	
	public Server(){
		 try {
			ServerSocket ss = new ServerSocket(portNumber);
			Socket s = ss.accept();
			is = s.getInputStream();
			os = s.getOutputStream();
		} catch (IOException e) { }
	}
	
	public InputStream getInputStream(){ return is; }
	public OutputStream getOutputStream(){ return os; }
	
	
	
	public static void main(String[] args) {
		Server server = new Server();

		Mouse myMouse = new Mouse(25, 30, true);
		Mouse enemyMouse = new Mouse(475, 475, false);
		
		MessageSender mSender = new MessageSender(server.getOutputStream());
		myMouse.setMessageSender(mSender);
		
		MessageReceiver mReceiver = new MessageReceiver(server.getInputStream());
		mReceiver.setEnemyMouse(enemyMouse);
		new Thread(mReceiver).start();
		
		Maze maze = new Maze();
		myMouse.setMaze(maze);
		
		Food food = new Food();
		
		JDrawingBoard board = new JDrawingBoard(500, 500);
		Graphics g = board.getCanvas();
		board.addKeyListener(myMouse);
		
		new Thread(myMouse).start();
		
		while(true){
			board.clearCanvas();
			myMouse.draw(g);
			enemyMouse.draw(g);
			maze.draw(g);
			food.draw(g);
			board.repaint();
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) { }
		}
	}

}







