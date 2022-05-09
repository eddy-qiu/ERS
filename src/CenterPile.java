import java.util.*;

public class CenterPile extends Deck{
	ArrayList<Card> Cards = new ArrayList<Card>();
	private int faceRemaining = 0;
	private boolean sequenced = false;
	public Card get(int index) {
		return Cards.get(index);
	}
	public void add(Card card) {
		Cards.add(card);
	}
	public Card remove(int index) {
		return Cards.remove(index);
	}
	public boolean isSlap() {
		if(Cards.size()<2) {
			return false;
		}
		if(Cards.get(Cards.size()-1).getValue() == Cards.get(Cards.size()-2).getValue()) {
			return true;
		}
		if(Cards.get(Cards.size()-1).getValue() == Cards.get(Cards.size()-3).getValue()) {
			return true;
		}
		if((Cards.get(Cards.size()-1).getValue() == 12 && Cards.get(Cards.size()-2).getValue() == 13) || (Cards.get(Cards.size()-1).getValue() == 13 && Cards.get(Cards.size()-2).getValue() == 12)) {
			return true;
		}
		return false;
	}
	public int faceSequence() {
		if(faceRemaining != 0) {
			faceRemaining -= 1;
			return faceRemaining;
		}
		else if(sequenced == false) {
			if(Cards.get(Cards.size()-1).getValue() == 1) {
				faceRemaining = 4;
				sequenced = true;
				return 4;
			}
			if(Cards.get(Cards.size()-1).getValue() == 13) {
				faceRemaining = 3;
				sequenced = true;
				return 3;
			}
			if(Cards.get(Cards.size()-1).getValue() == 12) {
				faceRemaining = 2;
				sequenced = true;
				return 2;
			}
			if(Cards.get(Cards.size()-1).getValue() == 11) {
				faceRemaining = 1;
				sequenced = true;
				return 1;
			}
			faceRemaining = 0;
			return 0;
		}
		return 0;
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
