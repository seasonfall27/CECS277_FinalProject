
public class Onion extends Toppings{
	
Pizza pizza;
	
	public Onion (Pizza pizza)
	{
		this.pizza = pizza;
	}
	
	

	public String getDescription() {
		
		return pizza.getDescription() + ", Onion";
	}

}
