package jrJava.mouseAndMaze_network;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Maze {

	private BufferedImage image;

	
	public Maze(){
		try {
			image = ImageIO.read(new File("jrJava/mouseAndMaze_network/maze.png"));
		} catch (IOException e) { }
	}
	
	
	public void draw(Graphics g){
		g.drawImage(image, 0,  0, null);
	}
	
	
	public boolean hitWall(int x, int y){
		if(getAlpha(x, y)<10) return false;
		else return true;
	}
	
	private int getAlpha(int x, int y){ 
		int color = image.getRGB(x, y);
		return (color>>24) & 0x000000ff;
	}
	
	private int getRed(int x, int y){  
		int color = image.getRGB(x, y);
		return (color>>16) & 0x000000ff;
	}
	
	private int getGreen(int x, int y){  
		int color = image.getRGB(x, y);
		return (color>>8) & 0x000000ff;
	}
	
	private int getBlue(int x, int y){ 
		int color = image.getRGB(x, y);
		return (color>>0) & 0x000000ff;
	}
	
}











