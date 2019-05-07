
public class MediumPartyRoom implements PartyRoom{

	private final String description = "Room with party tables and chairs, quick access to arcade.";
	private final int capacity = 45;
	private final int pricePerHour = 250;
	
	private int totalHours;
	private String mealPlan;
	private int cost;
	private int numOfPartyFavors;
	private int numOfProjectorHours;
	private boolean partyDecorations;
	
	/*
	 * Empty Constructor for the Medium Party Room
	 */
	public MediumPartyRoom() {
		this.mealPlan = "Basic";
		this.totalHours = 0;
		this.cost = 0;
		this.numOfPartyFavors = 0;
		this.numOfProjectorHours = 0;
		this.partyDecorations = false;
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
	public void rentRoom(int hours) {
		this.cost += hours*pricePerHour;
		this.totalHours += hours;
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
	public void PartyDecorations(boolean partyDecor) {
		this.partyDecorations = partyDecor;
		if(this.partyDecorations) {
			this.cost += 100;
		}
	}
		
	
	//~~~~~~ Getter Functions ~~~~~~~~~
	
	@Override
	public String getDescription() {
		return this.description;
	}
	@Override
	public int getCapacity() {
		return this.capacity;
	}
	@Override
	public int getTotalHours() {
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
	public int getCost() {
		return this.cost;
	}
	
	//~~~~~~ Setter Functions ~~~~~~~~~
	
	@Override
	public void setTotalHours(int hours) {
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
	public void setCost(int cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Medium Party Room\n"+getDescription()+"\nIn use for: "+getTotalHours()+" hours\nMeal Plan: "+getMealPlan()+"\n\tTotal: $"+getCost();
	}

}
