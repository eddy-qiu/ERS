
abstract class Player {
	abstract String getMove();

	abstract String getMove(CenterPile pile, PlayerPile bot1Hand) throws InterruptedException;

	abstract String getMove(boolean playerTurn) throws InterruptedException;
}
