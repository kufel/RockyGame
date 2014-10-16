package edu.montclair.cs.game.hanglers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

import edu.montclair.cs.game.gameobjects.Rocky;
import edu.montclair.cs.game.screens.HUDScreen;

/**
 * The Class InputHandler.
 */
public class InputHandler implements InputProcessor{
	
	public Rocky myRocky;
	public HUDScreen myHud;
	
	/**
	 * Instantiates a new input handler.
	 *
	 * @param rocky the rocky
	 */
	public InputHandler(Rocky rocky) {
		myRocky = rocky;
		myHud = new HUDScreen();
	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.InputProcessor#touchDown(int, int, int, int)
	 */
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		myRocky.onTouchDown();
		myHud.setTouchDown();
		myHud.setMousePointer(Gdx.input.getX(), Gdx.input.getY());
		return false;
	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.InputProcessor#keyDown(int)
	 */
	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.InputProcessor#keyUp(int)
	 */
	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.InputProcessor#keyTyped(char)
	 */
	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.InputProcessor#touchUp(int, int, int, int)
	 */
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		myRocky.onTouchUp();
		myHud.setTouchUp();
		return false;
	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.InputProcessor#touchDragged(int, int, int)
	 */
	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		myHud.setMousePointer(Gdx.input.getX(), Gdx.input.getY());
		//	myHud.setMousePointer(screenX, screenY);
		return false;
	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.InputProcessor#mouseMoved(int, int)
	 */
	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	/* (non-Javadoc)
	 * @see com.badlogic.gdx.InputProcessor#scrolled(int)
	 */
	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
