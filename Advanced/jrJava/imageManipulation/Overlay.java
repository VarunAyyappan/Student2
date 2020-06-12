package jrJava.imageManipulation;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Overlay {

	public static void main(String[] args) throws Exception {
		
		BufferedImage b1 = ImageIO.read(new File("jrJava/imageManipulation/bg.png"));
		BufferedImage b2 = ImageIO.read(new File("jrJava/imageManipulation/transformerGreen.png"));
		BufferedImage b3 = new BufferedImage(b1.getWidth(), b1.getHeight(), BufferedImage.TYPE_INT_ARGB);
		
		FancyDrawingBoard board = new FancyDrawingBoard(b1.getWidth(), b1.getHeight());
		Graphics g = board.getCanvas();
		int i, j, color;
		
		for(i=0; i<b1.getWidth(); i++){
			for(j=0; j<b1.getHeight(); j++){
				color = b1.getRGB(i, j);
				b3.setRGB(i,  j, color);
				
				color = b2.getRGB(i, j);
				if(color!=0xffffffff) b3.setRGB(i,  j, color);
			}
		}

		g.drawImage(b3, 0, 0, null);
		board.repaint();
	}

}
