import java.util.ArrayList;

public class MediumPartyRoom implements PartyRoom{

	private final String description = "Room with party tables and chairs, quick access to arcade.";
	private final int capacity = 45;
	private final int pricePerHour = 250;
	
	private double totalHours;
	private String mealPlan;
	private double cost;
	private int numOfPartyFavors;
	private int numOfProjectorHours;
	private boolean partyDecorations;
	
	private static int ID = 0;
	private int roomNumber;
	
	public ArrayList<Reservation> reservations;
	public static ArrayList<Guest> waitlist;
	/*
	 * Empty Constructor for the Medium Party Room
	 */
	public MediumPartyRoom() {
		this.mealPlan = "Basic";
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
	 * Overloaded Constructor for the Medium Party Room
	 * 
	 * @param mealPlan - Meal Plan the Customer wants. Additional Price is calculated
	 * @param partyFavors - Number of Party Favors customer wants to add. Additional cost calculated
	 * @param projectorHours - Number of projector hours the customer wants. Additional cost calculated
	 * @param partyDecor - Whether the customer wants party decorations or not. Additional cost calculated
	 */
	public MediumPartyRoom(int hours, String mealPlan, int partyFavors, int projectorHours, boolean partyDecor) {
		this.cost += hours*pricePerHour;
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
		
		this.cost += 5*partyFavors;
		this.numOfPartyFavors = partyFavors;
		
		this.cost += 10*projectorHours;
		this.numOfProjectorHours = projectorHours;
		
		this.partyDecorations = partyDecor;
		if(this.partyDecorations) {
			this.cost += 100;
		}
	}
	
	//~~~~~~ Upgrade Functions ~~~~~~~~~	
	
	@Override
	public void rentRoom(DateAndTime time) {
		double timeDiff = time.getTimeVal();
		System.out.println(timeDiff);
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
				mealPlanAdditionalCost = 3*10;
			}
			if(meal.equals("Silver")) {
				mealPlanAdditionalCost = 3*25;
			}
			if(meal.equals("Gold")) {
				mealPlanAdditionalCost = 3*55;
			}
			if(meal.equals("Platinum")) {
				mealPlanAdditionalCost = 3*85;
			}
		}
		this.cost += mealPlanAdditionalCost;
		this.mealPlan = meal;
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
	public String getMealPlan() {
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
		return "Medium";
	}
	
	//~~~~~~ Setter Functions ~~~~~~~~~
	
	@Override
	public void addReservation(Reservation r) {
		this.reservations.add(r);
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
		this.mealPlan = mealPlan;
	}
	@Override
	public void setCost(double cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		String s = "Medium Party Room #"+this.roomNumber+"\nMeal Plan: "+this.getMealPlan()+"\nNumber Of Party Favors: "+this.getNumOfPartyFavors()
		+"\nNumber Of Projector Hours: "+this.getNumOfProjectorHours();
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
		setPartyDecorations(false);
	}
	@Override
	public String displayRoomInfo() {
		return "Medium Party Room\n\tDescription: "+description+"\n\tMax Capcity: "+capacity+"\n\tPrice Per Hour: $"+pricePerHour
				+"\n\tUpgrades Available: \n\t\t* Upgrade Meal Plan\n\t\t\t- Bronze (+$30)\n\t\t\t- Silver (+$75)"+
				"\n\t\t\t- Gold (+$165)\n\t\t\t- Platinum (+$255)" + "\n\t\t* Buy Party Favors: ($5 each)\n\t\t* Rent Projector: ($10 per hour)"
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
