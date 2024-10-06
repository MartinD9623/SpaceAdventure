package game;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {
	
	private static BufferedImage rocketGray, rocketGreen, 
	rocketRed, rocketYellow;
	private static BufferedImage background, background2;
	private static BufferedImage enemy;
	
	public ImageLoader() {
		
		try {
			
			background = ImageIO.read(ImageLoader.class.getResource("/images/background.jpg"));
			background2 = ImageIO.read(ImageLoader.class.getResource("/images/background.jpg"));
			
			rocketGray = ImageIO.read(ImageLoader.class.getResource("/images/rocketGray.png"));
			rocketGreen = ImageIO.read(ImageLoader.class.getResource("/images/rocketGreen.png"));
			rocketRed = ImageIO.read(ImageLoader.class.getResource("/images/rocketRed.png"));
			rocketYellow = ImageIO.read(ImageLoader.class.getResource("/images/rocketYellow.png"));
			
			enemy = ImageIO.read(ImageLoader.class.getResource("/images/enemy.png"));
			
		} catch(IOException e) {
			e.printStackTrace();
			System.out.println("keine Datei");
		}
	}
	
	public static BufferedImage getBackground() {
		return background;
	}
	
	public static BufferedImage getBackground2() {
		return background2;
	}
	
	public static BufferedImage getBackground3() {
		return background2;
	}
	
	public static BufferedImage getRocketGray() {
		return rocketGray;
	}
	
	public static BufferedImage getRocketGreen() {
		return rocketGreen;
	}
	
	public static BufferedImage getRocketRed() {
		return rocketRed;
	}
	
	public static BufferedImage getRocketYellow() {
		return rocketYellow;
	}
	
	public static BufferedImage getEnemy() {
		return enemy;
	}
	
}
