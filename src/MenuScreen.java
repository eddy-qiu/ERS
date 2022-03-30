import javax.swing.*;
import java.awt.event.*;
import java.awt.*; 
public class MenuScreen extends JPanel implements ActionListener{

	JFrame mainFrame, tutorialFrame;
	JPanel menuPanel, tutorialPanel;
	JButton start, tutorialButton, nextPage, backToMain;
	JLabel titleText, tutorialText;
	private int tutorialPage = 0;

	public MenuScreen() {
		mainFrame = new JFrame("Egyptian Rat Screw");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuPanel = new JPanel();
		menuPanel.setBackground(Color.YELLOW);
		menuPanel.setLayout(new BoxLayout
				(menuPanel, BoxLayout.PAGE_AXIS));
		
		tutorialFrame = new JFrame("Tutorial");
		tutorialFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tutorialPanel = new JPanel();
		tutorialPanel.setBackground(Color.GREEN);
		tutorialPanel.setLayout(new BoxLayout
				(tutorialPanel, BoxLayout.PAGE_AXIS));
		
		titleText = new JLabel("Egyptian Rat Screw");
		titleText.setAlignmentX(CENTER_ALIGNMENT);
		titleText.setAlignmentY(TOP_ALIGNMENT);
		menuPanel.add(titleText);
		
		start = new JButton("Start Game");
		start.setAlignmentX(CENTER_ALIGNMENT);
		start.setAlignmentY(TOP_ALIGNMENT);
		start.addActionListener(this);
		menuPanel.add(start);
		
		tutorialButton = new JButton("Tutorial");
		tutorialButton.setAlignmentX(CENTER_ALIGNMENT);
		tutorialButton.setAlignmentY(TOP_ALIGNMENT);
		tutorialButton.addActionListener(this);
		menuPanel.add(tutorialButton);
		
		backToMain = new JButton("Back to menu");
		backToMain.setAlignmentX(CENTER_ALIGNMENT);
		backToMain.setAlignmentY(TOP_ALIGNMENT);
		backToMain.addActionListener(this);
		tutorialPanel.add(backToMain);
	
		nextPage = new JButton("Next");
		nextPage.setAlignmentX(LEFT_ALIGNMENT);
		nextPage.setAlignmentY(BOTTOM_ALIGNMENT);
		nextPage.addActionListener(this);
		tutorialPanel.add(nextPage);
		
		tutorialText = new JLabel("Tutorial");
		tutorialPanel.add(tutorialText);
		
		menuPanel.setBorder(BorderFactory.
				createEmptyBorder(360, 360, 360, 360));
		mainFrame.setSize(720, 720);
		tutorialPanel.setBorder(BorderFactory.
				createEmptyBorder(360, 360, 360, 360));
		mainFrame.setContentPane(menuPanel);
		mainFrame.pack();
		
		tutorialFrame.setContentPane(tutorialPanel);
		tutorialFrame.pack();
		mainFrame.setVisible(true);
		tutorialFrame.hide();
	}
	public void actionPerformed(ActionEvent event) {
		String eventName = event.getActionCommand();
		if(eventName.equals("Tutorial")) {
			tutorialFrame.show();
			tutorialFrame.setSize(720, 720);
			mainFrame.hide();
			
			tutorialFrame.setVisible(true);
			tutorialPanel.add(backToMain);
			
		}else if(eventName.equals("Next")) {
			
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
