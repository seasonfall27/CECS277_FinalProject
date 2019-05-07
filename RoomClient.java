
public class RoomClient {

	public static void main(String[] args) {
		
		Room pm = RoomFactory.createRoom(RoomType.MEDIUM);
		((MediumPartyRoom) pm).rentRoom(2);
		((MediumPartyRoom) pm).upgradeMealPlan("Silver");
		((MediumPartyRoom) pm).rentProjector(6);
		System.out.println(pm);
		
		Room ps = RoomFactory.createRoom(RoomType.SMALL);
		((SmallPartyRoom) ps).rentRoom(3);
		((SmallPartyRoom) ps).PartyDecorations(true);
		((SmallPartyRoom) ps).buyPartyFavors(9);
		System.out.println(ps);
		
		Room b = RoomFactory.createRoom(RoomType.BILLIARDS);
		((Billiards) b).rentRoom(5);
		((Billiards) b).addMealPlan("Gold");
		System.out.println(b);
		 
		Room k = RoomFactory.createRoom(RoomType.KAREOKE);
		System.out.println(k);
		
		Room a = RoomFactory.createRoom(RoomType.AQUA);
		((AquaRoom) a).rentRoom(1);
		((AquaRoom) a).rentTowels(10);
		System.out.println(a);
		
	}

}
