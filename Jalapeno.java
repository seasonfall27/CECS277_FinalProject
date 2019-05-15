
public class Jalapeno extends Toppings {
Pizza pizza;
	
	public Jalapeno (Pizza pizza)
	{
		this.pizza = pizza;
	}
	
	

	public String getDescription() {
		
		return pizza.getDescription() + ", Jalapeno";
	}

}
