import javax.swing.*;
import java.awt.event.*;
import java.awt.*; 
public class MenuScreen extends JPanel implements ActionListener{

	JFrame mainFrame, ruleFrame;
	JPanel mainPanel, titlePanel, rulePanel, 
	rulebuttonPanel, ruleTextPanel, menuButtonPanel, 
	rightCardPanel, leftCardPanel, topCardPanel;
	JButton start, tutorialButton, ruleButton, nextPage, backToMain;
	JLabel titleText, ruleImage, topCard, leftCard, rightCard,
	bottomCard, empty1, empty2, empty3;
	JComboBox topCardDiff, rightCardDiff, leftCardDiff;
	ImageIcon Rule1, Rule2;
	private int rulePage = 1;

	public MenuScreen(){
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

		String[] Difficulty = {
				"Not active",
				"easy", 
				"medium", 
				"hard" 
		};

		topCardDiff = new JComboBox(Difficulty);
		rightCardDiff = new JComboBox(Difficulty);
		leftCardDiff = new JComboBox(Difficulty);
		//Main Panel
		mainFrame = new JFrame("Egyptian Rat Screw");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel = new JPanel();
		mainPanel.setBackground(Color.YELLOW);
		mainPanel.setLayout(new GridLayout(3,3, 20, 20));

		rightCardPanel = new JPanel();
		rightCardPanel.setLayout(new BoxLayout(rightCardPanel, BoxLayout.Y_AXIS));
		rightCardPanel.add(rightCard);
		rightCardPanel.add(rightCardDiff);

		leftCardPanel = new JPanel();
		leftCardPanel.setLayout(new BoxLayout(leftCardPanel, BoxLayout.Y_AXIS));
		leftCardPanel.add(leftCard);
		leftCardPanel.add(leftCardDiff);

		topCardPanel = new JPanel();
		topCardPanel.setLayout(new BoxLayout(topCardPanel, BoxLayout.Y_AXIS));
		topCardPanel.add(topCard);
		topCardPanel.add(topCardDiff);

		titleText = new JLabel("Egyptian Rat Screw");
		titleText.setAlignmentX(CENTER_ALIGNMENT);

		start = new JButton("Start Game");
		start.addActionListener(this);
		start.setActionCommand("Game");
		start.setAlignmentX(CENTER_ALIGNMENT);
		start.setAlignmentY(BOTTOM_ALIGNMENT);
		start.addActionListener(this);

		tutorialButton = new JButton("Tutorial");
		tutorialButton.setAlignmentX(CENTER_ALIGNMENT);
		tutorialButton.setAlignmentY(TOP_ALIGNMENT);
		tutorialButton.addActionListener(this);

		ruleButton = new JButton("Rules");
		ruleButton.setAlignmentX(CENTER_ALIGNMENT);
		ruleButton.setAlignmentY(TOP_ALIGNMENT);
		ruleButton.addActionListener(this);
		empty1 = new JLabel(" ");
		empty2 = new JLabel(" ");
		empty3 = new JLabel(" ");

		titlePanel = new JPanel();
		titlePanel.setLayout(new GridLayout(3,1,0,0));
		titlePanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 10, 20));
		titlePanel.add(empty1);
		titlePanel.add(titleText);
		titlePanel.add(start);

		menuButtonPanel = new JPanel();
		menuButtonPanel.setLayout(new GridLayout(2,1, 0, 0));
		menuButtonPanel.setBackground(Color.YELLOW);
		menuButtonPanel.add(tutorialButton);
		menuButtonPanel.add(ruleButton);

		mainPanel.add(empty1);
		mainPanel.add(topCardPanel);
		mainPanel.add(empty2);
		mainPanel.add(leftCardPanel);
		mainPanel.add(titlePanel);
		mainPanel.add(rightCardPanel);
		mainPanel.add(empty3);
		mainPanel.add(bottomCard);
		mainPanel.add(menuButtonPanel);


		//Rule Panel
		ruleFrame = new JFrame("Rules");
		ruleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rulePanel = new JPanel();
		rulePanel.setBackground(Color.GREEN);
		rulePanel.setLayout(new GridLayout(2,1,0,20));

		backToMain = new JButton("Back to menu");
		backToMain.addActionListener(this);

		nextPage = new JButton("Next");
		nextPage.addActionListener(this);

		Rule1 = new ImageIcon("Rules and Tutorial/RuleImg1.png");
		Rule2 = new ImageIcon("Rules and Tutorial/RuleImg2.png");
		ruleImage = new JLabel(Rule1);

		ruleTextPanel = new JPanel();
		ruleTextPanel.setLayout(new BoxLayout(ruleTextPanel, BoxLayout.Y_AXIS));
		ruleTextPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		ruleTextPanel.setBackground(Color.GREEN);
		ruleImage.setAlignmentX(CENTER_ALIGNMENT);
		ruleTextPanel.add(ruleImage);
		rulePanel.add(ruleTextPanel, BorderLayout.CENTER);

		rulebuttonPanel = new JPanel();
		rulebuttonPanel.setLayout(new BoxLayout(rulebuttonPanel, BoxLayout.Y_AXIS));
		rulebuttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 10, 20));
		backToMain.setAlignmentX(CENTER_ALIGNMENT);
		nextPage.setAlignmentX(CENTER_ALIGNMENT);
		rulebuttonPanel.add(nextPage);
		rulebuttonPanel.add(backToMain);
		rulePanel.add(rulebuttonPanel, BorderLayout.PAGE_END);

		mainPanel.setBorder(BorderFactory.
				createEmptyBorder(50, 50, 50, 50));
		rulePanel.setBorder(BorderFactory.
				createEmptyBorder(30, 30, 30, 30));
		mainFrame.setContentPane(mainPanel);
		mainFrame.pack();
		mainFrame.setVisible(true);

		ruleFrame.setContentPane(rulePanel);
		ruleFrame.pack();
		ruleFrame.setVisible(false);
	}
	public String getDifficulty(int card) {
		String Difficulty = "None";
		if(card == 1){
			Difficulty = (String) topCardDiff.getSelectedItem();
		}else if(card == 2) {
			Difficulty = (String) rightCardDiff.getSelectedItem();
		}else if(card == 3) {
			Difficulty = (String) leftCardDiff.getSelectedItem();
		}
		return Difficulty;
	}
	public void actionPerformed(ActionEvent event) {
		String eventName = event.getActionCommand();
		if(eventName.equals("Rules")) {
			ruleFrame.setVisible(true);
			mainFrame.setVisible(false);
		}else if(eventName.equals("Next")) {
			if(rulePage == 0) {
				ruleImage.setIcon(Rule1);
				rulePage++;
			}else if(rulePage == 1){
				ruleImage.setIcon(Rule2);
				rulePage = 0;
			}
		}
		else if(eventName.equals("Back to menu")) {
			ruleFrame.dispose();
			mainFrame.setVisible(true);
		}
		else if(eventName.contentEquals("Game")){
			int numPlayers = 4;
			if(topCardDiff.getSelectedItem().equals("None")) {
				numPlayers--;
			}
			if(leftCardDiff.getSelectedItem().equals("None")) {
				numPlayers--;
			}
			if(rightCardDiff.getSelectedItem().equals("None")) {
				numPlayers--;
			}
			try {
				GamePanel game = new GamePanel(numPlayers);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mainFrame.setVisible(false);

		}
	}
	private static void menuGUI() {
		JFrame.setDefaultLookAndFeelDecorated
		(true);
		MenuScreen menu = new MenuScreen();
	}
	public static void main(String[] args) {
		javax.swing.SwingUtilities.
		invokeLater(new Runnable() {
			public void run() {
				menuGUI();
			}
		});
	}
}
