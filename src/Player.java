
abstract class Player {
	abstract String getMove();

	abstract String getMove(CenterPile pile, PlayerPile bot1Hand);

	abstract void getMove(Boolean playerTurn);
}
