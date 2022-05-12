import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;


public class GamePanel extends JPanel implements ActionListener,MouseListener{
	JFrame GameFrame;
	JPanel mainPanel, rightCardPanel, leftCardPanel, topCardPanel, bottomCardPanel, centerPanel;
	JLabel topCard, leftCard, rightCard, bottomCard, empty1, empty2, empty3, empty4, topCardAmount,
	leftCardAmount,rightCardAmount,bottomCardAmount;
	Boolean playerTurn,slap,gameOver;
	CenterPile pile;
	PlayerPile players[],playerHand,bot1Hand,bot2Hand,bot3Hand;
	Player bot1Diff,bot2Diff,bot3Diff;
	int faceSequence;
	public GamePanel(String bot1,String bot2,String bot3,int numPlayers) throws Exception{//remember that animations can be separate from some backend functionality

		ImageIcon cardBack = new ImageIcon("cards/cardBack.png");
		ImageIcon rotatedCardBack = new ImageIcon("cards/cardBackSideways.png");
		Image image1 = cardBack.getImage();
		Image image2 = rotatedCardBack.getImage();
		Image newimg1 = image1.getScaledInstance(140, 180, java.awt.Image.SCALE_SMOOTH);  
		Image newimg2 = image2.getScaledInstance(180, 140, java.awt.Image.SCALE_SMOOTH);
		cardBack = new ImageIcon(newimg1);
		rotatedCardBack = new ImageIcon(newimg2);
		topCard = new JLabel(cardBack);
		leftCard = new JLabel(rotatedCardBack);
		rightCard = new JLabel(rotatedCardBack);
		bottomCard = new JLabel(cardBack);
		//create gui
		GameFrame = new JFrame("Egyptian Rat Screw");
		GameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GameFrame.setPreferredSize(new Dimension(720,720));

		mainPanel = new JPanel();
		mainPanel.setBackground(Color.YELLOW);
		mainPanel.setLayout(new GridLayout(3,3,10,35));

		centerPanel = new JPanel();
		centerPanel.setBackground(Color.WHITE);
		centerPanel.addMouseListener(this);

		rightCardPanel = new JPanel();
		rightCardPanel.setLayout(new GridLayout(1,1,0,0));
		rightCardPanel.add(rightCard);
		rightCardPanel.add();
		if(bot1.equals("None")) {
			rightCardPanel.setVisible(false);
		}

		leftCardPanel = new JPanel();
		leftCardPanel.setLayout(new GridLayout(1,1,0,0));
		leftCardPanel.add(leftCard);
		if(bot3.equals("None")) {
			leftCardPanel.setVisible(false);
		}

		topCardPanel = new JPanel();
		topCardPanel.setLayout(new GridLayout(1,1,0,0));
		topCardPanel.add(topCard);
		if(bot2.equals("None")) {
			topCardPanel.setVisible(false);
		}

		bottomCardPanel = new JPanel();
		bottomCardPanel.setLayout(new GridLayout(1,1,0,0));
		bottomCardPanel.add(bottomCard);
		bottomCardPanel.addMouseListener(this);

		empty1 = new JLabel("");
		empty2 = new JLabel("");
		empty3 = new JLabel("");
		empty4 = new JLabel("");

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
		int j = 0;
		playerHand = players[j];
		j++;
		if(!bot1.contentEquals("None") ) {
			bot1Hand = players[j];
			j++;
		}
		if(!bot2.contentEquals("None") ) {
			bot2Hand = players[j];
			j++;
		}
		if(!bot3.contentEquals("None") ) {
			bot3Hand = players[j];
			j++;
		}
		if(bot1.equals("easy")) { //set the difficulty for the bots
			bot1Diff = new EasyPlayer();
		}
		else if(bot1.equals("medium")) {
			bot1Diff = new MediumPlayer();
		}
		else if(bot1.equals("hard")) {
			bot1Diff = new HardPlayer();
		}
		if(bot2.equals("easy")) {
			bot2Diff = new EasyPlayer();
		}
		else if(bot2.equals("medium")) {
			bot2Diff = new MediumPlayer();
		}
		else if(bot2.equals("hard")) {
			bot2Diff = new HardPlayer();
		}
		if(bot3.equals("easy")) {
			bot3Diff = new EasyPlayer();
		}
		else if(bot3.equals("medium")) {
			bot3Diff = new MediumPlayer();
		}
		else if(bot3.equals("hard")) {
			bot3Diff = new HardPlayer();
		}
		if(!gameOver) {
			while(playerTurn) {
				//waits for playerTurn to turn false
			}
			if(!bot1.equals("None")) {
				boolean bot1Turn = true;
				while(bot1Turn) {
					bot1Diff.getMove(playerTurn);
					if(!playerTurn) {
						pile.add(bot1Hand.remove(0));
					}
					if(pile.get(pile.length()-1).isFace()) {
						faceSequence = pile.faceSequence();
						bot1Turn = false;
					}
					else if(faceSequence == 0) {
						bot1Turn = false;
					}
				}
			}
			if(!bot2.equals("None")) {
				boolean bot2Turn = true;
				while(bot2Turn) {
					bot2Diff.getMove(playerTurn);
					if(!playerTurn) {
						pile.add(bot2Hand.remove(0));
					}
					if(pile.get(pile.length()-1).isFace()) {
						faceSequence = pile.faceSequence();
						bot2Turn = false;
					}
					else if(faceSequence == 0) {
						bot2Turn = false;
					}
				}
			}
			if(!bot3.equals("None")) {
				boolean bot3Turn = true;
				while(bot3Turn) {
					bot3Diff.getMove(playerTurn);
					if(!playerTurn) {
						pile.add(bot3Hand.remove(0));
					}
					if(pile.get(pile.length()-1).isFace()) {
						faceSequence = pile.faceSequence();
						bot3Turn = false;
					}
					else if(faceSequence == 0) {
						bot3Turn = false;
					}
				}
			}
		}
	}
	public void mousePressed(MouseEvent e) {
		JPanel clickedPanel = (JPanel) e.getSource();
		if(clickedPanel == bottomCardPanel) {
			if(playerTurn == true) {
				pile.add(playerHand.remove(0));
				slap = pile.isSlap();
				playerTurn = false;
				
			}
		}
		if(clickedPanel == centerPanel) {
			if(slap == true) {
				for(int i=0;i<pile.length();i++) {
					playerHand.add(pile.remove(0));
				}
			}
			else { //burn
				pile.add(playerHand.remove(0));
			}
		}
	}
	public void actionPerformed(ActionEvent e) {
		String eventName = e.getActionCommand();

	}

}
