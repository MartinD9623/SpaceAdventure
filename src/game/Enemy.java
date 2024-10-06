package game;

import java.util.Random;

import gui.MainFrame;

public class Enemy {

	private int x, y;
	private int width = 40, height = 25; 
	private Random random;

	public Enemy() {

		random = new Random();
		x = random.nextInt(MainFrame.getWidth() - 70);
		y = -10;

	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		// TODO Auto-generated method stub
		return width;
	}

	public int getHeight() {
		// TODO Auto-generated method stub
		return height;
	}
}
