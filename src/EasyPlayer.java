
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

public class EasyPlayer extends Player{ 
//	general template for computer player, 
//	might make the easy player misslap sometimes
	public String getMove(CenterPile pile, PlayerPile myPile)
			throws InterruptedException {
		if(myPile.length() != 0 || myPile.length() > 0) {
			if(pile.isSlap()) {
				
				return "Slap";
			}
		}
		else {
			return null;
		}
		return null;
	}
	public String getMove(boolean playerTurn) throws
	InterruptedException {
		return "Play";
	}
	@Override
	String getMove() {
		// TODO Auto-generated method stub
		return null;
	}
}
