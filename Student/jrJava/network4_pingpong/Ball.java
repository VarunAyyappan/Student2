package jrJava.network4_pingpong;

import java.awt.Color;
import java.awt.Graphics;

import resources.DrawingBoard;

public class Ball {

	private char mode; // 'c' or 's'
	private int x = PingPong.WIDTH/2, y = PingPong.HEIGHT/2;  // x, y are center of the ball.
	private int vx = 2, vy = 1;
	private int radius = 20;
	private Color color = Color.red;
	private Deflector deflector; // active one.
 	private MessageSender sender;
	
 	
	public Ball(char mode){ this.mode = mode; }
		
	public void setDeflector(Deflector deflector){ this.deflector = deflector; }
	public void setMessageSender(MessageSender sender){ this.sender = sender; }
	
	
	public void move(){
		x += vx;
		y += vy;
		
		// collision with walls
		if(y<radius){
			y = radius;
			vy = -vy;
		}
		else if(y>PingPong.HEIGHT-radius){
			y = PingPong.HEIGHT-radius;
			vy = -vy;
		}
		
		
		// collision with deflector
		if(mode=='c' && x>=deflector.x && x<=deflector.x+deflector.w+radius && y>=deflector.y-radius && y<=deflector.y+deflector.h+radius){
			x = deflector.x+deflector.w+radius;
			vx = -vx; 
			vy = vy; // add some randomness.
			sender.send("B:" + x + "," + y + "," + vx + "," + vy);
		}
		
		if(mode=='s' && x>=deflector.x-radius && x<=deflector.x+deflector.w && y>=deflector.y-radius && y<=deflector.y+deflector.h+radius){
			x = deflector.x-radius;
			vx = -vx; 
			vy = vy; // add some randomness.
			sender.send("B:" + x + "," + y + "," + vx + "," + vy);
		}
		
	}
	
	
	public void update(String msg){
		// "B:143,89,3,-4"
		int colon, comma1, comma2, comma3;
		colon = msg.indexOf(':');
		comma1 = msg.indexOf(',');
		comma2 = msg.indexOf(',', comma1 + 1);
		comma3 = msg.indexOf(',', comma2 + 1);
		
		x = Integer.parseInt(msg.substring(colon+1, comma1));
		y = Integer.parseInt(msg.substring(comma1+1, comma2));
		vx = Integer.parseInt(msg.substring(comma2+1, comma3));
		vy = Integer.parseInt(msg.substring(comma3+1));
	}
	
	
	public void draw(DrawingBoard board){
		Graphics canvas = board.getCanvas();
		canvas.setColor(color);
		canvas.fillOval(x-radius, y-radius, 2*radius, 2*radius);
		canvas.setColor(Color.black);
		canvas.drawOval(x-radius, y-radius, 2*radius, 2*radius);
	}
	
}












