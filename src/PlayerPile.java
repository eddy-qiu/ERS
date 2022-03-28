import java.until.*;

public class PlayerPile extends Deck{
	ArrayList<Card> Cards = new ArrayList<Card>;
	public Card get(int index) {
		Cards.get(index);
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
}
