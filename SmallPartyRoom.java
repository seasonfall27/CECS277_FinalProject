import java.util.ArrayList;

public class SmallPartyRoom implements PartyRoom {
	private final static String description = "Capacity: 30 people\nCost: $150/hr\n"
			+ "Included in cost:\n        -Table & Chair set-up\n        -Basic Meal Plan\n"
			+ "Upgrades Available: \n"
			+ "        -Upgrade meal plan     Cost: $(new meal plan cost - basic meal plan cost)\n"
			+ "        -Party favor bags     Cost: $5 per bag\n"
			+ "        -Projector     Cost: $10/hour\n"
			+ "        -Party decorations & set-up     Cost: $100\n"
			+ "                  Themes: Hawaiian, Sea Life, Jungle, Space, or Modern Theme";
	private final int capacity = 30;
	private final int pricePerHour = 150;
	
	private double totalHours;
	private BasicMealPlan mealPlan;
	private double cost;
	private int numOfPartyFavors;
	private int numOfProjectorHours;
	private boolean partyDecorations;
	
	private static int ID = 0;
	private int roomNumber;
	
	private ArrayList<Reservation> reservations;
	private static ArrayList<Guest> waitlist;
	
	/*
	 * Empty Constructor for the Small Party Room
	 */
	public SmallPartyRoom() {
		this.mealPlan = new BasicMealPlan();
		this.totalHours = 0.0;
		this.cost = 0.0;
		this.numOfPartyFavors = 0;
		this.numOfProjectorHours = 0;
		this.partyDecorations = false;
		this.ID ++;
		this.roomNumber = ID;
		waitlist = new ArrayList<Guest>();
		reservations = new ArrayList<Reservation>();
	}
	
	/**
	 * Overloaded Constructor for the Small Party Room
	 * 
	 * @param mealPlan - Meal Plan the Customer wants. Additional Price is calculated
	 * @param partyFavors - Number of Party Favors customer wants to add. Additional cost calculated
	 * @param projectorHours - Number of projector hours the customer wants. Additional cost calculated
	 * @param partyDecor - Whether the customer wants party decorations or not. Additional cost calculated
	 */
	public SmallPartyRoom(int hours, String mealPlan, int partyFavors, int projectorHours, boolean partyDecor) {
		this.cost = hours*pricePerHour;
		this.totalHours = hours;
		
		this.mealPlan = new BasicMealPlan();
		int mealPlanAdditionalCost = 0;
		if(mealPlan!="Basic") {
			if(mealPlan.equals("Bronze")) {
				mealPlanAdditionalCost = 10;
				this.mealPlan = new BronzeMealPlan();
			}
			if(mealPlan.equals("Silver")) {
				mealPlanAdditionalCost = 25;
				this.mealPlan = new SilverMealPlan();
			}
			if(mealPlan.equals("Gold")) {
				mealPlanAdditionalCost = 55;
				this.mealPlan = new GoldMealPlan();
			}
			if(mealPlan.equals("Platinum")) {
				mealPlanAdditionalCost = 85;
				this.mealPlan = new PlatinumMealPlan();
			}
		}
		this.cost += mealPlanAdditionalCost;
		
		
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
	}

	@Override
	public void upgradeMealPlan(String meal) {
		int mealPlanAdditionalCost = 0;
		if(meal!="Basic") {
			if(meal.equals("Bronze")) {
				mealPlanAdditionalCost = 10;
				this.mealPlan = new BronzeMealPlan();
			}
			if(meal.equals("Silver")) {
				mealPlanAdditionalCost = 25;
				this.mealPlan = new SilverMealPlan();
			}
			if(meal.equals("Gold")) {
				mealPlanAdditionalCost = 55;
				this.mealPlan = new GoldMealPlan();
			}
			if(meal.equals("Platinum")) {
				mealPlanAdditionalCost = 85;
				this.mealPlan = new PlatinumMealPlan();
			}
		}
		this.cost += mealPlanAdditionalCost;
	}
	@Override
	public void buyPartyFavors(int num) {
		this.cost += 5*num;
		this.numOfPartyFavors += num;
	}
	@Override
	public void rentProjector(int hours) {
		this.cost += 10*hours;
		this.numOfProjectorHours += hours;
	}
	@Override
	public void partyDecorations(boolean partyDecor) {
		this.partyDecorations = partyDecor;
		if(this.partyDecorations) {
			this.cost += 100;
		}
	}
	
	
	//~~~~~~ Getter Functions ~~~~~~~~~
	
