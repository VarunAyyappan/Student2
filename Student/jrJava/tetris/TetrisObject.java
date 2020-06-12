package jrJava.tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class TetrisObject implements KeyListener {

	public static final int BLOCK_SIZE = 20;
	public static final int SIZE = 3*BLOCK_SIZE;
	
	private BufferedImage image, image2, temp;
	private int x, y; // top, left corner
	
	
	public TetrisObject(int[] shape, int color){
		image = new BufferedImage(SIZE+1, SIZE+1, BufferedImage.TYPE_INT_ARGB); // all for the sake of good looking.
		image2 = new BufferedImage(SIZE+1, SIZE+1, BufferedImage.TYPE_INT_ARGB);
		
		x = 120;
		y = 20;
		
		int i, j, k;
		for(i=0; i<shape.length; i++){
			if(shape[i]==0) continue;
			
			for(j=0; j<=BLOCK_SIZE; j++){
				for(k=0; k<=BLOCK_SIZE; k++){
					if(j==0 || j==BLOCK_SIZE || k==0 || k==BLOCK_SIZE){
						image.setRGB(i%3*BLOCK_SIZE + j , i/3*BLOCK_SIZE + k, 0xff000000);
					}
					else {
						image.setRGB(i%3*BLOCK_SIZE + j , i/3*BLOCK_SIZE + k, color);
					}
				}
			}
			
		}
		
	}
	
	
	public boolean moveDown(){
		 y += BLOCK_SIZE;
		 
		 if(!isLegal()){
		 	 y -= BLOCK_SIZE;
		 	 Graveyard.bury(image, x, y);
		 	 Coordinator.needToCreateNewTetrisObject = true;
		 	 return false;
		 }
		 
		 SoundEffect.moveDown();
		 return true;
	}
	
	
	public void draw(Graphics g){
		g.drawImage(image, x, y, null);
	}
	
	
	private void moveLeft(){
		x -= BLOCK_SIZE;
		
		if(!isLegal()){
		     x += BLOCK_SIZE;
		     return;
		}
		
		SoundEffect.shift();
	}
	
	
	private void moveRight(){
		x += BLOCK_SIZE;
		
		if(!isLegal()){
			x -= BLOCK_SIZE;
			return;
		}
		
		SoundEffect.shift();
	}
	
	
	private void rotateClockwise(){
		int j, k;
		for(j=0; j<=SIZE; j++){
			for(k=0; k<=SIZE; k++){
				image2.setRGB(SIZE-k, j, image.getRGB(j, k));
			}
		}
	}
	
	 
	private void rotate(){
		rotateClockwise();
		temp = image;
		image = image2;
		image2 = temp;
		
		if(!isLegal()){
			temp = image;
			image = image2;
			image2 = temp;
			return;
		}
		SoundEffect.rotate();
	}
	
	
	private void flip(){
		int j, k;
		for(j=0; j<=SIZE; j++){
			for(k=0; k<=SIZE; k++){
				image2.setRGB(SIZE-j, k, image.getRGB(j, k));
			}
		}
	}
	
	
	private void mirror(){
		flip();
		temp = image;
		image = image2;
		image2 = temp;
		
		if(!isLegal()){
			temp = image;
			image = image2;
			image2 = temp;
			return;
		}
		
		SoundEffect.mirror();
	}
	
	
	private boolean isLegal(){
		int j, k, xOffset, yOffset;
		for(j=0; j<3; j++){
			for(k=0; k<3; k++){
				xOffset = j*BLOCK_SIZE + BLOCK_SIZE/2;
				yOffset = k*BLOCK_SIZE + BLOCK_SIZE/2;
				
				if(image.getRGB(xOffset, yOffset)==0) continue;
				if(Graveyard.isOccupied(x + xOffset, y + yOffset)) return false;
			}
		}
		return true;
	}
	
	
	
	
	public void keyPressed(KeyEvent e){
		int keyCode = e.getKeyCode();
		
		if(keyCode==KeyEvent.VK_LEFT) moveLeft();
		else if(keyCode==KeyEvent.VK_RIGHT) moveRight();
		else if(keyCode==KeyEvent.VK_R) rotate();
		else if(keyCode==KeyEvent.VK_M) mirror();
		else if(keyCode==KeyEvent.VK_DOWN){
			while(moveDown());
		}
		
	}
	
	
	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e){}
}









