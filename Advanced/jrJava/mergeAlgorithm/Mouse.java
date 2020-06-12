package jrJava.mouseAndMaze;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.GeneralPath;

public class Mouse implements KeyListener {

	private Point[] bodyTemplate = {
			new Point(-100, 0), new Point(-80, -120), new Point(50, -100), new Point(100, 0),
			new Point(-100, 0), new Point(-80,  120), new Point(50,  100), new Point(100, 0)
	};
	
	private Point[] earTemplate = {
			new Point(60, -40), new Point(120, -120), new Point(-100, -120), new Point(20, -30),
			new Point(60,  40), new Point(120,  120), new Point(-100,  120), new Point(20,  30)
	};
	
	private Point[] eyeTemplate = { // two centers of the eyes.
			new Point(60, -20),
			new Point(60,  20)
	};
	
	private Point eyeRadius = new Point(11, 11);
	
	private Point[] whiskerTemplate = {
			new Point(80, -15), new Point(80, -45), new Point(100, -90), 
			new Point(85, -10), new Point(85, -35), new Point(100, -60),
			new Point(80,  15), new Point(80,  45), new Point(100,  90), 
			new Point(85,  10), new Point(85,  35), new Point(100,  60)
	};
	
	private Point[] tailTemplate = {
			new Point(-40, 0), new Point(-120, -50), new Point(-50, 40), new Point(-95, 0)
	};
	
	
	
	private Point[] body = new Point[bodyTemplate.length];
	private Point[] ear = new Point[earTemplate.length];
	private Point[] eye = new Point[eyeTemplate.length];
	private Point[] whisker = new Point[whiskerTemplate.length];
	private Point[] tail = new Point[tailTemplate.length];
	
	private int x, y;
	private int size = 200;
	private int xSpeed = 1, ySpeed = 0;
	private int stepSize = 2;
	private int compass = 2;   // left(0), up(1), right(2), down(3)
	private double scaleFactor = 0.18;
	private Stroke stroke = new BasicStroke(0.75f);
	private Maze maze;
	
	// network:
	private boolean isMine;
	private Color eyeColor;
	
	public Mouse(int x, int y, boolean isMine){ //x, y center of mouse.
		this.x = x;
		this.y = y;
		
		Point ref = new Point(0, 0);
		Utility.scale(bodyTemplate, ref, scaleFactor);
		Utility.scale(earTemplate, ref, scaleFactor);
		Utility.scale(eyeTemplate, ref, scaleFactor);
		Utility.scale(eyeRadius, ref, scaleFactor);
		Utility.scale(whiskerTemplate, ref, scaleFactor);
		Utility.scale(tailTemplate, ref, scaleFactor);
		
		size = (int)(size*scaleFactor);
		
		this.isMine = isMine;
		if(isMine) eyeColor = Color.green;
		else eyeColor = Color.red;
	}
	
	
	
	public void setMaze(Maze maze){ this.maze = maze; }
	
	
	
	public void move(){
		x += xSpeed*stepSize;
		y += ySpeed*stepSize;
		
		if(isCollided()){
			x -= xSpeed*stepSize;
			y -= ySpeed*stepSize;
		}
	}
	
	
	private boolean isCollided(){
		
		int px, py;
		if(xSpeed!=0){
			px = x + xSpeed*size/2;
			for(py=y-size/2; py<=y+size/2; py++){
				if(maze.hitWall(px, py)) return true;
			}
		}
		else {
			py = y + ySpeed*size/2;
			for(px=x-size/2; px<=x+size/2; px++){
				if(maze.hitWall(px, py)) return true;
			}
		}
		
		return false;
	}
	
	
	
	private void rotateClockwise(){
		Utility.rotateClockwise(bodyTemplate);
		Utility.rotateClockwise(earTemplate);
		Utility.rotateClockwise(eyeTemplate);
		Utility.rotateClockwise(whiskerTemplate);
		Utility.rotateClockwise(tailTemplate);
	}
	
	
	
