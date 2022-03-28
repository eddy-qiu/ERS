import java.util.*;

public class CenterPile extends Deck{
	ArrayList<Card> Cards = new ArrayList<Card>;
	private int faceRemaining = 0;
	public Card get(int index) {
		Cards.get(index);
	}
	public void add(Card card) {
		Cards.add(card);
	}
	public void remove(int index) {
		Cards.remove(index);
	}
	public boolean isSlap() {
		if(Cards.get(Cards.size()).getValue() == Cards.get(Cards.size()-1).getValue()) {
			return true;
		}
		if(Cards.get(Cards.size()).getValue() == Cards.get(size()-2).getValue()) {
			return true;
		}
		if((Cards.get(Cards.size()).getValue() == 12 && Cards.get(Cards.size()-1).getValue == 13) || (Cards.get(Cards.size()).getValue() == 13 && Cards.get(Cards.size()-1).getValue == 12)) {
			return true;
		}
		return false;
	}
	public int faceSequence() {
		if(faceRemaining != 0) {
			faceRemaining -= 1;
			return faceRemaining + 1;
		}
		else {
			if(Cards.get(Cards.size()).getValue() == 1) {
				faceRemaining = 4;
				return 4;
			}
			if(Cards.get(Cards.size()).getValue() == 13) {
				faceRemaining = 3;
				return 3;
			}
			if(Cards.get(Cards.size()).getValue() == 12) {
				faceRemaining = 2;
				return 2;
			}
			if(Cards.get(Cards.size()).getValue() == 11) {
				faceRemaining = 1;
				return 1;
			}
			faceRemaining = 0;
			return 0;
		}
	}
}
