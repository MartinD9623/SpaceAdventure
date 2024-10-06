package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JPanel;

import game.ImageLoader;
import timeClock.BackgroundTimer;

public class SettingsPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton btnLrocket, btnRrocket;
	private JButton btnLdif, btnRdif;
	private JButton btnToMenu, btnGame;
	public static int rocketType;
	public static int laserType;

	public SettingsPanel() {
		this.setBackground(Color.BLACK);
		this.setLayout(null);

		rocketType = 1;

		btnLrocket = new JButton("<");
		btnLrocket.setBounds(150, 100, 50, 50);
		btnLrocket.addActionListener(e -> {
			if (SettingsPanel.getRocketType() > 1) {
				SettingsPanel.setRocketType(SettingsPanel.getRocketType() - 1);
			} else {
				SettingsPanel.setRocketType(4);
			}
		});
		btnRrocket = new JButton(">");
		btnRrocket.setBounds(300, 100, 50, 50);
		btnRrocket.addActionListener(e -> {
			if (SettingsPanel.getRocketType() < 4) {
				SettingsPanel.setRocketType(SettingsPanel.getRocketType() + 1);
			} else {
				SettingsPanel.setRocketType(1);
			}
		});
		this.add(btnLrocket);
		this.add(btnRrocket);

		btnLdif = new JButton("<");
		btnLdif.addActionListener(e -> {
			if (!(SettingsPanel.laserType == 0)) {
				SettingsPanel.setLaserType(SettingsPanel.getLaserType() - 1);
			} else {
				SettingsPanel.setLaserType(2);
			}
		});
		btnRdif = new JButton(">");
		btnRdif.addActionListener(e -> {
			if (!(SettingsPanel.laserType == 2)) {
				SettingsPanel.setLaserType(SettingsPanel.getLaserType() + 1);
			} else {
				SettingsPanel.setLaserType(0);
			}
		});
		btnLdif.setBounds(150, 300, 50, 50);
		btnRdif.setBounds(300, 300, 50, 50);
		this.add(btnLdif);
		this.add(btnRdif);

		btnToMenu = new JButton("Back to Menu");
		btnToMenu.setBounds(50, 450, 150, 50);
		btnToMenu.addActionListener(e -> MainFrame.showOtherCd("Menu"));

		btnGame = new JButton("Start Game");
		btnGame.setBounds(300, 450, 150, 50);
		btnGame.addActionListener(e -> {
			MainFrame.showOtherCd("Game");
			BackgroundTimer.setStart(true);
			//timing = true;
		});

		this.add(btnToMenu);
		this.add(btnGame);

	}

	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D) g;

		g2D.drawImage(ImageLoader.getBackground(), 0, -600 + BackgroundTimer.getBackgroundY(), MainFrame.getWidth(),
				MainFrame.getHeight(), null);

		g2D.drawImage(ImageLoader.getBackground2(), 0, BackgroundTimer.getBackgroundY(), MainFrame.getWidth(),
				MainFrame.getHeight(), null);

		switch (rocketType) {
		case 1:
			g.drawImage(ImageLoader.getRocketGray(), 225, 50, 50, 100, null);
			break;
		case 2:
			g.drawImage(ImageLoader.getRocketGreen(), 225, 50, 50, 100, null);
			break;
		case 3:
			g.drawImage(ImageLoader.getRocketRed(), 225, 50, 50, 100, null);
			break;
		case 4:
			g.drawImage(ImageLoader.getRocketYellow(), 225, 50, 50, 100, null);
			break;
		default:
			g.drawImage(ImageLoader.getRocketGray(), 225, 50, 50, 100, null);
			break;
		}

		// laserType
		switch (laserType) {
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
		g.fillRect(225, 300, 50, 50);

		repaint();
	}

	public static int getRocketType() {
		return rocketType;
	}

	public static void setRocketType(int rocketType) {
		SettingsPanel.rocketType = rocketType;
	}

	public static int getLaserType() {
		return laserType;
	}

	public static void setLaserType(int laserType) {
		SettingsPanel.laserType = laserType;
	}

}
