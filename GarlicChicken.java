package Food;

public class GarlicChicken extends Toppings{
Pizza pizza;
	
	public GarlicChicken (Pizza pizza)
	{
		this.pizza = pizza;
	}
	
	

	public String getDescription() {
		
		return pizza.getDescription() + ", Garlic Chicken";
	}

}
