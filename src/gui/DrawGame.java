package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;

import game.ImageLoader;
import timeClock.BackgroundTimer;

public class DrawGame extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		Graphics2D g2D = (Graphics2D) g;

		g2D.drawImage(ImageLoader.getBackground(), 0, -600 + BackgroundTimer.getBackgroundY(), MainFrame.getWidth(),
				MainFrame.getHeight(), null);

		g2D.drawImage(ImageLoader.getBackground2(), 0, BackgroundTimer.getBackgroundY(), MainFrame.getWidth(),
				MainFrame.getHeight(), null);

		switch (SettingsPanel.rocketType) {
		case 1:
			g.drawImage(ImageLoader.getRocketGray(), GamePanel.getRocket().get(0).getX(),
					GamePanel.getRocket().get(0).getY(), GamePanel.getRocket().get(0).getWidth(),
					GamePanel.getRocket().get(0).getHeight(), null);
			break;
		case 2:
			g.drawImage(ImageLoader.getRocketGreen(), GamePanel.getRocket().get(0).getX(),
					GamePanel.getRocket().get(0).getY(), GamePanel.getRocket().get(0).getWidth(),
					GamePanel.getRocket().get(0).getHeight(), null);
			break;
		case 3:
			g.drawImage(ImageLoader.getRocketRed(), GamePanel.getRocket().get(0).getX(),
					GamePanel.getRocket().get(0).getY(), GamePanel.getRocket().get(0).getWidth(),
					GamePanel.getRocket().get(0).getHeight(), null);
			break;
		case 4:
			g.drawImage(ImageLoader.getRocketYellow(), GamePanel.getRocket().get(0).getX(),
					GamePanel.getRocket().get(0).getY(), GamePanel.getRocket().get(0).getWidth(),
					GamePanel.getRocket().get(0).getHeight(), null);
			break;
		default:
			g.drawImage(ImageLoader.getRocketGray(), GamePanel.getRocket().get(0).getX(),
					GamePanel.getRocket().get(0).getY(), GamePanel.getRocket().get(0).getWidth(),
					GamePanel.getRocket().get(0).getHeight(), null);
			break;
		}

		// Color Laser
		switch (SettingsPanel.getLaserType()) {
		case 0:
			g.setColor(new Color(0, 0, 255));
			break;
		case 1:
			g.setColor(new Color(255, 0, 0));
			break;
		case 2:
			g.setColor(new Color(0, 255, 0));
			break;
		}

		for (int i = 0; i < GamePanel.getRocket().get(0).getLasers().size(); i++) {

			g.drawLine(GamePanel.getRocket().get(0).getLasers().get(i).getLaserX(),
					GamePanel.getRocket().get(0).getLasers().get(i).getLaserY(),
					GamePanel.getRocket().get(0).getLasers().get(i).getLaserX(),
					GamePanel.getRocket().get(0).getLasers().get(i).getLaserY() - 10);
		}

		for (int e = 0; e < GamePanel.getEnemiesTimer().getEnemies().size(); e++) {

			g.drawImage(ImageLoader.getEnemy(), GamePanel.getEnemiesTimer().getEnemies().get(e).getX(),
					GamePanel.getEnemiesTimer().getEnemies().get(e).getY(),
					GamePanel.getEnemiesTimer().getEnemies().get(0).getWidth(),
					GamePanel.getEnemiesTimer().getEnemies().get(0).getHeight(), null);
		}
		repaint();

	}

}
