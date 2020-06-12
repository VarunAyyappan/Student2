package jrJava.drawingPanel;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FancyDrawingBoard extends JPanel {

	private BufferedImage bImage;
	private JFrame frame;

	public FancyDrawingBoard(int width, int height) {
		frame = new JFrame();
		frame.setBounds(200, 50, width, height); // Wrond!
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(bImage, 0, 0, null);
	}
}
