
package jrJava.nestedClass1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class BuyAgent implements ActionListener {

	// business logic fields
	// business logic methods

	private JButton button;
	private JTextField tf;

	private void setButton(JButton buttonIn) { button = buttonIn; }
	private void setTextField(JTextField tfIn) { tf = tfIn; }

	private void processsBuyTransaction() {
		// business logic
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {
			processsBuyTransaction();
			// Report back that "Purchased 1000 PopEyes stocks"
			tf.setText("Purchased 1000 Popeye stocks");
		}
	}
}
