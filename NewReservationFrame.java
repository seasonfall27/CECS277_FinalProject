import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.JTextComponent;


public class NewReservationFrame extends JFrame {
	JScrollPane scrollPane;
	JPanel panel;
	JPanel panel1;
	JPanel panel2;
	String roomName;
	String dateChosen;
	String startTimeChosen;
	String endTimeChosen;
	ReservationCalendar calendar;

	// Guest Information
	private JLabel name;
	private JTextField nameTextField;
	private JLabel phone;
	private JTextField phoneTextField;
	private JLabel address;
	private JTextField addressTextField;
	private JLabel bod;
	private JComboBox<String> monthOptions;
	private JSpinner dayOptions;
	private JTextField yearTextField;
	private JLabel email;
	private JTextField emailTextField;

	// Credit Card Information
	private JLabel ccName;
	private JTextField payNameTextField;
	private JLabel ccNumber;
	private JTextField payNumberTextField;
	private JLabel ccSC;
	private JTextField paySCTextField;
	private JLabel ccExpDate;
	private JTextField expDateTextField;
	private JLabel ccLabel;
	private JCheckBox ccVisaCheckbox;
	private JCheckBox ccMastercardCheckbox;
	private JCheckBox ccDiscoverCheckbox;
	private JCheckBox ccAmexCheckbox;
	private JCheckBox phoneCheckbox;
	private JCheckBox emailCheckbox;

	// Room Information
	private JLabel roomType;
	private JComboBox<String> roomTypeOptions;
	private ActionListener roomTypeListener;
	// Date
	private JSpinner dateSpinner;
	private JSpinner startSpinner;
	private JSpinner endSpinner;
	// Upgrades Available
	private JLabel upgradeLabel;
	private JLabel upgradeMPText;
	private JCheckBox upgradeMP;
	private JLabel mealPlanChecker;
	private JLabel towelText;
	private JTextField towelRentals;
	private JLabel pfText;
	private JTextField partyFavors;
	private JLabel projectorText;
	private JCheckBox projector;
	private JLabel partyDecoText; 
	private JCheckBox partyDeco;
	private JComboBox<String> themeOptions;

	// Meal Plan Information
	// Depending on which room was selected
	private JLabel mealPlan;
	private JComboBox<String> mealPlanType;
	private JLabel pizza1;
	private JComboBox<String> pizzaTopping1a;
	private JComboBox<String> pizzaTopping1b;
	private JComboBox<String> pizzaTopping1c;
	private JComboBox<String> pizzaTopping1d;
	private JLabel pizza2;
	private JComboBox<String> pizzaTopping2a;
	private JComboBox<String> pizzaTopping2b;
	private JComboBox<String> pizzaTopping2c;
	private JComboBox<String> pizzaTopping2d;
	private JLabel pizza3;
	private JComboBox<String> pizzaTopping3a;
	private JComboBox<String> pizzaTopping3b;
	private JComboBox<String> pizzaTopping3c;
	private JComboBox<String> pizzaTopping3d;
	private JLabel pizza4;
	private JComboBox<String> pizzaTopping4a;
	private JComboBox<String> pizzaTopping4b;
	private JComboBox<String> pizzaTopping4c;
	private JComboBox<String> pizzaTopping4d;
	private JLabel soda1;
	private JComboBox<String> sodaFlavor1;
	private JLabel soda2;
	private JComboBox<String> sodaFlavor2;
	private JLabel soda3;
	private JComboBox<String> sodaFlavor3;
	private JLabel soda4;
	private JComboBox<String> sodaFlavor4;
	private JLabel soda5;
	private JComboBox<String> sodaFlavor5;
	private JLabel saladOrBreadsticks;
	private JComboBox<String> sOrB;
	private JLabel salad;
	private JLabel breadsticks;
	private JLabel wing1;
	private JComboBox<String> wingFlavor1;
	private JLabel wing2;
	private JComboBox<String> wingFlavor2;
	private JLabel icecream1;
	private JComboBox<String> icecreamFlavor1;
	private JLabel icecream2;
	private JComboBox<String> icecreamFlavor2;

	private JButton saveButton;
	private JButton cancelButton;

