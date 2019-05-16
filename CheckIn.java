
public class CheckIn {

	private DateAndTime time;
	private Guest guest;
	private Room room;
	private int ID;

	public CheckIn(Room room, Guest guest, DateAndTime time, int ID) {
		this.time = time;
		this.guest = guest;
		this.room = room;
		this.ID = ID;
	}
	public void setGuest(Guest guest) {
		this.guest = guest;
	}
	public void setTime (DateAndTime time) {
		this.time = time;
	}
	public void setRoom (Room r) {
		this.room = r;
	}
	public void setID(int ID) {
		this.ID = ID;
	}
	public Guest getGuest() {
		return this.guest;
	}
	public DateAndTime getTime () {
		return this.time;
	}
	public Room getRoom () {
		return this.room;
	}
	public int getID() {
		return this.ID;
	}
	
	public String toString() {
		String s = "Check In #" + ID + "\n";
		s+= "Room: "+room.getType()+" Room\n";
		s+= "Guest Info: " + guest.toStringGuestInfo() +"\nCard Info: ";
		s += guest.toStringCardInfo() + "\nTime: ";
		s += time.toString();
		s += "\n" + room.getMealPlan() + "\n";
		return s;
	}
}
