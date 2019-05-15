import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class waitlistFrame extends JFrame {
	JPanel panel;
	private JButton acceptButton;
	private JButton declineButton;
	String roomName;
	String dateChosen;
	String startTimeChosen;
	String endTimeChosen;
	ReservationCalendar calendar;

	public waitlistFrame(String roomName, String dateChosen, String startTimeChosen, String endTimeChosen, ReservationCalendar calendar) {
		this.calendar = calendar;
		this.roomName = roomName;
		this.dateChosen = dateChosen;
		this.startTimeChosen = startTimeChosen;
		this.endTimeChosen = endTimeChosen;
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
			NewReservationFrame n = new NewReservationFrame(roomName, dateChosen, startTimeChosen, endTimeChosen, calendar);
			waitlistFrame.this.dispose();
			n.setVisible(true);
		}
	}
	
	/**
	 * Inner action listener class for the Cancel Button
	 * **/
	class DeclineButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent click) {
			selectDTFrame s = new selectDTFrame(roomName, calendar);
			waitlistFrame.this.dispose();
			s.setVisible(true);
		}
	}
}