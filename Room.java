import java.util.ArrayList;

public interface Room {
	
	ArrayList<Reservation> getReservations();
	
	ArrayList<Guest> getWaitlist();
	
	void addReservation(Reservation r);
	
	void addGuestToWaitlist(Guest g);
	
	String toString();
	
	void rentRoom(DateAndTime time);
	
	void upgradeAll(Upgrades upgrade);
	
	void upgradeMealPlan(String meal);
	
	void buyPartyFavors(int num);
	
	void rentProjector(int hours);
	
	void partyDecorations(boolean partyDecor);
	
	void rentTowels(int towels);
	
	void addMealPlan(String meal);
	
	String getDescription();
	
	int getCapacity();
	
	double getTotalHours();
	
	boolean getPartyDecorations();
	
	int getNumOfPartyFavors();
	
	int getNumOfProjectorHours();
	
	BasicMealPlan getMealPlan();
	
	double getCost();
	
	int getPricePerHour();
	
	int getNumOfTowelRentals();
	
	int getRoomNumber();
	
	String getType();
	
	void setTotalHours(double hours);
	
	void setPartyDecorations(boolean p);
	
	void setNumOfPartyFavors(int num);
	
	void setNumOfProjectorHours(int hours);
	
	void setMealPlan(String mealPlan);
	
	void setCost(double cost);
	
	void setNumOfTowelRentals(int towels);
	
	void reset();
	
	String displayRoomInfo();
	
	
	// Static counter to count the rooms (DONE)
	// date, time (related to scheduling class) (DONE)
	// convert start and end DateAndTime objects return time difference to calculate for cost (DONE)
	// Add room number (DONE)
	// Change how cost is determined based on DateAndTime objects (DONE)
	// Reset method (DONE)
	// Description and specifics (description and toString respectively) (DONE)
	// Fix aqua room pricing (DONE)
	// Fix Reservation permanent ID Situation (DONE)
	// Change everything about Time (DONE)
	// change description to static (DONE BY AUTUMN)
	// Write CheckIn Class (DONE)
	// Move times to the dateandtime class??? or move dateand (DONE)
	
	// Wait list thing (DONEISH)
	// Add broken cost (DONE???)
	
	// Fix Reservation ID
	// Fix Remove Reservation, its removing the wrong one
	// Fix isRoomAvailable()
	// Limit time by hours of operation and cleaning
	
	
	
}
