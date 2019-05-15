
public class Ham  extends Toppings{

Pizza pizza;
	
	public Ham (Pizza pizza)
	{
		this.pizza = pizza;
	}
	
	

	public String getDescription() {
		
		return pizza.getDescription() + ", Ham";
	}
}
