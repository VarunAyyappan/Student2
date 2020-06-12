package jrJava.nestedClass1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StockTradeGUI{

	private JFrame frame;
	private JPanel panel;
	private JButton button;
	private JTextField tf;

	public StockTradeGUI() {
		BuyAgent ba = new BuyAgent();
		
		frame = new JFrame();
		frame.setTitle("Stock Trade");
		frame.setBounds(200, 50, 300, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);

		panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		button = new JButton("Buy Stock");
		button.setBounds(50, 100, 120, 20);
		button.addActionListener(ba);
		panel.add(button);

		tf = new JTextField();
		tf.setBounds(50, 200, 200, 20);
		panel.add(tf);

		frame.setVisible(true);
	}
	
	public class BuyAgent implements ActionListener {

		// business logic fields
		// business logic methods

		private JButton button;
		private JTextField tf;

		//private void setButton(JButton buttonIn) { button = buttonIn; }
		//private void setTextField(JTextField tfIn) { tf = tfIn; }

		private void processsBuyTransaction() {
			// business logic
		}

		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==button) {
				processsBuyTransaction();
				// Report back that "Purchased 1000 PopEyes stocks"
				tf.setText("Purchased 1000 PopEyes stocks");
			}
		}
	}

	public static void main(String[] args) {
		StockTradeGUI stg = new StockTradeGUI();
		//BuyAgent ba = new BuyAgent();
		
	}

}
