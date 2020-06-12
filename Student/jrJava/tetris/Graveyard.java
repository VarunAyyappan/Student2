package jrJava.tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Graveyard {

	private static BufferedImage image;
	private static Graphics g;
	private static int blockSize = TetrisObject.BLOCK_SIZE;
	private static ArrayList<Integer> fullRows;
	private static int numOfRows, numOfCols;
	private static long lastTimeFullRowsFormed;
	
	static {
		image = new BufferedImage(Coordinator.SCREEN_WIDTH, Coordinator.SCREEN_HEIGHT, BufferedImage.TYPE_INT_ARGB);
		g = image.getGraphics();
		
		int j, k;
		for(j=0; j<image.getWidth(); j++){
			for(k=0; k<image.getHeight(); k++){
				if(j<blockSize || j>image.getWidth()-blockSize || k<blockSize || k>image.getHeight()-blockSize) image.setRGB(j, k, 0xfffefefe);
				else if(j==blockSize || j==image.getWidth()-blockSize || k==blockSize || k==image.getHeight()-blockSize) image.setRGB(j, k, 0xff000000);
				else image.setRGB(j, k, 0xffffffff);
			}
		}
		
		fullRows = new ArrayList<Integer>();
		numOfRows = image.getHeight()/blockSize - 2;
		numOfCols = image.getWidth()/blockSize - 2;
	}
	
	
	public static boolean isOccupied(int x, int y){
		return image.getRGB(x, y)!=0xffffffff;
	}
	
	
	
	public static void bury(BufferedImage tetrisImage, int x, int y){
		image.getGraphics().drawImage(tetrisImage, x, y, null);
		
		// find full rows.
		int tetrisSize = TetrisObject.SIZE/blockSize;
		
		int j, k, xC, yC;
		for(k=0; k<tetrisSize; k++){
			yC = y + k*blockSize + blockSize/2;
			if(yC>image.getHeight()-blockSize) break;
			
			boolean full = true;
			for(j=0; j<numOfCols; j++){
				xC = (1+j)*blockSize + blockSize/2;
				if(image.getRGB(xC, yC)==0xffffffff){
					full = false;
					break;
				}
			}
			
			if(!full) continue;
			
			
			g.setColor(Color.black);
			for(j=0; j<numOfCols; j++) g.drawLine((1+j)*blockSize, y + k*blockSize, (2+j)*blockSize, y + (k+1)*blockSize);
				
			fullRows.add(y + k*blockSize);
			lastTimeFullRowsFormed = System.currentTimeMillis();
		}
		
	}
	
	
	public static void removeFullRows(){
		if(System.currentTimeMillis()-lastTimeFullRowsFormed<1000 || fullRows.isEmpty()) return;
		
		int i, j, k;
		for(i=0; i<fullRows.size(); i++){
			
			for(k=fullRows.get(i); k>100; k--){
				for(j=0; j<image.getWidth(); j++){
					if(image.getRGB(j, k)==0xff000000 && 
							image.getRGB(j, k+blockSize+1)==0xffffffff &&
							image.getRGB(j, k-1)==0xffffffff){
						
						image.setRGB(j, k+blockSize, 0xffffffff);
					}
					else {
						image.setRGB(j, k+blockSize, image.getRGB(j, k));
					}
				}
			}
		}
		fullRows.clear();
		SoundEffect.deleteRow();
	}
	
	
	
	public static void draw(Graphics g){
		removeFullRows();
		g.drawImage(image, 0, 0, null);
	}
	
}







