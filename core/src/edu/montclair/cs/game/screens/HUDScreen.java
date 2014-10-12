package edu.montclair.cs.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * The Class HUDScreen.
 */
public class HUDScreen{
	
	private Stage stage = new Stage();
    private Table table = new Table();

    private Skin skin = new Skin(Gdx.files.internal("skins/uiskin.json"),
            new TextureAtlas(Gdx.files.internal("skins/uiskin.atlas")));

    private Label title = new Label("Score: ", skin);
    
    /**
     * Instantiates a new HUD screen.
     */
    public HUDScreen(){
    	initDraw();
    	// initActionHandlers();
    }

	/**
	 * Render.
	 *
	 * @param delta the delta
	 */
	public void render(float delta) {
	//	Gdx.gl.glClearColor(0, 0, 0, 1);
     //   Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
	}
	
	/**
	 * Show.
	 */
	public void initDraw() {
		//The elements are displayed in the order you add them.
        //The first appear on top, the last at the bottom.
		table.top().left();
        table.add(title);

        table.setFillParent(true);
        stage.addActor(table);

        Gdx.input.setInputProcessor(stage);
	}
	
	/**
	 * Inits the action handlers.
	 */
	public void initActionHandlers(){
	}

	/**
	 * Hide.
	 */
	public void hide() {
		dispose();
	}

	/**
	 * Dispose.
	 */
	public void dispose() {
		stage.dispose();
		skin.dispose();
	}
}