
public class LoungeFactory{

	public static Lounge createLounge(RoomType LoungeType) {
		Lounge L = null;
		switch(LoungeType) {
		case KAREOKE:
			L = new Kareoke();
			break;
		case BILLIARDS:
			L = new Billiards();
			break;
		default:
			break;
		}
		return L;
	}
}
