package timeClock;

import java.util.Timer;
import java.util.TimerTask;
import gui.MainFrame;

public class BackgroundTimer {

	private Timer timer;
	private static int backgroundY = 0, backgroundYY = -3000;
	//public static boolean timing = true;
	private static boolean backgroundStart;

	public BackgroundTimer(boolean start) {
		backgroundStart = start;
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {

			@Override

			public void run() {
				if (backgroundStart == true) {//BackgroundTimer.timing) {
					if (backgroundY < MainFrame.getHeight()) {
						backgroundY += 5;
					} else {
						backgroundY = 0;
					}
				}
			}
		}, 0, 50);
	}

	/*public static boolean getTiming() {
		return timing;
	}*/
	
	public static void setStart(boolean start)
	{
		backgroundStart = start;
	}
	
	public static boolean getStart()
	{
		return backgroundStart;
	}

	public static int getBackgroundY() {
		return backgroundY;
	}

	public static int getBackgroundYY() {
		return backgroundYY;
	}

}
