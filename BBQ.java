

public class BBQ extends WingsToppings {
Wings wing;
	
	public BBQ (Wings wing)
	{
		this.wing = wing;
	}
	
	
	@Override
	public String getDescription() {
		
		return wing.getDescription() + ", BBQ";
	}

}
