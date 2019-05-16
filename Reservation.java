
public class Reservation {
	Room room;
	Guest guest;
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
		s+= "\tRoom: "+room.getType()+" Room\n";
		s+= "\tGuest Info: \n" + guest.toStringGuestInfo() +"\n\tCard Info: \n";
		s += guest.toStringCardInfo() + "\n\tMeal Plan: ";
		s += "\n" + room.getMealPlan() +"\n\tReserved For Guest:\n";
		s += time.toString() + "\n\tSet Up/ Clean Up Times:";
		if(room instanceof SmallPartyRoom) {
			s+="\nSet Up Time: " + time.getSetUpTime(0.5);
			s+="\nClean Up Time: " + time.getCleanUpTime(0.5);
		}
		if(room instanceof MediumPartyRoom) {
			s+="\nSet Up Time: " + time.getSetUpTime(1);
			s+="\nClean Up Time: " + time.getCleanUpTime(1);
		}
		if(room instanceof AquaRoom) {
			s+="\nSet Up Time: " + time.getSetUpTime(1);
			s+="\nClean Up Time: " + time.getCleanUpTime(1);
		}
		if(room instanceof Kareoke) {
			s+="\nSet Up Time: " + time.getSetUpTime(0.1);
			s+="\nClean Up Time: " + time.getCleanUpTime(0.1);
		}
		if(room instanceof Billiards) {
			s+="\nSet Up Time: " + time.getSetUpTime(0.1);
			s+="\nClean Up Time: " + time.getCleanUpTime(0.1);
		}
		s+="\n";
		return s;
	}
	
	
	
}