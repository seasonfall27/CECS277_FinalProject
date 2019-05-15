


public class WingsMain {
	
	public static void main(String[] args) {
		Wings wings = new BoneLess ();
		
		System.out.println(wings.getDescription());
		
		wings = new Diablo (wings);
		
		System.out.println(wings.getDescription());
		
		wings = new MildSpicy (wings);
		
		System.out.println(wings.getDescription());
		
		wings = new LemonPepper (wings);
		
		System.out.print(wings.getDescription());
		
		Wings wings2 = new BoneInWings ();
		
		System.out.println(wings2.getDescription());
		
		wings2 = new Sesame (wings2);
		
		System.out.println(wings2.getDescription());
		
		wings2 = new MildSpicy (wings2);
		
		System.out.println(wings2.getDescription());
		
		wings2 = new BBQ (wings2);
		
		System.out.print(wings.getDescription());
		
	}

}