	/**
	 * Constructs a NewItemFrame object
	 * 
	 * @param cr - CashRegister object that is used to store items and calculate
	 *           cost for purchase
	 **/
	public NewReservationFrame(String roomName, String dateChosen, String startTimeChosen, String endTimeChosen, ReservationCalendar calendar) {
		this.roomName = roomName;
		this.dateChosen = dateChosen;
		this.startTimeChosen = startTimeChosen;
		this.endTimeChosen = endTimeChosen;
		this.calendar = calendar;
		// call private helper method to create and add components
		createComponents();

		// set the frame properties
		this.setTitle("New Reservation");
		this.setSize(400, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void createComponents() {

		// Guest Information
		JLabel guestTitle = new JLabel("Guest Information");
		guestTitle.setFont(new Font(Font.SERIF, Font.BOLD, 20));

		name = new JLabel("Guest's Full Name: ");
		nameTextField = new JTextField(30);

		phone = new JLabel("Phone Number: ");
		phoneTextField = new JTextField(35);

		address = new JLabel("Full Address: ");
		addressTextField = new JTextField(35);

		bod = new JLabel("Date of Birth (Month, Date, Year): ");
		String[] bodMonths = new String[] { "January", "February", "March", "April", "May", "June", "July", "August",
				"September", "October", "November", "December" };
		monthOptions = new JComboBox<String>(bodMonths);

		SpinnerModel spinnerModel = new SpinnerNumberModel(0, // initial value
				0, // min
				31, // max
				1); // step
		dayOptions = new JSpinner(spinnerModel);
//		spinner.addChangeListener(new ChangeListener());
		yearTextField = new JTextField(10);

		email = new JLabel("Email: ");
		emailTextField = new JTextField(35);

		JLabel contactPhone = new JLabel("Guest contact method: Phone: ");
		phoneCheckbox = new JCheckBox();
		JLabel contactEmail = new JLabel("Email: ");
		emailCheckbox = new JCheckBox();

		// Credit Card Information
		JLabel ccTitle = new JLabel("Payment Information");
		ccTitle.setFont(new Font(Font.SERIF, Font.BOLD, 20));

		ccName = new JLabel("Full Name on Card: ");
		payNameTextField = new JTextField(30);

		ccNumber = new JLabel("Card Number: ");
		payNumberTextField = new JTextField(35);

		ccSC = new JLabel("Security Number: ");
		paySCTextField = new JTextField(10);

		ccExpDate = new JLabel("Card Expiration Date 00/99 Format: ");
		expDateTextField = new JTextField(10);

		ccLabel = new JLabel("Type of Card: ");
		JLabel visa = new JLabel("Visa: ");
		ccVisaCheckbox = new JCheckBox();
		JLabel mastercard = new JLabel("Mastercard: ");
		ccMastercardCheckbox = new JCheckBox();
		JLabel discover = new JLabel("Discover: ");
		ccDiscoverCheckbox = new JCheckBox();
		JLabel amex = new JLabel("American Express: ");
		ccAmexCheckbox = new JCheckBox();

		// Room Details
		roomType = new JLabel("Room Details: ");
		roomType.setFont(new Font(Font.SERIF, Font.BOLD, 20));
		String[] roomTypeString = new String[] { "Aqua Room", "Small Party Room", "Medium Party Room",
				"Karaoke Lounge", "Adults Billiards Lounge" };
		roomTypeOptions = new JComboBox<String>(roomTypeString);
		roomTypeListener = new RoomTypeListener();
		roomTypeOptions.addActionListener(roomTypeListener);
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		Date defaultDate = cal.getTime();
		
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
		Date chosenDate = null;
		try {
			if (dateChosen == null) {
				chosenDate = defaultDate;
			}
			else {
				chosenDate = df.parse(dateChosen);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JLabel date = new JLabel("Date (MM/DD/YYYY): ");
		dateSpinner = new JSpinner(new SpinnerDateModel());
		JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "MM.dd.yyyy");
		dateSpinner.setEditor(dateEditor);
		dateSpinner.setValue(chosenDate);

		DateFormat df2 = new SimpleDateFormat("hh:mm a"); 
		Date chosenStartTime = null;
		try {
			if (startTimeChosen == null) {
				chosenStartTime = defaultDate;
			}
			else {
				chosenStartTime = df2.parse(startTimeChosen);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JLabel startTime = new JLabel("Start Time: ");
		SpinnerDateModel sm = new SpinnerDateModel(defaultDate, null, null, Calendar.MINUTE);
		startSpinner = new JSpinner(sm);
		JSpinner.DateEditor de = new JSpinner.DateEditor(startSpinner, "hh:mm a");
		de.getTextField().setEditable(false);
		startSpinner.setEditor(de);
		startSpinner.setValue(chosenStartTime);
		
		DateFormat df3 = new SimpleDateFormat("hh:mm a"); 
		Date chosenEndTime = null;
		try {
			if (endTimeChosen == null) {
				chosenEndTime = defaultDate;
			}
			else {
				chosenEndTime = df3.parse(endTimeChosen);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JLabel endTime = new JLabel("End Time: ");
		SpinnerDateModel sm2 = new SpinnerDateModel(defaultDate, null, null, Calendar.MINUTE);
		endSpinner = new JSpinner(sm2);
		JSpinner.DateEditor de2 = new JSpinner.DateEditor(endSpinner, "hh:mm a");
		de2.getTextField().setEditable(false);
		endSpinner.setEditor(de2);
		endSpinner.setValue(chosenEndTime);
		
		//Upgrade Information
		panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));

		// Meal Plan Information
		panel1 = new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));

		saveButton = new JButton("Save");
		ActionListener saveListener = new SaveButtonListener();
		saveButton.addActionListener(saveListener);

		cancelButton = new JButton("Cancel");
		ActionListener cancelListener = new CancelButtonListener();
		cancelButton.addActionListener(cancelListener);

		// create panel and add components
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(guestTitle);
		panel.add(name);
		panel.add(nameTextField);
		panel.add(phone);
		panel.add(phoneTextField);
		panel.add(address);
		panel.add(addressTextField);
		panel.add(bod);
		panel.add(monthOptions);
		panel.add(dayOptions);
		panel.add(yearTextField);
		panel.add(email);
		panel.add(emailTextField);
		panel.add(contactPhone);
		panel.add(phoneCheckbox);
		panel.add(contactEmail);
		panel.add(emailCheckbox);

		panel.add(ccTitle);
		panel.add(ccName);
		panel.add(payNameTextField);
		panel.add(ccNumber);
		panel.add(payNumberTextField);
		panel.add(ccSC);
		panel.add(paySCTextField);
		panel.add(ccExpDate);
		panel.add(expDateTextField);
		panel.add(ccLabel);
		panel.add(visa);
		panel.add(ccVisaCheckbox);
		panel.add(mastercard);
		panel.add(ccMastercardCheckbox);
		panel.add(discover);
		panel.add(ccDiscoverCheckbox);
		panel.add(amex);
		panel.add(ccAmexCheckbox);

		panel.add(roomType);
		panel.add(roomTypeOptions);
		panel.add(date);
		panel.add(dateSpinner);
		panel.add(startTime);
		panel.add(startSpinner);
		panel.add(endTime);
		panel.add(endSpinner);

		panel.add(saveButton);
		panel.add(cancelButton);
		
		if (roomName == "Aqua Room") {
			roomTypeOptions.setSelectedIndex(0);
		}
		if (roomName == "Small Party Room") {
			roomTypeOptions.setSelectedIndex(1);
		}
		if (roomName == "Medium Party Room") {
			roomTypeOptions.setSelectedIndex(2);
		}
		if (roomName == "Karaoke Lounge") {
			roomTypeOptions.setSelectedIndex(3);
		}
		if (roomName == "Billiards Lounge") {
			roomTypeOptions.setSelectedIndex(4);
		}

		// add the panel to this frame
		this.add(panel);
		scrollPane = new JScrollPane(panel);
		this.add(scrollPane, BorderLayout.CENTER);

	}

	private void createAllMPComponents() {
		pizza1 = new JLabel("Pizza 1: ");
		pizza2 = new JLabel("Pizza 2: ");
		pizza3 = new JLabel("Pizza 3: ");
		pizza4 = new JLabel("Pizza 4: ");
		String[] pizzaToppings = new String[] { "Cheese", "Pepperoni", "Ham", "Jalapeno", "Sausage", "Mushroom",
				"Pineapple", "Bell Pepper", "Onion", "Garlic Chicken" };
		pizzaTopping1a = new JComboBox<String>(pizzaToppings);
		pizzaTopping1b = new JComboBox<String>(pizzaToppings);
		pizzaTopping1c = new JComboBox<String>(pizzaToppings);
		pizzaTopping1d = new JComboBox<String>(pizzaToppings);
		pizzaTopping2a = new JComboBox<String>(pizzaToppings);
		pizzaTopping2b = new JComboBox<String>(pizzaToppings);
		pizzaTopping2c = new JComboBox<String>(pizzaToppings);
		pizzaTopping2d = new JComboBox<String>(pizzaToppings);
		pizzaTopping3a = new JComboBox<String>(pizzaToppings);
		pizzaTopping3b = new JComboBox<String>(pizzaToppings);
		pizzaTopping3c = new JComboBox<String>(pizzaToppings);
		pizzaTopping3d = new JComboBox<String>(pizzaToppings);
		pizzaTopping4a = new JComboBox<String>(pizzaToppings);
		pizzaTopping4b = new JComboBox<String>(pizzaToppings);
		pizzaTopping4c = new JComboBox<String>(pizzaToppings);
		pizzaTopping4d = new JComboBox<String>(pizzaToppings);

		soda1 = new JLabel("Soda 1: ");
		soda2 = new JLabel("Soda 2: ");
		soda3 = new JLabel("Soda 3: ");
		soda4 = new JLabel("Soda 4: ");
		soda5 = new JLabel("Soda 5: ");
		String[] sodaFlavors = new String[] { "Coca-Cola", "Diet Coke", "Canada Dry", "Orange Crush", "Orange Crush",
				"Squirt", "Root Beer" };
		sodaFlavor1 = new JComboBox<String>(sodaFlavors);
		sodaFlavor2 = new JComboBox<String>(sodaFlavors);
		sodaFlavor3 = new JComboBox<String>(sodaFlavors);
		sodaFlavor4 = new JComboBox<String>(sodaFlavors);
		sodaFlavor5 = new JComboBox<String>(sodaFlavors);

		saladOrBreadsticks = new JLabel("Salad or Breadsticks");
		String[] sOrBOptions = new String[] { "Salad", "Breadsticks" };
		sOrB = new JComboBox<String>(sOrBOptions);
		salad = new JLabel("Salad included");
		breadsticks = new JLabel("Breadsticks included");

		wing1 = new JLabel("Chicken Wings 1:");
		String[] wingFlavors = new String[] { "Mild Spicy", "Diablo", "Lemon Pepper", "BBQ", "Sesame" };
		wingFlavor1 = new JComboBox<String>(wingFlavors);
		wing2 = new JLabel("Chicken Wings 2:");
		wingFlavor2 = new JComboBox<String>(wingFlavors);

		String[] icFlavors = new String[] { "Chocolate Fudge", "Vanilla Bean", "Strawberry Shortcake", "Choco-mint",
				"Butter Pecan" };
		icecream1 = new JLabel("Ice Cream 1:");
		icecreamFlavor1 = new JComboBox<String>(icFlavors);
		icecream2 = new JLabel("Ice Cream 1:");
		icecreamFlavor2 = new JComboBox<String>(icFlavors);
	}
	
	private void createUpgradeComponents() {
		upgradeLabel = new JLabel("Upgrades: ");
		upgradeLabel.setFont(new Font(Font.SERIF, Font.BOLD, 20));
		upgradeMPText = new JLabel("Upgrade Meal Plan: ");
		upgradeMP = new JCheckBox();
		ActionListener upgradeListener = new UpgradeMPListener();
		upgradeMP.addActionListener(upgradeListener);
		mealPlanChecker = new JLabel("Upgraded meal plan: ");
		mealPlanChecker.setFont(new Font(Font.SERIF, Font.BOLD, 20));
		towelText = new JLabel("Towel Rentals ($2 each): ");
		towelRentals = new JTextField("0");
		pfText = new JLabel("Party Favors Bag ($5 per bag): ");
		partyFavors = new JTextField("0");
		projectorText = new JLabel("Projector ($10/hour): ");
		projector = new JCheckBox();
		partyDecoText = new JLabel("Party decorations & Set-Up (+$100): ");
		partyDeco = new JCheckBox();
		ActionListener themeListener = new ThemeListener();
		partyDeco.addActionListener(themeListener);
		String[] themeString = new String[] { "Hawaiian", "Sea Life", "Jungle", "Space", "Modern" };
		themeOptions = new JComboBox<String>(themeString);
	}

	private void createBasicMPComponents() {
		JLabel mealPlanLabel = new JLabel("Basic Meal Plan:");
		mealPlanLabel.setFont(new Font(Font.SERIF, Font.BOLD, 20));
		panel1.add(mealPlanLabel);
		JLabel costBasic = new JLabel("$65");
		panel1.add(costBasic);

		panel1.add(pizza1);
		panel1.add(pizzaTopping1a);
		panel1.add(pizza2);
		panel1.add(pizzaTopping2a);
		panel1.add(pizza3);
		panel1.add(pizzaTopping3a);

		panel1.add(soda1);
		panel1.add(sodaFlavor1);
		panel1.add(soda2);
		panel1.add(sodaFlavor2);
		panel1.add(soda3);
		panel1.add(sodaFlavor3);

	}

	private void createBronzeMPComponents() {
		JLabel mealPlanLabel = new JLabel("Bronze Meal Plan:");
		mealPlanLabel.setFont(new Font(Font.SERIF, Font.BOLD, 20));
		panel1.add(mealPlanLabel);
		JLabel costBronze = new JLabel("$75");
		panel1.add(costBronze);

		panel1.add(pizza1);
		panel1.add(pizzaTopping1a);
		panel1.add(pizzaTopping1b);
		panel1.add(pizza2);
		panel1.add(pizzaTopping2a);
		panel1.add(pizzaTopping2b);
		panel1.add(pizza3);
		panel1.add(pizzaTopping3a);
		panel1.add(pizzaTopping3b);

		panel1.add(soda1);
		panel1.add(sodaFlavor1);
		panel1.add(soda2);
		panel1.add(sodaFlavor2);
		panel1.add(soda3);
		panel1.add(sodaFlavor3);
		panel1.add(soda4);
		panel1.add(sodaFlavor4);
		panel1.add(soda5);
		panel1.add(sodaFlavor5);

		panel1.add(saladOrBreadsticks);
		panel1.add(sOrB);
	}

	private void createSilverMPComponents() {
		JLabel mealPlanLabel = new JLabel("Silver Meal Plan:");
		mealPlanLabel.setFont(new Font(Font.SERIF, Font.BOLD, 20));
		panel1.add(mealPlanLabel);
		JLabel costSilver = new JLabel("$90");
		panel1.add(costSilver);

		panel1.add(pizza1);
		panel1.add(pizzaTopping1a);
		panel1.add(pizzaTopping1b);
		panel1.add(pizzaTopping1c);
		panel1.add(pizza2);
		panel1.add(pizzaTopping2a);
		panel1.add(pizzaTopping2b);
		panel1.add(pizzaTopping2c);
		panel1.add(pizza3);
		panel1.add(pizzaTopping3a);
		panel1.add(pizzaTopping3b);
		panel1.add(pizzaTopping3c);

		panel1.add(soda1);
		panel1.add(sodaFlavor1);
		panel1.add(soda2);
		panel1.add(sodaFlavor2);
		panel1.add(soda3);
		panel1.add(sodaFlavor3);
		panel1.add(soda4);
		panel1.add(sodaFlavor4);
		panel1.add(soda5);
		panel1.add(sodaFlavor5);

		panel1.add(salad);
		panel1.add(breadsticks);
	}

	private void createGoldMPComponents() {
		JLabel mealPlanLabel = new JLabel("Gold Meal Plan:");
		mealPlanLabel.setFont(new Font(Font.SERIF, Font.BOLD, 20));
		panel1.add(mealPlanLabel);
		JLabel costGold = new JLabel("$120");
		panel1.add(costGold);

		panel1.add(pizza1);
		panel1.add(pizzaTopping1a);
		panel1.add(pizzaTopping1b);
		panel1.add(pizzaTopping1c);
		panel1.add(pizza2);
		panel1.add(pizzaTopping2a);
		panel1.add(pizzaTopping2b);
		panel1.add(pizzaTopping2c);
		panel1.add(pizza3);
		panel1.add(pizzaTopping3a);
		panel1.add(pizzaTopping3b);
		panel1.add(pizzaTopping3c);

		panel1.add(soda1);
		panel1.add(sodaFlavor1);
		panel1.add(soda2);
		panel1.add(sodaFlavor2);
		panel1.add(soda3);
		panel1.add(sodaFlavor3);
		panel1.add(soda4);
		panel1.add(sodaFlavor4);
		panel1.add(soda5);
		panel1.add(sodaFlavor5);

		panel1.add(salad);
		panel1.add(breadsticks);

		panel1.add(wing1);
		panel1.add(wingFlavor1);
		panel1.add(wing2);
		panel1.add(wingFlavor2);
	}

	private void createPlatinumMPComponents() {
		JLabel mealPlanLabel = new JLabel("Platinum Meal Plan:");
		mealPlanLabel.setFont(new Font(Font.SERIF, Font.BOLD, 20));
		panel1.add(mealPlanLabel);
		JLabel costPlatinum = new JLabel("$150");
		panel1.add(costPlatinum);

		panel1.add(pizza1);
		panel1.add(pizzaTopping1a);
		panel1.add(pizzaTopping1b);
		panel1.add(pizzaTopping1c);
		panel1.add(pizzaTopping1d);
		panel1.add(pizza2);
		panel1.add(pizzaTopping2a);
		panel1.add(pizzaTopping2b);
		panel1.add(pizzaTopping2c);
		panel1.add(pizzaTopping2d);
		panel1.add(pizza3);
		panel1.add(pizzaTopping3a);
		panel1.add(pizzaTopping3b);
		panel1.add(pizzaTopping3c);
		panel1.add(pizzaTopping3d);
		panel1.add(pizza4);
		panel1.add(pizzaTopping4a);
		panel1.add(pizzaTopping4b);
		panel1.add(pizzaTopping4c);
		panel1.add(pizzaTopping4d);

		panel1.add(soda1);
		panel1.add(sodaFlavor1);
		panel1.add(soda2);
		panel1.add(sodaFlavor2);
		panel1.add(soda3);
		panel1.add(sodaFlavor3);
		panel1.add(soda4);
		panel1.add(sodaFlavor4);
		panel1.add(soda5);
		panel1.add(sodaFlavor5);

		panel1.add(salad);
		panel1.add(breadsticks);

		panel1.add(wing1);
		panel1.add(wingFlavor1);
		panel1.add(wing2);
		panel1.add(wingFlavor2);

		panel1.add(icecream1);
		panel1.add(icecreamFlavor1);
		panel1.add(icecream2);
		panel1.add(icecreamFlavor2);
	}

	/**
	 * Inner action listener class for the first Pastry Options dropdown menu
	 **/
	class MealPlanTypeListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent click) {
			panel.remove(saveButton);
			panel.remove(cancelButton);
			panel1.removeAll();
			panel.updateUI();
			String mpChoice = (String) mealPlanType.getSelectedItem();
			createAllMPComponents();

			// choice determines what content is added to the frame
			if (mpChoice.equals("Basic")) {
				createBasicMPComponents();
			}
			if (mpChoice.equals("Bronze")) {
				createBronzeMPComponents();
			}
			if (mpChoice.equals("Silver")) {
				createSilverMPComponents();
			}
			if (mpChoice.equals("Gold")) {
				createGoldMPComponents();
			}
			if (mpChoice.equals("Platinum")) {
				createPlatinumMPComponents();
			}

			panel.add(panel1);
			panel.add(saveButton);
			panel.add(cancelButton);

			panel.revalidate();
			panel.repaint();

		}
	}

	/**
	 * Inner action listener class for the first Pastry Options dropdown menu
	 **/
	class RoomTypeListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent click) {
			panel.remove(saveButton);
			panel.remove(cancelButton);
			panel.remove(panel2);
			panel1.removeAll();
			createAllMPComponents();
			createUpgradeComponents();

