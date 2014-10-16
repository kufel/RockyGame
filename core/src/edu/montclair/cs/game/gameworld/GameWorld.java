package edu.montclair.cs.game.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

import edu.montclair.cs.game.gameobjects.Rocky;
import edu.montclair.cs.game.gameobjects.ScrollHandler;

/**
 * The Class GameWorld.
 */
public class GameWorld {
	
	private Rocky rocky;
	private ScrollHandler scroller;
	
	/**
	 * Instantiates a new game world.
	 */
	public GameWorld(int midpointY){
		rocky = new Rocky(50, midpointY + 320, 360 / 2, 640 / 2);
		scroller = new ScrollHandler(0);
	}

	/**
	 * Update.
	 *
	 * @param delta the delta
	 */
	public void update(float delta) {
		//Gdx.app.log("GameWorld", "update");
		rocky.update(delta);
		scroller.update(delta);
		
		if (scroller.collides(rocky)) {
	        // Clean up on game over
	        scroller.stop();
	    }
	}
	
	/**
	 * Gets the rocky.
	 *
	 * @return the rocky
	 */
	public Rocky getRocky(){
		return rocky;
	}
	
	/**
	 * Gets the scroller.
	 *
	 * @return the scroller
	 */
	public ScrollHandler getScroller(){
		return scroller;
	}
}