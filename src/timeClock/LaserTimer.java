package timeClock;

import java.util.Timer;
import java.util.TimerTask;
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
					for (int i = 0; i < GamePanel.getRocket().get(0).getLasers().size(); i++) {
						GamePanel.getRocket().get(0).getLasers().get(i)
								.setLaserY(GamePanel.getRocket().get(0).getLasers().get(i).getLaserY() - 1);
					}
				}

			}

		}, 0, 10);
	}

}
