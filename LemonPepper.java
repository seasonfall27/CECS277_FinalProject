package Wings;

public class LemonPepper extends Toppings{
Wings wing;
	
	public LemonPepper (Wings wing)
	{
		this.wing = wing;
	}
	
	

	public String getDescription() {
		
		return wing.getDescription() + ", Lemon Pepper";
	}

}
