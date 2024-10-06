package game;

import gui.GamePanel;

public class Laser {

	private int laserX, laserY;

	public Laser() {

		laserX = GamePanel.getRocket().get(0).getX() + 20;
		laserY = GamePanel.getRocket().get(0).getY();

	}

	public int getLaserX() {
		return laserX;
	}

	public void setLaserX(int laserX) {
		this.laserX = laserX;
	}

	public int getLaserY() {
		return laserY;
	}

	public void setLaserY(int laserY) {
		this.laserY = laserY;
	}

}
