package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JPanel;

import game.ImageLoader;

public class MenuPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton buttonSet, buttonEx;
	private int btnX = 150, btnY = 150, btnWidth = 200, btnHeight = 50;
	
	public MenuPanel() {

		this.setBackground(Color.BLACK);
		this.setLayout(null);

		buttonSet = new JButton("Settings");
		buttonSet.setBounds(btnX, btnY, btnWidth, btnHeight);
		buttonEx = new JButton("Exit");
		buttonEx.setBounds(btnX, btnY + 200, btnWidth, btnHeight);

		this.add(buttonSet);
		this.add(buttonEx);

		buttonSet.addActionListener(e -> MainFrame.showOtherCd("Settings"));
		buttonEx.addActionListener(e -> System.exit(0));
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2D = (Graphics2D) g;

		g2D.drawImage(ImageLoader.getBackground(1), 0, 0, MainFrame.getWidth(), MainFrame.getHeight(), null);
		
		repaint();
	}

}
