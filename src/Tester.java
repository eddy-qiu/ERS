import javax.swing.*;
public class Tester {
//	public static void main(String[] args) throws Exception {
//		FullDeck a  = new FullDeck(); //fulldeck testing
//		System.out.println(a.length());
//		System.out.println(a.get(1).value);
//		System.out.println(a.get(10).value);
//		a.shuffle();
//		System.out.println(a.get(1).value);
//		
//		CenterPile b = new CenterPile(); //centerpile testing
//		System.out.println(b.isSlap());
////		b.add(new Card(13));
////		b.add(new Card(3));
////		b.add(new Card(3));
////		System.out.println(b.isSlap());
////		b.add(new Card(2));
////		System.out.println(b.isSlap());
////		b.add(new Card(3));
////		System.out.println(b.isSlap());
////		System.out.println(b.faceSequence());
////		b.add(new Card(13));
////		b.add(new Card(12));
////		System.out.println(b.isSlap());
////		b.add(new Card(12));
////		b.add(new Card(13));
////		System.out.println(b.isSlap());
////		System.out.println(b.faceSequence());
////		System.out.println(b.faceSequence());
////		System.out.println(b.faceSequence());
////		System.out.println(b.faceSequence());
////		System.out.println(b.faceSequence());
////		System.out.println(b.faceSequence());
////		System.out.println(52/3);
		
//	}
	Tester() throws Exception{
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		Card one = new Card(4, "spades");
		JLabel oneCard = new JLabel(one.getImage());
		panel.add(oneCard);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}
	private static void menuGUI() throws Exception {
		JFrame.setDefaultLookAndFeelDecorated
		(true);
		Tester test = new Tester();
	}
	public static void main(String[] args) {
		javax.swing.SwingUtilities.
		invokeLater(new Runnable() {
			public void run() {
				try {
					menuGUI();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}
