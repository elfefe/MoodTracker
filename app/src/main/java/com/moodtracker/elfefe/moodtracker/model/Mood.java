package com.moodtracker.elfefe.moodtracker.model;

import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;

import com.moodtracker.elfefe.moodtracker.R;

public enum Mood {
    HAPPY(R.color.happy,R.drawable.happy),
    GOOD(R.color.good,R.drawable.good),
    AVERAGE(R.color.average,R.drawable.average),
    SAD(R.color.sad,R.drawable.sad),
    ANGRY(R.color.angry,R.drawable.angry);

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
