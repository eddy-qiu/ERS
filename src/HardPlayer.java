import java.util.concurrent.TimeUnit;

public class HardPlayer extends Player{ 
//	general template for computer player, 
//	might make the easy player misslap sometimes
	public String getMove(CenterPile pile, PlayerPile myPile)
			throws InterruptedException {
		if(myPile.length() != 0 || myPile.length() > 0) {
			if(pile.isSlap()) {
				TimeUnit.MILLISECONDS.sleep(450);
				return "Slap";
			}
		}
		else {
			return null;
		}
		return null;
	}
	public String getMove(boolean playerTurn) 
			throws InterruptedException {
		TimeUnit.SECONDS.sleep(3/2);
		return "Play";
	}
	@Override
	String getMove() {
		// TODO Auto-generated method stub
		return null;
	}
}