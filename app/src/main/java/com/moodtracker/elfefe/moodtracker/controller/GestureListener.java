package com.moodtracker.elfefe.moodtracker.controller;

import android.view.GestureDetector;
import android.view.MotionEvent;

import com.moodtracker.elfefe.moodtracker.model.Mood;

public class GestureListener implements GestureDetector.OnGestureListener {
    final private static int MOOD_DEFAULT = 1;
    private int valueX = MOOD_DEFAULT;
    private LoaderMainView loaderMainView;

    GestureListener(LoaderMainView loaderMainView){
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
            if (velocityY < 0 && valueX < Mood.values().length-1){
                valueX++;
                loaderMainView.setFeeling(Mood.values()[valueX].getColor(),Mood.values()[valueX].getFeeling());
            }
            if (velocityY > 0 && valueX > 0){
                valueX--;
                loaderMainView.setFeeling(Mood.values()[valueX].getColor(),Mood.values()[valueX].getFeeling());
            }
        return false;
    }

    int getValueX() {
        return valueX;
    }
}
