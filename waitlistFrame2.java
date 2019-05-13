import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class waitlistFrame2 extends JFrame {
	JPanel panel;
	private JButton acceptButton;
	private JButton declineButton;
	String roomName;
	String dateChosen;
	String startTimeChosen;
	String endTimeChosen;

	public waitlistFrame2() {
		// call private helper method to create and add components
		initializeUI();

		// set the frame properties
		this.setTitle("Waitlist");
		this.setSize(350, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void initializeUI() {
		panel = new JPanel();

		JLabel waitlist = new JLabel("No availability on selected date/time. Add to waitlist?");
		
		acceptButton = new JButton("Accept");
		ActionListener acceptListener = new AcceptButtonListener();
		acceptButton.addActionListener(acceptListener);

		declineButton = new JButton("Decline");
		ActionListener declineListener = new DeclineButtonListener();
		declineButton.addActionListener(declineListener);

		panel.add(waitlist);
		panel.add(declineButton);
		panel.add(acceptButton);
		this.add(panel);
	}
	
	/**
	 * Inner action listener class for the Cancel Button
	 * **/
	class AcceptButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent click) {
			ConfirmationFrame n = new ConfirmationFrame();
			waitlistFrame2.this.dispose();
			n.setVisible(true);
		}
	}
	
	/**
	 * Inner action listener class for the Cancel Button
	 * **/
	class DeclineButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent click) {
			waitlistFrame2.this.dispose();
		}
	}
	
	public static void main(String[] args) {
		waitlistFrame2 f = new waitlistFrame2();
		f.setVisible(true);
	}
}