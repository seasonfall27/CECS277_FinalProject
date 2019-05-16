import java.util.ArrayList;

public class AquaRoom implements Room{
	
	final static String description = "Capacity: 75 people\nCost: $700/hr\n"
			+ "Included in cost: Access to showers/lockers\n        -life guards on duty\n        -DJ\n"
			+ "        -table & chair set-up\n        -Basic Meal Plan\nUpgrades Available: \n"
			+ "        -Upgrade meal plan     Cost: $5x(new meal plan cost - basic meal plan cost)\n"
			+ "        -Towel Rentals     Cost: $2 each\n"
			+ "        -Party favor bags     Cost: $5 per bag\n"
			+ "        -Projector     Cost: $10/hour\n"
			+ "        -Party decorations & set-up     Cost: $100\n"
			+ "                  Themes: Hawaiian, Sea Life, Jungle, Space, or Modern Theme";
	private final int capacity = 75;
	private final int pricePerHour = 700;
	private final String restrictions = "To access water facilities, bathing suits must be worn at all time";
	
	private double totalHours;
	private BasicMealPlan mealPlan;
	private double cost;
	private int numOfTowelRentals;
	private int numOfPartyFavors;
	private int numOfProjectorHours;
	private boolean partyDecorations;
	
	private static int ID = 0;
	private int roomNumber;
	
	private ArrayList<Reservation> reservations;
	
	/*
	 * Empty Constructor for the Aqua Room
	 */
	public AquaRoom() {
		this.mealPlan = new BasicMealPlan();
		this.totalHours = 0.0;
		this.cost = 0.0;
		this.numOfTowelRentals = 0;
		this.numOfPartyFavors = 0;
		this.numOfProjectorHours = 0;
		this.partyDecorations = false;
		this.ID ++;
		this.roomNumber = ID;
		reservations = new ArrayList<Reservation>();
	}
	
	/**
	 * Overloaded Constructor for the Aqua Room
	 * 
	 * @param mealPlan - Meal Plan the Customer wants. Additional Price is calculated
	 * @param towels - Number of towels that will be rented. Additional cost is calculated
	 * @param partyFavors - Number of Party Favors customer wants to add. Additional cost calculated
	 * @param projectorHours - Number of projector hours the customer wants. Additional cost calculated
	 * @param partyDecor - Whether the customer wants party decorations or not. Additional cost calculated
	 */
	public AquaRoom(int hours, String mealPlan, int towels, int partyFavors, int projectorHours, boolean partyDecor) {
		this.cost = hours*pricePerHour;
		this.totalHours = hours;
		
		this.mealPlan = new BasicMealPlan();
		int mealPlanAdditionalCost = 0;
		if(mealPlan!="Basic") {
			if(mealPlan.equals("Bronze")) {
				mealPlanAdditionalCost = 50;
				this.mealPlan = new BronzeMealPlan();
			}
			if(mealPlan.equals("Silver")) {
				mealPlanAdditionalCost = 125;
				this.mealPlan = new SilverMealPlan();
			}
			if(mealPlan.equals("Gold")) {
				mealPlanAdditionalCost = 275;
				this.mealPlan = new GoldMealPlan();
			}
			if(mealPlan.equals("Platinum")) {
				mealPlanAdditionalCost = 425;
				this.mealPlan = new PlatinumMealPlan();
			}
		}
		this.cost += mealPlanAdditionalCost;
		
		this.cost += 2*towels;
		this.numOfTowelRentals = towels;
		
		this.cost += 5*partyFavors;
		this.numOfPartyFavors = partyFavors;
		
		this.cost += 10*projectorHours;
		this.numOfProjectorHours = projectorHours;
		
		this.partyDecorations = partyDecor;
		if(this.partyDecorations) {
			this.cost += 100;
		}
	}
	
	
	//~~~~~~ Upgrades Functions ~~~~~~~~~
	
	/**
	 * Sets the number of hours the room will be used and price is adjusted accordingly
	 * @param DateAndTime - DateAndTime object for start time
	 * @param DateAndTime - DateAndTime object for end time
	 */
	@Override
	public void rentRoom(DateAndTime time) {
		double timeDiff = time.getTimeVal();
		this.cost += timeDiff*pricePerHour;
		this.totalHours += timeDiff;
		
	}
	
