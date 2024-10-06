package timeClock;

import gui.GamePanel;

public class EnemiesMoveTimer implements Runnable {

	private static boolean moveEnemies = true;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//moveEnemies = true;

		while (moveEnemies) {

			try {
				if (GamePanel.getEnemiesTimer().getEnemies() != null)
				{
				for (int e = 0; e < GamePanel.getEnemiesTimer().getEnemies().size(); e++)
					GamePanel.getEnemiesTimer().getEnemies().get(e)
							.setY(GamePanel.getEnemiesTimer().getEnemies().get(e).getY() + 1);
				Thread.sleep(5);
				}

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