			String roomChoice = (String) roomTypeOptions.getSelectedItem();

			// choice determines what content is added to the frame
			if (roomChoice.equals("Aqua Room")) {
				panel2.removeAll();
				panel2.add(upgradeLabel);
				panel2.add(upgradeMPText);
				panel2.add(upgradeMP);
				panel2.add(towelText);
				panel2.add(towelRentals);
				panel2.add(pfText);
				panel2.add(partyFavors);
				panel2.add(projectorText);
				panel2.add(projector);
				panel2.add(partyDecoText);
				panel2.add(partyDeco);
				createBasicMPComponents();
			}
			if (roomChoice.equals("Small Party Room")) {
				panel2.removeAll();
				panel2.add(upgradeLabel);
				panel2.add(upgradeMPText);
				panel2.add(upgradeMP);
				panel2.add(pfText);
				panel2.add(partyFavors);
				panel2.add(projectorText);
				panel2.add(projector);
				panel2.add(partyDecoText);
				panel2.add(partyDeco);
				createBasicMPComponents();
			}
			if (roomChoice.equals("Medium Party Room")) {
				panel2.removeAll();
				panel2.add(upgradeLabel);
				panel2.add(upgradeMPText);
				panel2.add(upgradeMP);
				panel2.add(pfText);
				panel2.add(partyFavors);
				panel2.add(projectorText);
				panel2.add(projector);
				panel2.add(partyDecoText);
				panel2.add(partyDeco);
				createBasicMPComponents();
			}
			if (roomChoice.equals("Karaoke Lounge")) {
				panel2.removeAll();
				panel2.add(upgradeLabel);
				panel2.add(upgradeMPText);
				panel2.add(upgradeMP);
			}
			if (roomChoice.equals("Adults Billiards Lounge")) {
				panel2.removeAll();
				panel2.add(upgradeLabel);
				panel2.add(upgradeMPText);
				panel2.add(upgradeMP);
			}
			
