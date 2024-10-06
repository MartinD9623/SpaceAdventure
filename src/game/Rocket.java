package game;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;

import gui.GamePanel;

public class Rocket {

	private int x, y;
	private int width = 40, height = 70;
	private ArrayList<Laser> lasers;
	private int shoot;

	private static UpAction upAction;
	private static DownAction downAction;
	private static LeftAction leftAction;
	private static RightAction rightAction;
	private static ShootAction shootAction;

	public Rocket() {

		x = 250;
		y = 450;
		shoot = 0;

		lasers = new ArrayList<>();

		upAction = new UpAction();
		downAction = new DownAction();
		leftAction = new LeftAction();
		rightAction = new RightAction();
		shootAction = new ShootAction();

	}

	public class UpAction extends AbstractAction {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			Rocket rocket = GamePanel.getRocket().get(0);
			if (rocket.getY() >= 5) {
				rocket.setY(rocket.getY() - 5);
			}
		}
	}

	public class DownAction extends AbstractAction {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			Rocket rocket = GamePanel.getRocket().get(0);
			if (rocket.getY() <= 490) {
				rocket.setY(rocket.getY() + 5);
			}
		}
	}

	public class LeftAction extends AbstractAction {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			Rocket rocket = GamePanel.getRocket().get(0);
			if (rocket.getX() >= 5) {
				rocket.setX(rocket.getX() - 5);
			}
		}
	}

	public class RightAction extends AbstractAction {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			Rocket rocket = GamePanel.getRocket().get(0);
			if (rocket.getX() <= 440) {
				rocket.setX(rocket.getX() + 5);
			}
		}
	}

	public class ShootAction extends AbstractAction {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			Rocket rocket = GamePanel.getRocket().get(0);
			rocket.setShoot(1);
			rocket.lasers.add(new Laser());
		}
	}

	public static UpAction getUpAction() {
		return upAction;
	}

	public static DownAction getDownAction() {
		return downAction;
	}

	public static LeftAction getLeftAction() {
		return leftAction;
	}

	public static RightAction getRightAction() {
		return rightAction;
	}

	public static ShootAction getShootAction() {
		return shootAction;
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
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getShoot() {
		return shoot;
	}

	public void setShoot(int shoot) {
		this.shoot = shoot;
	}

	public ArrayList<Laser> getLasers() {
		return lasers;
	}

}
