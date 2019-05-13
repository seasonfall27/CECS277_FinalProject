
public class Billiards implements Lounge {

	private final static String description = "Enclosed lounge with pool table\n"
			+ "Capacity: 10 people\n"
			+ "Cost: $35/hr\n"
			+ "Included in cost:\n "
			+ "        -Access to pool table and cues\n"
			+ "Upgrades available:\n"
			+ "        -Add a meal plan\n"
			+ "Restrictions:\n"
			+ "        -21+ only\n";
	private final int capacity = 10;
	private final int pricePerHour = 25;
	private final String restrictions = "21+ and over";
	
	private int totalHours;
	private String mealPlan;
	private int cost;
	
	
	public Billiards() {
		this.mealPlan = "";
		this.totalHours = 0;
		this.cost = 0;
	}
	
	public Billiards(int hours, String mealPlan) {
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


	public static String getDescription() {
		return description;
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
	public int getCost() {
		return this.cost;
	}

	@Override
	public String getMealPlan() {
		return this.mealPlan;
	}

	@Override
	public int getTotalHours() {
		return this.totalHours;
	}

	@Override
	public void setMealPlan(String meal) {
		this.mealPlan = meal;
	}

	@Override
	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public void setTotalHours(int hours) {
		this.totalHours = hours;
	}
	
	@Override
	public void rentRoom(int hours) {
		this.cost += hours*pricePerHour;
		this.totalHours += hours;
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
		return "Billiards Lounge\n"+description+"\nIn use for: "+totalHours+" hours\nMeal Plan: "+mealPlan+"\n\tTotal: $"+cost;
	}
}