	public static String getDescription() {
		return description;
	}
	@Override
	public ArrayList<Reservation> getReservations(){
		return this.reservations;
	}
	@Override
	public ArrayList<Guest> getWaitlist(){
		return this.waitlist;
	}
	@Override
	public int getCapacity() {
		return this.capacity;
	}
	@Override
	public double getTotalHours() {
		return this.totalHours;
	}
	@Override
	public boolean getPartyDecorations() {
		return this.partyDecorations;
	}
	@Override
	public int getNumOfPartyFavors() {
		return this.numOfPartyFavors;
	}
	@Override
	public int getNumOfProjectorHours() {
		return this.numOfProjectorHours;
	}
	@Override
	public BasicMealPlan getMealPlan() {
		return this.mealPlan;
	}
	@Override
	public int getPricePerHour() {
		return this.pricePerHour;
	}
	@Override
	public double getCost() {
		return this.cost;
	}
	@Override
	public int getRoomNumber() {
		return this.roomNumber;
	}
	@Override
	public String getType() {
		return "Small";
	}
	
	//~~~~~~ Setter Functions ~~~~~~~~~
	
	@Override
	public void addReservation(Reservation r) {
		this.reservations.add(r);
	}
	
	@Override
	public void addGuestToWaitlist(Guest g) {
		this.waitlist.add(g);
	}
	
	@Override
	public void setTotalHours(double hours) {
		this.totalHours = hours;
	}
	@Override
	public void setPartyDecorations(boolean p) {
		this.partyDecorations = p;
	}
	@Override
	public void setNumOfPartyFavors(int num) {
		this.numOfPartyFavors = num;
	}
	@Override
	public void setNumOfProjectorHours(int hours) {
		this.numOfProjectorHours = hours;
	}
	@Override
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
	@Override
	public void setCost(double cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		String s = "Small Party Room #"+this.roomNumber+"\nMeal Plan: "+this.getMealPlan()+"\nNumber Of Party Favors: "+this.getNumOfPartyFavors()
		+"\nNumber Of Projector Hours: "+this.getNumOfProjectorHours();
		if(partyDecorations) {
			s += "\n With Party Decorations\n";
		}
		s += "\n\tTotal: $"+this.getCost()+"\n";
		return s;
	}
	@Override
	public void reset() {
		setTotalHours(0);
		setCost(0);
		setMealPlan("Basic");
		setNumOfPartyFavors(0);
		setNumOfProjectorHours(0);
		setPartyDecorations(false);
	}
	@Override
	public String displayRoomInfo() {
		return "Small Party Room\n\tDescription: "+description+"\n\tMax Capcity: "+capacity+"\n\tPrice Per Hour: $"+pricePerHour
				+"\n\tUpgrades Available: \n\t\t* Upgrade Meal Plan\n\t\t\t- Bronze (+$10)\n\t\t\t- Silver (+$25)"+
				"\n\t\t\t- Gold (+$55)\n\t\t\t- Platinum (+$85)" + "\n\t\t* Buy Party Favors: ($5 each)\n\t\t* Rent Projector: ($10 per hour)"
				+"\n\t\t* Buy Party Decorations: ($100)";
	}
	
	
	
	
	
	
	@Override
	public void rentTowels(int towels) {}
	@Override 
	public void addMealPlan(String meal) {}
	@Override
	public int getNumOfTowelRentals() {return 0;}
	@Override
	public void setNumOfTowelRentals(int towels) {}

}
