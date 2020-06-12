package jrJava.tetris;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.*;


public class JDrawingBoard extends JPanel {

	private JFrame frame;
	private BufferedImage bImage, tImage;
	private Graphics canvas, tCanvas;
	
	
	public JDrawingBoard(int width, int height){
		frame = new JFrame("My Application");
		frame.setBounds(200, 0, 0, 0); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setPreferredSize(new Dimension(width, height));
		
		frame.getContentPane().add(this);
		frame.pack();
		frame.setVisible(true); 
		
		bImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		canvas = bImage.getGraphics();
		
		tImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		tCanvas = tImage.getGraphics();
		
		((Graphics2D)canvas).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		((Graphics2D)tCanvas).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	}
	
	
	public void addKeyListener(KeyListener listener){ frame.addKeyListener(listener); }
	public void removeKeyListener(KeyListener listener){ frame.removeKeyListener(listener); }
	
	
	public Graphics getCanvas(){ return canvas; }
	public Graphics getTCanvas(){ return tCanvas; }
	
	public BufferedImage getBImage(){ return bImage; }
	public BufferedImage getTImage(){ return tImage; }
	
	
	public void clearCanvas(){
		int j, k; 
		for(j=0; j<bImage.getWidth(); j++){
			for(k=0; k<bImage.getHeight(); k++){
				bImage.setRGB(j, k, 0xffffffff); 
			}
		}
	} 
	
	public void clearTCanvas(){
		int j, k; 
		for(j=0; j<tImage.getWidth(); j++){
			for(k=0; k<tImage.getHeight(); k++){
				tImage.setRGB(j, k, 0x00000000); 
			}
		}
	} 
	
	
	
	public void paintComponent(Graphics g){
		g.drawImage(bImage,  0, 0, null);
		g.drawImage(tImage,  0, 0, null);
	}
	
	
}





