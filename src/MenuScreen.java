import javax.swing.*;
import java.awt.event.*;
import java.awt.*; 
public class MenuScreen extends JPanel implements ActionListener{

	JFrame mainFrame, tutorialFrame;
	JPanel menuPanel, menuTextPanel, tutorialPanel, tutorialbuttonPanel, tutorialTextPanel, menubuttonPanel;
	JButton start, tutorialButton, nextPage, backToMain;
	JLabel titleText, tutorialText;
	private int tutorialPage = 1;

	public MenuScreen(){
		//Main Panel
		mainFrame = new JFrame("Egyptian Rat Screw");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuPanel = new JPanel();
		menuPanel.setBackground(Color.YELLOW);
		menuPanel.setLayout(new BoxLayout
				(menuPanel, BoxLayout.PAGE_AXIS));
		
		titleText = new JLabel("Egyptian Rat Screw");
		titleText.setAlignmentX(CENTER_ALIGNMENT);
		titleText.setAlignmentY(TOP_ALIGNMENT);
//		menuPanel.add(titleText);
		
		start = new JButton("Start Game");
		start.setAlignmentX(RIGHT_ALIGNMENT);
		start.setAlignmentY(TOP_ALIGNMENT);
		start.addActionListener(this);
//		menuPanel.add(start);
		
		tutorialButton = new JButton("Tutorial");
		tutorialButton.setAlignmentX(RIGHT_ALIGNMENT);
		tutorialButton.setAlignmentY(TOP_ALIGNMENT);
		tutorialButton.addActionListener(this);
		//menuPanel.add(tutorialButton);
		
		menuTextPanel = new JPanel();
		menuTextPanel.setLayout(new BoxLayout(menuTextPanel, BoxLayout.PAGE_AXIS));
		menuTextPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 10, 20));
		menuTextPanel.add(titleText);
		menuPanel.add(menuTextPanel, BorderLayout.CENTER);
		
		menubuttonPanel = new JPanel();
		menubuttonPanel.setLayout(new BoxLayout(menubuttonPanel, BoxLayout.LINE_AXIS));
		menubuttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 10, 20));
		menubuttonPanel.add(start);
		menubuttonPanel.add(Box.createHorizontalGlue());
		menubuttonPanel.add(tutorialButton);
		menuPanel.add(menubuttonPanel, BorderLayout.PAGE_END);
		
		
		
		
		
		//Tutorial Panel
		tutorialFrame = new JFrame("Tutorial");
		tutorialFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tutorialPanel = new JPanel();
		tutorialPanel.setBackground(Color.GREEN);
		tutorialPanel.setLayout(new BoxLayout
				(tutorialPanel, BoxLayout.PAGE_AXIS));
		
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
		
		tutorialTextPanel = new JPanel();
		tutorialTextPanel.setLayout(new BoxLayout(tutorialTextPanel, BoxLayout.PAGE_AXIS));
		tutorialTextPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 10, 20));
		tutorialTextPanel.add(tutorialText);
		tutorialPanel.add(tutorialTextPanel, BorderLayout.CENTER);
		
		tutorialbuttonPanel = new JPanel();
		tutorialbuttonPanel.setLayout(new BoxLayout(tutorialbuttonPanel, BoxLayout.LINE_AXIS));
		tutorialbuttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 10, 20));
//		buttonPanel.setSize(720, 360);
		tutorialbuttonPanel.add(backToMain);
		tutorialbuttonPanel.add(Box.createHorizontalGlue());
		tutorialbuttonPanel.add(nextPage);
		tutorialPanel.add(tutorialbuttonPanel, BorderLayout.PAGE_END);
		
		menuPanel.setBorder(BorderFactory.
				createEmptyBorder(360, 360, 360, 360));
//		mainFrame.setSize(720, 720);
		tutorialPanel.setBorder(BorderFactory.
				createEmptyBorder(30, 30, 30, 30));
//		tutorialPanel.setSize(720, 720);
		mainFrame.setContentPane(menuPanel);
		mainFrame.pack();
		
		tutorialFrame.setContentPane(tutorialPanel);
		tutorialFrame.pack();
		mainFrame.setVisible(true);
		tutorialFrame.setVisible(false);
	}
	public void actionPerformed(ActionEvent event) {
		String eventName = event.getActionCommand();
		if(eventName.equals("Tutorial")) {
			tutorialFrame.setVisible(true);
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
			tutorialFrame.dispose();
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
