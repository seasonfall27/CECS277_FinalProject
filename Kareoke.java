import java.util.ArrayList;

public class Kareoke implements Lounge {

	private final static String description = "Enclosed lounge with karaoke machine\n"
			+ "Capacity: 10 people\n"
			+ "Cost: $30/hr\n"
			+ "Included in cost:\n "
			+ "        -Access to karaoke\n"
			+ "Upgrades available:\n"
			+ "        -Add a meal plan\n";
	private final int capacity = 10;
	private final int pricePerHour = 30;
	
	private double totalHours;
	private BasicMealPlan mealPlan;
	private double cost;
	
	private static int ID = 0;
	private int roomNumber;
	
	private static ArrayList<Guest> waitlist;
	private ArrayList<Reservation> reservations;
	
	public Kareoke() {
		this.mealPlan = null;
		this.totalHours = 0.0;
		this.cost = 0.0;
		this.ID ++;
		this.roomNumber = ID;
		waitlist = new ArrayList<Guest>();
		reservations = new ArrayList<Reservation>();
	}
	
	public Kareoke(int hours, String mealPlan) {
		this.cost = hours*pricePerHour;
		this.totalHours = hours;
		
		this.mealPlan = null;
		int mealPlanAdditionalCost = 0;
		if(mealPlan!="None" || mealPlan !="none" || mealPlan!="") {
			if(mealPlan.equals("Basic")) {
				mealPlanAdditionalCost = 65;
				this.mealPlan = new BasicMealPlan();
			}
			if(mealPlan.equals("Bronze")) {
				mealPlanAdditionalCost = 75;
				this.mealPlan = new BronzeMealPlan();
			}
			if(mealPlan.equals("Silver")) {
				mealPlanAdditionalCost = 90;
				this.mealPlan = new SilverMealPlan();
			}
			if(mealPlan.equals("Gold")) {
				mealPlanAdditionalCost = 120;
				this.mealPlan = new GoldMealPlan();
			}
			if(mealPlan.equals("Platinum")) {
				mealPlanAdditionalCost = 150;
				this.mealPlan = new PlatinumMealPlan();
			}
		}
		this.cost += mealPlanAdditionalCost;
	}

	@Override
	public ArrayList<Reservation> getReservations(){
		return this.reservations;
	}
	public static String getDescription() {
		return description;
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
	public int getPricePerHour() {
		return this.pricePerHour;
	}

	@Override
	public double getCost() {
		return this.cost;
	}

	@Override
	public BasicMealPlan getMealPlan() {
		return this.mealPlan;
	}

	@Override
	public double getTotalHours() {
		return this.totalHours;
	}
	
	@Override
	public int getRoomNumber() {
		return this.roomNumber;
	}
	@Override
	public String getType() {
		return "Kareoke";
	}
	@Override
	public void addReservation(Reservation r) {
		this.reservations.add(r);
	}
	@Override
	public void addGuestToWaitlist(Guest g) {
		this.waitlist.add(g);
	}
	@Override
	public void setMealPlan(String meal) {
		switch (meal) {
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
	public void setTotalHours(double hours) {
		this.totalHours = hours;
	}
	
	@Override
	public void rentRoom(DateAndTime time) {
		double timeDiff = time.getTimeVal();
		this.cost += timeDiff*pricePerHour;
		this.totalHours += timeDiff;
		
	}
	
	@Override
	public void upgradeAll(Upgrades upgrade) {
		this.addMealPlan(upgrade.mealPlan);
	}

	@Override
	public void addMealPlan(String meal) {
		int mealPlanAdditionalCost = 0;
		if(meal!="None" || meal !="none" || meal!="") {
			if(meal.equals("Basic")) {
				mealPlanAdditionalCost = 65;
				this.mealPlan = new BasicMealPlan();
			}
			if(meal.equals("Bronze")) {
				mealPlanAdditionalCost = 75;
				this.mealPlan = new BronzeMealPlan();
			}
			if(meal.equals("Silver")) {
				mealPlanAdditionalCost = 90;
				this.mealPlan = new SilverMealPlan();
			}
			if(meal.equals("Gold")) {
				mealPlanAdditionalCost = 120;
				this.mealPlan = new GoldMealPlan();
			}
			if(meal.equals("Platinum")) {
				mealPlanAdditionalCost = 150;
				this.mealPlan = new PlatinumMealPlan();
			}
		}
		this.cost += mealPlanAdditionalCost;
	}
	@Override
	public String toString() {
		String s = "Kareoke Room #"+this.roomNumber+"\nMeal Plan: "+this.getMealPlan();
		s += "\n\tTotal: $"+this.getCost()+"\n";
		return s;
	}
	@Override
	public void reset() {
		setTotalHours(0);
		setCost(0);
		setMealPlan("");
	}
	@Override
	public String displayRoomInfo() {
		return "Kareoke Room\n\tDescription: "+description+"\n\tMax Capcity: "+capacity+"\n\tPrice Per Hour: $"+pricePerHour
				+"\n\tUpgrades Available: \n\t\t* Add Meal Plan\n\t\t- Basic (+$65)\n\t\t\t- Bronze (+$75)\n\t\t\t- Silver (+$90)"+
				"\n\t\t\t- Gold (+$120)\n\t\t\t- Platinum (+$150)";
	}
	
	
	
	
	
	
	
	
	
	
	@Override
	public void upgradeMealPlan(String meal) {}
	@Override
	public void buyPartyFavors(int num) {}
	@Override
	public void rentProjector(int hours) {}
	@Override
	public void partyDecorations(boolean partyDecor) {}
	@Override
	public void rentTowels(int towels) {}
	@Override
	public boolean getPartyDecorations() {return false;}
	@Override
	public int getNumOfPartyFavors() {return 0;}
	@Override
	public int getNumOfProjectorHours() {return 0;}
	@Override
	public int getNumOfTowelRentals() {return 0;}
	@Override
	public void setPartyDecorations(boolean p) {}
	@Override
	public void setNumOfPartyFavors(int num) {}
	@Override
	public void setNumOfProjectorHours(int hours) {}
	@Override
	public void setNumOfTowelRentals(int towels) {}

	
	
}
