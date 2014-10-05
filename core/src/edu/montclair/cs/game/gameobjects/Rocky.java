package edu.montclair.cs.game.gameobjects;

import com.badlogic.gdx.math.Vector2;

/**
 * The Class Rocky.
 */
public class Rocky {
	
	private Vector2 position;
	private Vector2 velocity;
	private Vector2 acceleration;
	private float rotation;
	private int width;
	private int height;
	
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
		acceleration = new Vector2(0, 950);
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
		}

		// Rotate on jump
		if (velocity.y < 0) {
			rotation -= 480 * delta;
			if (rotation < 5) {
				rotation = 5;
			}
		}

		// rotate on land
		if (velocity.y > 0) {
			rotation += 480 * delta;
			if (rotation > -10) {
				rotation = -10;
;			} else if(position.y > 900){
				rotation = 2;
			}
		}
	}
	
	/**
	 * On click.
	 */
	public void onClick(){
		velocity.y = -750;
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
}