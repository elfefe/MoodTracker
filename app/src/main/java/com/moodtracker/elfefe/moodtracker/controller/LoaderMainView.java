package com.moodtracker.elfefe.moodtracker.controller;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class LoaderMainView {
    private ConstraintLayout mainLayout;
    private ImageView smiley;
    private ImageButton iconeHistory,iconeComment;
    private Context context;

    public LoaderMainView(Context context, ConstraintLayout mainLayout, ImageView smiley, ImageButton iconeHistory, ImageButton iconeComment) {
        this.context = context;
        this.mainLayout = mainLayout;
        this.smiley = smiley;
        this.iconeHistory = iconeHistory;
        this.iconeComment = iconeComment;
    }

    @TargetApi(Build.VERSION_CODES.M)
    public void setFeeling(int color, int feeling){
        smiley.setImageResource(feeling);
        mainLayout.setBackgroundColor(context.getResources().getColor(color));
        iconeHistory.setBackgroundColor(context.getResources().getColor(color));
        iconeComment.setBackgroundColor(context.getColor(color));
    }

}
