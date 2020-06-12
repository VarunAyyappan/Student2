package nestedClass_Practice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PracticeGUI {
	private JFrame frame;
	private JPanel panel;
	private JButton[] buttons;
	private JTextField tf;

	public PracticeGUI() {
		frame = new JFrame();
		frame.setTitle("reeeeeeeeeee");
		frame.setBounds(100, 100, 400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);

		panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		buttons = new JButton[5];
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton("Button "+(i+1));
			buttons[i].setBounds(50, 150+i*30, 120, 20);
			panel.add(buttons[i]);
		}
		buttons[0].addActionListener(new innerClass());
		buttons[1].addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						tf.setText("Button 2 is pressed");
					}
				}
		);
		buttons[2].addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						tf.setText("Button 3 is pressed");
					}
				}
		);

		ActionListener shared = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int source = 0;
				if(e.getSource()==buttons[3])
					source = 4;
				else if(e.getSource() == buttons[4])
					source = 5;

				tf.setText("Button "+ source +" is pressed");
			}
		};
		buttons[3].addActionListener(shared);
		buttons[4].addActionListener(shared);

		tf = new JTextField();
		tf.setBounds(50, 50, 270, 20);
		panel.add(tf);

		frame.setVisible(true);
	}

	private class innerClass implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			tf.setText("Button 1 is pressed");
		}
		
	}

	public static void main(String[] args) {
		PracticeGUI pg = new PracticeGUI();
	}
}
