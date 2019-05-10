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
	
	GoldMealPlan(ArrayList<Pizza> p, ArrayList<String> s, String c){
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
	
	public String display() {
		return "Gold Meal Plan:\n3 XL 3 Topping Gourmet Pizzas\n5 2L Soda Bottles\nSalad\nBread-sticks\nChoice of 2 chicken wing flavors (Spicy, mild, Lemon-pepper, BBQ, Sesame, or Diablo). Pick Bone-in or boneless\nCost: $120.00";
	}
	
}
