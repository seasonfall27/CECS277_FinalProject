package Food;

public class Pineapple extends Toppings {
Pizza pizza;
	
	public Pineapple (Pizza pizza)
	{
		this.pizza = pizza;
	}
	
	

	public String getDescription() {
		
		return pizza.getDescription() + ", Pineapple";
	}

}
