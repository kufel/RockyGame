package edu.montclair.cs.game.hanglers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * The Class AssetLoader.
 */
public class AssetLoader {
	
	public static Texture texture, bgTexture, rockyTexture, carTexture;
	public static TextureRegion bg, background, car;
	public static Animation rockyAnimation;
	public static TextureRegion rockyStep1, rockyStep2, rockyStep3;
	public static TextureRegion skullUp, skullDown, bar;
	
	/**
	 * Load.
	 */
	public static void load(){
		
		texture = new Texture(Gdx.files.internal("sprites/texture.png"));
		texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		bgTexture = new Texture(Gdx.files.internal("sprites/bg-720x1280.png"));
		bgTexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		rockyTexture = new Texture(Gdx.files.internal("sprites/rocky-1440x640.png"));
		rockyTexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		carTexture = new Texture(Gdx.files.internal("sprites/car.png"));
		carTexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		bg = new TextureRegion(bgTexture, 0, 0, 720, 1280);
		bg.flip(false, true);
		
		background = new TextureRegion(bgTexture, 0, 0, 720, 1280);
		background.flip(false, true);
		
		car = new TextureRegion(carTexture, 0, 0, 500, 453);
		car.flip(false, true);
		
		rockyStep1 = new TextureRegion(rockyTexture, 0, 0, 360, 640);
		rockyStep1.flip(false, true);
		rockyStep2 = new TextureRegion(rockyTexture, 360 * 1, 0, 360, 640);
		rockyStep2.flip(false, true);
		rockyStep3 = new TextureRegion(rockyTexture, 360 * 2, 0, 360, 640);
		rockyStep3.flip(false, true);
        
        TextureRegion[] rockys = { rockyStep1, rockyStep2, rockyStep3};
        rockyAnimation = new Animation(0.2f, rockys);
        rockyAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        
        skullUp = new TextureRegion(texture, 192, 0, 24, 14);
        // Create by flipping existing skullUp
        skullDown = new TextureRegion(skullUp);
        skullDown.flip(false, true);

        bar = new TextureRegion(texture, 136, 16, 22, 3);
        bar.flip(false, true);	
	}
	
	/**
	 * Dispose.
	 */
	public static void dispose() {
		// We must dispose of the texture when we are finished.
		texture.dispose();
	}
}