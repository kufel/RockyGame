package edu.montclair.cs.game.gameobjects;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import edu.montclair.cs.game.screens.GameOverScreen;

/**
 * The Class ScrollHandler.
 */
public class ScrollHandler {

	private Background frontBackground, backBackground;
	private Car car1, car2, car3;
	
	public static final int SCROLL_SPEED = -10;
	public static final int CAR_GAP = 750;
	
	/**
	 * Instantiates a new scroll handler.
	 *
	 * @param yPos the y pos
	 */
	public ScrollHandler(float yPos){
		frontBackground = new Background(0, yPos, 720, 1280, SCROLL_SPEED);
		backBackground = new Background(frontBackground.getTiilX(), yPos, 720, 1280, SCROLL_SPEED);
		
		car1 = new Car(300, 1280-400, 400, 400, SCROLL_SPEED);
		car2 = new Car(car1.getTiilX() + CAR_GAP, 1280-400, 400, 400, SCROLL_SPEED);
		car3 = new Car(car2.getTiilX() + CAR_GAP, 1280-400, 400, 400, SCROLL_SPEED);
	}
	
	/**
	 * Update.
	 *
	 * @param delta the delta
	 */
	public void update(float delta){
		// update objects
		frontBackground.update(delta);
		backBackground.update(delta);
		car1.update(delta);
		car2.update(delta);
		car3.update(delta);
		
		// check to see if cars are scrolled left
		if (car1.isScrolledLeft()) {
			car1.reset(car3.getTiilX() + CAR_GAP);
		} else if (car2.isScrolledLeft()) {
			car2.reset(car1.getTiilX() + CAR_GAP);
		} else if (car3.isScrolledLeft()) {
			car3.reset(car2.getTiilX() + CAR_GAP);
		}
		
		// check if backgrounds are scrolled
		if (frontBackground.isScrolledLeft()) {
			frontBackground.reset(backBackground.getTiilX());
		} else if (backBackground.isScrolledLeft()) {
			backBackground.reset(frontBackground.getTiilX());
		}
	}
	
	/**
	 * Stop.
	 */
	public void stop() {
		frontBackground.stop();
		backBackground.stop();
		car1.stop();
		car2.stop();
		car3.stop();
		((Game)Gdx.app.getApplicationListener()).setScreen(new GameOverScreen());
	}
	
	/**
	 * Collides.
	 *
	 * @param rocky the rocky
	 * @return true, if successful
	 */
	public boolean collides(Rocky rocky){
		return (car1.collides(rocky) || car2.collides(rocky) || car3.collides(rocky));
	}

	/**
	 * Gets the front background.
	 *
	 * @return the front background
	 */
	public Background getFrontBackground() {
		return frontBackground;
	}

	/**
	 * Gets the back background.
	 *
	 * @return the back background
	 */
	public Background getBackBackground() {
		return backBackground;
	}

	/**
	 * Gets the car1.
	 *
	 * @return the car1
	 */
	public Car getCar1(){
		return car1;
	}
	
	/**
	 * Gets the car2.
	 *
	 * @return the car2
	 */
	public Car getCar2(){
		return car2;
	}
	
	/**
	 * Gets the car3.
	 *
	 * @return the car3
	 */
	public Car getCar3(){
		return car3;
	}
}