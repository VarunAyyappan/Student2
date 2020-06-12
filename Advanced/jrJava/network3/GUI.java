package jrJava.network3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI implements ActionListener{

	private MessageSender mSender;

	private JFrame frame;
	private JPanel panel;
	private JScrollPane dScrollPane, tScrollPane;
	private JTextArea dTextArea, tTextArea;
	private JButton send;

	public GUI() {
		frame = new JFrame("Chat");
		frame.setBounds(200, 50, 380, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);			

		dScrollPane = new JScrollPane();
		dScrollPane.setBounds(30, 20, 300, 300);
		panel.add(dScrollPane);
		dTextArea = new JTextArea();
		dTextArea.setEditable(false);
		dTextArea.setText("Welcome to your chat.");
		dScrollPane.setViewportView(dTextArea);

		tScrollPane = new JScrollPane();
		tScrollPane.setBounds(30, 340, 300, 60);
		panel.add(tScrollPane);
		tTextArea = new JTextArea();
		tScrollPane.setViewportView(tTextArea);

		send = new JButton("Send");
		send.setBounds(260, 410, 70, 20);
		send.addActionListener(this);
		panel.add(send);

		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new GUI();
	}

	public void setMessageSender(MessageSender mSenderIn) {mSender = mSenderIn;}

	public void addText(String text) {
		dTextArea.setText(dTextArea.getText() + "\n\n" + text);
	}

	public void actionPerformed(ActionEvent e) {
		String msg = tTextArea.getText();

		mSender.send(msg);
		tTextArea.setText("");
		addText(msg);
	}

}
