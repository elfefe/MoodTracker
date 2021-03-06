package com.moodtracker.elfefe.moodtracker.model;

import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;

import com.moodtracker.elfefe.moodtracker.R;

public enum Mood {
    HAPPY(R.color.happy, R.drawable.happy, 1),
    GOOD(R.color.good, R.drawable.good, 0.8f),
    AVERAGE(R.color.average, R.drawable.average, 0.6f),
    SAD(R.color.sad, R.drawable.sad, 0.4f),
    ANGRY(R.color.angry, R.drawable.angry, 0.2f);

    public int getColor() {
        return color;
    }

    public int getFeeling() {
        return feeling;
    }

    public float getPercent() {
        return percent;
    }

    final int color;
    final int feeling;

    final float percent;

    Mood(@ColorRes int color, @DrawableRes int feeling, float percent) {
        this.color = color;
        this.feeling = feeling;
        this.percent = percent;
    }
}
