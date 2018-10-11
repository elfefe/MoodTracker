package com.moodtracker.elfefe.moodtracker.controller;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.moodtracker.elfefe.moodtracker.local.CommentRealm;
import com.moodtracker.elfefe.moodtracker.model.Mood;

import io.realm.RealmQuery;

public class HistoryOnClick {
    private Context context;
    private RealmQuery<CommentRealm> realmQuery;

    public HistoryOnClick(Context context, RealmQuery<CommentRealm> realmQuery) {
        this.context = context;
        this.realmQuery = realmQuery;
    }

    public void onClick(TextView textView, int position){

        CommentRealm dbGet = realmQuery.findAll().get(position);

        assert dbGet != null;
        textView.setBackgroundColor(context.getResources().getColor(dbGet.getFeeling()));

        textView.setOnClickListener(v -> Toast.makeText(
                context,
                dbGet.getComment(),
                Toast.LENGTH_LONG)
                .show()
        );

        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) textView.getLayoutParams();
        textView.setLayoutParams(layoutParams);

        if (dbGet.getFeeling() ==  Mood.HAPPY.getColor())
            layoutParams.matchConstraintPercentWidth =  1;
        else if (dbGet.getFeeling() ==  Mood.GOOD.getColor())
            layoutParams.matchConstraintPercentWidth =  0.8f;
        else if (dbGet.getFeeling() ==  Mood.AVERAGE.getColor())
            layoutParams.matchConstraintPercentWidth =  0.6f;
        else if (dbGet.getFeeling() ==  Mood.SAD.getColor())
            layoutParams.matchConstraintPercentWidth =  0.4f;
        else if (dbGet.getFeeling() ==  Mood.ANGRY.getColor())
            layoutParams.matchConstraintPercentWidth =  0.2f;
    }
}
