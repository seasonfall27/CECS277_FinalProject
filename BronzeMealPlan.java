
import java.util.ArrayList;

public class BronzeMealPlan extends BasicMealPlan{

	/**
	 * Strings describing the salad object;
	 */
	protected String salad;
	/**
	 * Strings describing the breadStick object;
	 */
	protected String breadSticks;
	
	/**
	 * Default constructor for Bronze Meal Plan
	 */
	public BronzeMealPlan() {// creates a default basic meal
		ArrayList<Pizza> tempPizzaList = new ArrayList<Pizza>();
		ArrayList<String> tempSodaList  = new ArrayList<String>();
		
		for (int i = 0; i < 3; i++) {
			tempPizzaList.add(new PlainPizza()); //will accept	pizza objects later
		
		}
		
		for (int i = 0; i < 5; i++) {
			tempSodaList.add("2L Soda Bottle");
		}
		this.gourmetPizzaList = tempPizzaList;
		sodaBottles = tempSodaList;
		
		breadSticks = "Bread Sticks";
		
		salad = "No Salad";
		
		cost = 75.00;
	}
	
	/**
	 * Overloaded constructor for Bronze Meal Plan
	 */
	public BronzeMealPlan(ArrayList<Pizza> p, ArrayList<String> s, String choice) {// creates a default basic meal
		super(p,s);
		
		if(choice == "Bread Sticks") {
			breadSticks = choice;
			salad = "No Salad";
		}
		else if (choice == "Salad"){
			breadSticks = "No Bread Sticks";
			salad = choice;
		}
		
		cost = 75.00;
	}
	
	public String getBreadSticks() {
		return breadSticks;
	}
	
	public String getSalad() {
		return salad;
	}
	
	public void setChoice(String choice) {
		if (choice == "Salad") {
			salad =  choice;
			breadSticks = "No Bread Sticks";
		}
		else if (choice == "Bread Sticks") {
			salad =  "No Salad";
			breadSticks = "Bread Sticks";
		}
	}
	
	public String getChoice() {
		String choice = "none";
		if (salad == "Salad") {
			choice = salad;
		}
		else if (breadSticks == "Bread Sticks") {
			choice = breadSticks;
		}
		return choice;
	}
	
	public double getCost() {
		return this.cost;
	}
	
	@Override
	public String toString() {
		String pizzaDiscriptionList = "";
		for (int i = 0; i < gourmetPizzaList.size(); i++) {
			pizzaDiscriptionList = pizzaDiscriptionList + gourmetPizzaList.get(i).getDescription() + " ";
		}
		return gourmetPizzaList.size() + "XL 2 Topping Gourmet Pizzas: " + pizzaDiscriptionList + ", " + sodaBottles.size() + " 2L Soda Bottles: " + sodaBottles + " " + salad + " " + breadSticks + "\ncost: " + cost;
	}

	public static String display() {
		String mealPlan = "Bronze Meal Plan:\n3 XL 2 Topping Gourmet Pizzas\n5 2L Soda Bottles\nSalad or Bread-Sticks\nCost: $75.00";
		return mealPlan;
	}
	
}
