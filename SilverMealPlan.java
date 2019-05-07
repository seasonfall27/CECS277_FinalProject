import java.util.ArrayList;

public class SilverMealPlan extends BronzeMealPlan{

	//protected ArrayList<String> gourmetPizzaList;
	//protected ArrayList<String> sodaBottles;
	//protected String breadSticks;
	//protected String salad;
	
	SilverMealPlan(){//Default constructor
		ArrayList<String> tempPizzaList = new ArrayList<String>();
		ArrayList<String> tempSodaList  = new ArrayList<String>();
		
		for (int i = 0; i < 3; i++) {
			tempPizzaList.add("XL 3 Topping Gourmet Pizza"); //will accept	pizza objects later
		
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
	
	SilverMealPlan(ArrayList<String> p, ArrayList<String> s){
		gourmetPizzaList = p;
		
		sodaBottles = s;
		
		breadSticks = "Bread Sticks";
		
		salad = "Salad";
		
		cost = 90.00;
	}
	
	//getBread
	//getSalad
}
