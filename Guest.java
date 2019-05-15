public class Guest {

	String name = null;
	String phoneNumber = null;
	String birthdayMonth = null;
	String birthdayDay = null;
	String birthdayYear = null;
	String email = null;
	String address = null;
	String nameOnCreditCard = null;
	String creditCard = null;
	String security = null;
	String cardExperation = null;
	String cardType = null;
	boolean contactPhone;
	boolean contactEmail;
	
	public void setName (String name) 
	{
		this.name = name;
	}
	
	public String getName  () 
	{
		return name;
	}
	
	public void setPhone (String phone)
	{
		this.phoneNumber = phone;
	}
	
	public String getPhone () 
	{
		return phoneNumber;
	}
	
	public void setBirthdayMonth (String date)
	{
		this.birthdayMonth = date;
	}
		
	public String getBirthdayMonth () {
		return birthdayMonth;
	}
	
	public void setBirthdayDay (String date)
	{
		this.birthdayDay = date;
	}
		
	public String getBirthdayDay () {
		return birthdayDay;
	}
	
	public void setBirthdayYear (String date)
	{
		this.birthdayYear = date;
	}
		
	public String getBirthdayYear () {
		return birthdayYear;
	}
	
	public void setEmail (String email) {
		this.email = email;
	}
	public String getEmail () {
		return email;
	}
	public void setAddress (String address) {
		this.address = address;
	}
	public String getAddress () {
		return address;
	}
	
	public void setNameOnCreditCard (String card) {
		this.nameOnCreditCard = card;
	}
	
	public String getNameOnCreditCard () {
		return nameOnCreditCard;
	}
	
	public void setCreditCard (String card) {
		this.creditCard = card;
	}
	
	public String getCreditCard () {
		return creditCard;
	}
	public void setSecurity (String code)
	{
		this.security = code;
	}
	public String getSecurity () {
		return security;
	}
	public void setCardExperation (String experation) {
		this.cardExperation = experation;
	}
	public String getCardExperation () {
		return cardExperation ;
	}
	public void setCreditType (String type) {
		this.cardType = type;
		
	}
	public String getCreditType () {
		return cardType;
	}
	
	public void setContactPhone(boolean phone) {
		this.contactPhone = phone;
	}
	
	public void setContactEmail(boolean email) {
		this.contactEmail = email;
	}
	
	public String toStringGuestInfo () {
		return "Guest Name: " + name + "\nGuest Address: " + address + "\nGuest Phone Number: " + phoneNumber 
				+ "\nGuest Birthday: " + birthdayMonth + birthdayDay + birthdayYear + "\nGuest Email: " + email;
	}
	
	public String toStringCardInfo () {
		return "Guest Name: " + name + "\nGuest Credit Card: " + creditCard + "\nCredit Security Code: " + security 
				+ "\nGuest Credit Experation Date: " + cardExperation + "\nCard Type: " + cardType ; 
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
}
