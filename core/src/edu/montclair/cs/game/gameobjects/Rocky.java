package edu.montclair.cs.game.gameobjects;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import edu.montclair.cs.game.screens.HUDScreen;

/**
 * The Class Rocky.
 */
public class Rocky {
	
	private HUDScreen hud;
	
	private Vector2 position;
	private Vector2 velocity;
	private Vector2 acceleration;
	private float rotation;
	private int width;
	private int height;
	private Rectangle bountingRectangle;
	private long startTimer, elapsedTime;
	private boolean isOnGround;

	/**
	 * Instantiates a new rocky.
	 *
	 * @param x the x
	 * @param y the y
	 * @param width the width
	 * @param height the height
	 */
	public Rocky(float x, float y, int width, int height){
		this.width = width;
		this.height = height;
		position = new Vector2(x, y);
		velocity = new Vector2(0, 0);
		acceleration = new Vector2(0, 750);
		bountingRectangle = new Rectangle();
		isOnGround = false;
		hud = new HUDScreen();
	}
	
	/**
	 * Update.
	 *
	 * @param delta the delta
	 */
	public void update(float delta){
		velocity.add(acceleration.cpy().scl(delta));
		
		// Set a maximum downwards velocity for Rocky
		if(velocity.y > 500){
			velocity.y = 500;
		}
		
		position.add(velocity.cpy().scl(delta));
		
		// Set a floor for rocky
		if(position.y > 900){
			position.y = 900;
			isOnGround = true;
		}

		// Rotate on jump
		if (velocity.y < 0) {
			rotation -= 180 * delta;
			if (rotation < 5) {
				rotation = 5;
			}
		}

		// rotate on land
		if (velocity.y > 0) {
			rotation += 180 * delta;
			if (rotation > -10) {
				rotation = -10;
;			} else if(position.y > 900){
				rotation = 2;
			}
		}
		
		// Set the rectangle position for hit detection
		bountingRectangle.set(position.x, position.y, 360/2, 640/2);
		
		// update jump indicator
		int jumpRingIndicator = 0;
		if (elapsedTime < 75) {
			jumpRingIndicator = 1;
		} else if(elapsedTime <= 200){
			jumpRingIndicator = 2;
		} else if(elapsedTime <= 250){
			jumpRingIndicator = 3;
		}
		hud.setJumpRingIndicaotr(jumpRingIndicator);
		jumpRingIndicator = 0;
	}
	
	/**
	 * On touch down.
	 */
	public void onTouchDown(){
		if (isOnGround) {
			startTimer = System.currentTimeMillis();
		}
	}
	
	/**
	 * On touch up.
	 */
	public void onTouchUp(){
		if (isOnGround) {
			
			isOnGround = false;
			
			elapsedTime = System.currentTimeMillis() - startTimer;
			System.out.println("Start Time: " + startTimer);
			System.out.println("Elapsed Time: " + elapsedTime);
			
			if (elapsedTime > 250) {
				elapsedTime = 250;
			}
			System.out.println("Formated Time: " + elapsedTime);
			
			int v0 = 950 / 250;
			int vf = (-1) * (int) (elapsedTime * v0);
			System.out.println("Vf jump: " + vf);
			
			velocity.y = vf;
			elapsedTime = 0;
		}
	}
	
	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public float getX() {
        return position.x;
    }

    /**
     * Gets the y.
     *
     * @return the y
     */
    public float getY() {
        return position.y;
    }

    /**
     * Gets the width.
     *
     * @return the width
     */
    public float getWidth() {
        return width;
    }

    /**
     * Gets the height.
     *
     * @return the height
     */
    public float getHeight() {
        return height;
    }
    
    /**
     * Gets the rotation.
     *
     * @return the rotation
     */
    public float getRotation(){
    	return rotation;
    }
    
    /**
     * Gets the hit box.
     *
     * @return the hit box
     */
    public Rectangle getHitBox(){
    	return bountingRectangle;
    }
}