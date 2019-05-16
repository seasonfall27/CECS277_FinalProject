
public class RoomClient {

	public static void main(String[] args) {
		
		Calendar c = new Calendar();
		// 1) String room Type
		// 2) DateAndTime object
		// 3) String meal Plan
		// 4) int party favors
		// 5) int projector hours
		// 6) boolean party decorations
		// 7) towel rentals
		
		DateAndTime d = new DateAndTime("19/12/1999","12:00 AM", "18:00 PM");
		DateAndTime b = new DateAndTime("19/12/2000","03:00 AM", "06:00 PM");
		
		Guest g = new Guest();
		Guest x = new Guest();
		x.setName("Jimmy");
		Guest y = new Guest();
		y.setName("Lauren");
		Guest z = new Guest();
		z.setName("Samantha");
		
		c.addReservation("Small", x, d, "Silver", 0, 0, false, 0);
		c.addReservation("Small", y, b, "Silver", 2, 1, true, 0);
		c.addReservation("Aqua", z, b, "Basic", 0, 0, false, 0);
		c.removeReservation(c.calendar.get(1));
		c.addReservation("Aqua", g, b, "Basic", 0, 0, false, 0);
		
		System.out.println("\nCalendar:\n");
		for(int i=0; i <c.calendar.size(); i++) {
			System.out.println(c.calendar.get(i).toString());
		}
		System.out.println("\n\n\n");
		
		c.checkIn(c.calendar.get(0));
		System.out.println("\nCheck Ins:\n");
		System.out.println(c.displayAllCheckIns());
		
		
		System.out.println("\n\nCalendar:\n");
		for(int i=0; i <c.calendar.size(); i++) {
			System.out.println(c.calendar.get(i).toString());
		}
		
		System.out.println("\n\nAqua Wait List:\n");
		for(int i=0; i <c.aquaWaitlist.size(); i++) {
			System.out.println(c.aquaWaitlist.get(i).toString());
		}
		
		
		/*for(int i=0; i<c.aqua.size(); i++) {
			System.out.println(c.aqua.get(i).toString());
		}
		DateAndTime d = new DateAndTime("19/12/1999","12:00 AM", "18:00 PM");
		Reservation r = new Reservation();
		r.setTime(d);
		c.addReservation("Aqua", d, "Basic", 0, 0, false, 0);
		c.aqua.get(0).addReservation(c.calendar.get(0));
		System.out.println("\nPersonal:\n");
		for(int i=0; i <c.small.get(0).getReservations().size(); i++) {
			System.out.println(c.small.get(0).getReservations().get(i).toString());
		}
		
		System.out.println("\nCalendar:\n");
		for(int i=0; i <c.calendar.size(); i++) {
			System.out.println(c.calendar.get(i).toString());
		}
		
		System.out.println("hi");
		
		
		
		
		
		/*c.addReservation("Medium", new DateAndTime("19/12/1999","12:00 AM", "19:00 PM"), "Basic", 0, 0, false, 0);
		
		c.addReservation("Small", new DateAndTime("19/12/1999","03:00 AM", "05:00 PM"), "Silver", 0, 0, false, 0);
		
		DateAndTime d = new DateAndTime("19/12/1999","12:00 AM", "18:00 PM");
		if(c.isRoomAvailable("Aqua", d)) {
			c.addReservation("Aqua", d, "Bronze", 0, 0, false, 1);
		}
		if(c.isRoomAvailable("Aqua", d)) {
			c.addReservation("Aqua", d, "Basic", 0, 0, false, 1);
		}
		if(c.isRoomAvailable("Aqua", d)) {
			c.addReservation("Aqua", d, "Basic", 0, 0, false, 1);
		}
		System.out.println("Pre Check In: \n");
		System.out.println(c.displayAllReservations());
		
		c.checkIn(c.calendar.get(1));
		System.out.println("\nPost Check In: \n");
		System.out.println(c.displayAllReservations());
		System.out.println("");
		System.out.println(c.displayAllCheckIns());*/
		
		
		
		/*System.out.println(c.small.get(0).displayRoomInfo());
		System.out.println(c.medium.get(0).displayRoomInfo());
		System.out.println(c.aqua.get(0).displayRoomInfo());
		System.out.println(c.karaoke.get(0).displayRoomInfo());
		System.out.println(c.billiards.get(0).displayRoomInfo());
		
		System.out.println("\n```````````````````````````````````````````\n\n\n\n\n`````````````````````````````````````\n");
		
		DateAndTime a = new DateAndTime("09/12/1999", "5:00", "9:00");
		c.addReservation(RoomType.SMALL, a);
		c.calendar.get(c.calendar.size()-1).room.upgradeMealPlan("Gold");
		System.out.println("");
		System.out.println(c.displayAllReservations());
		c.calendar.get(c.calendar.size()-1).room.reset();
		System.out.println(c.calendar.get(c.calendar.size()-1).room.displayRoomInfo());
		
		c.addReservation(RoomType.AQUA, s, e);
		c.calendar.get(c.calendar.size()-1).room.upgradeMealPlan("Silver");
		c.calendar.get(c.calendar.size()-1).room.rentTowels(8);
		c.calendar.get(c.calendar.size()-1).room.rentProjector(2);
		System.out.println("");
		System.out.println(c.displayAllReservations());
		
		c.addReservation(RoomType.MEDIUM, a, b);
		c.calendar.get(c.calendar.size()-1).room.upgradeMealPlan("PLATINUM");
		c.calendar.get(c.calendar.size()-1).room.rentProjector(3);
		System.out.println("");
		System.out.println(c.displayAllReservations());
		*/
		
		
		
	}

}
