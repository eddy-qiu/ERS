import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener{
	JFrame GameFrame;
	PlayerPile players[];
	JLayeredPane centerPile;
	public GamePanel(int numPlayers) throws Exception{//remember that animations can be separate from some backend functionality
		//create gui
		GameFrame = new JFrame();
		GameFrame.setPreferredSize(new Dimension(720,720));
		GameFrame.setLayout(new GridLayout(3,3));
		centerPile = new JLayeredPane();
		centerPile.setPreferredSize(new Dimension(240,240));
		//lots of code to create the cardback images
		ImageIcon cardBack = new ImageIcon("cards/cardBack.png");
		ImageIcon rotatedCardBack = new ImageIcon("cards/cardBackSideways.png");
		Image image1 = cardBack.getImage();
		Image image2 = rotatedCardBack.getImage();
		Image newimg1 = image1.getScaledInstance(120, 160, java.awt.Image.SCALE_SMOOTH);  
		Image newimg2 = image1.getScaledInstance(160, 120, java.awt.Image.SCALE_SMOOTH);
		cardBack = new ImageIcon(newimg1);
		rotatedCardBack = new ImageIcon(newimg2);
		
		//start game
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
