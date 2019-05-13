import java.util.ArrayList;

public class BasicMealPlan {
	/**
	 * ArrayList of strings describing pizzas. Will later be filled with pizza objects
	 */
	protected ArrayList<Pizza> gourmetPizzaList;
	/**
	 * ArrayList of strings representing 2L Sodas
	 */
	protected ArrayList<String> sodaBottles;
	
	/**
	 * double representation of cost
	 */
	protected double cost;
	
	/**
	 * BasicMealPlan constructor
	 */
	public BasicMealPlan() {// creates a default basic meal
		gourmetPizzaList = new ArrayList<Pizza>();
		sodaBottles = new ArrayList<String>();
		
		//Pizza pizza = new PlainPizza();
		
		for (int i = 0; i < 3; i++) {//creates 3 pizzas
			gourmetPizzaList.add(new PlainPizza()); //will accept	pizza objects later
		}
		for (int i = 0; i < 3; i++) {//creats 3 sodas
			sodaBottles.add("2L Soda Bottle");
		}
		
		cost = 65.00;
	}
	
	/**
	 * Overloaded BasicMealPlan constructor
	 * @param p - array list of pizza objects
	 * @param s - array list of soda objects
	 */
	public BasicMealPlan(ArrayList<Pizza> p, ArrayList<String> s) {//takes in
		
		gourmetPizzaList = p;
		
		sodaBottles = s;
		
		cost = 65.00;
	}
	
	/**
	 * Returns an array list of the pizza objects
	 * @return gourmetPizzaList
	 */
	public ArrayList<Pizza> getAllPizzas(){
		return gourmetPizzaList;
	}
	
	/**
	 * Returns requested pizza
	 * @param n is the pizza 1 to however many pizzas there are
	 * @return
	 */
	public Pizza getPizza(int n){
		return gourmetPizzaList.get(n-1);
	}
	
	/**
	 * Sets a specific pizza to a new pizza. Used for editing
	 * @param n
	 * @param p
	 */
	public void setPizza(int n, Pizza p) {
		gourmetPizzaList.set(n-1, p);
	}
	
	public String getSoda(int n){
		return sodaBottles.get(n-1);
	}
	
	/**
	 * 
	 */
	public void setSoda(int n, String s) {
		sodaBottles.set(n-1, s);
	}
	
	/**
	 * Returns an array list of the soda bottle objects
	 * @return sodaBottles
	 */
	public ArrayList<String> getAllSodas(){
		return sodaBottles;
	}
	
	/**
	 * Returns a String representation of the items
	 * "Name, Sweetness, Size"
	 */
	@Override
	public String toString() {
		return gourmetPizzaList.size() + " 1 Topping Gourmet Pizzas: " + gourmetPizzaList + ", " + sodaBottles.size() + " 2L Soda Bottles: " + sodaBottles + "\ncost: " + cost;
	}
	
	public static String display() {
		String mealPlan = "Basic Meal Plan:\n3 XL 1 Topping Gourmet Pizzas\n3 2L Soda Bottles\nCost: $65.00";
		return mealPlan;
	}
	
}
