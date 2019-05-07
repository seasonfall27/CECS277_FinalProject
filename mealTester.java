import java.util.ArrayList;

public class mealTester {

	public static void main(String[] arg) {
		ArrayList<String> pizzaList = new ArrayList<String>();
		ArrayList<String> sodaList = new ArrayList<String>();
		ArrayList<String> iceCreamList = new ArrayList<String>();
		pizzaList.add("pizza1");
		pizzaList.add("pizza2");
		pizzaList.add("pizza3");
		sodaList.add("soda1");
		sodaList.add("soda2");
		sodaList.add("soda3");
		iceCreamList.add("Ice Cream1");
		iceCreamList.add("Ice Cream2");
		iceCreamList.add("Ice Cream3");

		System.out.println("It works");
		/*BasicMealPlan myBasicMeal = new BasicMealPlan(pizzaList, sodaList);
		System.out.println(myBasicMeal.getAllPizzas());
		myBasicMeal.setPizza(2, "HELLA BIG PIZZA");
		System.out.println(myBasicMeal.getPizza(2));
		System.out.println(myBasicMeal.getAllPizzas());
		
		
		System.out.println(myBasicMeal.getAllSodas());
		myBasicMeal.setSoda(3, "GROSS SODA");
		System.out.println(myBasicMeal.getSoda(3));
		System.out.println(myBasicMeal.getAllSodas());
		System.out.println(myBasicMeal);*/
		
		/*BronzeMealPlan myBronzeMeal = new BronzeMealPlan(pizzaList, sodaList, "Bread Sticks");
		System.out.println(myBronzeMeal.getAllPizzas());
		myBronzeMeal.setPizza(1, "HELLA BIG PIZZA");
		System.out.println(myBronzeMeal.getAllPizzas());
		System.out.println(myBronzeMeal.getPizza(1));
		System.out.println(myBronzeMeal.getPizza(2));
		System.out.println(myBronzeMeal.getChoice());
		myBronzeMeal.setChoice("Salad");
		System.out.println(myBronzeMeal.getChoice());
		System.out.println(myBronzeMeal);*/
		
		/*SilverMealPlan mySilverMeal = new SilverMealPlan(pizzaList, sodaList);
		System.out.println(mySilverMeal.getAllPizzas());
		mySilverMeal.setPizza(1, "HELLA BIG PIZZA");
		System.out.println(mySilverMeal.getAllPizzas());
		System.out.println(mySilverMeal.getPizza(1));
		System.out.println(mySilverMeal.getPizza(2));
		System.out.println(mySilverMeal.getAllSodas());
		mySilverMeal.setSoda(3, "GROSS SODA");
		System.out.println(mySilverMeal.getSoda(3));
		System.out.println(mySilverMeal.getAllSodas());
		System.out.println(mySilverMeal);*/
		
		PlatinumMealPlan mySilverMeal = new PlatinumMealPlan(pizzaList, sodaList, "Hella Chicken", iceCreamList);
		System.out.println(mySilverMeal.getAllPizzas());
		mySilverMeal.setPizza(1, "HELLA BIG PIZZA");
		System.out.println(mySilverMeal.getAllPizzas());
		System.out.println(mySilverMeal.getPizza(1));
		System.out.println(mySilverMeal.getPizza(2));
		System.out.println(mySilverMeal.getAllSodas());
		mySilverMeal.setSoda(3, "GROSS SODA");
		System.out.println(mySilverMeal.getSoda(3));
		System.out.println(mySilverMeal.getAllSodas());
		System.out.println(mySilverMeal.getChicken());
		mySilverMeal.setChicken("Naught chicken");
		System.out.println(mySilverMeal);
		
	}
}
