package Food;

public class Pepperoni extends Toppings{

Pizza pizza;
	
	public Pepperoni (Pizza pizza)
	{
		this.pizza = pizza;
	}
	
	

	public String getDescription() {
		
		return pizza.getDescription() + ", Pepperoni";
	}
}
