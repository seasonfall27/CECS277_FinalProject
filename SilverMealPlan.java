import java.util.ArrayList;

public class SilverMealPlan extends BronzeMealPlan{

	//protected ArrayList<String> gourmetPizzaList;
	//protected ArrayList<String> sodaBottles;
	//protected String breadSticks;
	//protected String salad;
	
	SilverMealPlan(){//Default constructor
		ArrayList<Pizza> tempPizzaList = new ArrayList<Pizza>();
		ArrayList<String> tempSodaList  = new ArrayList<String>();
		
		for (int i = 0; i < 3; i++) {
			tempPizzaList.add(new PlainPizza()); //will accept	pizza objects later
		
		}
		
		for (int i = 0; i < 5; i++) {
			tempSodaList.add("2L Soda Bottle");
		}
		gourmetPizzaList = tempPizzaList;
		sodaBottles = tempSodaList;
		
		breadSticks = "Bread Sticks";
		
		salad = "Salad";
		
		cost = 90.00;
	}
	
	public double getCost() {
		return this.cost;
	}
	
	SilverMealPlan(ArrayList<Pizza> p, ArrayList<String> s){
		gourmetPizzaList = p;
		
		sodaBottles = s;
		
		breadSticks = "Bread Sticks";
		
		salad = "Salad";
		
		cost = 90.00;
	}
	
	public String display() {
		String mealPlan = "Silver Meal Plan:\n3 XL 3 Topping Gourmet Pizzas\n5 2L Soda Bottles\nSalad\n Bread-Sticks\nCost: $90.00";
		return mealPlan;
	}
	
	//getBread
	//getSalad
}
