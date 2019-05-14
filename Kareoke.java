import java.util.ArrayList;

public class Kareoke implements Lounge {

	private final String description = "Enclosed lounge with kareoke machine.";
	private final int capacity = 10;
	private final int pricePerHour = 30;
	
	private double totalHours;
	private String mealPlan;
	private double cost;
	
	private static int ID = 0;
	private int roomNumber;
	
	public static ArrayList<Guest> waitlist;
	public ArrayList<Reservation> reservations;
	
	public Kareoke() {
		this.mealPlan = "";
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
		
		this.mealPlan = "";
		int mealPlanAdditionalCost = 0;
		if(mealPlan!="none") {
			if(mealPlan.equals("Basic")) {
				mealPlanAdditionalCost = 65;
			}
			if(mealPlan.equals("Bronze")) {
				mealPlanAdditionalCost = 75;
			}
			if(mealPlan.equals("Silver")) {
				mealPlanAdditionalCost = 90;
			}
			if(mealPlan.equals("Gold")) {
				mealPlanAdditionalCost = 120;
			}
			if(mealPlan.equals("platinum")) {
				mealPlanAdditionalCost = 150;
			}
		}
		this.cost += mealPlanAdditionalCost;
		this.mealPlan = mealPlan;
	}

	@Override
	public ArrayList<Reservation> getReservations(){
		return this.reservations;
	}

	@Override
	public String getDescription() {
		return this.description;
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
	public String getMealPlan() {
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
	public void setMealPlan(String meal) {
		this.mealPlan = meal;
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
		if(meal!="none") {
			if(meal.equals("Basic")) {
				mealPlanAdditionalCost = 65;
			}
			if(meal.equals("Bronze")) {
				mealPlanAdditionalCost = 75;
			}
			if(meal.equals("Silver")) {
				mealPlanAdditionalCost = 90;
			}
			if(meal.equals("Gold")) {
				mealPlanAdditionalCost = 120;
			}
			if(meal.equals("platinum")) {
				mealPlanAdditionalCost = 150;
			}
		}
		this.cost += mealPlanAdditionalCost;
		this.mealPlan = meal;
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
