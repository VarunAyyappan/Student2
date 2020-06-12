package jrJava.bezier;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;

public class BezierTest_2ndOrder {

	public static void main(String[] args) {
		
		JDrawingBoard board = new JDrawingBoard(1000, 800);
		Graphics2D g = (Graphics2D) board.getCanvas();

		Point p1 = new Point(200, 200);
		Point p2 = new Point(700, 600);
		Point c =  new Point(300, 50);
		
		GeneralPath path = new GeneralPath();
		
		path.moveTo(p1.x, p1.y);
		path.quadTo(c.x, c.y, p2.x, p2.y);
		
		g.setColor(Color.blue);
		g.draw(path);
		
		g.setColor(Color.red);
		g.fillOval((int)(p1.x-2), (int)(p1.y-2), 4, 4);
		g.fillOval((int)(c.x-2), (int)(c.y-2), 4, 4);
		g.fillOval((int)(p2.x-2), (int)(p2.y-2), 4, 4);
		
		board.repaint();
		
	}

}
 



