package Food;

public class Pepperoni {

Pizza pizza;
	
	public Pepperoni (Pizza pizza)
	{
		this.pizza = pizza;
	}
	
	

	public String getDescription() {
		
		return pizza.getDescription() + ", Pepperoni";
	}
}
