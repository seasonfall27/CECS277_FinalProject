

public class MildSpicy extends WingsToppings {

	Wings wing;
	
	public MildSpicy (Wings wing)
	{
		this.wing = wing;
	}
	
	
	@Override
	public String getDescription() {
		
		return wing.getDescription() + ", Mild Spicy";
	}
}
