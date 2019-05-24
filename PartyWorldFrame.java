
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;


//import backend.AquaRoom;
//import backend.MediumPartyRoom;
//import backend.SmallPartyRoom;

public class PartyWorldFrame extends JFrame {
	JMenuBar menuBar;
	JScrollPane scrollPane;
	JPanel centerPanel;

	// border settings used in the method addARoomDescription()
	Border raisedbevel = BorderFactory.createRaisedBevelBorder();
	Border loweredbevel = BorderFactory.createLoweredBevelBorder();
	ReservationCalendar calendar;

	public PartyWorldFrame(ReservationCalendar calendar) {
		this.calendar = calendar;
		this.setTitle("Reservation System");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); // makes window screen size
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.createMenuBar();
		this.createDefaultPanel();
		this.setVisible(true);

	}

	/*
	 * initializes the default center panel and adds it to this frame
	 */
	private void createDefaultPanel() {
		centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		// Title of default view
		JLabel panelTitle = new JLabel("Party World Rooms");
		panelTitle.setFont(new Font(Font.SERIF, Font.BOLD, 30));

		centerPanel.add(panelTitle);
		addARoomDescription(centerPanel, "/pics/smallroom.jpg",
				"Small Party Room", SmallPartyRoom.getDescription());
		addARoomDescription(centerPanel, "medroom.jpg",
				"Medium Party Room", MediumPartyRoom.getDescription());
		addARoomDescription(centerPanel, "aquaworldroom.jpg", 
				"Aqua Room", AquaRoom.getDescription());
		addARoomDescription(centerPanel, "karaoke.jpg",
				"Karaoke Lounge", Kareoke.getDescription());
		addARoomDescription(centerPanel, "billiards.jpg",
				"Billiards Lounge", Billiards.getDescription());

		scrollPane = new JScrollPane(centerPanel);
		this.add(scrollPane, BorderLayout.CENTER);
	}

	/* initializes menu bar items and adds them to this window */
	private void createMenuBar() {
		menuBar = new JMenuBar();
		// -------
		JMenu menu;
		JMenu submenu;
		JMenuItem menuItem;

		// ------- DESCRIPTIONS MENU------------------
		menu = new JMenu("Descriptions");

		// Party Room Sub Menu
		submenu = new JMenu("Party Rooms");

		menuItem = new JMenuItem("All");
		menuItem.addActionListener(new RoomItemListener());
		submenu.add(menuItem);

		menuItem = new JMenuItem("Small Party Rooms");
		menuItem.addActionListener(new RoomItemListener());
		submenu.add(menuItem);

		menuItem = new JMenuItem("Medium Party Rooms");
		menuItem.addActionListener(new RoomItemListener());
		submenu.add(menuItem);

		menuItem = new JMenuItem("Aqua Room");
		menuItem.addActionListener(new RoomItemListener());
		submenu.add(menuItem);
		menu.add(submenu);

		// Lounges Sub Menu
		submenu = new JMenu("Lounges");

		menuItem = new JMenuItem("All");
		menuItem.addActionListener(new LoungeItemListener());
		submenu.add(menuItem);

		menuItem = new JMenuItem("Karaoke Lounges");
		menuItem.addActionListener(new LoungeItemListener());
		submenu.add(menuItem);

		menuItem = new JMenuItem("Billiards Lounges");
		menuItem.addActionListener(new LoungeItemListener());
		submenu.add(menuItem);

		menu.add(submenu);
		menu.addSeparator();

		// Meal Plans Sub Menu
		submenu = new JMenu("Meal Plans");

		menuItem = new JMenuItem("All");
		submenu.add(menuItem);
		menuItem.addActionListener(new MealItemListener());

		menuItem = new JMenuItem("Basic");
		submenu.add(menuItem);
		menuItem.addActionListener(new MealItemListener());

		menuItem = new JMenuItem("Bronze");
		submenu.add(menuItem);
		menuItem.addActionListener(new MealItemListener());

		menuItem = new JMenuItem("Silver");
		submenu.add(menuItem);
		menuItem.addActionListener(new MealItemListener());

		menuItem = new JMenuItem("Gold");
		submenu.add(menuItem);
		menuItem.addActionListener(new MealItemListener());

		menuItem = new JMenuItem("Platinum");
		submenu.add(menuItem);
		menuItem.addActionListener(new MealItemListener());

		menu.add(submenu);

		menuBar.add(menu);

		// ------- RESERVATIONS MENU------------------
		menu = new JMenu("Reservations");

		// New reservation item
		menuItem = new JMenuItem("New Reservation...");
		menu.add(menuItem);
		menuItem.addActionListener(new NewReservationItemListener());
		menu.addSeparator();

		// Edit reservation item
		menuItem = new JMenuItem("Edit Existing Reservation...");
		menu.add(menuItem);
		menuItem.addActionListener(new EditReservationItemListener());
		menu.addSeparator();

		// Manage reservation sub menu
		submenu = new JMenu("Manage Current Reservation");
		submenu.setMnemonic(KeyEvent.VK_S);

		menuItem = new JMenuItem("Check-in");
		menuItem.addActionListener(new CheckInListener());
		submenu.add(menuItem);

		menuItem = new JMenuItem("Check-out");
		menuItem.addActionListener(new CheckOutListener());
		submenu.add(menuItem);

		menu.add(submenu);

		menuBar.add(menu);
		this.add(menuBar, BorderLayout.NORTH);
	}

	/*
	 * adds room image and description to a given container
	 * @param container - the container onto which to add the new description
	 * @param imgDir - the directory of the image
	 * @param roomName - the name of the room
	 * @param roomDesc - the description of the room
	 */
	private void addARoomDescription(Container container, String imgDir, String roomName, String roomDesc) {
		JPanel p = new JPanel();

		ImageIcon icon = new ImageIcon(imgDir);
		JLabel picture = new JLabel(roomName, icon, JLabel.CENTER);
		picture.setFont(new Font(Font.SERIF, Font.BOLD, 20));

		// Set the position of the text, relative to the icon:
		picture.setVerticalTextPosition(JLabel.TOP);
		picture.setHorizontalTextPosition(JLabel.CENTER);
		// Set border around
		picture.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));

		p.add(picture);

		JTextArea description = new JTextArea(5, 10);
		description.append(roomDesc);
		description.setEditable(false);
		description.setFont(new Font(Font.SERIF, Font.PLAIN, 16));
		description.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
		p.add(description);

		JButton bookButton = new JButton("Book Now");
		ActionListener bnAquaListener = new BookNowAquaButtonListener();
		ActionListener bnSmallListener = new BookNowSmallButtonListener();
		ActionListener bnMedListener = new BookNowMedButtonListener();
		ActionListener bnKaraokeListener = new BookNowKaraokeButtonListener();
		ActionListener bnBilliardsListener = new BookNowBilliardsButtonListener();
		if (roomName == "Aqua Room") {
			bookButton.addActionListener(bnAquaListener);
		}
		if (roomName == "Small Party Room") {
			bookButton.addActionListener(bnSmallListener);
		}
		if (roomName == "Medium Party Room") {
			bookButton.addActionListener(bnMedListener);
		}
		if (roomName == "Karaoke Lounge") {
			bookButton.addActionListener(bnKaraokeListener);
		}
		if (roomName == "Billiards Lounge") {
			bookButton.addActionListener(bnBilliardsListener);
		}
		p.add(bookButton);
		container.add(p);
	}
	
	/*
	 * adds room image and description to a given container
	 * @param container - the container onto which to add the new description
	 * @param imgDir - the directory of the image
	 * @param roomName - the name of the room
	 * @param roomDesc - the description of the room
	 */
	private void addAMealDescription(Container container, String mealName, String mealDesc) {
		JPanel p = new JPanel();

		JTextArea description = new JTextArea(5, 10);
		description.append(mealDesc);
		description.setEditable(false);
		description.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
		description.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
		p.add(description);

		container.add(p);
	}

	class MealItemListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent click) {
			JMenuItem menuItem = (JMenuItem) click.getSource();
			String item = menuItem.getText();
			if (item.equals("All")) {
				centerPanel.removeAll();
				addAMealDescription(centerPanel, "Basic", BasicMealPlan.display());
				addAMealDescription(centerPanel, "Bronze", BronzeMealPlan.display());
				addAMealDescription(centerPanel, "Silver", SilverMealPlan.display());
				addAMealDescription(centerPanel, "Gold", GoldMealPlan.display());
				addAMealDescription(centerPanel, "Platinum", PlatinumMealPlan.display());
				centerPanel.updateUI();
			} else if (item.equals("Basic")) {
				centerPanel.removeAll();
				addAMealDescription(centerPanel, "Basic", BasicMealPlan.display());
				centerPanel.updateUI();}
			else if (item.equals("Bronze")) {
				centerPanel.removeAll();
				addAMealDescription(centerPanel, "Bronze", BronzeMealPlan.display());
				centerPanel.updateUI();}
			else if (item.equals("Silver")) {
				centerPanel.removeAll();
				addAMealDescription(centerPanel, "Silver", SilverMealPlan.display());
				centerPanel.updateUI();}
			else if (item.equals("Gold")) {
				centerPanel.removeAll();
				addAMealDescription(centerPanel, "Gold", GoldMealPlan.display());
				centerPanel.updateUI();}
			else if (item.equals("Platinum")) {
				centerPanel.removeAll();
				addAMealDescription(centerPanel, "Platinum", PlatinumMealPlan.display());
				centerPanel.updateUI();}
		}
	}

	class RoomItemListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent select) {
			JMenuItem item = (JMenuItem) select.getSource();

			if (item.getText().equals("All")) {
				// remove all components in panel.
				centerPanel.removeAll();
				addARoomDescription(centerPanel, "smallroom.jpg",
						"Small Party Room", SmallPartyRoom.getDescription());
				addARoomDescription(centerPanel, "medroom.jpg",
						"Medium Party Room", MediumPartyRoom.getDescription());
				addARoomDescription(centerPanel, "aquaworldroom.jpg",
						"Aqua Room", AquaRoom.getDescription());
				// refresh the panel.
				centerPanel.updateUI();
			}

			if (item.getText().equals("Small Party Rooms")) {
				// remove all components in panel.
				centerPanel.removeAll();
				addARoomDescription(centerPanel, "smallroom.jpg",
						"Small Party Room", SmallPartyRoom.getDescription());
				// refresh the panel.
				centerPanel.updateUI();
			}

			if (item.getText().equals("Medium Party Rooms")) {
				// remove all components in panel.
				centerPanel.removeAll();
				addARoomDescription(centerPanel, "medroom.jpg",
						"Medium Party Room", MediumPartyRoom.getDescription());
				// refresh the panel.
				centerPanel.updateUI();
			}

			if (item.getText().equals("Aqua Room")) {
				// remove all components in panel.
				centerPanel.removeAll();
				addARoomDescription(centerPanel, "aquaworldroom.jpg",
						"Aqua Room", AquaRoom.getDescription());
				// refresh the panel.
				centerPanel.updateUI();
			}
		}
	}
	
	class LoungeItemListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent select) {
			JMenuItem item = (JMenuItem) select.getSource();

			if (item.getText().equals("All")) {
				// remove all components in panel.
				centerPanel.removeAll();
				addARoomDescription(centerPanel, "karaoke.jpg",
						"Karaoke Lounge", Kareoke.getDescription());
				addARoomDescription(centerPanel, "billiards.jpg",
						"Billiards Lounge", Billiards.getDescription());
				// refresh the panel.
				centerPanel.updateUI();
			}

			if (item.getText().equals("Karaoke Lounges")) {
				// remove all components in panel.
				centerPanel.removeAll();
				addARoomDescription(centerPanel, "karaoke.jpg",
						"Karaoke Lounge", Kareoke.getDescription());
				// refresh the panel.
				centerPanel.updateUI();
			}

			if (item.getText().equals("Billiards Lounges")) {
				// remove all components in panel.
				centerPanel.removeAll();
				addARoomDescription(centerPanel, "billiards.jpg",
						"Billiards Lounge", Billiards.getDescription());
				// refresh the panel.
				centerPanel.updateUI();
			}
		}
	}
	
	/**
	 * Inner action listener class for the Cancel Button
	 * **/
	class NewReservationItemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent click) {
			NewReservationFrame n = new NewReservationFrame(null, null, null, null, calendar);
			n.setVisible(true);
		}
	}
	
	/**
	 * Inner action listener class for the Cancel Button
	 * **/
	class EditReservationItemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent click) {
			EnterConfirmationFrame e = new EnterConfirmationFrame(calendar);
			e.setVisible(true);
		}
	}
	
	/**
	 * Inner action listener class for the Cancel Button
	 * **/
	class BookNowAquaButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent click) {
			String roomName = ("Aqua Room");
			selectDTFrame s = new selectDTFrame(roomName, calendar);
			s.setVisible(true);
		}
	}
	
	/**
	 * Inner action listener class for the Cancel Button
	 * **/
	class BookNowSmallButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent click) {
			String roomName = ("Small Party Room");
			selectDTFrame s = new selectDTFrame(roomName, calendar);
			s.setVisible(true);
		}
	}
	
	/**
	 * Inner action listener class for the Cancel Button
	 * **/
	class BookNowMedButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent click) {
			String roomName = ("Medium Party Room");
			selectDTFrame s = new selectDTFrame(roomName, calendar);
			s.setVisible(true);
		}
	}
	
	/**
	 * Inner action listener class for the Cancel Button
	 * **/
	class BookNowKaraokeButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent click) {
			String roomName = ("Karaoke Lounge");
			selectDTFrame s = new selectDTFrame(roomName, calendar);
			s.setVisible(true);
		}
	}
	
	/**
	 * Inner action listener class for the Cancel Button
	 * **/
	class BookNowBilliardsButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent click) {
			String roomName = ("Billiards Lounge");
			selectDTFrame s = new selectDTFrame(roomName, calendar);
			s.setVisible(true);
		}
	}
	
	class CheckInListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent click) {
			CheckInFrame s = new CheckInFrame(calendar);
			s.setVisible(true);
		}
	}
	
	class CheckOutListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent click) {
			CheckOutFrame s = new CheckOutFrame(calendar);
			s.setVisible(true);
		}
	}

	public static void main(String[] args) {
		ReservationCalendar calendar = new ReservationCalendar();
		PartyWorldFrame f = new PartyWorldFrame(calendar);
		f.setVisible(true);
	}
}
