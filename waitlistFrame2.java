import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class waitlistFrame2 extends JFrame {
	JPanel panel;
	private JButton acceptButton;
	private JButton declineButton;
	Reservation r;
	ReservationCalendar calendar;
	String roomType;
	Guest guest;
	DateAndTime time;
	String meal;
	int partyFavors;
	int projectorHours;
	boolean partyDecorations;
	int towelRentals;

	public waitlistFrame2(String roomType, Guest guest, DateAndTime time, String meal, int partyFavors, int projectorHours, boolean partyDecorations, int towelRentals, ReservationCalendar calendar) {
		this.roomType = roomType;
		this.guest = guest;
		this.time = time;
		this.meal = meal;
		this.partyFavors = partyFavors;
		this.projectorHours = projectorHours;
		this.partyDecorations = partyDecorations;
		this.towelRentals = towelRentals;
		this.calendar = calendar;
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
			calendar.addReservation(roomType, guest, time, meal, partyFavors, projectorHours, partyDecorations, towelRentals);
			ConfirmationFrame c = new ConfirmationFrame(calendar.calendar.get(calendar.calendar.size()-1));
			waitlistFrame2.this.dispose();
			c.setVisible(true);
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
}