
public class PartyRoomFactory{

	public static PartyRoom createPartyRoom(RoomType roomType) {
		PartyRoom pr = null;
		switch(roomType) {
		case SMALL:
			pr = new SmallPartyRoom();
			break;
		case MEDIUM:
			pr = new MediumPartyRoom();
			break;
		default:
			break;
		}
		return pr;
	}	
}
