import java.util.ArrayList;

public class mealTester {

	public static void main(String[] arg) {
		
		Pizza pizza = new PlainPizza(); //This line creates a new Plain Pizza
		//System.out.println(pizza.getDescription()); // Output: XL Plain Pizza
		pizza = new BellPepper(pizza); //The rest of these line add toppings to the pizza
		pizza= new Cheese (pizza);
		pizza = new GarlicChicken(pizza);	
		pizza = new Ham(pizza);	
		pizza = new Jalapeno(pizza);	
		pizza = new Mushroom(pizza);
		pizza = new Onion(pizza);
		pizza = new Pepperoni(pizza);
		pizza = new Pineapple(pizza);
		pizza = new Sausage(pizza);
		
		System.out.println("Pizza #1" + pizza.getDescription()); // Output: Pizza #1XL Plain Pizza, Bell Pepper, Cheese, Garlic Chicken, Ham, Jalapeno, Mushroom, Onion, Pepperoni, Pineapple, Sausage
		Pizza pizza2 = new PlainPizza(); //This line creates a new Plain Pizza
		System.out.println("Pizza #2" + pizza2.getDescription()); // Output: Pizza #2XL Plain Pizza
		
		ArrayList<Pizza> pizzaList = new ArrayList<Pizza>(); //ArrayList with Pizza objects
		ArrayList<String> sodaList = new ArrayList<String>();
		ArrayList<String> iceCreamList = new ArrayList<String>();
		pizzaList.add(pizza);                        //Adds the pizza made earlier to the pizza list
		pizzaList.add(pizza2);
		//pizzaList.add(new PlainPizza());           //Adds a new plain Pizza Object. The array now has 2 items
		
		sodaList.add("soda1");
		sodaList.add("soda2");
		sodaList.add("soda3");
		iceCreamList.add("Ice Cream1");
		iceCreamList.add("Ice Cream2");
		iceCreamList.add("Ice Cream3");

		//System.out.println("It works");

		SilverMealPlan mySilverMeal = new SilverMealPlan(pizzaList, sodaList); //This makes a new SilverMealPlan object
		System.out.println("Printing the pizza 1 " + mySilverMeal.getPizza(1).getDescription()); //Output : Printing the pizza 1 XL Plain Pizza, Bell Pepper, Cheese, Garlic Chicken, Ham, Jalapeno, Mushroom, Onion, Pepperoni, Pineapple, Sausage
		System.out.println("Printing the pizza 2 " + mySilverMeal.getPizza(2).getDescription()); //Printing the pizza 2 XL Plain Pizza
		System.out.println(mySilverMeal.getAllPizzas()); //This prints out all the pizzas in the meal plan
		
		Pizza pizza3 = new PlainPizza(); //Makes a new plan pizza, pizza3
		pizza3 = new Mushroom(pizza3);    //Puts a mushroom toping on the pizza3
		System.out.println("here is the discription:" + pizza3.getDescription());
		
		mySilverMeal.setPizza(1, pizza3); //sets the first pizza int the array to pizza 3, the mushroom pizza
		System.out.println(mySilverMeal.getAllPizzas()); // should print all the pizzas with the first one being changed
		System.out.println("pizza #1 " + mySilverMeal.getPizza(1).getDescription()); //XL Plain Pizza, Mushroom
		System.out.println("pizza #2 " + mySilverMeal.getPizza(2).getDescription()); //XL Plain Pizza
		
		System.out.println(mySilverMeal.display());
	}
}
