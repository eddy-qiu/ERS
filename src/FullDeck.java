import java.util.*;

public class FullDeck extends Deck {
	private ArrayList<Card> Cards = new ArrayList<Card>();
	FullDeck() throws Exception{
		//adds all 52 cards to the deck
		for(int i=1;i<14;i++) {
			for(int j=1;j<5;j++) {
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
	public Card remove(int index) {
		return Cards.remove(index);
	}
	public void shuffle() {
		Collections.shuffle(Cards);
	}
	@Override
	public Card get(int index) {
		return Cards.get(index);
	}
	@Override
	void add() {
		// TODO Auto-generated method stub
		
	}
	@Override
	void remove() {
		// TODO Auto-generated method stub
		
	}
}
