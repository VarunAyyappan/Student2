package jrJava.drawingPanel;

import java.awt.Color;
import java.awt.Graphics;

public class Circle implements Drawable {

	private int x, y;
	private int radius;
	private Color color;

	public Circle(int x, int y, int radius, Color color){
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.color = color;
	}
	
	public void grow(){ radius++; }
	public void move(){ x++; y++; }
	
	
	public void draw(Graphics g){
		g.setColor(color);
		g.fillOval(x-radius, y-radius, 2*radius, 2*radius);
	}
	
}
