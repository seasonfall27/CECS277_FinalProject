
public abstract class Pizza {

	protected String description = "Unknown";
	
	
	public void setDescription (String data) {
		this.description = data;
	}
	public String getDescription () {
		return description;
	}
	
	public String toString() {
		return description;
	}
}
