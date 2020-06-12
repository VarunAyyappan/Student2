package jrJava.imageManipulation;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Basic2 {

	public static void main(String[] args) throws IOException {
		BufferedImage b1 = ImageIO.read(new File("jrJava/imageManipulation/transformer.png"));
		BufferedImage b2 = new BufferedImage(b1.getWidth(), b1.getHeight(), BufferedImage.TYPE_INT_ARGB);
		int i, j, alpha, red, green, blue, color;
		
		for(i=0; i<b1.getWidth(); i++) {
			for(j=0; j<b1.getHeight(); j++) {
				color = b1.getRGB(i, j);
				alpha = getAlpha(color);
				red = getRed(color);
				green = getGreen(color);
				blue = getBlue(color);

				b2.setRGB(i, j, getColor(alpha, green, red, blue));
				//b2.setRGB(i, j, getColor(alpha, (red+blue+green)/3, (red+blue+green)/3, (red+blue+green)/3));  //greyscale
				
			}
		}

		FancyDrawingBoard board = new FancyDrawingBoard(500, 600);
		Graphics canvas = board.getCanvas();
		canvas.drawImage(b2, 0, 0, null);

		board.repaint();

		ImageIO.write(b2, "png", new File("jrJava/imageManipulation/transformerGreen.png"));
	}

	public static int getAlpha(int color) {
		return (color>>24) & 0x000000ff;
	}

	public static int getRed(int color) {
		return (color>>16) & 0x000000ff;
	}

	public static int getGreen(int color) {
		return (color>>8) & 0x000000ff;
	}

	public static int getBlue(int color) {
		return (color) & 0x000000ff;
	}

	public static int getColor(int alpha, int red, int green, int blue) {
		return alpha<<24 | red<<16 | green<<8 | blue;
	}
}
