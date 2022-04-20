import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener{
	JFrame GameFrame;
	PlayerPile players[];
	JLayeredPane centerPile;
	public GamePanel() {
		GameFrame = new JFrame();
		GameFrame.setPreferredSize(new Dimension(720,720));
		GameFrame.setLayout(new GridLayout(3,3));
		centerPile = new JLayeredPane();
		centerPile.setPreferredSize(new Dimension(240,240));
		
		
	}
	public GamePanel(int numPlayers) throws Exception{//remember that animations can be separate from some backend functionality
		players = new PlayerPile[numPlayers+1];
		FullDeck allCards = new FullDeck(); //create 52 cards, shuffle them into respective number of player decks
		int cardsPerPlayer = 52/(numPlayers+1);
		allCards.shuffle();
		players[0] = new PlayerPile();
		for(int i=1;i<cardsPerPlayer+1;i++) {
			Card card = allCards.remove(0);
			players[0].add(card);
		}
		players[1] = new PlayerPile();
		for(int i=1;i<cardsPerPlayer+1;i++){
			Card card = allCards.remove(0);
			players[1].add(card);
		}
		if(numPlayers == 2) {
			players[2] = new PlayerPile();
			for(int i=1;i<cardsPerPlayer;i++){
				Card card = allCards.remove(0);
				players[2].add(card);
			}
			Card card = allCards.remove(0);
			players[0].add(card);
		}
		if(numPlayers == 3) {
			players[2] = new PlayerPile();
			for(int i=1;i<cardsPerPlayer;i++){
				Card card = allCards.remove(0);
				players[2].add(card);
			}
			players[3] = new PlayerPile();
			for(int i=1;i<cardsPerPlayer+1;i++){
				Card card = allCards.remove(0);
				players[3].add(card);
			}
		}
	}
	public void actionPerformed(ActionEvent e) {
		String eventName = e.getActionCommand();

	}

}
