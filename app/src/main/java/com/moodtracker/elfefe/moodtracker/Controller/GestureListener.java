package com.moodtracker.elfefe.moodtracker.Controller;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;

public class GestureListener  extends GestureDetector.SimpleOnGestureListener {
    private static final String DEBUG_TAG = "Gestures";


    @Override
    public boolean onDown(MotionEvent event) {
        Log.d(DEBUG_TAG,"onDown: " + event.toString());
        return true;
    }

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2,
                           float velocityX, float velocityY) {
        Log.d(DEBUG_TAG, "onFling: down - " + event1.getY() + " & up - "+ event2.getY());
        Log.d(DEBUG_TAG, Float.toString(velocityY));
        if (velocityY < 0)
            Log.d(DEBUG_TAG, "Vers le haut");
        if (velocityY > 0)
            Log.d(DEBUG_TAG, "Vers le bas");
        return true;
    }

}
