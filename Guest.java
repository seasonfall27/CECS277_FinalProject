public class Guest {

	String name = null;
	String phoneNumber = null;
	String birthday = null;
	String email = null;
	String address = null;
	String creditCard = null;
	String security = null;
	String cardExperation = null;
	String cardType = null;
	
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
	
	public void setBirthday (String date)
	{
		this.birthday = date;
	}
		
	public String getBirthay () {
		return birthday;
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
	
	public String toStringGuestInfo () {
		return "Guest Name: " + name + "\nGuest Address: " + address + "\nGuest Phone Number: " + phoneNumber 
				+ "\nGuest Birthday: " + birthday + "\nGuest Email: " + email;
	}
	
	public String toStringCardInfo () {
		return "Guest Name: " + name + "\nGuest Credit Card: " + creditCard + "\nCredit Security Code: " + security 
				+ "\nGuest Credit Experation Date: " + cardExperation + "\nCard Type: " + cardType ; 
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
}
