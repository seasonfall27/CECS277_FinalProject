
public class DateAndTime {

	private String date;
	private String start;
	private String end;
	private double timeVal;
	/**
	 * Empty Date and Time object
	 */
	public DateAndTime() {
		this.date = "00/00/00";
		this.start = "00:00 AM";
		this.end = "00:00 AM";
		this.timeVal = 0.0;
	}
	
	public DateAndTime(String date, String start, String end) {
		this.date = date;
		this.start = start;
		this.end = end;
		this.timeVal = calculateTimeValue(start, end);
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	public String getDate() {
		return this.date;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getStart() {
		return this.start;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getEnd() {
		return this.end;
	}
	public void setTimeVal(double timeVal) {
		this.timeVal = timeVal;
	}
	public double getTimeVal() {
		return this.timeVal;
	}
	/**
	 * Finds the time difference of two date and time objects
	 * @param start - start time
	 * @param end - end time
	 * @return - double representation of time difference
	 */
	public double calculateTimeValue(String start, String end) {
		char hour0A = start.charAt(0);
		char hour1A = start.charAt(1);
		String Hour1A = Character.toString(hour0A) + Character.toString(hour1A);
		char min0A = start.charAt(3);
		char min1A = start.charAt(4);
		String Min1A = Character.toString(min0A)+Character.toString(min1A);
		int hValA = Integer.parseInt(Hour1A);
		int mValA = Integer.parseInt(Min1A);
		double minsValA = (mValA/100)*1.3;
		
		char hour0B = end.charAt(0);
		char hour1B = end.charAt(1);
		String Hour1B = Character.toString(hour0B) + Character.toString(hour1B);
		char min0B = end.charAt(3);
		char min1B = end.charAt(4);
		String Min1B = Character.toString(min0B)+Character.toString(min1B);
		int hValB = Integer.parseInt(Hour1B);
		int mValB = Integer.parseInt(Min1B);
		double minsValB = (mValB/100)*1.3;
		
		double totalValueDifference = (hValB - hValA) + (minsValB - minsValA);
		return totalValueDifference;
	}
	
	public String getSetUpTime(double time) {
		String s = start;
		char h1 = s.charAt(0);
		char h2 = s.charAt(1);
		char m1 = s.charAt(3);
		char m2 = s.charAt(4);
		String hour = Character.toString(h1) + Character.toString(h2);
		String minute = Character.toString(m1) + Character.toString(m2);
		int nh = Integer.parseInt(hour);
		int nm = Integer.parseInt(minute);
		if(time==1) {
			nh++;
		}
		if(time == 0.5) {
			if(nm >= 30) {
				nm -= 30;
				nh++;
			}
			else {
				nm += 30;
			}
		}
		if(time < 0.5) {
			if(nm >= 15) {
				nm -= 15;
				nh++;
			}
			else {
				nm += 15;
			}
		}
		
		String startTime = nh + ":" + nm;
		if(nm == 0) {
			startTime += 0 + start.substring(5, 8);
		}
		return startTime;
	}
	
	public String getCleanUpTime(double time) {
		String s = end;
		char h1 = s.charAt(0);
		char h2 = s.charAt(1);
		char m1 = s.charAt(3);
		char m2 = s.charAt(4);
		String hour = Character.toString(h1) + Character.toString(h2);
		String minute = Character.toString(m1) + Character.toString(m2);
		int nh = Integer.parseInt(hour);
		int nm = Integer.parseInt(minute);
		if(time==1) {
			nh--;
		}
		if(time == 0.5) {
			if(nm <= 30) {
				nm += 30;
				nh--;
			}
			else {
				nm -= 30;
			}
		}
		if(time < 0.5) {
			if(nm <= 15) {
				nm += 15;
				nh--;
			}
			else {
				nm -= 15;
			}
		}
		
		String endTime = nh + ":" + nm;
		if(nm == 0) {
			endTime += 0 + end.substring(5, 8);
		}
		return endTime;
	}
	
	/**
	 * Compares two DateAndTime objects.  If they are the same, greater than 1, else less than 1
	 * @param dt - the Data and Time object being compared
	 * @return - 1 if same, -1 if not the same
	 */
	public int compareTo(DateAndTime dt) {
		// this start Value
		char hour0A = this.start.charAt(0);
		char hour1A = this.start.charAt(1);
		String Hour1A = Character.toString(hour0A) + Character.toString(hour1A);
		char min0A = this.start.charAt(3);
		char min1A = this.start.charAt(4);
		String Min1A = Character.toString(min0A)+Character.toString(min1A);
		int hValA = Integer.parseInt(Hour1A);
		int mValA = Integer.parseInt(Min1A);
		double minsValA = (mValA/100)*1.3;
		double aVal = minsValA + hValA;
		// Other's (dt) start Value
		char hour0B = dt.getStart().charAt(0);
		char hour1B = dt.getStart().charAt(1);
		String Hour1B = Character.toString(hour0B) + Character.toString(hour1B);
		char min0B = dt.getStart().charAt(3);
		char min1B = dt.getStart().charAt(4);
		String Min1B = Character.toString(min0B)+Character.toString(min1B);
		int hValB = Integer.parseInt(Hour1B);
		int mValB = Integer.parseInt(Min1B);
		double minsValB = (mValB/100)*1.3;
		double bVal = minsValB + hValB;
		// this end Value
		char hour0C = this.end.charAt(0);
		char hour1C = this.end.charAt(1);
		String Hour1C = Character.toString(hour0C) + Character.toString(hour1C);
		char min0C = this.end.charAt(3);
		char min1C = this.end.charAt(4);
		String Min1C = Character.toString(min0C)+Character.toString(min1C);
		int hValC = Integer.parseInt(Hour1C);
		int mValC = Integer.parseInt(Min1C);
		double minsValC = (mValC/100)*1.3;
		double cVal = minsValC + hValC;
		
		if(this.date.equals(dt.getDate()) && this.start.equals(dt.getStart()) && this.end.equals(dt.getEnd())) {
			return 1;
		}
		// If Other's Start is after this start but before this end, there is overlap
		else if( bVal > aVal && bVal < cVal){
			return 1;
		}
		else {
			return -1;
		}
	}

	public String toString() {
		return "Date: "+ date + "\nStart Time: " + start + "\nEnd Time: " + end;
	}

}
