import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmationFrame extends JFrame {
	JPanel panel;
	private JButton closeButton;
	private JTextArea textArea;
	Reservation r;

	public ConfirmationFrame(Reservation r) {
		this.r = r;
		// call private helper method to create and add components
		initializeUI();

		// set the frame properties
		this.setTitle("Reservation Confirmation");
		this.setSize(600, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void initializeUI() {
		panel = new JPanel();

		JLabel rc = new JLabel("Reservation Confirmation");
		
		textArea = new JTextArea(10, 45);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(r.toString());
		
		textArea.setText(stringBuilder.toString());
		
		closeButton = new JButton("Close");
		ActionListener closeListener = new CloseButtonListener();
		closeButton.addActionListener(closeListener);

		panel.add(rc);
		panel.add(textArea);
		panel.add(closeButton);
		this.add(panel);
	}
	
	
	/**
	 * Inner action listener class for the Cancel Button
	 * **/
	class CloseButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent click) {
			ConfirmationFrame.this.dispose();
		}
	}
}