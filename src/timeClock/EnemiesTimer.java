package timeClock;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import game.Enemy;

public class EnemiesTimer implements Runnable {

	private final List<Enemy> enemies = Collections.synchronizedList(new ArrayList<>());
	private static boolean buildEnemies;

	@Override
	public void run() {
		buildEnemies = true;

		while (true) {
			if (buildEnemies) {
				try {
					synchronized (enemies) {
						enemies.add(new Enemy());
					}
					System.out.println("Added Enemey");
					Thread.sleep(2000);

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Added");
			} else {
				enemies.clear();

			}
		}
	}

	public static void setStart(boolean start) {
		buildEnemies = start;
	}

	public List<Enemy> getEnemies() {
		return enemies;
	}

}