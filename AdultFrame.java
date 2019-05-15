import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdultFrame extends JFrame {
	JPanel panel;
	private JButton closeButton;
	ReservationCalendar calendar;

	public AdultFrame() {
		// call private helper method to create and add components
		initializeUI();

		// set the frame properties
		this.setTitle("Cannot book Karaoke Lounge");
		this.setSize(350, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void initializeUI() {
		panel = new JPanel();

		JLabel enter = new JLabel("Age is less than 21. Cannot book Karaoke Lounge");
		
		closeButton = new JButton("Close");
		ActionListener closeListener = new CloseButtonListener();
		closeButton.addActionListener(closeListener);

		panel.add(enter);
		panel.add(closeButton);
		this.add(panel);
	}
	
	/**
	 * Inner action listener class for the Cancel Button
	 * **/
	class CloseButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent click) {
			AdultFrame.this.dispose();
		}
	}
}