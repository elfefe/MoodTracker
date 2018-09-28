package com.moodtracker.elfefe.moodtracker.Controller;

import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;

public class GestureListener  extends SimpleOnGestureListener {
    private static final String DEBUG_TAG = "Gestures";
    private String flingYDetector;


    @Override
    public boolean onDown(MotionEvent event) {
        Log.d(DEBUG_TAG,"onDown: " + event.toString());
        return true;
    }

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2,
                           float velocityX, float velocityY) {
        if (velocityY < 0)
            flingYDetector = "UP";
        if (velocityY > 0)
            flingYDetector = "DOWN";
        return true;
    }

    public String getFlingYDetector() {
        return flingYDetector;
    }
}
