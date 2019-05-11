
public class Diablo extends WingsToppings{
	Wings wing;
	
	public Diablo (Wings wing)
	{
		this.wing = wing;
	}
	
	
	
	public String getDescription() {
		
		return wing.getDescription() + ", Diablo";
	}

}
