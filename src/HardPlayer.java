import java.util.concurrent.TimeUnit;

public class HardPlayer {
	public String getMove(CenterPile pile, PlayerPile myPile) throws InterruptedException {
		if(myPile.length() != 0 || myPile.length() > 0) {
			if(pile.isSlap()) {
				TimeUnit.MILLISECONDS.sleep(450);
				return "Slap";
			}
			else {
				TimeUnit.SECONDS.sleep(3/2);
				return "Play";
			}
		}
		else {
			return null;
		}
	}
}
