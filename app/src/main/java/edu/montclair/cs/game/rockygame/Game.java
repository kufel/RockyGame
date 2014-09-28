package edu.montclair.cs.game.rockygame;

import android.app.Activity;
import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.graphics.Point;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Sebastian on 9/26/2014.
 */
public class Game extends Activity {
    // canvas settings
    public static int canvasHeight;
    public static int canvasWidth;
    public static final boolean devMode = false;
    public static final double version = 1.00;
    // settings
    public static int FPS = 25;
    public static double gravity = 0.1;
    public static double velocity = 0;
    public static int posX = 0;
    public static int posY = 180;
    public static double rotation = 0;
    public static double jump = -0.2;
    public static int score = 0;
    public static int highscore = 0;
    public static int money = 0;
    public static boolean gameOver = true;

    Game() {
        init();
        initTimer();
    }

    private void init() {
        // get screen size
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        canvasWidth = size.x;
        canvasHeight = size.y;
    }

    private void initTimer() {
        // Game Timer used for updating
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
                                      public void run() {
                                          update();
                                      }
                                  },
                0, // delay for x sec
                1000 // repeat every x sec
        );
    }

    private void update() {
        // empty
        posX++;
    }

    public static int getPosX() {
        return posX;
    }
}
