package jrJava.mouseAndMaze;

import java.awt.Graphics;

public class Coordinator {

	public static void main(String[] args) {
		
		JDrawingBoard board = new JDrawingBoard(500, 500);
		Graphics g = board.getCanvas();

		Mouse myMouse = new Mouse(475, 30, true);
		Mouse enemyMouse = new Mouse(25, 30, false);
				
		board.addKeyListener(myMouse);
		
		Maze maze = new Maze();
		myMouse.setMaze(maze);
		
		while(true){
			
			myMouse.move();
			
			board.clearCanvas();
			myMouse.draw(g);
			enemyMouse.draw(g);
			maze.draw(g);
			board.repaint();  
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) { }
		}
	}

}
