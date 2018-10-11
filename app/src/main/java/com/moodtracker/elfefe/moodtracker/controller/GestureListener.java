package com.moodtracker.elfefe.moodtracker.controller;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

import com.moodtracker.elfefe.moodtracker.model.LoaderMainView;
import com.moodtracker.elfefe.moodtracker.model.Mood;

public class GestureListener implements GestureDetector.OnGestureListener {
    private int valueX = 1;
    private LoaderMainView loaderMainView;

    public GestureListener(LoaderMainView loaderMainView){
        this.loaderMainView = loaderMainView;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (velocityY < 0 && valueX <4){
                valueX++;
                Log.d("GESTURE:", String.valueOf(valueX));
                loaderMainView.setFeeling(Mood.values()[valueX].getColor(),Mood.values()[valueX].getFeeling());
            }
            if (velocityY > 0 && valueX >0){
                valueX--;
                Log.d("GESTURE:", String.valueOf(valueX));
                loaderMainView.setFeeling(Mood.values()[valueX].getColor(),Mood.values()[valueX].getFeeling());
            }
        return false;
    }

    public int getValueX() {
        return valueX;
    }
}
