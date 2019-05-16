
public class WaitlistedGuest {

	private Guest guest;
	private Upgrades upgrade;
	private DateAndTime time;
	
	public WaitlistedGuest(Guest guest, DateAndTime time, Upgrades upgrade){
		this.guest = guest;
		this.time = time;
		this.upgrade = upgrade;
	}
	
	public void setGuest(Guest guest) {
		this.guest = guest;
	}
	public void setTime(DateAndTime time) {
		this.time = time;
	}
	public void setUpgrades(Upgrades upgrade) {
		this.upgrade = upgrade;
	}
	public Guest getGuest() {
		return this.guest;
	}
	public DateAndTime getTime() {
		return this.time;
	}
	public Upgrades getUpgrades() {
		return this.upgrade;
	}
	
	public String toString() {
		return "Guest Info:\n"+guest.toStringGuestInfo()+"\nCard Info:\n"+guest.toStringCardInfo();
	}
}
