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
			
			background = ImageIO.read(ImageLoader.class.getResource("/images/stars.jpeg"));
			background2 = ImageIO.read(ImageLoader.class.getResource("/images/stars.jpeg"));
			
			rocketGray = ImageIO.read(ImageLoader.class.getResource("/images/rocket1.png"));
			rocketGreen = ImageIO.read(ImageLoader.class.getResource("/images/rocket2.png"));
			rocketRed = ImageIO.read(ImageLoader.class.getResource("/images/rocket3.png"));
			rocketYellow = ImageIO.read(ImageLoader.class.getResource("/images/rocket4.png"));
			
			enemy = ImageIO.read(ImageLoader.class.getResource("/images/enemy.png"));
			
		} catch(IOException e) {
			e.printStackTrace();
			System.out.println("keine Datei");
		}
	}
	
	public static BufferedImage getBackground(int number) {
		switch (number) {
			case 1:
				return background;
			case 2:
				return background2;
			default:
				return background;
		}
	}

	public static BufferedImage getRocket(int rocketType) {
		switch(rocketType) {
			case 1:
				return rocketGray;
			case 2:
				return rocketGreen;
			case 3:
				return rocketRed;
			case 4:
				return rocketYellow;
			default:
				return rocketGray;
		}
	}
	
	public static BufferedImage getEnemy() {
		return enemy;
	}
	
}
