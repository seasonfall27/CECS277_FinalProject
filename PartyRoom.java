
public interface PartyRoom extends Room{
	/**
	 * gets the fixed description of the Room
	 * @return - String of Description of the room
	 */
	String getDescription();
	/**
	 * gets the fixed capacity of the Room
	 * @return - int capacity
	 */
	int getCapacity();
	/**
	 * gets the total hours for the room to be rented
	 * @return - int hours the room will be rented
	 */
	int getTotalHours();
	/**
	 * gets the boolean value of whether party decorations are to be used or not
	 * @return - boolean value of the party decorations
	 */
	boolean getPartyDecorations();
	/**
	 * gets the number of party favors to be used in the room
	 * @return - int value of number of party favors
	 */
	int getNumOfPartyFavors();
	/**
	 * gets the number of hours the projector will be used
	 * @return - int number of hours the projector will be used
	 */
	int getNumOfProjectorHours();
	/**
	 * gets the string value of the meal plan
	 * @return - string meal plan
	 */
	String getMealPlan();
	/**
	 * gets the cost applied to the room
	 * @return - int value of the additional cost
	 */
	int getCost();
	/**
	 * gets the fixed price per hour of the room
	 * @return - price per hour of the room
	 */
	int getPricePerHour();
	/**
	 * Sets the number of hours the room will be used and price is adjusted accordingly
	 * @param hours - number of hours the room will be rented
	 */
	void rentRoom(int hours);
	/**
	 * upgrades the meal plan. Adds to additional cost and changes meal plan
	 * @param meal - meal plan to be upgraded to
	 */
	void upgradeMealPlan(String meal);
	/**
	 * Allows customer to buy party favors. Adds to additional cost and increments numOfPartyFavors
	 * @param num - number of party favors to be bought
	 */
	void buyPartyFavors(int num);
	/**
	 * Customer enters number of hours to use the projector and Adds to additional cost and
	 * updates the number of hours the projector will be used
	 * @param hours - number of hours the customer wants to use the projector
	 */
	void rentProjector(int hours);
	/**
	 * Customer can choose to add party decorations. Adds to additional cost and party decorations becomes true
	 * @param paryDecor - Boolean value of whether party decorations will be used or not
	 */
	void PartyDecorations(boolean paryDecor);
	/**
	 * sets the total hours the room will be rented
	 * @param hours - hours the room will be rented
	 */
	void setTotalHours(int hours);
	/**
	 * Set the boolean value for party decorations
	 * @param p - boolean value of party decorations
	 */
	void setPartyDecorations(boolean p);
	/**
	 * Sets the number of party favors to be used
	 * @param num - number of party favors to be used
	 */
	void setNumOfPartyFavors(int num);
	/**
	 * sets the number of projector hours
	 * @param hours - number of projector hours
	 */
	void setNumOfProjectorHours(int hours);
	/**
	 * sets the meal plan to be used
	 * @param mealPlan - String value of meal plan
	 */
	void setMealPlan(String mealPlan);
	/**
	 * sets the cost of the room
	 * @param cost - int value of the additional cost
	 */
	void setCost(int cost);
	/**
	 * to string of the party rooms
	 * @return - string representation of the rooms descriptions
	 */
	String toString();
	
}