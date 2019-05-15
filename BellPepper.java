

public class BellPepper extends Toppings {
Pizza pizza;
	
	public BellPepper (Pizza pizza)
	{
		this.pizza = pizza;
	}
	
	

	public String getDescription() {
		
		return pizza.getDescription() + ", Bell Pepper";
	}

}
