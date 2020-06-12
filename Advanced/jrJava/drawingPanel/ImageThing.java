package jrJava.drawingPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class ImageThing implements Drawable {

	private int x, y;
	private int size;
	private Image image;

	public ImageThing(int x, int y, int size, Image image){
		this.x = x;
		this.y = y;
		this.size = size;
		this.image = image;
	}
	
	public void grow(){ size++; }
	public void move(){ x++; y++; }
	
	
	public void draw(Graphics g){
		g.drawImage(image, x, y, size, size, null);
	}
	
}
