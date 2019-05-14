
public class Reservation {
	String roomType;
	//Customer Info
	//Meal Plan object integrated into rooms
	DateAndTime time;
	Upgrades upgrade;
	private static int id = 0;
	private int ID;
	/**
	 * Empty constructor for the Reservation class
	 */
	public Reservation() {
		roomType = "";
		time = new DateAndTime();
		id++;
		ID = id;
	}
	/**
	 * Overloaded constructor for the Reservation class (STILL NEEDS CUSTOMER INFO)
	 * @param room - Type of Room object 
	 * @param start = DateAndTime object start
	 * @param end = DateAndTime object end
	 */
	public Reservation(String roomType, DateAndTime time, Upgrades upgrade) {
		this.roomType = roomType;
		this.time = time;
		this.upgrade = upgrade;
	}
	
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public void setTime(DateAndTime time) {
		this.time = time;
	}
	public String getRoomType() {
		return this.roomType;
	}
	public DateAndTime getTime() {
		return this.time;
	}
	public int getID() {
		return this.ID;
	}
	/**
	 * To String of a reservation
	 */
	public String toString() {
		String s = "Reservation #"+this.getID()+"\n"; 
		// Add Customer Info Here
		return s;
	}
	
	
	
}