package edu.montclair.cs.game.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;

import edu.montclair.cs.game.gameobjects.Background;
import edu.montclair.cs.game.gameobjects.Car;
import edu.montclair.cs.game.gameobjects.Rocky;
import edu.montclair.cs.game.gameobjects.ScrollHandler;
import edu.montclair.cs.game.hanglers.AssetLoader;

/**
 * The Class GameRenderer.
 */
public class GameRenderer {

	private GameWorld myWorld;
	private OrthographicCamera cam;
	private ShapeRenderer shapeRenderer;
	
	private SpriteBatch batcher;
	
	private int gameHeight;
	private int midPointY;
	
	// Game Objects
	private Rocky rocky;
	private ScrollHandler scroller;
	private Background frontBackground, backBackground;
	private Car car1, car2, car3;

	// private Assets
	public TextureRegion bg, background, car;
	public Animation rockyAnimation;
	public TextureRegion rockyStep1, rockyStep2, rockyStep3;
	

	/**
	 * Instantiates a new game renderer.
	 *
	 * @param world the world
	 */
	public GameRenderer(GameWorld world, int gameHeight, int midPointY) {
		myWorld = world;
		
		this.gameHeight = gameHeight;
		this.midPointY = midPointY;
		
		cam = new OrthographicCamera();
		cam.setToOrtho(true, 720, 1280);
		
		batcher = new SpriteBatch();
		// Attach batcher to camera
		batcher.setProjectionMatrix(cam.combined);		
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(cam.combined);

		// Call helper methods to initialize instance variables
		initGameObjects();
		initAssets();
	}
	
	/**
	 * Render.
	 */
	public void render(float runTime) {
		Gdx.app.log("GameRenderer", "render");

        shapeRenderer.begin(ShapeType.Filled);

        // Draw Background color
        shapeRenderer.setColor(55 / 255.0f, 80 / 255.0f, 100 / 255.0f, 1);
        shapeRenderer.rect(0, 0, 136, midPointY + 66);
		
        shapeRenderer.end(); // Start shapeRenderer

        batcher.begin();
        // Disable transparency
        batcher.disableBlending();
       // batcher.draw(AssetLoader.bg, 0, 0, 720, 1280);        
        drawBackground();
        
        if(false){ // Rocky hit box
			batcher.end();
			shapeRenderer.begin(ShapeType.Filled);
			shapeRenderer.setColor(55 / 255.0f, 80 / 255.0f, 100 / 255.0f, 1);
			Rectangle r = myWorld.getRocky().getHitBox();
			shapeRenderer.rect(r.getX(), r.getY(), r.getWidth(), r.getHeight());
			shapeRenderer.end();
			batcher.begin();
		}
        
		if (false) { // Excuse the mess below. Temporary code for testing bounding rectangles.
			batcher.end();
			shapeRenderer.begin(ShapeType.Filled);
			// Bar up for pipes 1 2 and 3
			shapeRenderer.rect(car1.getCarHitBox().x, car1.getCarHitBox().y,
					car1.getCarHitBox().width,car1.getCarHitBox().height);
			shapeRenderer.rect(car2.getCarHitBox().x, car2.getCarHitBox().y,
					car2.getCarHitBox().width,car2.getCarHitBox().height);
			shapeRenderer.rect(car3.getCarHitBox().x, car3.getCarHitBox().y,
					car3.getCarHitBox().width,car3.getCarHitBox().height);
			shapeRenderer.end();
			batcher.begin();
		}
        
     // Enable transparency
        batcher.enableBlending();
        drawObstacles();
        
		batcher.draw(rockyAnimation.getKeyFrame(runTime), rocky.getX(),
				rocky.getY(), rocky.getWidth() / 2.0f,
				rocky.getHeight() / 2.0f, rocky.getWidth(), rocky.getHeight(),
				1, 1, rocky.getRotation());

		batcher.end(); // End shapeRenderer
	}
	
	/**
	 * Draw background.
	 */
	private void drawBackground() {
		batcher.draw(background, frontBackground.getX(),
				frontBackground.getY(), frontBackground.getWidth(),
				frontBackground.getHeight());
		batcher.draw(background, backBackground.getX(), backBackground.getY(),
				backBackground.getWidth(), backBackground.getHeight());
	}
	
	/**
	 * Draw obstacles.
	 */
	private void drawObstacles(){
		// Temporary code! Sorry about the mess :)
        // We will fix this when we finish the Pipe class.
		batcher.draw(car, car1.getX(), car1.getY(), car1.getWidth(),
				car1.getHeight());
		batcher.draw(car, car2.getX(), car2.getY(), car2.getWidth(),
				car1.getHeight());
		batcher.draw(car, car3.getX(), car3.getY(), car3.getWidth(),
				car1.getHeight());
	}

	/**
	 * Inits the game objects.
	 */
	private void initGameObjects(){
		rocky  = myWorld.getRocky();
		scroller = myWorld.getScroller();
		frontBackground = scroller.getFrontBackground();
		backBackground = scroller.getBackBackground();
		car1 = scroller.getCar1();
		car2 = scroller.getCar2();
		car3 = scroller.getCar3();
	}

	/**
	 * Inits the assets.
	 */
	private void initAssets(){
		bg = AssetLoader.bg;
		background = AssetLoader.background;
		rockyAnimation = AssetLoader.rockyAnimation;
		rockyStep1 = AssetLoader.rockyStep1;
		rockyStep2 = AssetLoader.rockyStep2;
		rockyStep3 = AssetLoader.rockyStep3;
		car = AssetLoader.car;
	}
}