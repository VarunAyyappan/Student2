package jrJava.imageManipulation;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ColorFusion {

	public static void main(String[] args) throws Exception {
		
		BufferedImage b1 = ImageIO.read(new File("jrJava/imageManipulation/transformer.png"));
		BufferedImage b2 = ImageIO.read(new File("jrJava/imageManipulation/transformerGreen.png"));
		BufferedImage b3 = new BufferedImage(b1.getWidth(), b1.getHeight(), BufferedImage.TYPE_INT_ARGB);
		
		int i, j;
		int color1, color2;
		int alpha, red, green, blue;
		double w;
		
		for(i=0; i<b1.getWidth(); i++){
			for(j=0; j<b1.getHeight(); j++){
				
				color1 = b1.getRGB(i, j);
				color2 = b2.getRGB(i, j);
				
				w = 1 - (double)i/(b1.getWidth()-1);
				//w = Math.pow(1 - (double)i/(b1.getWidth()-1), 2);
				//w = Math.sqrt(1 - (double)i/(b1.getWidth()-1));
				
				alpha = (int)(w*getAlpha(color1) + (1-w)*getAlpha(color2));
				red = (int)(w*getRed(color1) + (1-w)*getRed(color2));
				green = (int)(w*getGreen(color1) + (1-w)*getGreen(color2));
				blue = (int)(w*getBlue(color1) + (1-w)*getBlue(color2));
				
				b3.setRGB(i, j, getColor(alpha, red, green, blue));
			}
		}
		
		FancyDrawingBoard board = new FancyDrawingBoard(b1.getWidth(), b1.getHeight());
		Graphics g = board.getCanvas();
		g.drawImage(b3, 0, 0, null);
		board.repaint();
		
		ImageIO.write(b3, "png", new File("jrJava/imageManipulation/transformerFused.png"));
	}

	
	
	public static int getColor(int a, int r, int g, int b){
		return a<<24 | r<<16 | g<<8 | b;
	}
	
	
	public static int getAlpha(int color){
		return (color>>24) & 0x000000ff;
	}
	
	public static int getRed(int color){
		return (color>>16) & 0x000000ff;
	}
	
	public static int getGreen(int color){
		return (color>>8) & 0x000000ff;
	}
	
	public static int getBlue(int color){
		return (color) & 0x000000ff;
	}
	
}
