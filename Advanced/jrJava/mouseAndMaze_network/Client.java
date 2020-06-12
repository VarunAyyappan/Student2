package jrJava.mouseAndMaze_network;

import java.awt.Graphics;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

	private String serverIPAddress = /*"localhost"; */ "192.168.1.43";
	private int serverPortNumber = 5454;
	private InputStream is;
	private OutputStream os;
	
	public Client(){
		try {
			Socket s = new Socket(serverIPAddress, serverPortNumber);
			is = s.getInputStream();
			os = s.getOutputStream();
		}catch (IOException e) { }
	}
	
	public InputStream getInputStream(){ return is; }
	public OutputStream getOutputStream(){ return os; }
	
	
	public static void main(String[] args) {
		Client client = new Client();
		
		Mouse myMouse = new Mouse(475, 475, true);
		Mouse enemyMouse = new Mouse(25, 30, false);

		MessageSender mSender = new MessageSender(client.getOutputStream());
		myMouse.setMessageSender(mSender);
		
		MessageReceiver mReceiver = new MessageReceiver(client.getInputStream());
		mReceiver.setEnemyMouse(enemyMouse);
		new Thread(mReceiver).start();
		
		
		Maze maze = new Maze();
		myMouse.setMaze(maze);
		
		Food food = new Food();
		myMouse.setFood(food);
		enemyMouse.setFood(food);
		
		JDrawingBoard board = new JDrawingBoard(500, 500);
		Graphics g = board.getCanvas();
		board.addKeyListener(myMouse);
		
		new Thread(myMouse).start();
		
		while(true){
			board.clearCanvas();
			food.draw(g);
			myMouse.draw(g);
			enemyMouse.draw(g);
			maze.draw(g);
			board.repaint();
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) { }
		}
	}

}






