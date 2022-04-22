import javax.swing.*;
import java.awt.event.*;
import java.awt.*; 
public class MenuScreen extends JPanel implements ActionListener{

	JFrame mainFrame, ruleFrame;
	JPanel mainPanel, titlePanel, rulePanel, 
	rulebuttonPanel, ruleTextPanel, menuButtonPanel, 
	rightCardPanel, leftCardPanel, topCardPanel;
	JButton start, tutorialButton, ruleButton, nextPage, backToMain;
	JLabel titleText, tutorialText, topCard, leftCard, rightCard,
	bottomCard, empty1, empty2, empty3;
	JComboBox topCardDiff, rightCardDiff, leftCardDiff;
	private int tutorialPage = 1;

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
		titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.PAGE_AXIS));
		titlePanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 10, 20));
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





		//Tutorial Panel
		ruleFrame = new JFrame("Tutorial");
		ruleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rulePanel = new JPanel();
		rulePanel.setBackground(Color.GREEN);
		rulePanel.setLayout(new BoxLayout
				(rulePanel, BoxLayout.PAGE_AXIS));

		backToMain = new JButton("Back to menu");
		//		backToMain.setAlignmentX(CENTER_ALIGNMENT);
		//		backToMain.setAlignmentY(TOP_ALIGNMENT);
		backToMain.addActionListener(this);


		nextPage = new JButton("Next");
		//		nextPage.setAlignmentX(CENTER_ALIGNMENT);
		//		nextPage.setAlignmentY(TOP_ALIGNMENT);
		nextPage.addActionListener(this);

		tutorialText = new JLabel("First Page");
		tutorialText.setPreferredSize(new Dimension(720, 50));
		tutorialText.setAlignmentX(LEFT_ALIGNMENT);
		//		tutorialText.setAlignmentY(TOP_ALIGNMENT);

		ruleTextPanel = new JPanel();
		ruleTextPanel.setLayout(new BoxLayout(ruleTextPanel, BoxLayout.PAGE_AXIS));
		ruleTextPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 10, 20));
		ruleTextPanel.add(tutorialText);
		rulePanel.add(ruleTextPanel, BorderLayout.CENTER);

		rulebuttonPanel = new JPanel();
		rulebuttonPanel.setLayout(new BoxLayout(rulebuttonPanel, BoxLayout.LINE_AXIS));
		rulebuttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 10, 20));
		//		buttonPanel.setSize(720, 360);
		rulebuttonPanel.add(backToMain);
		rulebuttonPanel.add(Box.createHorizontalGlue());
		rulebuttonPanel.add(nextPage);
		rulePanel.add(rulebuttonPanel, BorderLayout.PAGE_END);

		mainPanel.setBorder(BorderFactory.
				createEmptyBorder(100, 100, 100, 100));
		//		mainFrame.setSize(720, 720);
		rulePanel.setBorder(BorderFactory.
				createEmptyBorder(30, 30, 30, 30));
		//		tutorialPanel.setSize(720, 720);
		mainFrame.setContentPane(mainPanel);
		mainFrame.pack();

		ruleFrame.setContentPane(rulePanel);
		ruleFrame.pack();
		mainFrame.setVisible(true);
		ruleFrame.setVisible(false);
	}
	public void actionPerformed(ActionEvent event) {
		String eventName = event.getActionCommand();
		if(eventName.equals("Rules")) {
			ruleFrame.setVisible(true);
			mainFrame.hide();

		}else if(eventName.equals("Next")) {

			if(tutorialPage == 0) {
				tutorialText.setText("All 52 cards will be dealt evenly among every player. The player will always starts first  ");
				tutorialPage++;
			}else if(tutorialPage == 1) {
				tutorialText.setText("Second Page");
				tutorialPage++;
			}else if(tutorialPage == 2) {
				tutorialText.setText("Third Page");
				tutorialPage++;
			}else if(tutorialPage == 3) {
				tutorialText.setText("Fourth Page");
				tutorialPage++;
			}else if(tutorialPage == 4) {
				tutorialText.setText("Fifth Page");
				tutorialPage = 0;
			}
		}else if(eventName.equals("Back to menu")) {
			ruleFrame.dispose();
			mainFrame.show();
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
