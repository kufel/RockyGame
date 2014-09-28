package edu.montclair.cs.game.rockygame;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Sebastian on 9/26/2014.
 */
public class MyActivity extends Activity {
    CanvasActivity drawView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawView = new CanvasActivity(this);
        drawView.setBackgroundColor(Color.WHITE);
        setContentView(drawView);
    }

    public void play(View view) {
        Intent i = new Intent(this, Game.class);
        startActivity(i);
    }

    public void highScore(View view) {
        Intent i = new Intent(this, Game.class);
        startActivity(i);
    }

    public void settings(View view) {
        Intent i = new Intent(this, Settings.class);
        startActivity(i);
    }
}
