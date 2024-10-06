package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import game.Rocket;
import timeClock.BackgroundTimer;
import timeClock.CollisionTimer;
import timeClock.EnemiesMoveTimer;
import timeClock.EnemiesTimer;

public class GamePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DrawGame drawGame;
	private static ArrayList<Rocket> rocket;
	private static EnemiesTimer enemiesTimer;
	private Thread thread, thread2, thread3;
	private static EnemiesMoveTimer enemiesMoveTimer;
	private CollisionTimer collisionTimer;
	private static TimingAction timingAction;

	public GamePanel() {

		drawGame = new DrawGame();
		rocket = new ArrayList<Rocket>();
		rocket.add(new Rocket());

		enemiesTimer = new EnemiesTimer();
		thread = new Thread(enemiesTimer);
		thread.start();

		enemiesMoveTimer = new EnemiesMoveTimer();
		thread2 = new Thread(enemiesMoveTimer);
		thread2.start();

		collisionTimer = new CollisionTimer();
		thread3 = new Thread(collisionTimer);
		thread3.start();

		this.setBackground(Color.BLACK);

		this.setLayout(null);
		drawGame.setBounds(0, 0, MainFrame.getWidth(), MainFrame.getHeight());
		drawGame.setVisible(true);

		this.add(drawGame);

		// KeyBindings
		this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("W"), "upAction");
		this.getActionMap().put("upAction", Rocket.getUpAction());

		this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("S"), "downAction");
		this.getActionMap().put("downAction", Rocket.getDownAction());

		this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("A"), "leftAction");
		this.getActionMap().put("leftAction", Rocket.getLeftAction());

		this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("D"), "rightAction");
		this.getActionMap().put("rightAction", Rocket.getRightAction());

		this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("SPACE"), "shootAction");
		this.getActionMap().put("shootAction", Rocket.getShootAction());

		timingAction = new TimingAction();
		this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ENTER"), "timing");
		this.getActionMap().put("timing", GamePanel.getTimingAction());
		// this.getActionMap().put("timing", GamePanel.restart());

		this.setVisible(true);
	}

	public class TimingAction extends AbstractAction {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			BackgroundTimer.setStart(true);
			EnemiesTimer.setStart(true);
			EnemiesMoveTimer.setMoveEnemies(true);
		}
	}

	public static TimingAction getTimingAction() {
		return timingAction;
	}

	public static EnemiesTimer getEnemiesTimer() {
		return enemiesTimer;
	}

	public static EnemiesMoveTimer getEnemiesMoveTimer() {
		return enemiesMoveTimer;
	}

	public static ArrayList<Rocket> getRocket() {
		return rocket;
	}

}
