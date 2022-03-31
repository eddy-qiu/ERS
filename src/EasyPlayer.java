import java.util.concurrent.TimeUnit;

public class EasyPlayer { //general template for computer player, might make the easy player misslap sometimes
	public String getMove(CenterPile pile, PlayerPile myPile) throws InterruptedException {
		if(myPile.length() != 0 || myPile.length() > 0) {
			if(pile.isSlap()) {
				TimeUnit.SECONDS.sleep(1);
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
