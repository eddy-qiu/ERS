
public class Card {
	int value;
	boolean face = false;
	Card(int assignedValue) throws Exception{
		if(assignedValue < 1 || assignedValue > 13) {
		throw new Exception("invalid card");
		}
		value = assignedValue;
		if(assignedValue > 10 || assignedValue == 1) {
			face = true;
		}
	}
	public int getValue() {
		return value;
	}
	public boolean isFace() {
		return face;
	}
}
