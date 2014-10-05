package edu.montclair.cs.game.gameobjects;

import com.badlogic.gdx.math.Vector2;

// TODO: Auto-generated Javadoc
/**
 * The Class Scrollable.
 */
public class Scrollable {
	
	protected Vector2 position;
	protected Vector2 velocity;
	protected int width;
	protected int height;
	protected boolean isScrolledLeft;
	
	/**
	 * Instantiates a new scrollable.
	 *
	 * @param x the x
	 * @param y the y
	 * @param width the width
	 * @param height the height
	 * @param scrollSpeed the scroll speed
	 */
	public Scrollable(float x, float y, int width,int height, float scrollSpeed){
		position = new Vector2(x,y);
		velocity = new Vector2(scrollSpeed,0);
		this.width = width;
		this.height = height;
		isScrolledLeft = false;
	}
	
	/**
	 * Update.
	 *
	 * @param delta the delta
	 */
	public void update(float delta){
		position.add(velocity).cpy().scl(delta);
		
		if(position.x + width < 0){
			isScrolledLeft = true;
		}
	}
	
	/**
	 * Reset.
	 *
	 * @param newX the new x
	 */
	public void reset(float newX){
		position.x = newX;
		isScrolledLeft = false;
	}
	
	/**
	 * Checks if is scrool left.
	 *
	 * @return true, if is scrool left
	 */
	public boolean isScrolledLeft(){
		return isScrolledLeft;
	}
	
	/**
	 * Gets the tiil x.
	 *
	 * @return the tiil x
	 */
	public float getTiilX(){
		return position.x + width;
	}
	
	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public float getX(){
		return position.x;
	}
	
	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public float getY(){
		return position.y;
	}
	
	/**
	 * Gets the width.
	 *
	 * @return the width
	 */
	public int getWidth(){
		return width;
	}
	
	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	public int getHeight(){
		return height;
	}
}