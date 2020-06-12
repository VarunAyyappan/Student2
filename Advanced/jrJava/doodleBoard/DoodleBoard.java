package jrJava.doodleBoard;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import javax.swing.*;


public class DoodleBoard extends JPanel implements ActionListener, MouseListener, MouseMotionListener { 

	private BufferedImage bImage;
	private Graphics canvas;
	
	private JFrame frame;
	private JPanel buttonPanel;
	private JScrollPane scrollPane;
	private JButton[] colorButtons;
	private String[] colorNames = {"red", "green", "blue", "orange", "black"};
	
	private int x, y, lastX, lastY;
	private Color penColor;
	private Stroke stroke;
	private Stroke[] strokes = { new BasicStroke(0.5f), new BasicStroke(1), new BasicStroke(2), new BasicStroke(3), new BasicStroke(5)}; 
	private String[] strokeNames = {"0.5", "1.0", "2.0", "3.0", "6.0"};
	private JButton[] strokeButtons;
	
	private int eraserRadius = 4;
	
	
	
	public DoodleBoard(int width, int height){
		frame = new JFrame("Doodle Board");
		frame.setBounds(200, 0, 0, 0);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.white);
		scrollPane = new JScrollPane(this);
		
		scrollPane.setPreferredSize(new Dimension(width/2, height/2));
		this.setPreferredSize(new Dimension(width, height));
		 
		frame.getContentPane().add(buttonPanel, BorderLayout.NORTH);
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		colorButtons = new JButton[colorNames.length];
		for(int i=0; i<colorButtons.length; i++){
			colorButtons[i] = new JButton(colorNames[i]);
			buttonPanel.add(colorButtons[i]);
			colorButtons[i].addActionListener(this);
		}
		
		strokeButtons = new JButton[strokeNames.length];
		for(int i=0; i<strokeButtons.length; i++){
			strokeButtons[i] = new JButton(strokeNames[i]);
			buttonPanel.add(strokeButtons[i]);
			strokeButtons[i].addActionListener(this);
		}
		
		
		bImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		canvas = bImage.getGraphics();
		((Graphics2D)canvas).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		((Graphics2D)canvas).setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		
		canvas.setColor(Color.white);
		canvas.fillRect(0, 0, bImage.getWidth(), bImage.getHeight());
		
		frame.pack();
		frame.setVisible(true); 
		
		this.addMouseListener(this);
		this.addMouseMotionListener(this); 
		
		penColor = Color.black;
		stroke = new BasicStroke(2.0f);
	}
	
	 
	
	public void paintComponent(Graphics g){
		g.drawImage(bImage, 0,  0, null);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==colorButtons[0]) penColor = Color.red;
		else if(e.getSource()==colorButtons[1]) penColor = Color.green;
		else if(e.getSource()==colorButtons[2]) penColor = Color.blue;
		else if(e.getSource()==colorButtons[3]) penColor = Color.orange;
		else if(e.getSource()==colorButtons[4]) penColor = Color.black;
		
		else if(e.getSource()==strokeButtons[0]) stroke = strokes[0];
		else if(e.getSource()==strokeButtons[1]) stroke = strokes[1];
		else if(e.getSource()==strokeButtons[2]) stroke = strokes[2];
		else if(e.getSource()==strokeButtons[3]) stroke = strokes[3];
		else if(e.getSource()==strokeButtons[4]) stroke = strokes[4];
		
	}
	
	
	public void mousePressed(MouseEvent e) {
		lastX = e.getX();
		lastY = e.getY();
	}
	

	public void mouseDragged(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		
		if(e.isShiftDown()){
			canvas.setColor(Color.white);
			canvas.fillOval(x-eraserRadius, y-eraserRadius, 2*eraserRadius,2*eraserRadius);
		}
		else {	
			canvas.setColor(penColor);
			((Graphics2D)canvas).setStroke(stroke);
			canvas.drawLine(lastX, lastY, x, y);
		}
		
		this.repaint();
		
		lastX = x;
		lastY = y;
	}
	
	
	public void mouseMoved(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	
	
	
	public static void main(String[] args) {
		new DoodleBoard(1600, 1200);
	}



	

}