			panel.add(panel2);
			panel.add(panel1);
			panel.add(saveButton);
			panel.add(cancelButton);
			panel.revalidate();
			panel.repaint();
		}
	}
	
	/**
	 * Inner action listener class for the first Pastry Options dropdown menu
	 **/
	class UpgradeMPListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent click) {
	        if (upgradeMP.isSelected()) {
	        	panel.remove(panel1);
	        	roomTypeOptions.setEnabled(false);
	        	panel.remove(saveButton);
				panel.remove(cancelButton);
				
				String[] mealPlanOptions = new String[] {"Bronze", "Silver", "Gold", "Platinum" };
				mealPlanType = new JComboBox<String>(mealPlanOptions);
				ActionListener mealPlanListener = new MealPlanTypeListener();
				mealPlanType.addActionListener(mealPlanListener);
			
				createAllMPComponents();
				panel.add(mealPlanChecker);
	        	panel.add(mealPlanType);
	        } else {
	        	panel.remove(mealPlanChecker);
	        	panel.remove(mealPlanType);
	        	panel.remove(panel1);
	        	roomTypeOptions.setEnabled(true);
	        	
	        	String roomChoice = (String) roomTypeOptions.getSelectedItem();

				// choice determines what content is added to the frame
				if (roomChoice.equals("Aqua Room")) {
					panel1.removeAll();
					createBasicMPComponents();
					panel.add(panel1);
				}
				if (roomChoice.equals("Small Party Room")) {
					panel1.removeAll();
					createBasicMPComponents();
					panel.add(panel1);
				}
				if (roomChoice.equals("Medium Party Room")) {
					panel1.removeAll();
					createBasicMPComponents();
					panel.add(panel1);
				}
				if (roomChoice.equals("Karaoke Lounge")) {
				}
				if (roomChoice.equals("Adults Billiards Lounge")) {
				}
	        }

			panel.add(saveButton);
			panel.add(cancelButton);
			panel.revalidate();
			panel.repaint();
		}
	}

	/**
	 * Inner action listener class for the Cancel Button
	 **/
	class ThemeListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent click) {

			if (partyDeco.isSelected()) {
				roomTypeOptions.setEnabled(false);
				panel2.add(themeOptions);
				panel2.updateUI();
			}
			else {
				panel2.remove(themeOptions);
				panel2.updateUI();
	        	roomTypeOptions.setEnabled(true);
			}
		}
	}
	
	/**
	 * Inner action listener class for the Cancel Button
	 * **/
	class CancelButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent click) {
			NewReservationFrame.this.dispose();
		}
	}
	
	/**
	 * Inner action listener class for the save button
	 **/
	class SaveButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
