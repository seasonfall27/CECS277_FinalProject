import java.util.ArrayList;

public class PlatinumMealPlan extends GoldMealPlan{
	
	ArrayList<String> iceCream;
	
	PlatinumMealPlan(){
		ArrayList<Pizza> tempPizzaList = new ArrayList<Pizza>();
		ArrayList<String> tempSodaList  = new ArrayList<String>();
		
		for(int i = 0; i < 4; i++) {//makes 4 XL 4 topping pizzas
			tempPizzaList.add(new PlainPizza());
		}
		for(int i = 0; i < 5; i++) {//makes 4 XL 4 topping pizzas
			tempSodaList.add("2L Soda Bottle");
		}
		
		gourmetPizzaList = tempPizzaList;
		sodaBottles = tempSodaList;
		salad = "Salad";
		breadSticks = "Bread Sticks";
		chicken = new BoneInWings();
		iceCream.add("Generic Ice Cream");
		iceCream.add("Generic Ice Cream");
		cost = 150.00;
	}
	
	PlatinumMealPlan(ArrayList<Pizza> p, ArrayList<String> s, Wings c, ArrayList<String> I){
		
		gourmetPizzaList = p;
		sodaBottles = s;
		salad = "Salad";
		breadSticks = "Bread Sticks";
		chicken = c;
		iceCream = I;
		cost = 150.00;
	}
	
	//setters
	void setIceCream(ArrayList<String> I) {
		iceCream = I;
	}
	
	public double getCost() {
		return this.cost;
	}
	
	//getters
	ArrayList<String> getIceCream () {
		return iceCream;
	}
	
	public String toString() {
		return gourmetPizzaList.size() + "XL 4 Topping Gourmet Pizzas: " + gourmetPizzaList + ", " + sodaBottles.size() + " 2L Soda Bottles: " + sodaBottles + ", " + "" + salad + ", " + breadSticks + ", " + chicken + ", Ice Cream: " + iceCream +"\ncost: " + cost;
	}
	
	public String display() {
		String mealPlan = "Platinum Meal Plan:\n4 XL 4 Topping Gourmet Pizzas\n5 2L Soda Bottles\nSalad\n Bread-Sticks\nChoice of 2 chicken wing flavors\n(Mild Spicy, Lemon-Pepper, BBQ, Sesame, or Diablo)\nPick bone-in or boneless\n2 Flavors of Ice cream(Chocolate, Vanilla, Strawberry)\nCost: $150.00";
		return mealPlan;
	}
}
