

public class Sausage extends Toppings{
Pizza pizza;
	
	public Sausage (Pizza pizza)
	{
		this.pizza = pizza;
	}
	
	

	public String getDescription() {
		
		return pizza.getDescription() + ", Sausage";
	}

}
