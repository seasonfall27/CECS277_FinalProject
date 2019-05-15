import javax.swing.*;

import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class selectDTFrame extends JFrame {
	JPanel panel;
	String roomName;
	private JLabel roomType;
	private JButton submitButton;
	private JSpinner dateSpinner;
	private JSpinner startSpinner;
	private JSpinner endSpinner;
	ReservationCalendar calendar;

	public selectDTFrame(String roomName, ReservationCalendar calendar) {
		this.roomName = roomName;
		this.calendar = calendar;
		// call private helper method to create and add components
		initializeUI();

		// set the frame properties
		this.setTitle("Select Room Date/Time");
		this.setSize(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void initializeUI() {
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		roomType = new JLabel(roomName);

		JLabel date = new JLabel("Date (MM/DD/YYYY): ");
		dateSpinner = new JSpinner(new SpinnerDateModel());
		JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "MM.dd.yyyy");
		dateSpinner.setEditor(dateEditor);
		dateSpinner.setValue(new Date());

		Calendar cal2 = Calendar.getInstance();
		cal2.set(Calendar.HOUR_OF_DAY, 0);
		cal2.set(Calendar.MINUTE, 0);

		Date date1 = cal2.getTime();

		JLabel startTime = new JLabel("Start Time: ");
		SpinnerDateModel sm = new SpinnerDateModel(date1, null, null, Calendar.MINUTE);
		startSpinner = new JSpinner(sm);
		JSpinner.DateEditor de = new JSpinner.DateEditor(startSpinner, "hh:mm a");
		de.getTextField().setEditable(false);
		startSpinner.setEditor(de);

		JLabel endTime = new JLabel("End Time: ");
		SpinnerDateModel sm2 = new SpinnerDateModel(date1, null, null, Calendar.MINUTE);
		endSpinner = new JSpinner(sm2);
		JSpinner.DateEditor de2 = new JSpinner.DateEditor(endSpinner, "hh:mm a");
		de2.getTextField().setEditable(false);
		endSpinner.setEditor(de2);

		submitButton = new JButton("Submit");
		ActionListener saveListener = new SubmitButtonListener();
		submitButton.addActionListener(saveListener);

		panel.add(roomType);
		panel.add(date);
		panel.add(dateSpinner);
		panel.add(startTime);
		panel.add(startSpinner);
		panel.add(endTime);
		panel.add(endSpinner);
		panel.add(submitButton);

		this.add(panel);
	}

	/**
	 * Inner action listener class for the Submit Button
	 **/
	class SubmitButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent click) {
			// insert if statement on whether the date chosen already is taken or not
			/**
			 * if date is available -> pre-fill new reservation screen with selected
			 * date/time else date is not available -> waitlist screen will pop up
			 **/

			String dateChosen = new SimpleDateFormat("MM/dd/yyyy").format(dateSpinner.getValue());

			String startTimeChosen = new SimpleDateFormat("HH:mm a").format(startSpinner.getValue());

			String endTimeChosen = new SimpleDateFormat("HH:mm a").format(endSpinner.getValue());

			DateAndTime timeChosen = new DateAndTime(dateChosen, startTimeChosen, endTimeChosen);

			if (calendar.isRoomAvailable(roomName, timeChosen) == false) {
				waitlistFrame w = new waitlistFrame(roomName, dateChosen, startTimeChosen, endTimeChosen, calendar);
				selectDTFrame.this.dispose();
				w.setVisible(true);
			} else {
				NewReservationFrame n = new NewReservationFrame(roomName, dateChosen, startTimeChosen, endTimeChosen, calendar);
				selectDTFrame.this.dispose();
				n.setVisible(true);
			}
		}
	}
}