
public class main {
	public static void main(String[] args) {
		System.out.println("hello");
		System.out.println("hello");
		System.out.println("hi");
		FullDeck gameDeck = null;
		try {
			gameDeck = new FullDeck();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gameDeck.shuffle();
		MenuScreen Game = new MenuScreen();
		
	}
}
