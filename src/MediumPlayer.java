import java.util.concurrent.TimeUnit;
public class MediumPlayer extends Player{ //general template for computer player, might make the easy player misslap sometimes
	public String getMove(CenterPile pile, PlayerPile myPile) throws InterruptedException {
		if(myPile.length() != 0 || myPile.length() > 0) {
			if(pile.isSlap()) {
				TimeUnit.SECONDS.sleep(1);
				return "Slap";
			}
		}
		else {
			return null;
		}
		return null;
	}
	public void getMove(boolean playerTurn) throws InterruptedException {
		if(!playerTurn) {
			TimeUnit.SECONDS.sleep(3/2);
		}
	}
	@Override
	String getMove() {
		// TODO Auto-generated method stub
		return null;
	}
}