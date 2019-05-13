public interface Lounge extends Room{
	/**
	 * gets the fixed description of the Room
	 * @return - String of Description of the room
	 */
	static void getDescription() {
		return;
	}
	/**
	 * gets the fixed capacity of the Room
	 * @return - int capacity
	 */
	public int getCapacity();
	/**
	 * gets the fixed price per hour of the room
	 * @return - price per hour of the room
	 */
	public int getPricePerHour();
	/**
	 * gets the of the room
	 * @return - int value of the additional cost
	 */
	public int getCost();
	
	public String getMealPlan();
	/**
	 * gets the total hours for the room to be rented
	 * @return - int hours the room will be rented
	 */
	public int getTotalHours();
	/**
	 * sets the meal plan to be used
	 * @param mealPlan - String value of meal plan
	 */
	public void setMealPlan(String meal);
	/**
	 * sets the cost of the room
	 * @param cost - int value of the additional cost
	 */
	public void setCost(int cost);
	/**
	 * sets the total hours the room will be rented
	 * @param hours - hours the room will be rented
	 */
	public void setTotalHours(int hours);
	/**
	 * Sets the number of hours the room will be used and price is adjusted accordingly
	 * @param hours - number of hours the room will be rented
	 */
	public void rentRoom(int hours);
	/**
	 * Adds a meal plan to the Lounge
	 * @param meal - Meal Plan Object to be added
	 */
	public void addMealPlan(String meal);
	/**
	 * to string of the Lounge
	 * @return - string representation of the Lounge's descriptions
	 */
	String toString();
	
}
