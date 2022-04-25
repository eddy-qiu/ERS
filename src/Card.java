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
	public ImageIcon getImage() {
		String appendedCardName = String.valueOf("cards/"+this.getValue() + "_of_"+ this.getSuite() + ".png");
		System.out.println(appendedCardName);
		cardImage = new ImageIcon(appendedCardName);
		Image image1 = cardImage.getImage();
		Image newimg1 = image1.getScaledInstance(120,160,java.awt.Image.SCALE_SMOOTH);
		return new ImageIcon(newimg1);
	}
	public ImageIcon getImageSideways() {
		String appendedCardName = String.valueOf("cards/"this.getValue() + "_of_"+ this.getSuite() + ".png");
		cardImage = new ImageIcon(appendedCardName);
		Image image1 = cardImage.getImage();
		Image newimg1 = image1.getScaledInstance(120,160,java.awt.Image.SCALE_SMOOTH);
		
	    BufferedImage image = (BufferedImage)newimg1;
		
		// Calculate the new size of the image based on the angle of rotaion
	    double radians = Math.toRadians(90);
	    double sin = Math.abs(Math.sin(radians));
	    double cos = Math.abs(Math.cos(radians));
	    int newWidth = (int) Math.round(image.getWidth() * cos + image.getHeight() * sin);
	    int newHeight = (int) Math.round(image.getWidth() * sin + image.getHeight() * cos);

	    // Create a new image
	    BufferedImage rotate = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2d = rotate.createGraphics();
	    // Calculate the "anchor" point around which the image will be rotated
	    int x = (newWidth - image.getWidth()) / 2;
	    int y = (newHeight - image.getHeight()) / 2;
	    // Transform the origin point around the anchor point
	    AffineTransform at = new AffineTransform();
	    at.setToRotation(radians, x + (image.getWidth() / 2), y + (image.getHeight() / 2));
	    at.translate(x, y);
	    g2d.setTransform(at);
	    // Paint the original image
	    g2d.drawImage(image, 0, 0, null);
	    g2d.dispose();
	    
	    return new ImageIcon(rotate);
	}
}
