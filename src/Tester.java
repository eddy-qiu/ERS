
public class Tester {
	public static void main(String[] args) throws Exception {
		FullDeck a  = new FullDeck();
		System.out.println(a.length());
		System.out.println(a.get(1).value);
		System.out.println(a.get(10).value);
		a.shuffle();
		System.out.println(a.get(1).value);
		
		CenterPile b = new CenterPile();
		System.out.println(b.isSlap());
		b.add(new Card(13));
		b.add(new Card(3));
		b.add(new Card(3));
		System.out.println(b.isSlap());
		b.add(new Card(2));
		System.out.println(b.isSlap());
		b.add(new Card(3));
		System.out.println(b.isSlap());
		b.add(new Card(13));
		b.add(new Card(12));
		System.out.println(b.isSlap());
		b.add(new Card(12));
		b.add(new Card(13));
		System.out.println(b.isSlap());
		System.out.println(b.faceSequence());
		System.out.println(b.faceSequence());
		System.out.println(b.faceSequence());
		System.out.println(b.faceSequence());
		System.out.println(b.faceSequence());
		System.out.println(b.faceSequence());
	}
	
}
