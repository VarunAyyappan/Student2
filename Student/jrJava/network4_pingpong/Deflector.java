package jrJava.network4_pingpong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import resources.DrawingBoard;


public class Deflector implements MouseMotionListener {

	public int x, y; // top, left corner.
	public int w = 10, h = 50;
	private Color color;
	private MessageSender sender;
	
	
	public Deflector(char mode, boolean isActive){
		
		if(mode=='c'){
			if(isActive){
				x = 10;
				color = Color.blue;
			}
			else {
				x = PingPong.WIDTH - 10- w;
				color = Color.green;
			}
		}
		else {
			if(isActive){
				x = PingPong.WIDTH - 10- w;
				color = Color.green;
			}
			else {
				x = 10;
				color = Color.blue;
			}
		}
		
		y = PingPong.HEIGHT/2 - h/2;
	}
	
	
	public void setMessageSender(MessageSender sender){ this.sender = sender; }
	
	
	public void draw(DrawingBoard board){
		Graphics canvas = board.getCanvas();
		canvas.setColor(color);
		canvas.fillRect(x, y, w, h);
		canvas.setColor(Color.black);
		canvas.drawRect(x, y, w, h);
	}

	
	public void update(String msg){
		y = Integer.parseInt(msg);
	}
	

	public void mouseDragged(MouseEvent e) {
		y = e.getY();
		sender.send("" + y);
	}


	public void mouseMoved(MouseEvent e) { }
	

}
















