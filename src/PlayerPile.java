import java.util.*;

public class PlayerPile extends Deck{
	ArrayList<Card> Cards = new ArrayList<Card>();
	public Card get(int index) {
		return Cards.get(index);
	}
	public void add(Card card) {
		Cards.add(card);
	}
	public void addToBack(Card card) {
		Cards.add(Cards.size()-1,card);
	}
	public Card remove(int index) {
		return Cards.remove(index);
	}
	public int length() {
		return Cards.size();
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
