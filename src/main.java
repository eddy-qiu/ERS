
public class main {
	public static void main(String[] args) {
		System.out.println("hello");
		System.out.println("hello");
		System.out.println("hi");
		FullDeck game = null;
		try {
			game = new FullDeck();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		game.shuffle();
	}
}
