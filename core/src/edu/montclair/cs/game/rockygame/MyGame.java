package edu.montclair.cs.game.rockygame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import edu.montclair.cs.game.hanglers.AssetLoader;
import edu.montclair.cs.game.screens.GameScreen;

/**
 * The Class MyGame.
 */
public class MyGame extends Game{ 
	
	/* (non-Javadoc)
	 * @see com.badlogic.gdx.ApplicationListener#create()
	 */
	@Override
	public void create() {
		Gdx.app.log("RockyGame", "created");
		AssetLoader.load();
		setScreen(new GameScreen());
	}
	
	/* (non-Javadoc)
	 * @see com.badlogic.gdx.Game#dispose()
	 */
	@Override
	public void dispose(){
		super.dispose();
		AssetLoader.dispose();
	}
	
}
