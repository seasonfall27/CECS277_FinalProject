package Wings;


public class MildSpicy extends Toppings {

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