	public void draw(Graphics graphics){
		Graphics2D g = (Graphics2D) graphics;
		g.setStroke(stroke);
		
		Utility.copy(bodyTemplate, body);
		Utility.copy(earTemplate, ear);
		Utility.copy(eyeTemplate, eye);
		Utility.copy(whiskerTemplate, whisker);
		Utility.copy(tailTemplate, tail);
		
		Utility.shift(body, x, y);
		Utility.shift(ear, x, y);
		Utility.shift(eye, x, y);
		Utility.shift(whisker, x, y);
		Utility.shift(tail, x, y);
		
		// body
		GeneralPath bodyPath = new GeneralPath();
		bodyPath.moveTo(body[0].x, body[0].y);
		bodyPath.curveTo(body[1].x, body[1].y, body[2].x, body[2].y, body[3].x, body[3].y);
		bodyPath.moveTo(body[4].x, body[4].y);
		bodyPath.curveTo(body[5].x, body[5].y, body[6].x, body[6].y, body[7].x, body[7].y);
		
		g.setColor(Color.lightGray);
		g.fill(bodyPath);
		g.setColor(Color.black);
		g.draw(bodyPath);
		
		// ear
		GeneralPath earPath = new GeneralPath();
		earPath.moveTo(ear[0].x, ear[0].y);
		earPath.curveTo(ear[1].x, ear[1].y, ear[2].x, ear[2].y, ear[3].x, ear[3].y);
		earPath.moveTo(ear[4].x, ear[4].y);
		earPath.curveTo(ear[5].x, ear[5].y, ear[6].x, ear[6].y, ear[7].x, ear[7].y);
		
		g.setColor(new Color(220, 220, 220));
		g.fill(earPath);
		g.setColor(Color.black);
		g.draw(earPath);
		
		// eye
		g.setColor(eyeColor);
		g.fillOval((int)(eye[0].x-eyeRadius.x), (int)(eye[0].y-eyeRadius.y), (int)(2*eyeRadius.x), (int)(2*eyeRadius.y));
		g.fillOval((int)(eye[1].x-eyeRadius.x), (int)(eye[1].y-eyeRadius.y), (int)(2*eyeRadius.x), (int)(2*eyeRadius.y));
		g.setColor(Color.black);
		g.drawOval((int)(eye[0].x-eyeRadius.x), (int)(eye[0].y-eyeRadius.y), (int)(2*eyeRadius.x), (int)(2*eyeRadius.y));
		g.drawOval((int)(eye[1].x-eyeRadius.x), (int)(eye[1].y-eyeRadius.y), (int)(2*eyeRadius.x), (int)(2*eyeRadius.y));
		
		// whisker
		GeneralPath whiskerPath = new GeneralPath();
		whiskerPath.moveTo(whisker[0].x, whisker[0].y);
		whiskerPath.quadTo(whisker[1].x, whisker[1].y, whisker[2].x, whisker[2].y);
		whiskerPath.moveTo(whisker[3].x, whisker[3].y);
		whiskerPath.quadTo(whisker[4].x, whisker[4].y, whisker[5].x, whisker[5].y);
		whiskerPath.moveTo(whisker[6].x, whisker[6].y);
		whiskerPath.quadTo(whisker[7].x, whisker[7].y, whisker[8].x, whisker[8].y);
		whiskerPath.moveTo(whisker[9].x, whisker[9].y);
		whiskerPath.quadTo(whisker[10].x, whisker[10].y, whisker[11].x, whisker[11].y);
		
		g.setColor(Color.red);
		g.draw(whiskerPath);
		
		// tail
		GeneralPath tailPath = new GeneralPath();
		tailPath.moveTo(tail[0].x, tail[0].y);
		tailPath.curveTo(tail[1].x, tail[1].y, tail[2].x, tail[2].y, tail[3].x, tail[3].y);
		g.setColor(Color.black);
		g.draw(tailPath);
	}
	
	
	
	public void keyPressed(KeyEvent e){
		int keyCode = e.getKeyCode();
		if(keyCode!=KeyEvent.VK_LEFT && keyCode!=KeyEvent.VK_RIGHT && keyCode!=KeyEvent.VK_UP && keyCode!=KeyEvent.VK_DOWN) return;
		
		// depending on the key pressed --> xSpeed, ySpeed, compass
		int nCompass;
		if(keyCode==KeyEvent.VK_LEFT){
			xSpeed = -1;
			ySpeed = 0;
			nCompass = 0;
		}
		else if(keyCode==KeyEvent.VK_UP){
			xSpeed = 0;
			ySpeed = -1;
			nCompass = 1;
		}
		else if(keyCode==KeyEvent.VK_RIGHT){
			xSpeed = 1;
			ySpeed = 0;
			nCompass = 2;
		}
		else {
			xSpeed = 0;
			ySpeed = 1;
			nCompass = 3;
		}
		
		// depending on the compass, we determine the number of rotations.
		int numOfRotation = nCompass - compass;
		if(numOfRotation<0) numOfRotation += 4;
		for(int i=0; i<numOfRotation; i++) rotateClockwise();
		compass = nCompass;
	}
	
	
	
	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e){}
	
}












