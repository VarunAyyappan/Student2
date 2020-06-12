package jrJava.mouseAndMaze_network;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Food {

	private BufferedImage image;
	
	public Food(){
		try {
			image = ImageIO.read(new File("jrJava/mouseAndMaze_network/foods.png"));
		} catch (IOException e) { }
	}
	
	
	public void draw(Graphics g){
		g.drawImage(image, 0,  0, null);
	}
	
	
	public int clear(int x, int y, int w, int h){
		int scoreIncrement = 0;
		int i,j, alpha;
		for(i=x; i<x+w; i++){
			for(j=y; j<y+h; j++){
				if(Math.random()<0.03){
					alpha = getAlpha(i,j);
					if(alpha>10){
						if(alpha==255) scoreIncrement += 1;
						else if(alpha==254) scoreIncrement += 4;
						else if(alpha==253) scoreIncrement += 2;
						else if(alpha==252) scoreIncrement += 3;
						else if(alpha==251) scoreIncrement += 5;
						else if(alpha==250) scoreIncrement += 6;
						image.setRGB(i, j, 0);
					}
				}
			}
		}
		return scoreIncrement;
	}
	
	
	
	private int getAlpha(int x, int y){
		int color = image.getRGB(x,  y);
		return (color>>24) & 0x000000ff;
	}
	
	
}










