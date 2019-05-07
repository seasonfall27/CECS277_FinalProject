package Wings;

public class Sesame extends Toppings{
	
Wings wing;
	
	public Sesame (Wings wing)
	{
		this.wing = wing;
	}
	
	
	@Override
	public String getDescription() {
		
		return wing.getDescription() + ", Sesame";
	}

}
