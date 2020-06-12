package jrJava.drawingBoard;

import java.awt.Color;
import java.awt.Graphics;

public class Square {
	
	private int x, y;
	private int size;
	private Color color;

	public Square(int x, int y, int size, Color color){
		this.x = x;
		this.y = y;
		this.size = size;
		this.color = color;
	}
	
	public void grow(){ size++; }
	public void move(){ x++; y++; }
	
	
	public void draw(Graphics g){
		g.setColor(color);
		g.fillRect(x, y, size, size);
	}
	
	
}
