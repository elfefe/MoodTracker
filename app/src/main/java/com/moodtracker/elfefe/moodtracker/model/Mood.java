package com.moodtracker.elfefe.moodtracker.model;

import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;

import com.moodtracker.elfefe.moodtracker.R;

public enum Mood {
    ANGRY(R.color.angry,R.drawable.angry),
    SAD(R.color.sad,R.drawable.sad),
    AVERAGE(R.color.average,R.drawable.average),
    GOOD(R.color.good,R.drawable.good),
    HAPPY(R.color.happy,R.drawable.happy);

    public int getColor() {
        return color;
    }

    public int getFeeling() {
        return feeling;
    }

    int color,feeling;

    Mood(@ColorRes int color,@DrawableRes int feeling) {
        this.color = color;
        this.feeling = feeling;
    }


}
