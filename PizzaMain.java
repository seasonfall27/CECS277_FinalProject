
public class PizzaMain {

	public static void main(String[] args) {
		Pizza pizza = new PlainPizza ();
		
		System.out.println(pizza.getDescription());
		
		pizza = new Cheese(pizza);
		
		System.out.println(pizza.getDescription());
		
		pizza= new Ham (pizza);
		
		System.out.println(pizza.getDescription());
	}

}
