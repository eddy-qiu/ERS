import java.util.*;

public class PlayerPile extends Deck{
	ArrayList<Card> Cards = new ArrayList<Card>();
	public Card get(int index) {
		return Cards.get(index);
	}
	public void add(Card card) {
		Cards.add(card);
	}
	public void remove(int index) {
		Cards.remove(index);
	}
	public int length() {
		return Cards.size();
	}
	public void add() {
		
	}
	@Override
	Card get() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	void remove() {
		// TODO Auto-generated method stub
		
	}
}
