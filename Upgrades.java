
public class Upgrades {

	public String mealPlan;
	public int partyFavors;
	public int projectorHours;
	public boolean partyDecorations;
	public int towelRentals;
	
	public Upgrades() {
		this.mealPlan = "";
		this.partyFavors = 0;
		this.projectorHours = 0;
		this.partyDecorations = false;
		this.towelRentals = 0;
	}
	
	public Upgrades(String meal) {
		this.mealPlan = meal;
		this.partyFavors = 0;
		this.projectorHours = 0;
		this.partyDecorations = false;
		this.towelRentals = 0;
	}
	
	public Upgrades(String meal, int party, int projector, boolean decor) {
		mealPlan = meal;
		partyFavors = party;
		projectorHours = projector;
		partyDecorations = decor;
		this.towelRentals = 0;
	}
	
	public Upgrades(String meal, int party, int projector, boolean decor, int towels) {
		mealPlan = meal;
		partyFavors = party;
		projectorHours = projector;
		partyDecorations = decor;
		towelRentals = towels;
	}
	
	
}
