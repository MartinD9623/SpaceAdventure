package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

import game.Enemy;
import game.ImageLoader;
import game.Laser;
import game.Rocket;
import timeClock.BackgroundTimer;

public class DrawGame extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D) g;

		Rocket rocket = GamePanel.getRocket().get(0);

		g2D.drawImage(ImageLoader.getBackground(1), 0, -600 + BackgroundTimer.getBackgroundY(), MainFrame.getWidth(),
				MainFrame.getHeight(), null);

		g2D.drawImage(ImageLoader.getBackground(2), 0, BackgroundTimer.getBackgroundY(), MainFrame.getWidth(),
				MainFrame.getHeight(), null);

		g.drawImage(ImageLoader.getRocket(SettingsPanel.rocketType), rocket.getX(),
				rocket.getY(), rocket.getWidth(),
				rocket.getHeight(), null);

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

		ArrayList<Laser> lasers = rocket.getLasers();
		for (int i = 0; i < lasers.size(); i++) {

			Laser laser = lasers.get(i);
			g.drawLine(laser.getLaserX(),
					laser.getLaserY(),
					laser.getLaserX(),
					laser.getLaserY() - 10);
		}

		List<Enemy> enemies = GamePanel.getEnemiesTimer().getEnemies();

		for (int e = 0; e < enemies.size(); e++) {
			Enemy enemy = enemies.get(e);
			g.drawImage(ImageLoader.getEnemy(), enemy.getX(),
					enemy.getY(),
					enemy.getWidth(),
					enemy.getHeight(), null);
		}
		repaint();

	}

}
