package gui;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import timeClock.EnemiesTimer;

public class MainFrame{
	
	private JFrame frame;
	private static final int width = 500, height = 600;
	
	private static JPanel container;
	private static CardLayout cd;
	private MenuPanel menuPanel;
	private SettingsPanel settingsPanel;
	private GamePanel gamePanel;
	
	public void create () {
		
		frame = new JFrame();
		frame.setSize(width, height);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		cd = new CardLayout();
		container = new JPanel(cd);
		
		menuPanel = new MenuPanel();
		settingsPanel = new SettingsPanel();
		gamePanel = new GamePanel();
		
		container.add(menuPanel, "Menu");
		container.add(settingsPanel, "Settings");
		container.add(gamePanel, "Game");
		
		cd.show(container, "Menu");
		frame.add(container);
		
		frame.setVisible(true);
		
	}
	
	public static void showOtherCd(String panel)
	{
		cd.show(container, panel);
	}
	
	
	public static int getWidth() {
		return width;
	}
	
	public static int getHeight() {
		return height;
	}
	
	/*public static JPanel getContainer() {
		return container;
	}
	
	public static CardLayout getCd() {
		return cd;
	}

	public static MenuPanel getMenuPanel() {
		return menuPanel;
	}

	public static SettingsPanel getSettingsPanel() {
		return settingsPanel;
	}

	public static GamePanel getGamePanel() {
		return gamePanel;
	}*/

}
