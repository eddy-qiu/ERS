import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;


public class GamePanel extends JPanel implements ActionListener,MouseListener{
	JFrame GameFrame;
	JPanel mainPanel, rightCardPanel, leftCardPanel, topCardPanel, bottomCardPanel;
	JLayeredPane centerPanel;
	JLabel topCard, leftCard, rightCard, bottomCard, empty1, empty2, empty3, empty4, topCardAmount,
	leftCardAmount,rightCardAmount,bottomCardAmount;
	Boolean playerTurn=true,slap=false,gameOver=false;
	CenterPile pile = new CenterPile();
	PlayerPile players[],playerHand,bot1Hand,bot2Hand,bot3Hand;
	Player bot1Diff,bot2Diff,bot3Diff;
	int faceSequence,numPlayer;
	String b1,b2,b3;
	public GamePanel(String bot1,String bot2,String bot3,int numPlayers) throws Exception{//remember that animations can be separate from some backend functionality
		b1=bot1;
		b2=bot2;
		b3=bot3;
		numPlayer = numPlayers;
		System.out.println("here");
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
		mainPanel.setBackground(Color.GREEN);
		mainPanel.setLayout(new GridLayout(3,3,10,35));

		centerPanel = new JLayeredPane();
		centerPanel.addMouseListener(this);

		rightCardPanel = new JPanel();
		rightCardPanel.setBackground(Color.GREEN);
		rightCardPanel.setLayout(new GridLayout(1,1,0,0));
		rightCardPanel.add(rightCard);
		if(bot1.equals("None")) {
			rightCardPanel.setVisible(false);
		}

		leftCardPanel = new JPanel();
		leftCardPanel.setBackground(Color.GREEN);
		leftCardPanel.setLayout(new GridLayout(1,1,0,0));
		leftCardPanel.add(leftCard);
		if(bot3.equals("None")) {
			leftCardPanel.setVisible(false);
		}

		topCardPanel = new JPanel();
		topCardPanel.setBackground(Color.GREEN);
		topCardPanel.setLayout(new GridLayout(1,1,0,0));
		topCardPanel.add(topCard);
		if(bot2.equals("None")) {
			topCardPanel.setVisible(false);
		}

		bottomCardPanel = new JPanel();
		bottomCardPanel.setBackground(Color.GREEN);
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
		mainPanel.add(bottomCardPanel);
		mainPanel.add(empty4);

		GameFrame.setContentPane(mainPanel);
		GameFrame.pack();
		GameFrame.setVisible(true);

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
	}
	public void startGame(String bot1, String bot2, String bot3, int numPlayers) throws InterruptedException {//start game

		if(!playerTurn) {
			if(!bot1.equals("None")) {
				boolean bot1Turn = true;
				while(bot1Turn) {
					bot1Diff.getMove(playerTurn);
					if(!playerTurn) {
						Timer timer1 = new Timer(1000, new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								ImageIcon card = bot1Hand.get(0).getImage();
								JLabel cardPanel = new JLabel(card);
								int x = (int)(Math.random()*50);
								int y = (int)(Math.random()*30);
								cardPanel.setBounds(x,y,140,180);
								centerPanel.add(cardPanel);
								centerPanel.moveToFront(cardPanel);
							}
						});
						repaint();
						timer1.setRepeats(false);
						timer1.start();
						pile.add(bot1Hand.remove(0));
					}
					if(pile.get(pile.length()-1).isFace()) {
						faceSequence = pile.faceSequence();
						bot1Turn = false;
					}
					else if(faceSequence == 0) {
						bot1Turn = false;
					}
					faceSequence--;
				}
			}
			if(!bot2.equals("None")) {
				boolean bot2Turn = true;
				while(bot2Turn) {
					bot2Diff.getMove(playerTurn);
					if(!playerTurn) {
						Timer timer2 = new Timer(2000, new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								ImageIcon card = bot2Hand.get(0).getImage();
								JLabel cardPanel = new JLabel(card);
								int x = (int)(Math.random()*50);
								int y = (int)(Math.random()*30);
								cardPanel.setBounds(x,y,140,180);
								centerPanel.add(cardPanel);
								centerPanel.moveToFront(cardPanel);
							}
						});
						repaint();
						timer2.setRepeats(false);
						timer2.start();
						pile.add(bot2Hand.remove(0));
					}
					if(pile.get(pile.length()-1).isFace()) {
						faceSequence = pile.faceSequence();
						bot2Turn = false;
					}
					else if(faceSequence == 0) {
						bot2Turn = false;
					}
					faceSequence--;
				}
			}
			if(!bot3.equals("None")) {
				boolean bot3Turn = true;
				while(bot3Turn) {
					bot3Diff.getMove(playerTurn);
					if(!playerTurn) {
						Timer timer3 = new Timer(3000, new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								ImageIcon card = bot3Hand.get(0).getImage();
								JLabel cardPanel = new JLabel(card);
								int x = (int)(Math.random()*50);
								int y = (int)(Math.random()*30);
								cardPanel.setBounds(x,y,140,180);
								centerPanel.add(cardPanel);
								centerPanel.moveToFront(cardPanel);
							}
						});
						repaint();
						timer3.setRepeats(false);
						timer3.start();
						pile.add(bot3Hand.remove(0));
					}
					if(pile.get(pile.length()-1).isFace()) {
						faceSequence = pile.faceSequence();
						bot3Turn = false;
					}
					else if(faceSequence == 0) {
						bot3Turn = false;
					}
					faceSequence--;
				}
			}
			playerTurn = true;
		}
	}

	public void mousePressed(MouseEvent e) {
		JPanel clickedPanel = null;
		try {
			clickedPanel = (JPanel) e.getSource();
		}
		catch(Exception e1){

		}
		JLayeredPane clicked2 = null;
		try {
			clicked2 = (JLayeredPane) e.getSource();
		}
		catch(Exception e2) {

		}
		if(clickedPanel == bottomCardPanel) {

			if(playerTurn == true) {
				System.out.println("clicked");

				ImageIcon card = playerHand.get(0).getImage();
				JLabel cardPanel = new JLabel(card);
				int x = (int)(Math.random()*50);
				int y = (int)(Math.random()*30);
				cardPanel.setBounds(x,y,140,180);
				centerPanel.add(cardPanel);
				centerPanel.moveToFront(cardPanel);

				repaint();

				pile.add(playerHand.remove(0));
				slap = pile.isSlap();
				faceSequence--;
				if(playerHand.length()==0) {
					bottomCardPanel.remove(bottomCard);
					JLabel gameOverText = new JLabel("Game Over!");
					bottomCardPanel.add(gameOverText);
					repaint();
				}
				if(faceSequence <= 0) {
					faceSequence = 0;
					playerTurn = false;
					try {
						this.startGame(b1, b2, b3, numPlayer);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
		if(clicked2 == centerPanel) {
			System.out.println("clicked2");
			if(slap == true) {
				for(int i=0;i<pile.length();i++) {
					playerHand.add(pile.remove(0));
				}
			}
			else { //burn

				if(playerHand.length()==0) {
					bottomCardPanel.remove(bottomCard);
					JLabel gameOverText = new JLabel("Game Over!");
					bottomCardPanel.add(gameOverText);
					repaint();
				}
			}
		}
	}
	public void actionPerformed(ActionEvent e) {
		String eventName = e.getActionCommand();

	}
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
