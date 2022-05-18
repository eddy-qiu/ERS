import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class GamePanel extends JPanel implements ActionListener, MouseListener {
	JFrame GameFrame;
	JPanel mainPanel, topCardPanel, bottomCardPanel;
	JLayeredPane centerPanel;
	JLabel topCard, bottomCard, empty1, empty2, empty3, empty4, empty5, empty6, topCardAmount, bottomCardAmount;
	Boolean playerTurn = true, slap = false, gameOver = false;
	CenterPile pile = new CenterPile();
	PlayerPile players[], playerHand, bot1Hand;
	Player bot1Diff;
	int faceSequence = 0, numPlayer;
	String b1;
	boolean playerPlayedFace;
	int speed = 1000;
	boolean slapped = false;

	Timer timer1 = new Timer();

	public GamePanel(String bot1) throws Exception {// remember that animations can be separate from some backend
													// functionality
		b1 = bot1;

		ImageIcon cardBack = new ImageIcon("cards/cardBack.png");
		ImageIcon rotatedCardBack = new ImageIcon("cards/cardBackSideways.png");
		Image image1 = cardBack.getImage();
		Image image2 = rotatedCardBack.getImage();
		Image newimg1 = image1.getScaledInstance(140, 180, java.awt.Image.SCALE_SMOOTH);
		Image newimg2 = image2.getScaledInstance(180, 140, java.awt.Image.SCALE_SMOOTH);
		cardBack = new ImageIcon(newimg1);
		rotatedCardBack = new ImageIcon(newimg2);
		topCard = new JLabel(cardBack);
		bottomCard = new JLabel(cardBack);

		GameFrame = new JFrame("Egyptian Rat Screw");
		GameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GameFrame.setPreferredSize(new Dimension(720, 720));

		mainPanel = new JPanel();
		mainPanel.setBackground(Color.GREEN);
		mainPanel.setLayout(new GridLayout(3, 3, 10, 35));

		centerPanel = new JLayeredPane();
		centerPanel.addMouseListener(this);

		topCardPanel = new JPanel();
		topCardPanel.setBackground(Color.GREEN);
		topCardPanel.setLayout(new GridLayout(1, 1, 0, 0));
		topCardPanel.add(topCard);

		bottomCardPanel = new JPanel();
		bottomCardPanel.setBackground(Color.GREEN);
		bottomCardPanel.setLayout(new GridLayout(1, 1, 0, 0));
		bottomCardPanel.add(bottomCard);
		bottomCardPanel.addMouseListener(this);

		empty1 = new JLabel("");
		empty2 = new JLabel("");
		empty3 = new JLabel("");
		empty4 = new JLabel("");
		empty5 = new JLabel("");
		empty6 = new JLabel("");

		mainPanel.add(empty1);
		mainPanel.add(topCardPanel);
		mainPanel.add(empty2);
		mainPanel.add(empty3);
		mainPanel.add(centerPanel);
		mainPanel.add(empty4);
		mainPanel.add(empty5);
		mainPanel.add(bottomCardPanel);
		mainPanel.add(empty6);

		GameFrame.setContentPane(mainPanel);
		GameFrame.pack();
		GameFrame.setVisible(true);

		players = new PlayerPile[2];
		FullDeck allCards = new FullDeck(); // create 52 cards, shuffle them into respective number of player decks
		int cardsPerPlayer = 52 / (2);
		allCards.shuffle();
		players[0] = new PlayerPile();
		for (int i = 1; i < cardsPerPlayer + 1; i++) {
			Card card = allCards.remove(0);
			players[0].add(card);
		}
		players[1] = new PlayerPile();
		for (int i = 1; i < cardsPerPlayer + 1; i++) {
			Card card = allCards.remove(0);
			players[1].add(card);
		}
//
		players[0].add(new Card(11, "diamonds"));
		players[0].add(new Card(3, "diamonds"));
		players[0].add(new Card(4, "diamonds"));

		players[1].add(new Card(3, "diamonds"));
		players[1].add(new Card(6, "diamonds"));
		players[1].add(new Card(7, "diamonds"));

		players[0].add(new Card(5, "diamonds"));
		players[0].add(new Card(5, "diamonds"));
		players[0].add(new Card(7, "diamonds"));

		int j = 0;
		playerHand = players[j];
		j++;
		if (!bot1.contentEquals("None")) {
			bot1Hand = players[j];
			j++;
		}
		if (bot1.equals("easy")) { // set the difficulty for the bots

			speed = 1000;
		} else if (bot1.equals("medium")) {
			speed = 750;
		} else if (bot1.equals("hard")) {
			speed = 400;

		} else if (bot1.equals("medium")) {
			bot1Diff = new MediumPlayer();
		} else if (bot1.equals("hard")) {
			bot1Diff = new HardPlayer();

		}
	}

	public void computerPlayCard() throws InterruptedException {// start game
		if (slapped) {
			slapped = false;
			playerTurn = true;
			return;
		}
		if (!playerTurn) {
			slap = pile.isSlap();
			if (bot1Hand.length() == 0 && !slap) {
				JOptionPane.showMessageDialog(GameFrame, "You Won!");
			}
			repaint();
			timer1.schedule(new TimerTask() {
				public void run() {
					ImageIcon card = bot1Hand.get(0).getImage();
					JLabel cardPanel = new JLabel(card);
					int x = (int) (Math.random() * 50);
					int y = (int) (Math.random() * 30);
					cardPanel.setBounds(x, y, 140, 180);
					centerPanel.add(cardPanel);
					centerPanel.moveToFront(cardPanel);
					
					topCardPanel.repaint();

					Card c = bot1Hand.remove(0);
					pile.add(c);
					slap = pile.isSlap();

					if (slap) {
						Timer timer = new Timer();
						timer.schedule(new TimerTask() {
							public void run() {
								if (!slapped) {
									computerSlap();
									try {
										computerPlayCard();
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
								}
							}
						}, speed);
						return;
					}
					
					if(slapped) {
						playerTurn = true;
						return;
					}
					if (bot1Hand.length() == 0) {
						topCard.setVisible(false);
					} else {
						topCard.setVisible(true);
					}
					faceSequence--;

					if (pile.get(pile.length() - 1).isFace()) {
						faceSequence = pile.faceSequence();
						playerTurn = true;
						playerPlayedFace = false;
					} else if (faceSequence < 0) {
						if (playerHand.length() == 0 && !slap) {
							JOptionPane.showMessageDialog(GameFrame, "Game Over!");
							return;
						}
						playerPlayedFace = false;
						playerTurn = true;
					} else if (faceSequence == 0 && !playerPlayedFace) {
						playerTurn = false;
					} else if (faceSequence == 0 && playerPlayedFace) {
						Timer t = new Timer();
						t.schedule(new TimerTask() {
							@Override
							public void run() {
								int size = pile.length();
								for (int i = 0; i < size; i++) {
									Card c = pile.remove(0);
									playerHand.add(c);
								}
								centerPanel.removeAll();
								centerPanel.revalidate();
								centerPanel.repaint();
							}

						}, 1000);
						playerPlayedFace = false;
						playerTurn = true;
					} else {
						try {
							computerPlayCard();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}, 1000);

		}

	}

	public void mousePressed(MouseEvent e) {

		JPanel clickedPanel = null;
		try {
			clickedPanel = (JPanel) e.getSource();
		} catch (Exception e1) {

		}
		JLayeredPane clicked2 = null;
		try {
			clicked2 = (JLayeredPane) e.getSource();
		} catch (Exception e2) {

		}

		if (clickedPanel == bottomCardPanel) {
			if (!playerTurn)
				return;
			ImageIcon card = playerHand.get(0).getImage();
			JLabel cardPanel = new JLabel(card);
			int x = (int) (Math.random() * 50);
			int y = (int) (Math.random() * 30);
			cardPanel.setBounds(x, y, 140, 180);
			centerPanel.add(cardPanel);
			centerPanel.moveToFront(cardPanel);

			slapped = false;
			repaint();
			pile.add(playerHand.remove(0));
			if (playerHand.length() == 0)
				bottomCard.setVisible(false);
			else
				bottomCard.setVisible(true);
			slap = pile.isSlap();
			faceSequence--;

			if (slap) {
				Timer timer = new Timer();
				timer.schedule(new TimerTask() {

					@Override
					public void run() {
						computerSlap();
						try {
							computerPlayCard();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						return;
					}

				}, speed);
				return;
			}
			if (pile.get(pile.length() - 1).isFace()) {
				faceSequence = pile.faceSequence();
				playerPlayedFace = true;
				playerTurn = false;
				try {
					this.computerPlayCard();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			} else if (faceSequence == 0) {
				Timer timer = new Timer();
				timer.schedule(new TimerTask() {
					@Override
					public void run() {
						centerPanel.removeAll();
						centerPanel.revalidate();
						centerPanel.repaint();
						if (!slapped) {
							playerTurn = false;
							int size = pile.length();
							for (int i = 0; i < size; i++) {
								bot1Hand.add(pile.remove(0));
							}
							try {
								computerPlayCard();
							} catch (InterruptedException e1) {
								e1.printStackTrace();
							}
						} else {
							playerPlayedFace = false;
							playerTurn = true;
							int size = pile.length();
							for (int i = 0; i < size; i++) {
								bot1Hand.add(pile.remove(0));
							}
						}
					}
				}, 1000);
			} else if (faceSequence < 0) {
				faceSequence = 0;
				playerTurn = false;
				try {
					computerPlayCard();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} else if (clicked2 == centerPanel) {
			slap = pile.isSlap();
			if (slap) {
				int size = pile.length();
				for (int i = 0; i < size; i++) {
					playerHand.add(pile.remove(0));
				}

				centerPanel.removeAll();
				centerPanel.revalidate();
				centerPanel.repaint();
				pile.clear();

				faceSequence = 0;
				slapped = true;
				playerPlayedFace = false;
				playerTurn = true;
				faceSequence = 0;
				return;
			} else { // burn
				pile.addToBack(playerHand.remove(0));
				if (playerHand.length() == 0 && !slap) {
					JOptionPane.showMessageDialog(GameFrame, "Game Over!");
					return;
				}
			}
		}

	}

	public void computerSlap() {
		slap = pile.isSlap();
		
		if (!slapped && slap) {
			playerPlayedFace = false;
			playerTurn = false;
			faceSequence = 0;
			slapped = false;
			centerPanel.removeAll();
			centerPanel.revalidate();
			centerPanel.repaint();
			int size = pile.length();
			for (int i = 0; i < size; i++) {
				bot1Hand.add(pile.remove(0));
			}
			slap = false;
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
