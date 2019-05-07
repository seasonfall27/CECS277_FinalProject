import java.util.ArrayList;

public class GoldMealPlan extends SilverMealPlan{

	protected String chicken;
	
	GoldMealPlan(){
		super();
		salad = "Salad";
		breadSticks = "Bread Sticks";
		chicken = "Generic chicken stuff";
		cost = 120.00;
	}
	
	GoldMealPlan(ArrayList<String> p, ArrayList<String> s, String c){
		super(p,s);
		salad = "Salad";
		breadSticks = "Bread Sticks";
		chicken = c;
		cost = 120.00;
	}
	
	String getChicken() {
		return chicken;
	}
	
	void setChicken(String c) {
		chicken = c;
	}
	
	public String toString() {
		return gourmetPizzaList.size() + "XL 3 Topping Gourmet Pizzas: " + gourmetPizzaList + ", " + sodaBottles.size() + " 2L Soda Bottles: " + sodaBottles + ", " + "" + salad + ", " + breadSticks + ", " + chicken +"\ncost: " + cost;
	}
	
}
