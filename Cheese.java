

public class Cheese extends Toppings {

	Pizza pizza;
	
	public Cheese (Pizza pizza)
	{
		this.pizza = pizza;
	}
	
	
	@Override
	public String getDescription() {
		
		return pizza.getDescription() + ", Cheese";
	}

}
