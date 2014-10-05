package edu.montclair.cs.game.gameobjects;

import java.util.Random;

/**
 * The Class Car.
 */
public class Car extends Scrollable{
	
	private Random random;
	
	/**
	 * Instantiates a new car.
	 *
	 * @param x the x
	 * @param y the y
	 * @param width the width
	 * @param height the height
	 * @param scrollSpeed the scroll speed
	 */
	public Car(float x, float y, int width, int height, float scrollSpeed) {
		super(x, y, width, height, scrollSpeed);
		random = new Random();
	}

	/**
	 * Reset.
	 *
	 * @param newX the new x
	 */
	@Override
	public void reset(float newX) {
		super.reset(newX);
		height = random.nextInt(90) + 15;
	}
}
