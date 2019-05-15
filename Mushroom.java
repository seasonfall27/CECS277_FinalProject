

public class Mushroom extends Toppings {
Pizza pizza;
	
	public Mushroom (Pizza pizza)
	{
		this.pizza = pizza;
	}
	
	

	public String getDescription() {
		
		return pizza.getDescription() + ", mushroom";
	}

}