	@Override
	public void upgradeAll(Upgrades upgrade) {
		this.upgradeMealPlan(upgrade.mealPlan);
		this.buyPartyFavors(upgrade.partyFavors);
		this.rentProjector(upgrade.projectorHours);
		this.partyDecorations(upgrade.partyDecorations);
		this.rentTowels(upgrade.towelRentals);
	}
	
	/**
	 * upgrades the meal plan. Adds to additional cost and changes meal plan
	 * @param meal - meal plan to be upgraded to
	 */
	public void upgradeMealPlan(String meal) {
		int mealPlanAdditionalCost = 0;
		if(meal!="Basic") {
			if(meal.equals("Bronze")) {
				mealPlanAdditionalCost = 50;
				this.mealPlan = new BronzeMealPlan();
			}
			if(meal.equals("Silver")) {
				mealPlanAdditionalCost = 125;
				this.mealPlan = new SilverMealPlan();
			}
			if(meal.equals("Gold")) {
				mealPlanAdditionalCost = 275;
				this.mealPlan = new GoldMealPlan();
			}
			if(meal.equals("Platinum")) {
				mealPlanAdditionalCost = 425;
				this.mealPlan = new PlatinumMealPlan();
			}
		}
		this.cost += mealPlanAdditionalCost;
	}
	/**
	 * Allows customer to buy party favors. Adds to additional cost and increments numOfPartyFavors
	 * @param num - number of party favors to be bought
	 */
	public void buyPartyFavors(int num) {
		this.cost += 5*num;
		this.numOfPartyFavors += num;
	}
	/**
	 * Customer enters number of hours to use the projector and Adds to additional cost and
	 * updates the number of hours the projector will be used
	 * @param hours - number of hours the customer wants to use the projector
	 */
	public void rentProjector(int hours) {
		this.cost += 10*hours;
		this.numOfProjectorHours += hours;
	}
	/**
	 * Customer can choose to add party decorations. Adds to additional cost and party decorations becomes true
	 * @param paryDecor - Boolean value of whether party decorations will be used or not
	 */
	public void partyDecorations(boolean partyDecor) {
		this.partyDecorations = partyDecor;
		if(this.partyDecorations) {
			this.cost += 100;
		}
	}
	/**
	 * Number of towels wanted to be rented is set and additional cost is calculated
	 * @param towels - int number of towels to be rented
	 */
	public void rentTowels(int towels) {
		this.cost += 2*towels;
		this.numOfTowelRentals += towels;
	}
	
	
	//~~~~~~ Getter Functions ~~~~~~~~~
	
	@Override
	public ArrayList<Reservation> getReservations(){
		return this.reservations;
	}
	
