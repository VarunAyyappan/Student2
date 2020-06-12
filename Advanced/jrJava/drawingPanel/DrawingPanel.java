package jrJava.drawingPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.*;


public class DrawingPanel extends JPanel {

	private JFrame frame;
	private ArrayList<Drawable> drawables;
	
	public DrawingPanel(){
		frame = new JFrame();
		frame.setBounds(200, 50, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(this); 

		drawables = new ArrayList<Drawable>();
		
		frame.setVisible(true); 
	}
	
	
	public void add(Drawable drawable){ drawables.add(drawable); }
	public void remove(Drawable drawable){ drawables.remove(drawable); }
	
	
	public void paintComponent(Graphics g){
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		
		g.setColor(Color.white);
		g.fillRect(0,  0, getWidth(), getHeight()); 
		
		for(int i=0; i<drawables.size(); i++) drawables.get(i).draw(g); 
	}
	
	
	public static void main(String[] args) {
		DrawingPanel panel = new DrawingPanel();

		
		Square s1 = new Square(200, 100, 150, Color.red);
		Square s2= new Square(500, 400, 220, Color.cyan);
		Circle c1 = new Circle(300, 500, 70, Color.blue);
		Circle c2 = new Circle(600, 200, 170, Color.orange);
		ImageThing t1 = new ImageThing(100, 300, 100, new ImageIcon("jrJava/drawingPanel/heart.png").getImage());
		ImageThing t2 = new ImageThing(400, 200, 200, new ImageIcon("jrJava/drawingPanel/hockey_stick.png").getImage());
		
		panel.add(s1);
		panel.add(s2);
		panel.add(c1);
		panel.add(c2);
		panel.add(t1);
		panel.add(t2);
		
		panel.repaint();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) { }
		
		panel.remove(t2);
		panel.repaint();
	}

}


