package edu.montclair.cs.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

/**
 * The Class HUDScreen.
 */
public class HUDScreen {
	
	private ShapeRenderer shapeRenderer;
	private static boolean mouseDown;
	
	private static int jumpRingIndicator, screenX, screenY;
	
	private Stage stage = new Stage();
    private Table table = new Table();

    private Skin skin = new Skin(Gdx.files.internal("skins/uiskin.json"),
            new TextureAtlas(Gdx.files.internal("skins/uiskin.atlas")));

    private Label title = new Label("Score: ", skin);
    
    /**
     * Instantiates a new HUD screen.
     */
    public HUDScreen(){
    	mouseDown = false;
    	jumpRingIndicator = 0;
    	screenX = 0;
    	screenY = 0;
    	
    	shapeRenderer = new ShapeRenderer();
    	
    	initDraw();
    }

	/**
	 * Render.
	 *
	 * @param delta the delta
	 */
	public void render(float delta) {
		drawJumpIndicator();
		
		stage.act();
		stage.draw();
	}
	
	/**
	 * Draw jump indicator.
	 */
	public void drawJumpIndicator(){
//	System.out.println(mouseDown);
		if(mouseDown){
        	//System.out.println("called");
			shapeRenderer.begin(ShapeType.Line);
			if (jumpRingIndicator == 1 || jumpRingIndicator == 2
					|| jumpRingIndicator == 3) {
				shapeRenderer.setColor(0 / 255.0f, 200 / 255.0f, 0 / 255.0f, 1);
				shapeRenderer.circle(screenX, screenY, 21);
			}
			if (jumpRingIndicator == 1 || jumpRingIndicator == 2) {
				shapeRenderer.setColor(255 / 255.0f, 250 / 255.0f, 0 / 255.0f,
						1);
				shapeRenderer.circle(screenX, screenY, 22);
			}
			if (jumpRingIndicator == 3) {
				shapeRenderer.setColor(250 / 255.0f, 0 / 255.0f, 0 / 255.0f,
						1);
				shapeRenderer.circle(screenX, screenY, 25);
			}
			shapeRenderer.end();
        }
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
	 * Sets the touch down.
	 */
	public void setTouchDown(){
		mouseDown = true;
		System.out.println("Press Down");
	}
	
	/**
	 * Sets the touch up.
	 */
	public void setTouchUp(){
		mouseDown = false;
		System.out.println("Press Up");
	}
	
	/**
	 * Sets the mouse pointer.
	 *
	 * @param screenX the screen x
	 * @param screenY the screen y
	 */
	public void setMousePointer(int screenX, int screenY) {
		this.screenX = screenX;
		this.screenY = screenY;		
	}

	/**
	 * Sets the jump ring indicator.
	 *
	 * @param jumpRingIndicator the new jump ring indicator
	 */
	public void setJumpRingIndicaotr(int jumpRingIndicator) {
		this.jumpRingIndicator = jumpRingIndicator;	
		//System.out.println("Jump indicator " + jumpRingIndicator);
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