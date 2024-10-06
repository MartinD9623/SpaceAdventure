package timeClock;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import game.Laser;
import gui.GamePanel;

public class LaserTimer { // need correction: timer is getting faster after every use!!!

	private Timer timer;

	public LaserTimer() {

		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				if (BackgroundTimer.getStart()) {
					ArrayList<Laser> lasers = GamePanel.getRocket().get(0).getLasers();
					for (int i = 0; i < lasers.size(); i++) {
						Laser laser = lasers.get(i);
						laser.setLaserY(laser.getLaserY() - 1);
					}
				}

			}

		}, 0, 10);
	}

}