// TODO Save button creates new reservation objects (Guest name, phone number, address, DOB, Email,)
			String name = nameTextField.getText();
			String phoneNumber = phoneTextField.getText();
			String address = addressTextField.getText();
			String birthMonth = (String) monthOptions.getSelectedItem();
			String birthDay = dayOptions.getValue().toString();
			String birthYear = yearTextField.getText();
			String emailInput = emailTextField.getText();
			boolean contactByPhone = false;
			if (phoneCheckbox.isSelected()) {
				contactByPhone = true;
			}
			boolean contactByEmail = false;
			if (emailCheckbox.isSelected()) {
				contactByEmail = true;
			}
			//card info
			String nameOnCard = payNameTextField.getText();
			String numberOnCard = payNumberTextField.getText();
			String security = paySCTextField.getText();
			String cardExpiration = expDateTextField.getText();
			String cardType = "Card Type";
			if (ccVisaCheckbox.isSelected()) {
				cardType = ccVisaCheckbox.getText();
			}
			else if (ccMastercardCheckbox.isSelected()) {
				cardType = ccMastercardCheckbox.getText();
			}
			else if (ccDiscoverCheckbox.isSelected()) {
				cardType = ccDiscoverCheckbox.getText();
			}
			else if (ccAmexCheckbox.isSelected()) {
				cardType = ccAmexCheckbox.getText();
			}
			//room details
			String roomType = (String) roomTypeOptions.getSelectedItem();
			
			String dateChosen = new SimpleDateFormat("MM/dd/yyyy").format(dateSpinner.getValue());

			String startTimeChosen = new SimpleDateFormat("HH:mm a").format(startSpinner.getValue());

			String endTimeChosen = new SimpleDateFormat("HH:mm a").format(endSpinner.getValue());

			DateAndTime timeChosen = new DateAndTime(dateChosen, startTimeChosen, endTimeChosen);
			
			Guest newGuest = new Guest();
			newGuest.setName(name);
			newGuest.setPhone(phoneNumber);
			newGuest.setBirthdayMonth(birthMonth);
			newGuest.setBirthdayDay(birthDay);
			newGuest.setBirthdayYear(birthYear);
			newGuest.setEmail(emailInput);
			newGuest.setAddress(address);
			newGuest.setNameOnCreditCard(nameOnCard);
			newGuest.setCreditCard(numberOnCard);
			newGuest.setSecurity(security);
			newGuest.setCardExperation(cardExpiration);
			newGuest.setCreditType(cardType);
			newGuest.setContactPhone(contactByPhone);
			newGuest.setContactEmail(contactByEmail);
			
			int testingYear = Integer.parseInt(birthYear);
			if (roomType == "Karaoke Lounge" && testingYear > 1998) {
				AdultFrame a = new AdultFrame();
				NewReservationFrame.this.dispose();
				a.setVisible(true);
			}
			else {
				if (calendar.isRoomAvailable(roomType, timeChosen) == false) {
					waitlistFrame w = new waitlistFrame(roomType, dateChosen, startTimeChosen, endTimeChosen, calendar);
					NewReservationFrame.this.dispose();
					w.setVisible(true);
				} else {
					// create new reservation object
//					ConfirmationFrame c = new ConfirmationFrame(finalizedReservation);
//					NewReservationFrame.this.dispose();
//					c.setVisible(true);
				}
			}
		}	
	}
}
