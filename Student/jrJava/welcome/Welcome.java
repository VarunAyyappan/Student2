package jrJava.welcome;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import resources.DrawingBoard;
import trace.Trace;

public class Welcome {

	public static void main(String[] args){
		
		DrawingBoard board = new DrawingBoard(0, 0, 1000, 600);
		Graphics2D canvas = board.getCanvas();
		
		canvas.setFont(new Font("arial", Font.BOLD, 120));
		
		canvas.setColor(Color.RED);
		canvas.drawString("Welcome to", 150, 180);
		
		canvas.setColor(Color.GREEN);
		canvas.drawString("Jr.Java", 250, 320);
		
		canvas.setColor(Color.BLUE);
		canvas.drawString("class", 300, 460);
		
		board.repaint();
		
	}
	
}
