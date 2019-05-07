
public class RoomFactory {

	/**
	 * Defines how the client will be able to create whatever room object
	 * they want based in one method
	 * @param rt - enum option representing what room the client wants to make
	 * @return - Object representing a room object
	 */
	public static Room createRoom(RoomType rt) {
		Room room = null;
		switch (rt) {
		case MEDIUM:
			room = PartyRoomFactory.createPartyRoom(RoomType.MEDIUM);
			break;
		case SMALL:
			room = PartyRoomFactory.createPartyRoom(RoomType.SMALL);
			break;
		case AQUA:
			room = AquaRoomFactory.createAquaRoom();
			break;
		case KAREOKE:
			room = LoungeFactory.createLounge(RoomType.KAREOKE);
			break;
		case BILLIARDS:
			room = LoungeFactory.createLounge(RoomType.BILLIARDS);
			break;
			default:
				break;
		}
		return room;
	}
	
}
