import java.util.ArrayList;

public class PlatinumMealPlan extends GoldMealPlan{
	
	ArrayList<String> iceCream;
	
	PlatinumMealPlan(){
		ArrayList<String> tempPizzaList = new ArrayList<String>();
		ArrayList<String> tempSodaList  = new ArrayList<String>();
		
		for(int i = 0; i < 4; i++) {//makes 4 XL 4 topping pizzas
			tempPizzaList.add("XL 4 Topping Gourmet Pizza");
		}
		for(int i = 0; i < 5; i++) {//makes 4 XL 4 topping pizzas
			tempSodaList.add("2L Soda Bottle");
		}
		
		gourmetPizzaList = tempPizzaList;
		sodaBottles = tempSodaList;
		salad = "Salad";
		breadSticks = "Bread Sticks";
		chicken = "Generic chicken stuff";
		iceCream.add("Generic Ice Cream");
		iceCream.add("Generic Ice Cream");
		cost = 150.00;
	}
	
	PlatinumMealPlan(ArrayList<String> p, ArrayList<String> s, String c, ArrayList<String> I){
		
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
	
	//getters
	ArrayList<String> getIceCream () {
		return iceCream;
	}
	
	public String toString() {
		return gourmetPizzaList.size() + "XL 4 Topping Gourmet Pizzas: " + gourmetPizzaList + ", " + sodaBottles.size() + " 2L Soda Bottles: " + sodaBottles + ", " + "" + salad + ", " + breadSticks + ", " + chicken + ", Ice Cream: " + iceCream +"\ncost: " + cost;
	}
}
