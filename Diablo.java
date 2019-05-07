package Wings;

public class Diablo extends Toppings{
Wings wing;
	
	public Diablo (Wings wing)
	{
		this.wing = wing;
	}
	
	
	
	public String getDescription() {
		
		return wing.getDescription() + ", Diablo";
	}

}