	/**
	 * gets the fixed description of the Room
	 * @return - String of Description of the room
	 */
	public static String getDescription() {
		return description;
	}
	/**
	 * gets the restrictions of the aqua Room
	 * @return - String restrictions
	 */
	public String getRestrictions() {
		return this.restrictions;
	}
	/**
	 * gets the fixed capacity of the Room
	 * @return - int capacity
	 */
	public int getCapacity() {
		return this.capacity;
	}
	/**
	 * gets the fixed price per hour of the room
	 * @return - int price per hour of the room
	 */
	public int getPricePerHour() {
		return this.pricePerHour;
	}
	/**
	 * gets the number of hours the room will be rented
	 * @return - double hours the room will be rented
	 */
	public double getTotalHours() {
		return this.totalHours;
	}
	/**
	 * gets the boolean value of whether party decorations are to be used or not
	 * @return - boolean value of the party decorations
	 */
	public boolean getPartyDecorations() {
		return this.partyDecorations;
	}
	/**
	 * gets the number of party favors to be used in the room
	 * @return - int value of number of party favors
	 */
	public int getNumOfPartyFavors() {
		return this.numOfPartyFavors;
	}
	/**
	 * gets the number of hours the projector will be used
	 * @return - int number of hours the projector will be used
	 */
	public int getNumOfProjectorHours() {
		return this.numOfProjectorHours;
	}
	/**
	 * gets the string value of the meal plan
	 * @return - string meal plan
	 */
	public BasicMealPlan getMealPlan() {
		return this.mealPlan;
	}
	/**
	 * gets the additional cost applied to the room
	 * @return - double value of the additional cost
	 */
	public double getCost() {
		return this.cost;
	}
	/**
	 * gets the number of towels that will be rented
	 * @return - int number of towels to be rented
	 */
	public int getNumOfTowelRentals() {
		return this.numOfTowelRentals;
	}
	@Override
	public int getRoomNumber() {
		return this.roomNumber;
	}
	@Override
	public String getType() {
		return "Aqua";
	}
	
	
	//~~~~~~ Setter Functions ~~~~~~~~~
	@Override
	public void addReservation(Reservation r) {
		this.reservations.add(r);
	}
	/**
	 * sets the number of hours the room will be rented
	 * @param hours - double hours the room will be rented
	 */
	public void setTotalHours(double hours) {
		this.totalHours = hours;
	}
	/**
	 * Set the boolean value for party decorations
	 * @param p - boolean value of party decorations
	 */
	public void setPartyDecorations(boolean p) {
		this.partyDecorations = p;
	}
	/**
	 * Sets the number of party favors to be used
	 * @param num - number of party favors to be used
	 */
	public void setNumOfPartyFavors(int num) {
		this.numOfPartyFavors = num;
	}
	/**
	 * sets the number of projector hours
	 * @param hours - number of projector hours
	 */
	public void setNumOfProjectorHours(int hours) {
		this.numOfProjectorHours = hours;
	}
	/**
	 * sets the meal plan to be used
	 * @param mealPlan - String value of meal plan
	 */
	public void setMealPlan(String mealPlan) {
		switch (mealPlan) {
		case "Basic":
			this.mealPlan = new BasicMealPlan();
			break;
		case "Bronze":
			this.mealPlan = new BronzeMealPlan();
			break;
		case "Silver":
			this.mealPlan = new SilverMealPlan();
			break;
		case "Gold":
			this.mealPlan = new GoldMealPlan();
			break;
		case "Platinum":
			this.mealPlan = new PlatinumMealPlan();
			break;
		default:
			break;
		}
	}
	/**
	 * sets the additional cost
	 * @param cost - double value of the additional cost
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}
	/**
	 * sets the number of towels to be rented
	 * @param towels - int number of towels
	 */
	public void setNumOfTowelRentals(int towels) {
		this.numOfTowelRentals = towels;
	}
	/**
	 * To String for the Aqua Room
	 */
	@Override
	public String toString() {
		String s = "Aqua Room #"+this.roomNumber+"\nMeal Plan: "+this.getMealPlan()+"\nNumber Of Party Favors: "+this.getNumOfPartyFavors()
		+"\nNumber Of Projector Hours: "+this.getNumOfProjectorHours()+"\nNumber of Towel Rentals: "+this.getNumOfTowelRentals();
		if(partyDecorations) {
			s += "\n With Party Decorations\n";
		}
		s += "\tTotal: $"+this.getCost()+"\n";
		return s;
	}
	@Override
	public void reset() {
		setTotalHours(0);
		setCost(0);
		setMealPlan("Basic");
		setNumOfPartyFavors(0);
		setNumOfProjectorHours(0);
		setNumOfTowelRentals(0);
		setPartyDecorations(false);
	}
	@Override
	public String displayRoomInfo() {
		return "Aqua Room\n\tDescription: "+description+"\n\tRestrictions: "+restrictions+"\n\tMax Capcity: "+capacity+"\n\tPrice Per Hour: $"+pricePerHour
				+"\n\tUpgrades Available: \n\t\t* Upgrade Meal Plan\n\t\t\t- Bronze (+$30)\n\t\t\t- Silver (+$75)"+
				"\n\t\t\t- Gold (+$165)\n\t\t\t- Platinum (+$255)" + "\n\t\t* Buy Party Favors: ($5 each)\n\t\t* Rent Projector: ($10 per hour)"
				+"\n\t\t* Buy Party Decorations: ($100)\n\t\t* Rent Towels($2 each)";
	}
	
	
	
	

	
	
	
	
	@Override 
	public void addMealPlan(String meal) {}
}
