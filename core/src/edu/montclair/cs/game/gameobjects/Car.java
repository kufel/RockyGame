package edu.montclair.cs.game.gameobjects;


import java.util.Random;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

/**
 * The Class Car.
 */
public class Car extends Scrollable{
	
	private Random random;
	
	private Rectangle obsticleCar;
	
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
		obsticleCar = new Rectangle();
	}
	
	@Override
	public void update(float delta){
		// Call the update method in the superclass (Scrollable)
		super.update(delta);
	
		// The set() method allows you to set the top left corner's x, y
        // coordinates,
        // along with the width and height of the rectangle
		obsticleCar.set(position.x, position.y, width, height);;
	}

	/**
	 * Reset.
	 *
	 * @param newX the new x
	 */
	@Override
	public void reset(float newX) {
		super.reset(newX);
		//height = random.nextInt(90) + 15;
	}
	
	/**
	 * Gets the car hit box.
	 *
	 * @return the car hit box
	 */
	public Rectangle getCarHitBox(){
		return obsticleCar;
	}
	
	/**
	 * Collides.
	 *
	 * @param rocky the rocky
	 * @return true, if successful
	 */
	public boolean collides(Rocky rocky){
		if (position.x < rocky.getX() + rocky.getWidth()) {
			return (Intersector.overlaps(rocky.getHitBox(), obsticleCar));
		}
		return false;
	}
}
