package timeClock;

import java.util.ArrayList;

import game.Enemy;

public class EnemiesTimer implements Runnable {

	public static ArrayList<Enemy> enemies;
	private static boolean buildEnemies;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		enemies = new ArrayList<>();
		buildEnemies = true;

		while (buildEnemies) {
			if (buildEnemies) {
				try {
						enemies.add(new Enemy());
						System.out.println("Added Enemey");
						Thread.sleep(2000);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Added");
			}
		}
	}
	
	public static void setStart(boolean start)
	{
		buildEnemies = start;
	}

	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}

}