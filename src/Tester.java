
public class Tester {
	public static void main(String[] args) throws Exception {
		FullDeck a  = new FullDeck();
		System.out.println(a.length());
		System.out.println(a.get(1).value);
		System.out.println(a.get(10).value);
		a.shuffle();
		System.out.println(a.get(1).value);
	}
	
}
