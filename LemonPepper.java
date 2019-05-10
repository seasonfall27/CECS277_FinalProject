
public class LemonPepper extends WingsToppings{
Wings wing;
	
	public LemonPepper (Wings wing)
	{
		this.wing = wing;
	}
	
	

	public String getDescription() {
		
		return wing.getDescription() + ", Lemon Pepper";
	}

}
