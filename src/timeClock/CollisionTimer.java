package timeClock;

import java.util.ArrayList;

import game.Enemy;
import game.Laser;
import game.Rocket;
import gui.GamePanel;
import gui.MainFrame;

public class CollisionTimer implements Runnable {

	private boolean running = true;
	int enemyX, enemyY, laserX, laserY, rocketX, rocketY;
	int enemyWidth, enemyHeight, rocketWidth, rocketHeight;
	private final Rocket rocket = GamePanel.getRocket().get(0);

	@Override
	public void run() {
		// TODO Auto-generated method stub

		while (running) {

			ArrayList<Enemy> enemies = GamePanel.getEnemiesTimer().getEnemies();

			for (int e = 0; e < enemies.size(); e++) {

				Enemy enemy = enemies.get(e);
				enemyX = enemy.getX();
				enemyY = enemy.getY();
				enemyWidth = enemy.getWidth();
				enemyHeight = enemy.getHeight();

				// Collide Enemy + Laser
				ArrayList<Laser> lasers = rocket.getLasers();
				for (int l = 0; l < lasers.size(); l++) {

					Laser laser = lasers.get(l);
					laserX = laser.getLaserX();
					laserY = laser.getLaserY();

					if (enemyX <= laserX && (enemyX + enemyWidth) >= laserX
							&& (laserY - 10) <= (enemyY + enemyHeight)) {
						if (enemyY < MainFrame.getHeight() && laserY > 0) {
							GamePanel.getEnemiesTimer().getEnemies().remove(e);
							rocket.getLasers().remove(l);
							System.out.println("Collide Laser / Enemy!");
							break;
						}
					}
				}

				// Collide Enemy + Rocket
				rocketX = rocket.getX();
				rocketY = rocket.getY();
				rocketWidth = rocket.getWidth();
				rocketHeight = rocket.getHeight();
				if (rocketCollidesWithEnemy(rocketX, rocketY, rocketWidth, rocketHeight, enemyX, enemyY, enemyWidth,
						enemyHeight)) {
					enemies.remove(e);
					rocket.setX(250);
					rocket.setY(450);
					BackgroundTimer.setStart(false);
					// EnemiesMoveTimer.setMoveEnemies(false);
					EnemiesTimer.setStart(false);
					break;
				}
			}
		}
	}

	private boolean rocketCollidesWithEnemy(int rocketX, int rocketY, int rocketWidth, int rocketHeight,
			int enemyX, int enemyY, int enemyWidth, int enemyHeight) {
		boolean collidesX = rocketX < enemyX + enemyWidth && rocketX + rocketWidth > enemyX;
		boolean collidesY = rocketY < enemyY + enemyHeight && rocketY + rocketHeight > enemyY;
		return collidesX && collidesY;
	}
}