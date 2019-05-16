import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class EnterConfirmationFrame extends JFrame {
	JPanel panel;
	private JButton submitButton;
	private JButton closeButton;
	private JTextField numberField;
	ReservationCalendar calendar;

	public EnterConfirmationFrame(ReservationCalendar calendar) {
		this.calendar = calendar;
		// call private helper method to create and add components
		initializeUI();

		// set the frame properties
		this.setTitle("Enter Confirmation Number");
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void initializeUI() {
		panel = new JPanel();

		JLabel enter = new JLabel("Enter confirmation number of reservation: ");
		
		numberField = new JTextField(30);
		
		submitButton = new JButton("Submit");
		ActionListener acceptListener = new SubmitButtonListener();
		submitButton.addActionListener(acceptListener);
		
		closeButton = new JButton("Close");
		ActionListener closeListener = new CloseButtonListener();
		closeButton.addActionListener(closeListener);

		panel.add(enter);
		panel.add(numberField);
		panel.add(submitButton);
		panel.add(closeButton);
		this.add(panel);
	}
	
	/**
	 * Inner action listener class for the Cancel Button
	 * **/
	class SubmitButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent click) {
			String confString = numberField.getText();
			Reservation foundRes = calendar.getReservationByName(confString);
			if (foundRes == null) {
				JLabel noExist = new JLabel("Confirmation Number of Reservation does not exist.\n Please close the window.");
				panel.remove(submitButton);
				panel.remove(numberField);
				panel.remove(closeButton);
				panel.add(noExist);
				panel.add(closeButton);
				panel.updateUI();
			}
			else {
				EditReservationFrame e = new EditReservationFrame(foundRes, calendar);
				EnterConfirmationFrame.this.dispose();
				e.setVisible(true);
			}
		}
	}
	
	/**
	 * Inner action listener class for the Cancel Button
	 * **/
	class CloseButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent click) {
			EnterConfirmationFrame.this.dispose();
		}
	}
}