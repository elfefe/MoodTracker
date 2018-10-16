package com.moodtracker.elfefe.moodtracker.controller;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.constraint.ConstraintLayout;
import android.widget.ImageView;

public class LoaderMainView {
    private ConstraintLayout mainLayout;
    private ImageView smiley;
    private Context context;

    public LoaderMainView(Context context, ConstraintLayout mainLayout, ImageView smiley) {
        this.context = context;
        this.mainLayout = mainLayout;
        this.smiley = smiley;
    }

    @TargetApi(Build.VERSION_CODES.M)
    void setFeeling(@ColorRes int color, @DrawableRes int feeling){
        smiley.setImageResource(feeling);
        mainLayout.setBackgroundColor(context.getResources().getColor(color));
    }

}
