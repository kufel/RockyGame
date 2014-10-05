package edu.montclair.cs.game.rockygame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import edu.montclair.cs.game.rockygame.MyGame;

/**
 * The Class DesktopLauncher.
 */
public class DesktopLauncher {
	
	/**
	 * The main method.
	 *
	 * @param arg the arguments
	 */
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Rocky Game";
        config.width = 480;
        config.height = 720;
		new LwjglApplication(new MyGame(), config);
	}
}
