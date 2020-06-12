package jrJava.drawingBoard;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Coordinator {

	
	public static void main(String[] args) {
		FancyDrawingBoard board = new FancyDrawingBoard(800, 600);
		
		board.clear();
		board.repaint();
		
		Square s1 = new Square(200, 100, 150, Color.red);
		Square s2= new Square(500, 400, 220, Color.cyan);
		Circle c1 = new Circle(300, 500, 70, Color.blue);
		Circle c2 = new Circle(600, 200, 170, Color.orange);
		ImageThing t1 = new ImageThing(100, 300, 100, new ImageIcon("jrJava/drawingPanel/heart.png").getImage());
		ImageThing t2 = new ImageThing(400, 200, 200, new ImageIcon("jrJava/drawingPanel/hockey_stick.png").getImage());
		
		Graphics canvas = board.getCanvas();
		s1.draw(canvas);
		s2.draw(canvas);
		c1.draw(canvas);
		c2.draw(canvas);
		t1.draw(canvas);
		t2.draw(canvas);
		
		board.repaint();
	}

}
