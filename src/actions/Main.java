package actions;

import game.ImageLoader;
import gui.MainFrame;
import timeClock.BackgroundTimer;
import timeClock.LaserTimer;

public class Main {

	public static void main(String[] args) {

		MainFrame frame = new MainFrame();

		frame.create();

		ImageLoader imageLoader = new ImageLoader();
		BackgroundTimer bgTimer = new BackgroundTimer(true);
		LaserTimer laserTimer = new LaserTimer();
		
		
	}

}
