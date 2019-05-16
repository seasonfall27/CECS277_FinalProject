import java.util.ArrayList;

public class ReservationCalendar {

	public ArrayList<Reservation> calendar;
	public ArrayList<CheckIn> checkedIn;
	
	public static ArrayList<Room> small;
	public static ArrayList<Room> medium;
	public static ArrayList<Room> aqua;
	public static ArrayList<Room> billiards;
	public static ArrayList<Room> kareoke;
	
	/**
	 * Constructor for Calendar.  Will Create all Room objects necessary for the duration of the program
	 */
	public ReservationCalendar() {
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
		case "Small Party Room":
			for(int i=0; i<small.size(); i++) {
				for(int j=0; j<small.get(i).getReservations().size(); i++) {
					if(time.compareTo(small.get(i).getReservations().get(j).getTime()) > 0) {
						return false;
					}
				}
			}
			break;
		case "Medium Party Room":
			for(int i=0; i<medium.size(); i++) {
				for(int j=0; j<medium.get(i).getReservations().size(); i++) {
					if(time.compareTo(medium.get(i).getReservations().get(j).getTime()) > 0) {
						return false;
					}
				}
			}
			break;
		case "Aqua Room":
			for(int i=0; i<aqua.size(); i++) {
				for(int j=0; j<aqua.get(i).getReservations().size(); i++) {
					if(time.compareTo(aqua.get(i).getReservations().get(j).getTime()) > 0) {
						return false;
					}
				}
			}
			break;
		case "Karaoke Lounge":
			for(int i=0; i<kareoke.size(); i++) {
				for(int j=0; j<kareoke.get(i).getReservations().size(); i++) {
					if(time.compareTo(kareoke.get(i).getReservations().get(j).getTime()) > 0) {
						return false;
					}
				}
			}
			break;
		case "Billiards Lounge":
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
	public void addReservation(String roomType, Guest guest,DateAndTime time /*, Customer customer*/, String meal, int partyFavors, int projectorHours, boolean partyDecorations, int towelRentals) {
		
		Upgrades u = new Upgrades(meal, partyFavors, projectorHours, partyDecorations, towelRentals);
		Reservation r = null;
		
		switch (roomType) {
		case "Small Party Room":
			for(int i=0; i<small.size(); i++) {
				if(small.get(i).getReservations().size() > 0) {
					for(int j=0; j<small.get(i).getReservations().size(); j++) {
						if(time.compareTo(small.get(i).getReservations().get(j).getTime()) < 0) {
							r = new Reservation(small.get(i), guest, time, u);  // makes reservation object with info input
							small.get(i).addReservation(r);         // Adds the reservation to the specific small room's reservation list
						}
					}
				}
				else {
					r = new Reservation(small.get(i), guest, time, u);  // makes reservation object with info input
					small.get(i).addReservation(r);         // Adds the reservation to the specific small room's reservation list
				}
			}
			break;
		case "Medium Party Room":
			for(int i=0; i<medium.size(); i++) {
				if(medium.get(i).getReservations().size() > 0) {
					for(int j=0; j<medium.get(i).getReservations().size(); j++) {
						if(time.compareTo(medium.get(i).getReservations().get(j).getTime()) < 0) {
							r = new Reservation(medium.get(i), guest, time, u);
							medium.get(i).addReservation(r);
						}
					}
				}
				else {
					r = new Reservation(medium.get(i), guest, time, u);
					medium.get(i).addReservation(r);
				}
			}
			break;
		case"Aqua Room":
			for(int i=0; i<aqua.size(); i++) {
				if(aqua.get(i).getReservations().size() > 0) {
					for(int j=0; j<aqua.get(i).getReservations().size(); j++) {
						if(time.compareTo(aqua.get(i).getReservations().get(j).getTime()) < 0) {
							r = new Reservation(aqua.get(i), guest, time, u);
							aqua.get(i).addReservation(r);
						}
					}
				}
				else {
					r = new Reservation(aqua.get(i), guest, time, u);
					aqua.get(i).addReservation(r);
				}
			}
			break;
		case "Karaoke Lounge":
			for(int i=0; i<kareoke.size(); i++) {
				if(kareoke.get(i).getReservations().size() > 0) {
					for(int j=0; j<kareoke.get(i).getReservations().size(); j++) {
						if(time.compareTo(kareoke.get(i).getReservations().get(j).getTime()) < 0) {
							r = new Reservation(kareoke.get(i), guest, time, u);
							kareoke.get(i).addReservation(r);
						}
					}
				}
				else {
					r = new Reservation(kareoke.get(i), guest, time, u);
					kareoke.get(i).addReservation(r);
				}
			}
			break;
		case "Billiards Lounge":
			for(int i=0; i<billiards.size(); i++) {
				if(billiards.get(i).getReservations().size() > 0) {
					for(int j=0; j<billiards.get(i).getReservations().size(); j++) {
						if(time.compareTo(billiards.get(i).getReservations().get(j).getTime()) < 0) {
							r = new Reservation(billiards.get(i), guest, time, u);
							billiards.get(i).addReservation(r);
						}
					}
				}
				else {
					r = new Reservation(billiards.get(i), guest, time, u);
					billiards.get(i).addReservation(r);
				}
			}
			break;
		default:
			break;
		}
		calendar.add(r);  // adds the reservation to the calendar
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
				String type = R.getRoom().getType();
				if(type.equals("Small Party Room")) {
					for(int w=0; w<small.get(i).getReservations().size(); w++) {
						if(small.get(i).getReservations().get(w).getTime().compareTo(R.getTime()) > 0) {
							small.get(i).getReservations().remove(w);
						}
					}
				}
				if(type.equals("Medium Party Room")) {
					for(int w=0; w<medium.get(i).getReservations().size(); w++) {
						if(medium.get(i).getReservations().get(w).getTime().compareTo(R.getTime()) > 0) {
							medium.get(i).getReservations().remove(w);
						}
					}
				}
				if(type.equals("Aqua Room")) {
					for(int w=0; w<aqua.get(i).getReservations().size(); w++) {
						if(aqua.get(i).getReservations().get(w).getTime().compareTo(R.getTime()) > 0) {
							aqua.get(i).getReservations().remove(w);
						}
					}
				}
				if(type.equals("Karaoke Lounge")) {
					for(int w=0; w<kareoke.get(i).getReservations().size(); w++) {
						if(kareoke.get(i).getReservations().get(w).getTime().compareTo(R.getTime()) > 0) {
							kareoke.get(i).getReservations().remove(w);
						}
					}
				}
				if(type.equals("Billiards Lounge")) {
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
		String type = r.getRoom().getType();
		CheckIn c = null;
		switch (type) {
		case "Small Party Room":
			c = new CheckIn(small.get(0), r.getGuest(), r.getTime(), r.getID());
			break;
		case "Medium Party Room":
			c = new CheckIn(medium.get(0), r.getGuest(), r.getTime(), r.getID());
			break;
		case "Aqua Room":
			c = new CheckIn(aqua.get(0), r.getGuest(), r.getTime(), r.getID());
			break;
		case "Karaoke Lounge":
			c = new CheckIn(kareoke.get(0), r.getGuest(), r.getTime(), r.getID());
			break;
		case "Billiards Lounge":
			c = new CheckIn(billiards.get(0), r.getGuest(), r.getTime(), r.getID());
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
