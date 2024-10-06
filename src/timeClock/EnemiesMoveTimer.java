package timeClock;

import java.util.List;

import game.Enemy;
import gui.GamePanel;

public class EnemiesMoveTimer implements Runnable {

	private static boolean moveEnemies = true;

	@Override
	public void run() {

		while (true) {
			if (moveEnemies) {
				try {
					List<Enemy> enemies = GamePanel.getEnemiesTimer().getEnemies();
					if (enemies != null && enemies.size() > 0) {
						for (int e = 0; e < enemies.size(); e++) {
							Enemy enemy = enemies.get(e);
							enemy.setY(enemy.getY() + 1);
						}
						Thread.sleep(5);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void setMoveEnemies(boolean move) {
		moveEnemies = move;
	}
}
