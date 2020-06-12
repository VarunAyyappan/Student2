package jrJava.imageManipulation;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Basic {

	
	public static void main(String[] args) {
		
		BufferedImage b = new BufferedImage(600, 400, BufferedImage.TYPE_INT_ARGB);
		
		int i, j;
		int alpha, red, green, blue;
		int color;
		
		for(i=100; i<350; i++){
			for(j=100; j<350; j++){
				alpha = 100;
				red = 0;
				green = 255;
				blue = 0;
				color = alpha<<24 | red<<16 | green<<8 | blue;
				b.setRGB(i, j, color);
			}
		}
			
		
		
		FancyDrawingBoard board = new FancyDrawingBoard(600, 400);
		Graphics canvas = board.getCanvas();
		canvas.drawImage(b, 0, 0, null);
		
		board.repaint();
	}

}
