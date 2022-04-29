import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener{
	JFrame GameFrame;
	JPanel mainPanel, rightCardPanel, leftCardPanel, topCardPanel, bottomCardPanel, centerPanel;
	JLabel topCard, leftCard, rightCard, bottomCard, empty1, empty2, empty3, empty4;
	
	PlayerPile players[];
	public GamePanel(int numPlayers) throws Exception{//remember that animations can be separate from some backend functionality
		
		ImageIcon cardBack = new ImageIcon("cards/cardBack.png");
		ImageIcon rotatedCardBack = new ImageIcon("cards/cardBackSideways.png");
		Image image1 = cardBack.getImage();
		Image image2 = rotatedCardBack.getImage();
		Image newimg1 = image1.getScaledInstance(120, 160, java.awt.Image.SCALE_SMOOTH);  
		Image newimg2 = image2.getScaledInstance(160, 120, java.awt.Image.SCALE_SMOOTH);
		cardBack = new ImageIcon(newimg1);
		rotatedCardBack = new ImageIcon(newimg2);
		topCard = new JLabel(cardBack);
		topCard.setAlignmentX(CENTER_ALIGNMENT);
		leftCard = new JLabel(rotatedCardBack);
		leftCard.setAlignmentX(CENTER_ALIGNMENT);
		rightCard = new JLabel(rotatedCardBack);
		rightCard.setAlignmentX(CENTER_ALIGNMENT);
		bottomCard = new JLabel(cardBack);
		bottomCard.setAlignmentX(CENTER_ALIGNMENT);
		//create gui
		GameFrame = new JFrame("Egyptian Rat Screw");
		GameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GameFrame.setPreferredSize(new Dimension(720,720));
		
		mainPanel = new JPanel();
		mainPanel.setBackground(Color.YELLOW);
		mainPanel.setLayout(new GridLayout(3,3,20,20));
		
		centerPanel = new JPanel();
		centerPanel.setBackground(Color.WHITE);
		
		rightCardPanel = new JPanel();
		rightCardPanel.setLayout(new BoxLayout(rightCardPanel, BoxLayout.Y_AXIS));
		rightCardPanel.add(rightCard);
		
		leftCardPanel = new JPanel();
		leftCardPanel.setLayout(new BoxLayout(leftCardPanel, BoxLayout.Y_AXIS));
		leftCardPanel.add(leftCard);

		topCardPanel = new JPanel();
		topCardPanel.setLayout(new BoxLayout(topCardPanel, BoxLayout.Y_AXIS));
		topCardPanel.add(topCard);
		
		bottomCardPanel = new JPanel();
		bottomCardPanel.setLayout(new BoxLayout(topCardPanel, BoxLayout.Y_AXIS));
		bottomCardPanel.add(bottomCard);
		
		empty1 = new JLabel("");
		empty2 = new JLabel("");
		empty3 = new JLabel("");
		empty3 = new JLabel("");
		
		mainPanel.add(empty1);
		mainPanel.add(topCardPanel);
		mainPanel.add(empty2);
		mainPanel.add(leftCardPanel);
		mainPanel.add(centerPanel);
		mainPanel.add(rightCardPanel);
		mainPanel.add(empty3);
		mainPanel.add(bottomCard);
		mainPanel.add(empty4);
		
		GameFrame.setContentPane(mainPanel);
		GameFrame.pack();
		GameFrame.setVisible(true);
		
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
