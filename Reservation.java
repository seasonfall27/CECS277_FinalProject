
public class Reservation {
	Room room;
	Guest guest;
	//Meal Plan object integrated into rooms
	DateAndTime time;
	private static int id = 0;
	private int ID;
	/**
	 * Empty constructor for the Reservation class
	 */
	public Reservation() {
		room = null;
		time = new DateAndTime();
		this.guest = new Guest();
		id++;
		ID = id;
	}
	/**
	 * Overloaded constructor for the Reservation class (STILL NEEDS CUSTOMER INFO)
	 * @param room - Type of Room object 
	 * @param start = DateAndTime object start
	 * @param end = DateAndTime object end
	 */
	public Reservation(Room roomType, Guest guest,DateAndTime time, Upgrades upgrade) {
		this.room = roomType;
		this.guest = guest;
		this.ID = id;
		this.room.upgradeAll(upgrade);
		this.time = time;
		this.room.rentRoom(time);
	}
	
	public void setGuest(Guest guest) {
		this.guest = guest;
	}
	public void setTime(DateAndTime time) {
		this.time = time;
	}
	public DateAndTime getTime() {
		return this.time;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public Room getRoom() {
		return this.room;
	}
	public Guest getGuest() {
		return this.guest;
	}
	public void setID(int id) {
		this.ID = id;
	}
	public int getID() {
		return this.ID;
	}
	/**
	 * To String of a reservation
	 */
	public String toString() {
		String s = "Reservation #" + this.getID()+"\n";
		s+= "Room: "+room.getType()+" Room\n";
		s+= "Guest Info: " + guest.toStringGuestInfo() +"\nCard Info: ";
		s += guest.toStringCardInfo() + "\nTime: ";
		s += time.toString();
		s += "\n\n" + room.getMealPlan();
		// Add Customer Info Here
		return s;
	}
	
	
	
}