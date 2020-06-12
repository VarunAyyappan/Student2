package jrJava.imageManipulation;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ImageRotation {

	public static void main(String[] args) throws Exception {
		
		BufferedImage b1 = ImageIO.read(new File("jrJava/imageManipulation/transformerSquare.png"));
		BufferedImage b2 = new BufferedImage(b1.getWidth(), b1.getHeight(), BufferedImage.TYPE_INT_ARGB);
		
		FancyDrawingBoard board = new FancyDrawingBoard(b1.getWidth(), b1.getHeight());
		Graphics g = board.getCanvas();
		
		int i, j, color;
		BufferedImage temp;
		
		while(true){
			for(i=0; i<b1.getWidth(); i++){
				for(j=0; j<b1.getHeight(); j++){
					
					color = b1.getRGB(i, j);
					b2.setRGB(b1.getWidth()-1-j, i, color);
				}
			}
	
			g.drawImage(b2, 0, 0, null);
			board.repaint();
			
			temp = b1;
			b1 = b2;
			b2 = temp;
			
			Thread.sleep(1000);
		}
		
	}

}
