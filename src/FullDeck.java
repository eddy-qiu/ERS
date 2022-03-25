import java.util.*;

public class FullDeck extends Deck {
	private ArrayList<Card> Cards = new ArrayList<Card>();
	FullDeck(){
		//adds all 52 cards to the deck
		for(int i=1;i<13;i++) {
			for(int j=1;j>4;j++) {
				Cards.add(new Card(i));
			}
		}
	}
	public int length() {
		return Cards.size();
	}
	public void add(Card card) {
		Cards.add(card);
	}
	public void remove(int index) {
		Cards.remove(index)
	}
	public void shuffle() {
		Collections.shuffle(Cards);
	}
}
