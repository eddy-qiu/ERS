import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class Card {
	int value;
	boolean face = false;
	ImageIcon cardImage;
	String cardSuite;
	Card(int assignedValue, String suite) throws Exception{
		cardSuite = suite;
		if(assignedValue < 1 || assignedValue > 13) {
		throw new Exception("invalid card");
		}
		value = assignedValue;
		if(assignedValue > 10 || assignedValue == 1) {
			face = true;
		}
	}
	public int getValue() {
		return value;
	}
	public boolean isFace() {
		return face;
	}
	public String getSuite() {
		return cardSuite;
	}
	public String appendCardName() {
		String cardName = String.valueOf(this.getValue());
		if(this.isFace() || this.getValue() == 1) {
			if(this.getValue() == 11) {
				cardName = "jack";
			}
			if(this.getValue() == 12) {
				cardName = "queen";
			}
			if(this.getValue() == 13) {
				cardName = "king";
			}
			if(this.getValue() == 1) {
				cardName = "ace";
			}
		}
		return String.valueOf("cards/"+ cardName + "_of_"
		+ this.getSuite() + ".png");
	}
	public ImageIcon getImage() {
		cardImage = new ImageIcon(this.appendCardName());
		Image image1 = cardImage.getImage();
		Image newimg1 = image1.getScaledInstance(120,160,
				java.awt.Image.SCALE_SMOOTH);
		return new ImageIcon(newimg1);
	}
	public ImageIcon getImageSideways() {
		cardImage = new ImageIcon(this.appendCardName());
		Image image1 = cardImage.getImage();
		
		BufferedImage image = new BufferedImage
				(image1.getWidth(null), 
						image1.getHeight(null), 
						BufferedImage.TYPE_INT_ARGB);

	    Graphics2D bGr = image.createGraphics();
	    bGr.drawImage(image1, 0, 0, null);
	    bGr.dispose();
		
	    double radians = Math.toRadians(90);
	    double sin = Math.abs(Math.sin(radians));
	    double cos = Math.abs(Math.cos(radians));
	    int newWidth = (int) Math.round(image.getWidth()
	    		* cos + image.getHeight() * sin);
	    int newHeight = (int) Math.round(image.getWidth()
	    		* sin + image.getHeight() * cos);

	    BufferedImage rotate = new BufferedImage(newWidth,
	    		newHeight, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2d = rotate.createGraphics();

	    int x = (newWidth - image.getWidth()) / 2;
	    int y = (newHeight - image.getHeight()) / 2;

	    AffineTransform at = new AffineTransform();
	    at.setToRotation(radians, x + (image.getWidth() / 2)
	    		, y + (image.getHeight() / 2));
	    at.translate(x, y);
	    g2d.setTransform(at);

	    g2d.drawImage(image, 0, 0, null);
	    g2d.dispose();
	    
	    Image rotate1 = rotate.getScaledInstance(160,120,
	    		java.awt.Image.SCALE_SMOOTH);
	    return new ImageIcon(rotate1);
	}
}
