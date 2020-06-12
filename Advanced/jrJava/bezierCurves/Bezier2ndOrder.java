package jrJava.bezierCurves;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.GeneralPath;

import resources.DrawingBoard;

public class Bezier2ndOrder implements MouseListener, MouseMotionListener {

	private GeneralPath path = new GeneralPath();;
	private DrawingBoard board = new DrawingBoard(1000, 800);
	private Graphics2D g = board.getCanvas();
	
	private double p1x = 200, p1y = 400;
	private double cx = 500, cy = 200;
	private double p2x = 800, p2y = 400;

	private int mx, my, pmx, pmy;
	
	
	public Bezier2ndOrder(){
		board.addMouseListener(this);
		board.addMouseMotionListener(this);
		draw();
	}
	
	public void mousePressed(MouseEvent e) {
		pmx = e.getX();
		pmy = e.getY();
	}


	public void mouseDragged(MouseEvent e) {
		mx = e.getX();
		my = e.getY();
		cx += mx - pmx;
		cy += my - pmy;
		pmx = mx;
		pmy = my;
		draw();
	}


	public void mouseMoved(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}

	
	public void draw(){
		board.clear();
		path.reset();
		path.moveTo(p1x, p1y);
		path.quadTo(cx,  cy, p2x, p2y);
		g.setColor(Color.blue);
		g.draw(path);
		
		g.setColor(Color.red);
		g.fillOval((int)(p1x-2), (int)(p1y-2), 4, 4);
		g.fillOval((int)(cx-2), (int)(cy-2), 4, 4);
		g.fillOval((int)(p2x-2), (int)(p2y-2), 4, 4);
		board.repaint();
	}
	
	public static void main(String[] a){
		new Bezier2ndOrder();
	}
}








