import java.util.ArrayList;

public class Calendar {

	public ArrayList<Reservation> calendar;
	public ArrayList<CheckIn> checkedIn;
	
	public ArrayList<Room> small;
	public ArrayList<Room> medium;
	public ArrayList<Room> aqua;
	public ArrayList<Room> billiards;
	public ArrayList<Room> kareoke;
	
	/**
	 * Constructor for Calendar.  Will Create all Room objects necessary for the duration of the program
	 */
	public Calendar() {
		calendar = new ArrayList<Reservation>();
		checkedIn = new ArrayList<CheckIn>();
		
		small = new ArrayList<Room>();
		medium = new ArrayList<Room>();
		aqua = new ArrayList<Room>();
		billiards = new ArrayList<Room>();
		kareoke = new ArrayList<Room>();
		
		for(int i=0; i<10; i++) {
			small.add(RoomFactory.createRoom(RoomType.SMALL));
		}
		for(int i=0; i<30; i++) {
			medium.add(RoomFactory.createRoom(RoomType.MEDIUM));
		}
		aqua.add(RoomFactory.createRoom(RoomType.AQUA));
		for(int i=0; i<10; i++) {
			kareoke.add(RoomFactory.createRoom(RoomType.KAREOKE));
		}
		for(int i=0; i<5; i++) {
			billiards.add(RoomFactory.createRoom(RoomType.BILLIARDS));
		}
	}
	
	/**
	 * Checks to see if a desired room is available
	 * @param room - Room type wanting to see if it is open
	 * @return - true if available, false otherwise
	 */
	public boolean isRoomAvailable(String room, DateAndTime time) {
		switch (room) {
		case "Small":
			for(int i=0; i<small.size(); i++) {
				for(int j=0; j<small.get(i).getReservations().size(); i++) {
					if(time.compareTo(small.get(i).getReservations().get(j).getTime()) > 0) {
						return false;
					}
				}
			}
			break;
		case "Medium":
			for(int i=0; i<medium.size(); i++) {
				for(int j=0; j<medium.get(i).getReservations().size(); i++) {
					if(time.compareTo(medium.get(i).getReservations().get(j).getTime()) > 0) {
						return false;
					}
				}
			}
			break;
		case "Aqua":
			for(int i=0; i<aqua.size(); i++) {
				for(int j=0; j<aqua.get(i).getReservations().size(); i++) {
					if(time.compareTo(aqua.get(i).getReservations().get(j).getTime()) > 0) {
						return false;
					}
				}
			}
			break;
		case "Kareoke":
			for(int i=0; i<kareoke.size(); i++) {
				for(int j=0; j<kareoke.get(i).getReservations().size(); i++) {
					if(time.compareTo(kareoke.get(i).getReservations().get(j).getTime()) > 0) {
						return false;
					}
				}
			}
			break;
		case "Billiards":
			for(int i=0; i<billiards.size(); i++) {
				for(int j=0; j<billiards.get(i).getReservations().size(); i++) {
					if(time.compareTo(billiards.get(i).getReservations().get(j).getTime()) < 0) {
						return true;
					}
				}
			}
			break;
		default:
			break;
		}
		return true;
	}
	
