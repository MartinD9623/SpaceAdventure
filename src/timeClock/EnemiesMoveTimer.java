package timeClock;

import java.util.ArrayList;

import game.Enemy;
import gui.GamePanel;

public class EnemiesMoveTimer implements Runnable {

	private static boolean moveEnemies = true;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// moveEnemies = true;

		while (moveEnemies) {

			try {
				if (GamePanel.getEnemiesTimer().getEnemies() != null) {
					ArrayList<Enemy> enemies = GamePanel.getEnemiesTimer().getEnemies();
					for (int e = 0; e < enemies.size(); e++) {
						Enemy enemy = enemies.get(e);
						enemy.setY(enemy.getY() + 1);
					}
					Thread.sleep(5);
				}

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
