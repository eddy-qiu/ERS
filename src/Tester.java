import java.awt.Image;

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
//		JFrame frame = new JFrame();
//		JPanel panel = new JPanel();
//		Card one = new Card(4, "spades");
//		JLabel oneCard = new JLabel(one.getImage());
//		panel.add(oneCard);
//		Card two = new Card(5, "hearts");
//		JLabel twoCard = new JLabel(two.getImageSideways());
//		panel.add(twoCard);
//		Card three = new Card(13, "diamonds");
//		JLabel threeCard = new JLabel(three.getImageSideways());
//		panel.add(threeCard);
//		ImageIcon winBack = new ImageIcon("cards/cardBackWin.png");
//		Image image1 = winBack.getImage();
//		Image newimg1 = image1.getScaledInstance(120, 160, java.awt.Image.SCALE_SMOOTH);
//		winBack = new ImageIcon(newimg1);
//		JLabel winBackLabel = new JLabel(winBack);
//		panel.add(winBackLabel);
//		ImageIcon winBackSideways = new ImageIcon("cards/cardBackSidewaysWin.png");
//		Image image2 = winBackSideways.getImage();
//		Image newimg2 = image2.getScaledInstance(160, 120, java.awt.Image.SCALE_SMOOTH);
//		winBackSideways = new ImageIcon(newimg2);
//		JLabel winBackSidewaysLabel = new JLabel(winBackSideways);
//		panel.add(winBackSidewaysLabel);
//		frame.add(panel);
//		frame.pack();
//		frame.setVisible(true);
		
	}
	private static void menuGUI() throws Exception {
		JFrame.setDefaultLookAndFeelDecorated
		(true);
		Tester test = new Tester();
	}
	public static void main(String[] args) {
//		javax.swing.SwingUtilities.
//		invokeLater(new Runnable() {
//			public void run() {
//				try {
//					menuGUI();
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		});
		CenterPile center = new CenterPile();
		try{
			System.out.println(center.length());
			center.add(new Card(11,"Clubs"));
			System.out.println(center.faceSequence());
			center.add(new Card(1,"Hearts"));
			System.out.println(center.faceSequence());
			center.add(new Card(2,"Clubs"));
			System.out.println(center.faceSequence());
			System.out.println(center.length());
			center.remove(0);
			System.out.println(center.length());
		}
		catch(Exception e) {
			
		}
		System.out.println(center.get(0).getValue());
		System.out.println(center.faceSequence());
		}
	}