	/**
	 * Adds a reservation if the time and room are both available
	 * @param room - the room wanted to be reserved
	 * @param start - the start time wanting to be reserved
	 * @param end - the end time of the time slot
	 */
	public void addReservation(String roomType, DateAndTime time /*, Customer customer*/, String meal, int partyFavors, int projectorHours, boolean partyDecorations, int towelRentals) {
		
		Upgrades u = new Upgrades(meal, partyFavors, projectorHours, partyDecorations, towelRentals);
		Reservation r = new Reservation(roomType, time, u);
		calendar.add(r);
		
		switch (roomType) {
		case "Small":
			for(int i=0; i<small.size(); i++) {
				for(int j=0; j<small.get(i).getReservations().size(); i++) {
					if(time.compareTo(small.get(i).getReservations().get(j).getTime()) < 0) {
						small.get(i).addReservation(r);
					}
				}
			}
			break;
		case "Medium":
			for(int i=0; i<medium.size(); i++) {
				for(int j=0; j<medium.get(i).getReservations().size(); i++) {
					if(time.compareTo(medium.get(i).getReservations().get(j).getTime()) < 0) {
						medium.get(i).addReservation(r);
					}
				}
			}
			break;
		case"Aqua":
			for(int i=0; i<aqua.size(); i++) {
				for(int j=0; j<aqua.get(i).getReservations().size(); i++) {
					if(time.compareTo(aqua.get(i).getReservations().get(j).getTime()) < 0) {
						aqua.get(i).addReservation(r);
					}
				}
			}
			break;
		case "Kareoke":
			for(int i=0; i<kareoke.size(); i++) {
				for(int j=0; j<kareoke.get(i).getReservations().size(); i++) {
					if(time.compareTo(kareoke.get(i).getReservations().get(j).getTime()) < 0) {
						kareoke.get(i).addReservation(r);
					}
				}
			}
			break;
		case "Billiards":
			for(int i=0; i<billiards.size(); i++) {
				for(int j=0; j<billiards.get(i).getReservations().size(); i++) {
					if(time.compareTo(billiards.get(i).getReservations().get(j).getTime()) < 0) {
						billiards.get(i).addReservation(r);
					}
				}
			}
			break;
		default:
			break;
		}
	}
	/**
	 * Calls a room by the enum type and the room number.  Will remove reservation and add room back to available rooms
	 * @param room - Room type wanting to remove from the calendar
	 * @param roomNum - 
	 */
	public void removeReservation(Reservation R) {
		for(int i=0; i<calendar.size(); i++) {
			if(calendar.get(i).getID() == R.getID()) {
				calendar.remove(i);
				String type = R.getRoomType();
				if(type.equals("Small")) {
					for(int w=0; w<small.get(i).getReservations().size(); w++) {
						if(small.get(i).getReservations().get(w).getTime().compareTo(R.getTime()) > 0) {
							small.get(i).getReservations().remove(w);
						}
					}
				}
				if(type.equals("Medium")) {
					for(int w=0; w<medium.get(i).getReservations().size(); w++) {
						if(medium.get(i).getReservations().get(w).getTime().compareTo(R.getTime()) > 0) {
							medium.get(i).getReservations().remove(w);
						}
					}
				}
				if(type.equals("Aqua")) {
					for(int w=0; w<aqua.get(i).getReservations().size(); w++) {
						if(aqua.get(i).getReservations().get(w).getTime().compareTo(R.getTime()) > 0) {
							aqua.get(i).getReservations().remove(w);
						}
					}
				}
				if(type.equals("Kareoke")) {
					for(int w=0; w<kareoke.get(i).getReservations().size(); w++) {
						if(kareoke.get(i).getReservations().get(w).getTime().compareTo(R.getTime()) > 0) {
							kareoke.get(i).getReservations().remove(w);
						}
					}
				}
				if(type.equals("Billiards")) {
					for(int w=0; w<billiards.get(i).getReservations().size(); w++) {
						if(billiards.get(i).getReservations().get(w).getTime().compareTo(R.getTime()) > 0) {
							billiards.get(i).getReservations().remove(w);
						}
					}
				}
			}
		}
	}
	/**
	 * Displays all Reservations and their information
	 * @return - String of all reservations
	 */
	public String displayAllReservations() {
		String s = "";
		for(int i=0; i<calendar.size(); i++) {
			s += calendar.get(i).toString();
			s += "\n";
		}
		return s;
	}
	
	public String displayAllCheckIns() {
		String s = "";
		for(int i=0; i<checkedIn.size(); i++) {
			s += checkedIn.get(i).toString();
			s += "\n";
		}
		return s;
	}
	/**
	 * Gets a specific reservation by ID number
	 * @param IDNum - Int num that matches a reservation
	 * @return - Reservation with that ID number 
	 */
	public Reservation getReservationByID(int IDNum) {
		for(int i=0; i<calendar.size(); i++) {
			if(calendar.get(i).getID()==IDNum) {
				return calendar.get(i);
			}
		}
		return null;
	}
	
	public void checkIn(Reservation r) {
		String type = r.getRoomType();
		CheckIn c = null;
		switch (type) {
		case "Small":
			c = new CheckIn(small.get(0), r.getTime(), r.getID(), r.upgrade);
			break;
		case "Medium":
			c = new CheckIn(medium.get(0), r.getTime(), r.getID(), r.upgrade);
			break;
		case "Aqua":
			c = new CheckIn(aqua.get(0), r.getTime(), r.getID(), r.upgrade);
			break;
		case "Kareoke":
			c = new CheckIn(kareoke.get(0), r.getTime(), r.getID(), r.upgrade);
			break;
		case "Billiards":
			c = new CheckIn(billiards.get(0), r.getTime(), r.getID(), r.upgrade);
			break;
		default:
			break;
		}
		checkedIn.add(c);
		removeReservation(r);
	}
	
	public void checkOut(CheckIn chin) {
		for(int i=0; i<checkedIn.size(); i++) {
			if(checkedIn.get(i).getID()==chin.getID()) {
				checkedIn.remove(i);
			}
		}
	}
	
	
	
}
