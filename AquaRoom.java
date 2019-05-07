public class AquaRoom implements Room{
	
	private final String description = "Olympic-sized pool with water slide, kiddie pool, and large jacuzzi.";
	private final int capacity = 75;
	private final int pricePerHour = 700;
	private final String restrictions = "To access water facilities, bathing suits must be worn at all time";
	
	private int totalHours;
	private String mealPlan;
	private int cost;
	private int numOfTowelRentals;
	private int numOfPartyFavors;
	private int numOfProjectorHours;
	private boolean partyDecorations;
	
	/*
	 * Empty Constructor for the Aqua Room
	 */
	public AquaRoom() {
		this.mealPlan = "Basic";
		this.totalHours = 0;
		this.cost = 0;
		this.numOfTowelRentals = 0;
		this.numOfPartyFavors = 0;
		this.numOfProjectorHours = 0;
		this.partyDecorations = false;
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
		
		this.mealPlan = "Basic";
		int mealPlanAdditionalCost = 0;
		if(mealPlan!="Basic") {
			if(mealPlan.equals("Bronze")) {
				mealPlanAdditionalCost = 10;
			}
			if(mealPlan.equals("Silver")) {
				mealPlanAdditionalCost = 25;
			}
			if(mealPlan.equals("Gold")) {
				mealPlanAdditionalCost = 55;
			}
			if(mealPlan.equals("Platinum")) {
				mealPlanAdditionalCost = 85;
			}
		}
		this.cost += mealPlanAdditionalCost;
		this.mealPlan = mealPlan;
		
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
	 * @param hours - number of hours the room will be rented
	 */
	public void rentRoom (int hours) {
		this.cost += hours*pricePerHour;
		this.totalHours += hours;
	}
	
	/**
	 * upgrades the meal plan. Adds to additional cost and changes meal plan
	 * @param meal - meal plan to be upgraded to
	 */
	public void upgradeMealPlan(String meal) {
		int mealPlanAdditionalCost = 0;
		if(meal!="Basic") {
			if(meal.equals("Bronze")) {
				mealPlanAdditionalCost = 5*10;
			}
			if(meal.equals("Silver")) {
				mealPlanAdditionalCost = 5*25;
			}
			if(meal.equals("Gold")) {
				mealPlanAdditionalCost = 5*55;
			}
			if(meal.equals("Platinum")) {
				mealPlanAdditionalCost = 5*85;
			}
		}
		this.cost += mealPlanAdditionalCost;
		this.mealPlan = meal;
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
	public void PartyDecorations(boolean partyDecor) {
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
		
	/**
	 * gets the fixed description of the Room
	 * @return - String of Description of the room
	 */
	public String getDescription() {
		return this.description;
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
	 * @return - int hours the room will be rented
	 */
	public int getTotalHours() {
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
	public String getMealPlan() {
		return this.mealPlan;
	}
	/**
	 * gets the additional cost applied to the room
	 * @return - int value of the additional cost
	 */
	public int getCost() {
		return this.cost;
	}
	/**
	 * gets the number of towels that will be rented
	 * @return - int number of towels to be rented
	 */
	public int getNumOfTowelRentals() {
		return this.numOfTowelRentals;
	}
	
	
	//~~~~~~ Setter Functions ~~~~~~~~~
	
	/**
	 * sets the number of hours the room will be rented
	 * @param hours - int hours the room will be rented
	 */
	public void setTotalHours(int hours) {
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
		this.mealPlan = mealPlan;
	}
	/**
	 * sets the additional cost
	 * @param cost - int value of the additional cost
	 */
	public void setCost(int cost) {
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
	public String toString() {
		return "Aqua Room\n"+description+"\nIn use for: "+totalHours+" hours\nMeal Plan: "+mealPlan+"\n\tTotal: $"+cost;
	}

}
