package timeClock;

import gui.GamePanel;
import gui.MainFrame;

public class CollisionTimer implements Runnable {

	private boolean running = true;
	int enemyX, enemyY, laserX, laserY, rocketX, rocketY;
	int enemyWidth, enemyHeight, rocketWidth, rocketHeight;

	@Override
	public void run() {
		// TODO Auto-generated method stub

		while (running) {

			// Collide Enemy + Laser
			for (int e = 0; e < GamePanel.getEnemiesTimer().getEnemies().size(); e++) {

				enemyX = GamePanel.getEnemiesTimer().getEnemies().get(e).getX();
				enemyY = GamePanel.getEnemiesTimer().getEnemies().get(e).getY();
				enemyWidth = GamePanel.getEnemiesTimer().getEnemies().get(e).getWidth();
				enemyHeight = GamePanel.getEnemiesTimer().getEnemies().get(e).getHeight();

				for (int l = 0; l < GamePanel.getRocket().get(0).getLasers().size(); l++) {

					laserX = GamePanel.getRocket().get(0).getLasers().get(l).getLaserX();
					laserY = GamePanel.getRocket().get(0).getLasers().get(l).getLaserY();

					if (enemyX <= laserX && (enemyX + enemyWidth) >= laserX
							&& (laserY - 10) <= (enemyY + enemyHeight)) {
						if (enemyY < MainFrame.getHeight() && laserY > 0) {
							GamePanel.getEnemiesTimer().getEnemies().remove(e);
							GamePanel.getRocket().get(0).getLasers().remove(l);
							System.out.println("Collide Laser / Enemy!");
							break;
						}
					}
				}

				// Collide Enemy + Rocket

				rocketX = GamePanel.getRocket().get(0).getX();
				rocketY = GamePanel.getRocket().get(0).getY();
				rocketWidth = GamePanel.getRocket().get(0).getWidth();
				rocketHeight = GamePanel.getRocket().get(0).getHeight();

				if (((rocketX >= enemyX && rocketX <= enemyX + enemyWidth)
						|| (rocketX + rocketWidth >= enemyX && rocketX + rocketWidth <= enemyX + enemyWidth))
						&& ((enemyY >= rocketY && enemyY <= rocketY + rocketHeight) || (enemyY + enemyHeight >= rocketY
								&& enemyY + enemyHeight <= rocketY + rocketHeight))) {
					GamePanel.getEnemiesTimer().getEnemies().remove(e);
					GamePanel.getRocket().get(0).setX(250);
					GamePanel.getRocket().get(0).setY(450);

					BackgroundTimer.setStart(false);
					EnemiesTimer.setStart(false);

					break;

				}
			}

		}
	}
}