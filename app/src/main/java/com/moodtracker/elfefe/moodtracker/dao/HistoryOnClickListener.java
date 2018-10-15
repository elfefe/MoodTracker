package com.moodtracker.elfefe.moodtracker.dao;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.moodtracker.elfefe.moodtracker.dao.CommentRealm;
import com.moodtracker.elfefe.moodtracker.model.Mood;

import io.realm.RealmQuery;

public class HistoryOnClickListener {
    private Context context;
    private RealmQuery<CommentRealm> realmQuery;

    private static  final float WIDTH_100_PERCENT = 1f;
    private static  final float WIDTH_80_PERCENT = 0.8f;
    private static  final float WIDTH_60_PERCENT = 0.6f;
    private static  final float WIDTH_40_PERCENT = 0.4f;
    private static  final float WIDTH_20_PERCENT = 0.2f;

    public HistoryOnClickListener(Context context, RealmQuery<CommentRealm> realmQuery) {
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
            layoutParams.matchConstraintPercentWidth =  WIDTH_100_PERCENT;
        else if (dbGet.getFeeling() ==  Mood.GOOD.getColor())
            layoutParams.matchConstraintPercentWidth =  WIDTH_80_PERCENT;
        else if (dbGet.getFeeling() ==  Mood.AVERAGE.getColor())
            layoutParams.matchConstraintPercentWidth =  WIDTH_60_PERCENT;
        else if (dbGet.getFeeling() ==  Mood.SAD.getColor())
            layoutParams.matchConstraintPercentWidth =  WIDTH_40_PERCENT;
        else if (dbGet.getFeeling() ==  Mood.ANGRY.getColor())
            layoutParams.matchConstraintPercentWidth =  WIDTH_20_PERCENT;
    }
}
