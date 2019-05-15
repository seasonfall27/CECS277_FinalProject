
public class CheckIn {

	private DateAndTime time;
	private Room room;
	private int ID;

	public CheckIn(Room room, DateAndTime time, int ID, Upgrades upgrade) {
		this.time = time;
		this.room = room;
		this.ID = ID;
		this.room.rentRoom(time);
		this.room.upgradeAll(upgrade);
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
		return "Check In #" + ID + "\n" + time.toString() + "\n" + room.toString();
	}
}
