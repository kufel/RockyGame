package edu.montclair.cs.game.rockygame;

/**
 * Created by Sebastian on 9/27/2014.
 */

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class CanvasActivity extends View {
    Paint paint = new Paint();

    public CanvasActivity(Context context) {
        super(context);
        initTimer();
    }

    @Override
    public void onDraw(Canvas canvas) {
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(3);
        canvas.drawRect(25, 130, 180 + Game.getPosX(), 180, paint);
        paint.setStrokeWidth(0);
        paint.setColor(Color.CYAN);
        canvas.drawRect(133, 160, 177, 177, paint);
        paint.setColor(Color.YELLOW);
        canvas.drawRect(133, 133, 177, 160, paint);
    }

    public void initTimer() {
        // FPS Timer
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                postInvalidate();
                //invalidate();
            }
        },
                0, // delay for x sec
                1000 / Game.FPS // repeat every x sec
        );
    }
}